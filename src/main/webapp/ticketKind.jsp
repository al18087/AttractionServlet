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
<title>ticket</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">入場券購入</h1>
	</header>
	<h4>購入するチケットを選択してください</h4>
	<br>
	<form action="/attraction/TicketingServlet?action=purchase_ticket"
		method="post">
		<select name="ticket">
			<c:forEach items="${ticket}" var="item">
				<option value="${item.ticketId}">${item.ticketName}:
					￥${item.price}
			</c:forEach>
		</select> <input type="submit" value="購入" class="btn btn-primary">
	</form>
</body>
</html>