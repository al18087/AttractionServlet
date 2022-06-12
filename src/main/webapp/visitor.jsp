<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
<title>visitor</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">入場券を以下の内容で購入しました</h1>
	</header>
	<table class="table">
		<tr>
			<th>入場者番号</th>
			<td>${visitor.visitorId}</td>
		</tr>
		<tr>
			<th>チケットの種類</th>
			<td>${ticketName}</td>
		</tr>
		<tr>
			<th>入場日</th>
			<td>${visitor.visitorDate}</td>
		</tr>
		<tr>
			<th>入場時刻</th>
			<td>${visitor.visitorTime}</td>
		</tr>
	</table>
</body>
</html>