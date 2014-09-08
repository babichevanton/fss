<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
	<form:form method="POST" action="registration/confirmation">
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
	        <td><form:label path="surname">Фамилия</form:label></td>
	        <td><form:input path="surname" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="name">Имя</form:label></td>
	        <td><form:input path="name" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="patronymic">Отчество</form:label></td>
	        <td><form:input path="patronymic" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="address">Контактный адрес</form:label></td>
	        <td><form:input path="address" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="phone">Контактный телефон</form:label></td>
	        <td><form:input path="phone" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="email">Адрес электронной почты</form:label></td>
	        <td><form:input path="email" /></td>
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