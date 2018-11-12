<%@page isELIgnored="false" pageEncoding="UTF-8" %>

    <script type="text/javascript">
        $(function () {
            $("#dg").datagrid({
                fit:true,
                url:"${pageContext.request.contextPath}/article/articlePaging",
                    pagePosition:"bottom",
                pageList:[2,4,6,8],
                pageSize:4,
                height:400,
                fitColumns:true,
                remoteSort:false,//关闭服务器排序
                toolbar:"#tb",//设置顶部工具栏
                pagination:true,//设置分页工具栏
                columns:[[
                    {title:'dx',field:'dx',checkbox:true},
                    {title:'ID',field:'id',fixed:false,width:100},
                    {title:'标题',field:'title',fixed:false,width:100},
                    {title:'路径',field:'imgPath',fixed:false,width:100},
                    {title:'内容',field:'content',fixed:false,width:100},
                    {title:'日期',field:'publishDate',fixed:false,width:100}
                ]]

            });
        })

        /*添加功能*/
        function bannerSave() {
            $("#dl").dialog({
                href:'${pageContext.request.contextPath}/back/article/articleAdd.jsp',
                title:'部门添加',
                iconCls:'icon-save',
                width:400,
                height:400,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',

                    handler:xixi,


                },{
                    text:'关闭',
                    iconCls:'icon-clear',
                    handler:function(){
                        /*关闭保存对话框*/
                        $("#dl").dialog('close');
                    }
                }]


            })
        }
        /*添加轮播图*/
        function xixi() {
            $("#ff").form('submit',{
                url:'${pageContext.request.contextPath}/article/articleAdd',

                success:function(result) {
                    //alert("3");
                    //var r = $.parseJSON(result);
                   // alert("1")
                    if(result.success){
                        //提示信息
                        $.messager.show({title:'提示',msg:"用户添加成功!!!"});
                    }else{
                        //提示信息
                        $.messager.show({title:'提示',msg:result.message});
                    }
                    //关闭对话框
                    $("#dl").dialog('close');
                    alert("2")
                    //刷新datagrid
                    $("#dg").datagrid('reload');
                }
            });
        }
        /*修改对话框*/
        function xg() {
            var rows=$("#dg").datagrid('getSelections');
            if (rows.length==1){
            $("#update").dialog({
                href:'${pageContext.request.contextPath}/back/guru/articleUpdate.jsp?id='+rows[0].id,
                buttons:[
                    {
                        text:'修改',
                        iconCls:'icon-save',
                        handler:function () {
                            $("#save1form").form('submit',{
                                url:'${pageContext.request.contextPath}/article/articleModify',
                                success:function (result) {
                                    //var r=$.parseJSON(result);
                                    if(result.success){
                                        /*提示信息*/
                                        $.messager.alert('提示','修改成功！');


                                    }else {
                                        /*提示信息*/
                                        $.messager.alert('提示',result.message);
                                    }
                                    /*关闭对话框*/
                                    $("#update").dialog('close');
                                    /*刷新页面*/
                                    $("#dg").datagrid('reload');
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
            }else {
                $.messager.alert('提示','仅选中一行！');
            }

        }
        /*批量删除*/
        function pl() {
            var rows=$("#dg").datagrid('getSelections');
            if (rows.length<=0){
                $.messager.alert('提示','至少选中一行！');
            }else{
                var ids=[];
                for (var i = 0; i <rows.length ; i++) {
                    console.log(rows[i].id);
                    ids.push(rows[i].id);
                }
                console.log(ids);
                $.ajax({
                    url:'${pageContext.request.contextPath}/article/articleP',
                    type:'POST',
                    traditional:true,
                    data:{id:ids},
                    success:function (result) {
                        //var r=$.parseJSON(result);
                        if(result.success){

                            /*消息提示*/
                            $.messager.alert('提示','删除成功！','info');
                            /*刷新页面*/
                            $("#dg").datagrid('reload');
                        }
                    },
                    error:function (result) {
                        //var r=$.parseJSON(result);
                        if (result.success){

                            /*消息提示*/
                            $.messager.alert('提示',result.message,'info');
                            /*刷新页面*/
                            $("#dg").datagrid('reload');
                        }
                    }

                });
            }
        }
    </script>

      <table id="dg"></table>

        <%--顶部工具栏--%>
      <div id="tb">
          <a href="#" class="easyui-linkbutton" onclick="bannerSave()" data-options="iconCls:'icon-edit',plain:true">添加</a>
          <a href="#" class="easyui-linkbutton" onclick="" data-options="iconCls:'icon-edit',plain:true">删除</a>
          <a href="#" class="easyui-linkbutton" onclick="xg()" data-options="iconCls:'icon-edit',plain:true">修改</a>
          <a href="#" class="easyui-linkbutton" onclick="pl()" data-options="iconCls:'icon-edit',plain:true">批量删除</a>
          <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">帮助</a>
      </div>
        <%--添加对话框--%>
      <div id="dl" style="background-color: #E0F892">

      </div>

        <%--修改对话框--%>
        <div id="update" data-options="title:'修改信息',width:400,height:400,iconCls:'icon-edit',draggable:false,minimizable:true,maximizable:true" style="background-color: #ababab">


        </div>

