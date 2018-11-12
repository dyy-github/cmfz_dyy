<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
    <script type="text/javascript">

        $(function () {

            $('#tttt').treegrid({
                url:'${pageContext.request.contextPath}/album/albumPaging',
                idField:'id',
                treeField:'title',
                pagination:true,//设置分页工具栏
                toolbar:[//设置顶部工具栏
                    {
                        iconCls: 'icon-edit',
                        text:'专辑添加',
                        handler: albumA,
                    },
                    {
                        iconCls: 'icon-edit',
                        text:'专辑详情',
                        handler: function(){
                            //alert("------");
                            var ja=$("#tttt").treegrid("getSelected");
                            //alert("1");
                            if(ja!=null){
                                if(ja.size==null){
                                    $("#albumX").dialog("open");
                                    $("#albumF").form("load",ja);
                                    $("#album_img").prop("src",ja.coverImg);
                                }else {
                                    alert('请选择您要了解的专辑');
                                }
                            }else {
                                alert('请选择您要了解的专辑');
                            }
                        }
                    },
                    {
                        iconCls: 'icon-edit',
                        text:'章节添加',
                        handler: function(){
                            var ja=$("#tttt").treegrid("getSelected");
                            if(ja==null){
                                alert('请选中一行数据');
                            }else{
                                if(ja.size==null){
                                    $("#chapterA").dialog("open");
                                    $("#w_id").textbox("setValue",ja.id);
                                }else{
                                    alert('请选中一张专辑');
                                }

                            }
                        }
                    },
                    {
                        iconCls: 'icon-edit',
                        text:'章节删除',
                        handler: function(){
                            var ja=$("#tttt").treegrid("getSelected");
                            if (ja==null){
                                alert('请选中一张章节');
                            } else {
                                if(ja.size!=null){
                                    alert(ja.id);
                                    location.href="${pageContext.request.contextPath}/chapter/chapterRemove?id="+ja.id;
                                    $("#tttt").treegrid('reload');
                                }else{
                                    alert('请选中一张章节');
                                }
                            }
                        }
                    },
                    {
                        iconCls: 'icon-edit',
                        text:'专辑删除',
                        handler: function(){
                            var ja=$("#tttt").treegrid("getSelected");
                            console.log(ja);
                            if(ja==null){
                                alert('请选中一张专辑');
                            }else {
                                if(ja.size==null){
                                    alert('请选中一张专辑');
                                }else{
                                    location.href="${pageContext.request.contextPath}/album/albumRemove?id="+ja.id;
                                    $("#tttt").treegrid('reload');
                                }
                            }
                        }
                    },
                    {
                        iconCls: 'icon-edit',
                        text:'下载音频',
                        handler: function(){
                            //alert('编辑按钮');
                            var c=$("#tttt").treegrid('getSelected');
                            if(c!=null){
                                if(c.size!=null&&c!=null){

                                    location.href="${pageContext.request.contextPath}/chapter/downLoad?fileName="+c.downPath;

                                }else {
                                    alert("请选择章节！")
                                }
                            }else {
                                alert("请选择章节！");
                            }

                            console.log(c);
                        }
                    }
                ],
                pageList:[6,12,24,30],
                pageSize:12,
                fitColumns:true,
                pagePosition:"bottom",
                columns:[[
                    {title:'ID',field:'id',width:90},
                    {field:'title',title:'标题',width:60,align:'right'},
                    {field:'size',title:'大小',width:80},
                    {field:'duration',title:'集数',width:80},
                    {field:'downPath',title:'downPath',width:80},
                    {field:'uploadTime',title:'时间',width:80},

                ]]
            });
        })

        function albumA() {
            /*添加功能*/

            $("#dl").dialog({
                href:'${pageContext.request.contextPath}/back/album/albumAdd.jsp',
                title:'专辑添加',
                iconCls:'icon-save',
                width:300,
                height:500,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',

                    handler:function () {
                        $("#fff").form('submit',{

                            url:'${pageContext.request.contextPath}/album/albumAdd',

                            success:function(result) {

                                //var r = $.parseJSON(result);
                                //alert("1")
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
                                $("#tttt").treegrid('reload');
                            }
                        });
                    }


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

        //audioBtn播放器的关闭按钮
        $("#audioBtn").linkbutton({
            plain:true,
            iconCls:"icon-save",
            onClick:function () {
                $("#audioDiv").css("display","none");
            }
        });

    </script>

        <table id="tttt"></table>




        <div id="dl" style="background: #a4e9c1">

        </div>
        <%--专辑详情展示--%>
        <div id="albumX" class="easyui-dialog" title="专辑详情展示" style="width:300px;height:450px;text-align: center;background-color: bisque"
             data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

            <form id="albumF" method="post">
                <div style="margin-top: 50px">
                    <label for="title">专辑名称:</label>
                    <input class="easyui-validatebox" type="text" id="title" name="title" />
                </div>
                <div style="margin-top: 15px">
                    <label for="count">专辑集数:</label>
                    <input class="easyui-validatebox" type="text" name="count" id="count" />
                </div>

                <div style="margin-top: 15px">
                    <label for="star">专辑星级:</label>
                    <input class="easyui-validatebox" type="text" name="star" id="star" />
                </div>
                <div style="margin-top: 15px">
                    <label for="publishDate">专辑上传日期:</label>
                    <input class="easyui-validatebox" type="text" name="publishDate" id="publishDate" />
                </div>
                <div style="margin-top: 15px">
                    <label for="author">专辑作者:</label>
                    <input class="easyui-validatebox" type="text" name="author" id="author" />
                </div>
                <div style="margin-top: 15px">
                    <label for="brief">专辑简介:</label>
                    <input class="easyui-validatebox" type="text" name="brief" id="brief" />
                </div>
                <div style="margin-top: 15px">
                    <label for="album_img">专辑封面:</label>
                    <img id="album_img" src="${pageContext.request.contextPath}" />
                </div>
            </form>
        </div>

        <%--章节添加--%>
        <div id="chapterA" class="easyui-dialog" title="专辑详情展示" style="width:300px;height:450px;background-color: #ffa8a8;text-align: center"
             data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
                        text:'SAVE',
                        iconCls:'icon-save',
                        handler:function(){
                            $('#chapterF').form('submit',{
                                url:'${pageContext.request.contextPath}/chapter/chapterAdd',
                                success:function(result){
                                    if(result.success){
                                        //提示信息
                                        $.messager.show({title:'提示',msg:'用户添加成功!!!'});
                                    }else{
                                        //提示信息
                                        $.messager.show({title:'提示',msg:result.message});
                                    }
                                    //关闭对话框
                                    $('#chapterA').dialog('close');

                                    //刷新datagrid
                                    $('#tttt').treegrid('reload');
                                }

                            })
                        }
                    },{
                        text:'CLOSE',
                        iconCls:'icon-cancel',
                        handler:function(){
                            $('#chapterA').dialog('close');
                        }
                    }]">

            <form id="chapterF"  method="post">
                <div style="margin-top: 50px">
                    <label for="w_id">外&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;键:</label>
                    <input class="easyui-textbox"  type="text"  id="w_id" name="w_id" data-options="iconCls:'icon-search'" style="width:160px"/>
                </div>
                <div style="margin-top: 15px">
                    <label for="titlec">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题:</label>
                    <input class="easyui-textbox" type="text" id="titlec" name="title" data-options="iconCls:'icon-search'" style="width:160px"/>
                </div>
                <div style="margin-top: 15px">
                    <label for="size">大&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;小:</label>
                    <input class="easyui-textbox" type="text" name="size" id="size" data-options="iconCls:'icon-search'" style="width:160px"/>
                </div>
                <div style="margin-top: 15px">
                    <label for="duration">章节时长:</label>
                    <input class="easyui-textbox" type="text" name="duration" id="duration" data-options="iconCls:'icon-search'" style="width:160px"/>
                </div>
                <div style="margin-top: 15px">
                    <label for="downPath">下载路径:</label>
                    <input class="easyui-filebox" type="text" name="dP" id="downPath" data-options="" style="width:160px"/>
                </div>
                <div style="margin-top: 15px">
                    <label for="uploadTime">下载时间:</label>
                    <input class="easyui-datebox" type="text" name="uploadTime" id="uploadTime" data-options="" style="width:160px"/>
                </div>

            </form>



        </div>


