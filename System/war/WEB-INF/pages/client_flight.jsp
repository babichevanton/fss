<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-6     col-lg-offset-3">
    <c:choose>
        <c:when test="${not empty pt_flight}">
            <div class="row">
                <h2>
                    <p>Авиарейс ${pt_flight.flight.number}</p>
                    <p>Из:</p>
                    <p>${pt_flight.flight.dptr_airport.city} ${pt_flight.flight.dptr_airport.name} ${pt_flight.dptr.getTime()}</p>
                    <p>В:</p>
                    <p>${pt_flight.flight.arr_airport.city} ${pt_flight.flight.arr_airport.name} ${pt_flight.arr.getTime()}</p>
                </h2>
            </div>
            <br/>
            <c:forEach items="${pt_flight.services}" var="service">
                <div class="row">
                    <p style="font-size=16px">Класс: ${service.name}   Стоимость: ${service.cost}</p>
                    <table class="table table-hover">
                        <thead>
                            <th>Ряд</th>
                            <th>Литера</th>
                            <th>Статус</th>                           
                        </thead>
                        <tbody>
                            <c:forEach items="${service.seats}" var="seat">
                                <tr>
                                    <td>${seat.row}</td>    
                                    <td>${seat.symb}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${seat.status == 0}">
                                                <a href="<c:url value="/for_clients/client=${cl_id}/flights/part_fl=${pt_flight.id}/order_seat=${seat.id}"/>">
                                                    <p>Забронировать/приобрести</p>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <p>Занято</p>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p class="text-center text-danger">Запрошенный авиарейс отсутствует</p>
        </c:otherwise>
    </c:choose>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>