<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <p class="text-center text-danger" style="margin-top:20px;">Неверная пара логин/пароль</p>
      <a href="<c:url value="/authorization/client"/>" style="color:inherit;">
        <h1><p class="text-center" style="font-size:14px;">Вернуться на страницу авторизации</p></h1>
      </a>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>