<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%--
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
--%>

<%
    if(session.getAttribute("admin")==null){
        response.sendRedirect("../login.jsp");
        return;
    }
%>

<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <title>持名法州主页</title>
                <span style="white-space: pre"></span>
                <link href="/back/img/favicon.ico" rel="icon" type="image/x-icon">
            <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
            <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
            <script type="text/javascript" src="../js/jquery.min.js"></script>
            <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
            <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
            <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
                <script type="text/javascript" src="../js/common.js"></script>
                <script type="text/javascript" src="../js/jquery.etree.js"></script>
            <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
            <script type="text/javascript">
                <!--菜单处理-->
                $.post(
                    "${pageContext.request.contextPath}/menu/menuAll",
                    function (result) {
                        //遍历一级菜单
                        $.each(result,function (index,menu) {
                            //遍历二级菜单
                            var count="<div style='text-align: center;background: #e5e5e5'>";
                            $.each(menu.menus,function (index,m) {
                                count+="<a style='width:90%;margin: 10px 0px;border: 2px #f2c56d solid;' onclick=\"addTabs('"+m.title+"','"+m.href+"','"+m.iconCls+"')\" class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+m.iconCls+"'\">"+m.title+"</a>";
                            })
                            count+="<div>";
                            //添加菜单
                            $("#aa").accordion('add',{
                                title:menu.title,
                                iconCls:menu.iconCls,
                                content:count,
                            });
                        })
                    }

                );

                //点击菜单追加选项卡
                function addTabs(title,href,iconCls) {
                    //添加以前先判断tabs中是否存在这个选项卡
                    if(!$("#tt").tabs('exists',title)){

                        $("#tt").tabs('add',{
                            title:title,
                            iconCls:iconCls,
                            closable:true,
                            fit:true,
                            href:"${pageContext.request.contextPath}"+href,
                        })
                    }else {
                        $("#tt").tabs('select',title);
                    }
                }


                /*修改密码对话框*/
                function xg(id) {
                    $("#update").dialog({
                        href:'${pageContext.request.contextPath}/back/admin/updatePassword.jsp?name=${sessionScope.admin.name}&id=${sessionScope.admin.id}',
                        buttons:[
                            {
                                text:'修改',
                                iconCls:'icon-save',
                                handler:function () {
                                    $("#save1form").form('submit',{
                                        url:'${pageContext.request.contextPath}/admin/update',
                                        success:function (result) {
                                            var r=$.parseJSON(result);
                                            if(r.success){
                                                /*提示信息*/
                                                $.messager.alert('提示','修改成功！','info');
                                                /*关闭对话框*/
                                                $("#update").dialog('close');
                                                /*刷新页面*/
                                                $("#tb").datagrid('reload');

                                            }else {
                                                /*提示信息*/
                                                $.messager.alert('提示',r.message,'info');
                                            }
                                        }
                                    })

                                }
                            },{
                                text:'取消',
                                iconCls:'icon-clear',
                                handler:function () {
                                    /*关闭对话框*/
                                    $("#update").dialog('close');
                                }
                            }
                        ]
                    });
                }

            </script>

    </head>
    <body class="easyui-layout">
            <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
                <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
                <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.name} &nbsp;<a href="#" class="easyui-linkbutton" onclick="xg()" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/exit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
            </div>
            <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
                <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
            </div>
            <%--菜单栏--%>
            <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
                <div id="aa" class="easyui-accordion" data-options="fit:true" style="background: #e5e5e5">

                </div>
            </div>
            <%--中间栏--%>
            <div data-options="region:'center'">
                <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
                    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
                </div>
            </div>

            <%--修改对话框--%>
            <div id="update" data-options="title:'修改信息',width:400,height:250,iconCls:'icon-edit',draggable:false,minimizable:true,maximizable:true">


            </div>
    </body>
</html>