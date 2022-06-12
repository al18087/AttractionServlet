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
<title>login</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">入場者番号を入力</h1>
	</header>
	<form action="/attraction/LoginServlet?action=login" method="post">
		<table class="table">
			<tr>
				<th>入場者番号</th>
				<td><input type="text" name="visitor_id"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン" class="btn btn-primary">
	</form>
</body>
</html>