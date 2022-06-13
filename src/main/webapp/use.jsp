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
<title>use</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">アトラクションを予約しました。</h1>
	</header>
	<table class="table">
		<tr>
			<th>アトラクション</th>
			<td>${attraction_name}</td>
		</tr>
		<tr>
			<th>予約時刻</th>
			<td>${use_time}</td>
		</tr>
	</table>
</body>
</html>