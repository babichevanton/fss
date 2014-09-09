<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>

<div class="row">
  <div class="col-lg-10">
      <h1><p class="text-center" style="font-size:64px;">Авиарейсы</p></h1>
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
                <th>Аэропорт отбытия</th>
                <th>Время отбытия</th>
                <th>Аэропорт прибытия</th>
                <th>Время прибытия</th>
                <th>Места</th>
                <th></th>
              </thead>
              <tbody>
                <c:forEach items="${flights}" var="flight">
                    <tr>
                        <td>${flight.flight.number}</td>
                        <td>${flight.flight.length}</td>
                        <td>${flight.flight.airline.name}</td>
                        <td>${flight.flight.dptr_airport.name}</td>
                        <td>${flight.dptr.getTime()}</td>
                        <td>${flight.flight.arr_airport.name}</td>
                        <td>${flight.arr.getTime()}</td>
                        <td>
                          <table class="table table-hover">
                            <thead>
                              <th>Класс</th>
                              <th>Цена</th>
                              <th>Свободно</th>
                            </thead>
                            <tbody>
                              <c:forEach items="${flight.services}" var="sclass">
                                <tr>
                                    <td>${sclass.name}</td>
                                    <td>${sclass.cost}</td>
                                    <td>
                                      <c:set var="totalFree" value="${0}"/>
                                      <c:forEach items="${sclass.seats}" var="seat">
                                        <c:choose>
                                          <c:when test="${seat.status == 0}">
                                            <c:set var="totalFree" value="${totalFree + 1}"/>
                                          </c:when>
                                        </c:choose>
                                      </c:forEach>
                                      ${totalFree}
                                    </td>
                                </tr>
                              </c:forEach>
                            </tbody>
                          </table>
                        </td>
                        <td>
                          <a href="<c:url value="flights/part_fl=${flight.id}"/>">
                            <p class="text-center">дополнительно</p>
                          </a>
                        </td>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
      </c:when>
      <c:otherwise>
          <p class="text-center text-danger" style="margin-top:20px;">Авиарейсов, соответствующих критерию поиска, не найдено.</p>
      </c:otherwise>
  </c:choose>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>