<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
	<div class="container-fluid col-lg-5 col-lg-offset-3">
	    <h3><p class="text-center text-success" style="font-size:20px;">Здравствуйте, ${client.surname} ${client.name} ${client.patronymic}!</p></h3>
	    <br/>
	</div>
</div>
<div class="row">
	<a href="<c:url value="/for_clients/client=${client.id}/view_profile"/>">
		<p class="text-left" style="margin-top:10px;" style="font-size:20px;">Управление профилем</p>
	</a>
	<p class="text-center" style="font-size:14px;">Доступна возможность изменять данные в своем профиле, а также полностью удалить его.</p>
</div>
<div class="row">
    <a href="<c:url value="/for_clients/client=${client.id}/searchflights"/>">
		<p class="text-left" style="margin-top:10px;" style="font-size:20px;">Доступные авиалинии</p>
	</a>
	<p class="text-center" style="font-size:14px;">Здесь доступна информация о доступных авиалиниях. Заполните форму поиска, и сайт предоставит записи обо всех авиарейсах, удовлетворяющих критериям поиска</p>
</div>
