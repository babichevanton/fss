<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
	<p class="text-left" style="font-size:16px;">Место</p>
    <table class="table table-hover">
        <thead>
            <th>Ряд</th>
            <th>Литера</th>
        </thead>
        <tbody>
            <tr>
                <td>${seat.row}</td>    
                <td>${seat.symb}</td>
            </tr>
        </tbody>
    </table>
	<form:form method="POST" action="order_seat=${seat.id}/confirmation">
    	<p>
	    	<form:radiobutton path="type" value="order"></form:radiobutton>Забронировать
	    	<form:radiobutton path="type" value="reserve"></form:radiobutton>Приобрести
    	</p>
    	<br/>
		<c:choose>
			<c:when test="${not empty bonus}">
				<p>Доступно приобретение места за бонусы на следующей карте:</p>
				<form:hidden path="id" value="${bonus.id}"/>
			    <table class="table">
			        <thead>
			            <th>Авиалиния</th>
			            <th>Название</th>
			            <th>Баллы</th>
			        </thead>
			        <tbody>
			            <tr>
			                <td>${bonus.airline.name}</td>    
			                <td>${bonus.name}</td>    
			                <td>${bonus.points}</td>
			            </tr>
			        </tbody>
			    </table>
                <c:set var="totalCost" value="${seat.getServiceClass().getParticularFlight().getFlight().getLength() * seat.getServiceClass().getCoeff()}"></c:set>
                <fmt:formatNumber type="number" maxFractionDigits="0" value="${totalCost}"></fmt:formatNumber>
				<p>Приобретение места возможно за ${totalCost} баллов:</p>
				<p>
				    <form:checkbox path="card" />Использовать бонусную карту
			    </p>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<table>
			<tr>
		        <td><form:label path="account">Номер счета списания</form:label></td>
		        <td><form:input path="account"/></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Submit"/>
		        </td>
		    </tr>
	    </table>
	</form:form>
</div>
<div class="container-fluid col-lg-5 col-lg-offset-3">
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>