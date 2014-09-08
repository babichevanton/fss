<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <h3><p class="text-center text-success" style="font-size:16px;">Здравствуйте, ${client.surname} ${client.name} ${client.patronymic}!</p></h3>
    <p class="text-center text-success" style="font-size:16px;">Регистрация успешно завершена.</p>
    <p class="text-center text-success" style="font-size:16px;">Добро пожаловать на наш сайт.</p>
    <br/>
</div>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <a href="<c:url value="/home"/>" style="color:inherit;">
        <p class="text-center" style="font-size:20px;">На главную</p>
    </a>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>