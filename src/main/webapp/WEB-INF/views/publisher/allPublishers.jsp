<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<table border="1">

		<tr>
			<th>Id</th>
			<th>Wydawnictwo</th>
		</tr>

		<c:forEach var="p" items="${allPublishers}">

			<tr>
				<td>${p.id}</td>
				<td>${p.publisherName}</td>
				<td><a href="${pageContext.request.contextPath}/publisher/${p.id}/del">Usuń</a></td>
				<td><a href="${pageContext.request.contextPath}/publisher/${p.id}/modify">Modyfikuj</a></td>

			</tr>

		</c:forEach>

	</table>

</body>
</html>