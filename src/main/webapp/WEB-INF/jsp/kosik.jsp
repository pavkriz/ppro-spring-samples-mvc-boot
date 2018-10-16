<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Košík</title>
</head>
<body>
	<h1>Košík</h1>
	<table border="1">
			<tr>
				<th>Název</th>
				<th>Cena bez DPH</th>
				<th>DPH</th>
				<th>Cena s DPH</th>
				<th>Množství</th>
			</tr>
		<c:forEach var="p" items="${kosik.polozky}">
			<tr>
				<td>${p.polozka.nazev }</td>
				<td align="right"> 
					<fmt:formatNumber pattern="#,##0.00 Kč" value="${p.polozka.cena }"/> 
				</td>
				<td align="center"> 
					<fmt:formatNumber pattern="#0" value="${p.polozka.dph }"/> 
				</td>
				<td align="right"> 
					<fmt:formatNumber pattern="#,##0.00 Kč" value="${p.polozka.cenaSDph }"/> 
				</td>
				<td>
					${p.pocet}
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td><strong>CELKEM</strong></td>
			<td align="right">
				<strong>
				<fmt:formatNumber pattern="#,##0.00 Kč" value="${ kosik.cenaCelkem}"/>
				</strong>
			</td>
			<td></td>
			<td align="right">
				<strong>
				<fmt:formatNumber pattern="#,##0.00 Kč" value="${ kosik.cenaSDphCelkem}"/>
				</strong>
			</td>
		</tr>
	</table>
	<c:url var="kosClear" value="kosik.do">
		<c:param name="akce" value="clear"/>
	</c:url>
	[<a href="${kosClear }">Vysypat</a>]
	[<a href="katalog.do">Zpět do katalogu</a>]
</body>

</html>