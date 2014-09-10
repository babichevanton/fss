<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>

<div class="row">
  <div class="col-lg-10">
      <h1><p class="text-center" style="font-size:64px;"></p></h1>
  </div>
</div>
<div class="row">
  <div class="container-fluid col-lg-5 col-lg-offset-3">
    <table class="table table-hover">
      <tbody>
        <tr>
            <td>Фамилия</td>
            <td>${client.surname}</td>
        </tr>
        <tr>
            <td>Имя</td>
            <td>${client.name}</td>
        </tr>
        <tr>
            <td>Отчество</td>
            <td>${client.patronymic}</td>
        </tr>
        <tr>
            <td>Контактный адрес</td>
            <c:choose>
                <c:when test="${not empty client.address}">
                  <td>${client.address}</td>
                </c:when>
                <c:otherwise>
                  <td>Не указан</td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td>Контактный телефон</td>
            <c:choose>
                <c:when test="${not empty client.phone}">
                  <td>${client.phone}</td>
                </c:when>
                <c:otherwise>
                  <td>Не указан</td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td>Адрес электронной почты</td>
            <c:choose>
                <c:when test="${not empty client.email}">
                  <td>${client.email}</td>
                </c:when>
                <c:otherwise>
                  <td>Не указан</td>
                </c:otherwise>
            </c:choose>
        </tr>
      </tbody>
    </table>
    <h3>Бонусные карты</h3>
    <c:choose>
        <c:when test="${not empty cards}">
            <table class="table table-hover">
              <thead>
                <th>Номер</th>
                <th>Авиалиния</th>
                <th>Баллы</th>
                <th></th>
              </thead>
              <tbody>
                <c:forEach items="${cards}" var="card">
                  <tr>
                      <td>${card.name}</td>
                      <td>${card.airline.name}</td>
                      <td>${card.points}</td>
                      <td>
                        <a href="<c:url value="/for_clients/client={cl_id}/view_profile/delbonusconfirm"/>">
                          <p>Удалить</p>
                        </a>
                      </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>У вас нет ниодной бонусной карты</p>
        </c:otherwise>
    </c:choose>
    <a href="<c:url value="/for_clients/client={cl_id}/view_profile/addbonus"/>">
      <p class="text-left" style="margin-top:10px;" style="font-size:14px;">Добавить бонусную карту</p>
    </a>
    <h3>Забронированные места</h3>
    <c:choose>
        <c:when test="${not empty seats}">
            <table class="table table-hover">
              <thead>
                <th>Номер</th>
                <th>Авиалиния</th>
                <th>Аэропорт отбытия</th>
                <th>Время отбытия</th>
                <th>Аэропорт прибытия</th>
                <th>Время прибытия</th>
                <th>Место</th>
                <th></th>
              </thead>
              <tbody>
                <c:forEach items="${seats}" var="seat">
                    <tr>
                        <td>${seat.getServiceClass().getParticularFlight().flight.number}</td>
                        <td>${seat.getServiceClass().getParticularFlight().flight.airline.name}</td>
                        <td>${seat.getServiceClass().getParticularFlight().flight.dptr_airport.name}</td>
                        <td>${seat.getServiceClass().getParticularFlight().dptr.getTime()}</td>
                        <td>${seat.getServiceClass().getParticularFlight().flight.arr_airport.name}</td>
                        <td>${seat.getServiceClass().getParticularFlight().arr.getTime()}</td>
                        <td>${seat.row}${seat.symb}</td>
                        <td>
                          <a href="<c:url value="/for_clients/client={cl_id}/de-reserve"/>">
                            <p class="text-center">Разбронировать</p>
                          </a>
                        </td>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>У вас нет ни одного забронированного места</p>
        </c:otherwise>
    </c:choose>
  </div>
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>