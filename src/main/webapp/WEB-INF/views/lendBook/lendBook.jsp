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

		<h3>Wypożycz książkę</h3>

		<form:form method="post" modelAttribute="lendBook">
	
	Książka:<form:select path="book">
				<form:options items="${bookInLibrary}" itemValue="id"
					itemLabel="title" />
			</form:select>
			<br />
			<br />
			
	Użytkownik:<form:select path="user">
				<form:options var ="p" items="${availableUsers}" itemValue="id"
					itemLabel="fullName" />
			</form:select>
			<br />
			<br />
			<input type="submit" />

		</form:form>

	</div>
	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>