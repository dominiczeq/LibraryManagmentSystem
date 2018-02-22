<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dodaj książkę</title>
</head>
<body>
	<h3>Dodaj książkę:</h3>

	<form:form method="post" modelAttribute="book">

	Tytuł: <form:input path="title" type="text" />
		<br />
		<br />
		
	Autor:<form:select path="author">
			<form:options items="${availableAuthors}" 
			itemValue="id"
			itemLabel="authorName" />
		</form:select>
		<a class="nav-link" href="${pageContext.request.contextPath}/addAuthor" class="href">Dodaj autora</a>
		<br />
		<br />
			
	Wydawnictwo:<form:select path="publisher">
			<form:options items="${availablePublishers}" 
			itemValue="id"
			itemLabel="publisherName" />
		</form:select>
		<a class="nav-link" href="${pageContext.request.contextPath}/addPublisher" class="href">Dodaj wydawnictwo</a>
		<br />
		<br />
			
	 Gatunek:   <form:select path="genre">
			<form:options items="${availableGenres}" 
			itemValue="id"
			itemLabel="genreName" />
		</form:select>
				<a class="nav-link" href="${pageContext.request.contextPath}/addGenre" class="href">Dodaj autora</a>
		<br />
		<br />
	
	Rok wydania: <form:input path="publicationDate" type="text" />
		<br />
		<br />
	Ilość: <form:input path="amount" type="text" />
		<br />
		<br />

		<input type="submit" />

	</form:form>

</body>
</html>