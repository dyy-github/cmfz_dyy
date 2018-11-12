<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        console.log("${param.name}");
        console.log("${param.id}");
        $("save1form").form('load','${pageContext.request.contextPath}/admin/update?id=${param.id}&name=${param.name}');
    })
</script>
<div style="text-align: center">

    <form id="save1form" class="easyui-form" action="" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px">
            用户名:<input type="text" name="name" value="${param.name}" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px">
            密码:<input type="text" name="password" class="easyui-textbox">
        </div>


    </form>

</div>