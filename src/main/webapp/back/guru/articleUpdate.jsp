<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("save1form").form('load','${pageContext.request.contextPath}/article/articleModify?id='+${param.id});
    })
</script>
<div style="text-align: center">

    <form id="save1form" class="easyui-form" action="" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px">
            标题:<input type="text" name="title" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px">
            插图:<input type="text" name="imgPath" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            内容:<input type="text" name="content" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            日期:<input type="text" name="publishDate" class="easyui-datebox">
        </div>
    </form>

</div>