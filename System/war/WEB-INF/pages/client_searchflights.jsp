<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<div class="container-fluid col-lg-5 col-lg-offset-3">
	<form:form method="POST" action="flights">
		<table>
		<tr>
	        <td><form:label path="dptr_town">Город вылета</form:label></td>
	        <td><form:input path="dptr_town" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="dptr_time">Дата вылета</form:label></td>
	        <td><form:input path="dptr_time" /></td>
	    </tr>
		<tr>
	        <td><form:label path="arr_town">Город прилета</form:label></td>
	        <td><form:input path="arr_town" /></td>
	    </tr>
		<tr>
	        <td><form:label path="arr_time">Дата прилета</form:label></td>
	        <td><form:input path="arr_time" /></td>
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