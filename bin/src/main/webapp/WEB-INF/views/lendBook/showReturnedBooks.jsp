<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="../jspf/headConfig.jspf"%>
<title>System zarządzania biblioteką</title>
</head>
<body>

	<%@ include file="../jspf/mainMenu.jspf"%>
	<div class="container">
	<div class="col-10">

		<h3>Historia wypożyczonych pozycji</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Tytuł książki</th>
					<th scope="col">Wypożyczający</th>
					<th scope="col">Data wypożyczenia</th>
					<th scope="col">Data oddania</th>
				</tr>
			</thead>
			<c:forEach var="p" items="${returnedBooks}">
				<tbody>
					<tr>
						<th scope="row">${p.id}</th>
						<td>${p.book}</td>
						<td>${p.user}</td>
						<td>${p.lendDate}</td>
						<td>${p.returnBook}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		</div>
	</div>
	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>