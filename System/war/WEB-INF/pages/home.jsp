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
	<div class="row">
		<p class="text-center" style="font-size:14px;"><a href="<c:url value="/authorization/client"/>">Клиенты</a> могут посмотреть информацию о подходящих доступных авиарейсах. Также предоставляется возможность ознакомиться с дополнительной информацией по любому заинтересовавшему авиарейсу и забронировать свободное место на него.</p>
	</div>
	<div class="row">
		<p class="text-center" style="font-size:14px;"><a href="<c:url value="/authorization/admin"/>">Администраторы</a> могут посмотреть любую информацию о всех имеющихся авиарейсах и клиентах системы. Также предоставляется возможность добавления новых авиарейсов и редактирования данных имеющихся авиарейсов.</p>
	</div>
	<div class="row">
		<p class="text-center" style="font-size:14px;">Для получения доступа к функциональности сайта необходима авторизация. Вы новичок на нашем сайте? Тогда скорее пройдите <a href="<c:url value="/registration"/>">регистрацию!</a></p>
	</div>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>