<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dostępni autorzy</title>
</head>
<body>

<h3>Dostępni autorzy:</h3>
	<table border="1">

		<tr>
			<th>Id</th>
			<th>Autor</th>
		</tr>

		<c:forEach var="p" items="${allAuthors}">

			<tr>
				<td>${p.id}</td>
				<td>${p.authorName}</td>
				

			</tr>

		</c:forEach>

	</table>

</body>
</html>