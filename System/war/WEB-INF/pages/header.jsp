<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<html>  
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Система информации об авиарейсах и билетах</title>
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>" type="text/css">
</head>
  
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-lg-10">
		    <a href="<c:url value="/home"/>" style="color:inherit;">
			<h1><p class="text-center" style="font-size:32px;">Авиарейсы Штолле</p></h1>
			</a>
		</div>
		<div class="col-lg-2">
			<a href="<c:url value="/authorization/client"/>">
				<p class="text-right" style="margin-top:20px;">Клиентам</p>
			</a>
			<a href="<c:url value="/authorization/administrator"/>">
				<p class="text-right" style="margin-top:20px;">Администраторам</p>
			</a>
			<a href="<c:url value="/registry"/>">
				<p class="text-right" style="margin-top:20px;">Регистрация</p>
			</a>
		</div>
	</div>
	<div class="row" style="margin-bottom:30px; margin-top:30px">