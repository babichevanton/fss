<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
	<c:choose>
		<c:when test="${seat.status == 1}">
		    <h3><p class="text-center text-success" style="font-size:16px;">Вы успешно забронировали место ${seat.row}${seat.symb}</p></h3>
		    <br/>
		</c:when>
		<c:when test="${seat.status == 2}">
		    <h3><p class="text-center text-success" style="font-size:16px;">Вы успешно зарезервировали место ${seat.row}${seat.symb}</p></h3>
		    <br/>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</div>
<div class="container-fluid col-lg-5 col-lg-offset-3">
    <a href="<c:url value="/home"/>" style="color:inherit;">
        <p class="text-center" style="font-size:20px;">На главную</p>
    </a>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>