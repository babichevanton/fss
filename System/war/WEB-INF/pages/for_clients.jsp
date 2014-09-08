<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid col-lg-5 col-lg-offset-3">
    <h3><p class="text-center text-success" style="font-size:32px;">Здравствуйте, ${client.surname} ${client.name} ${client.patronymic}!</p></h3>
    <br/>
</div>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <a href="<c:url value="/flights"/>" style="color:inherit;">
        <p class="text-center" style="font-size:20px;">Посмотреть доступные авиарейсы</p>
    </a>
</div>
