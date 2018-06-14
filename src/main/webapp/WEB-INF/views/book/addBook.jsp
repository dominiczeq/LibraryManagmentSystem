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
	
	<h3>Dodaj książkę:</h3>

	<form:form method="post" modelAttribute="book">

	Tytuł: <form:input path="title" type="text" /> <form:errors path="title"/>
		<br />
		<br />
		
	Autor:<form:select path="author">
			<form:options items="${availableAuthors}" 
			itemValue="id"
			itemLabel="authorName" />
		</form:select>
		<a class="nav-link" href="${pageContext.request.contextPath}/addAuthorFromBook" class="href">Dodaj autora</a>
		<br />
			
	Wydawnictwo:<form:select path="publisher">
			<form:options items="${availablePublishers}" 
			itemValue="id"
			itemLabel="publisherName" />
		</form:select>
		<a class="nav-link" href="${pageContext.request.contextPath}/addPublisherFromBook" class="href">Dodaj wydawnictwo</a>
		<br />
			
	 Gatunek:   <form:select path="genre">
			<form:options items="${availableGenres}" 
			itemValue="id"
			itemLabel="genreName" />
		</form:select>
				<a class="nav-link" href="${pageContext.request.contextPath}/addGenreFromBook" class="href">Dodaj wydawnictwo</a>
		<br />
	
	Rok wydania: <form:input path="publicationDate" type="number" value="2018" min="1950" max="2018"/> <form:errors path="publicationDate"/>
		<br />
		<br />
	Ilość: <form:input path="amount" type="number" value="1" max="200"/> <form:errors path="amount"/>
		<br />
		<br />

		<input type="submit" />

	</form:form>

	<%@ include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>