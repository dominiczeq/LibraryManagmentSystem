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

		<h3>Lista czytelników:</h3>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th>Email</th>
				<th>Numer telefonu</th>
				<th>ilość wypożycznych książek</th>
			</tr>
			<c:forEach var="p" items="${allUsers}">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.surname}</td>
					<td>${p.email}</td>
					<td>${p.phoneNumber}</td>
					<td>${p.borrowedBooks}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>