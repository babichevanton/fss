<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>  
<head>
</head>
  
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-lg-10">
		    <a href="<c:url value="/home"/>" style="color:inherit;">
			<h1><p class="text-center" style="font-size:64px;">аЁаАаМаОаЛббб</p></h1>
			</a>
		</div>
	</div>
    
	<div class="row" style="margin-bottom:30px; margin-top:30px">
        <c:choose>
            <c:when test="${not empty flights}">
                <table class="table table-hover">
                    <thead>
                       <th>Номер</th>
                       <th>Расстоние</th>
                       <th>Авиалиния</th>
                       <th>Отбытие</th>
                       <th>Прибытие</th>
                   </thead>
                   <tbody>
                      <c:forEach items="${flights}" var="flight">
                          <tr>
                              <td>${flight.number}</td>
                              <td>${flight.length}</td>
                              <td>${flight.airline.name}</td>
                              <td>${flight.dptr_airport.name}</td>
                              <td>${flight.arr_airport.name}</td>
                          </tr>
                       </c:forEach>
                   </tbody>
                 </table>

            </c:when>
            <c:otherwise>
                <p class="text-center text-danger" style="margin-top:20px;">Ничего нет!</p>
            </c:otherwise>
        </c:choose>
    </div>
    
	<div class="row">
		<p class="text-center text-muted">2014 @ Mikhail Koltsov</p>
	</div>
</div>
  </body>
</html>