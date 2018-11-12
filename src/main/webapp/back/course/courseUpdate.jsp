<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("save1formc").form('load','${pageContext.request.contextPath}/course/courseModify?id='+${param.id});
    })
</script>
<div style="text-align: center">

    <form id="save1formc" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px">
            标题:<input type="text" name="title" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px">
            marking:<input type="text" class="easyui-filebox" data-options="" name="marking">
        </div>
        <div style="margin-top: 20px">
            日期:<input type="text" name="creatTime" class="easyui-datebox">
        </div>
    </form>

</div>