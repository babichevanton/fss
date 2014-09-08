<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
	<form:form method="POST" action="for_admins">
		<table>
		<tr>
	        <td><form:label path="login">Логин</form:label></td>
	        <td><form:input path="login" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="password">Пароль</form:label></td>
	        <td><form:input path="password" /></td>
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