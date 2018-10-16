<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Správa katalogu</title>
</head>
<body>
	<h1>Správa katalogu</h1>
	[<a href="polozka.do">Přidat položku</a>]<br/>
	<table border="1">
			<tr>
				<th>Název</th>
				<th>Cena bez DPH</th>
				<th>DPH</th>
				<th>Cena s DPH</th>
				<th>Operace</th>
			</tr>
		<c:forEach var="p" items="${katalog.polozky}">
			<tr>
				<td>${p.nazev }</td>
				<td align="right"> 
					<fmt:formatNumber pattern="#,##0.00 Kč" value="${p.cena }"/> 
				</td>
				<td align="center"> 
					<fmt:formatNumber pattern="#0" value="${p.dph }"/> 
				</td>
				<td align="right"> 
					<fmt:formatNumber pattern="#,##0.00 Kč" value="${p.cenaSDph }"/> 
				</td>
				<td>
					<form action="sprava.do" style="display: inline">
						<input type="hidden" name="akce" value="remove" />
						<input type="hidden" name="polId" value="${p.id }" />
						<input type="submit" value=" X ">
					</form>
					<form action="polozka.do" style="display: inline">
						<input type="hidden" name="polId" value="${p.id }" />
						<input type="submit" value=" E ">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	[<a href="katalog.do">Zpět na katalog</a>]<br/>
</body>
</html>