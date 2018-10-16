<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	.err {
		color : red;
	}
</style>
<title>Detail položky</title>
</head>
<body>
	<h1>Detail položky</h1>
	<form:form modelAttribute="polozka">
		<table>
			<tr>
				<td>ID položky</td>
				<td><form:input path="id" size="5"/></td>
				<td><form:errors path="id" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Název položky</td>
				<td><form:input path="nazev"/></td>
				<td><form:errors path="nazev" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Cena bez DPH</td>
				<td><form:input path="cena" size="10"/> Kč</td>
				<td><form:errors path="cena" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Sazba DPH</td>
				<td><form:input path="dph" size="5"/> %</td>
				<td><form:errors path="dph" cssClass="err"/></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="Uložit"/>	
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>