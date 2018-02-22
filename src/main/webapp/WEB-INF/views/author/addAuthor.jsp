<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dodaj nowego autora</title>
</head>
<body>
<h3>Dodaj nowego autora:</h3>

<form:form method="post" modelAttribute="author">

Nazwa wydawnictwa: <form:input path="authorName" type="text"/>

<br/>
<input type="submit" />

</form:form>



</body>
</html>