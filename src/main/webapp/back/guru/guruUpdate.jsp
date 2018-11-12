<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("save1form").form('load','${pageContext.request.contextPath}/emp/update?id=${param.id}');
    })
</script>
<div style="text-align: center">

    <form id="save1form" class="easyui-form" action="" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px">
            姓名:<input type="text" name="name" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px">
            头像:<input type="text" name="u" class="easyui-filebox">
        </div>
        <div style="margin-top: 20px">
            性别:<input type="text" name="gender" class="easyui-textbox">
        </div>

    </form>

</div>