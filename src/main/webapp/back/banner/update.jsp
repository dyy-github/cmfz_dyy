<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("save1form").form('load','${pageContext.request.contextPath}/emp/update?id='+${param.id});
    })
</script>
<div style="text-align: center">

    <form id="save1form" class="easyui-form" action="" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px">
            标题:<input type="text" name="title" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px">
            路径:<input type="text" name="imgPath" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            排序:<input type="text" name="descs" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            状态:<input type="text" name="status" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            日期:<input type="text" name="date" class="easyui-datebox">
        </div>
    </form>

</div>