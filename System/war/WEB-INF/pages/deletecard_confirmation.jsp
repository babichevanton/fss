<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <h3><p class="text-center text-success" style="font-size:16px;">Вы удалили карту ${name}</p></h3>
    <br/>
</div>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <a href="<c:url value="/for_clients/client=${cl_id}/view_profile"/>" style="color:inherit;">
        <p class="text-center" style="font-size:20px;">На страницу профиля</p>
    </a>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>