<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
  <c:choose>
      <c:when test="${not empty client}">
		<%@ include file="/WEB-INF/pages/authorization_client_succeed.jsp" %>
      </c:when>
      <c:otherwise>
		<%@ include file="/WEB-INF/pages/authorization_client_failed.jsp" %>
      </c:otherwise>
  </c:choose>
</div>
<div class="container-fluid col-lg-5 col-lg-offset-3">
</div>
<%@ include file="/WEB-INF/pages/footer.jsp" %>