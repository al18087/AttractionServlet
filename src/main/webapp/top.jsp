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
<title>top</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">アトラクション選択</h1>
	</header>
	<form
		action="/attraction/ReserveServlet?action=reserve&visitor_id=${login}"
		method="post">
		<select name="attraction">
			<c:forEach items="${attraction}" var="item">
				<option value="${item.attractionId}">${item.attractionName}
					￥${item.price}
			</c:forEach>
		</select>
		<input type="submit" value="予約" class="btn btn-primary">
	</form>
</body>
</html>