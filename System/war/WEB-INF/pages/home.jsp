<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <h3><p class="text-center text-success" style="font-size:64px;">Авиарейсы Штолле</p></h3>
    <br/>
    <p>Добро пожаловать на сайт системы информации об авиарейсах и авиабилетах имени Наркомана Штолле</p>
    <p>Здесь вы можете узнать об авиарейсах, доступных на сегодняшний день. С помощью этого сайта Вы можете получить информацию о доступных местах на интересующий вас авиарейс, а также приобрести любое из свободных мест</p>
</div>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <a href="<c:url value="/flights"/>" style="color:inherit;">
        <p class="text-center" style="font-size:20px;">Посмотреть доступные авиарейсы</p>
    </a>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>