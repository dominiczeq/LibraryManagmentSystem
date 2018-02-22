<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<h3>Dodaj nowego użytkownika:</h3>

		<form:form method="post" modelAttribute="user">

	Imię: <form:input path="name" type="text" />
	Nazwisko: <form:input path="surname" type="text" />
	E-mail: <form:input path="email" type="text" />
	Numer kontaktowy: <form:input path="phoneNumber" type="text" />

			<br />
			<input type="submit" />

		</form:form>
	</div>
	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>