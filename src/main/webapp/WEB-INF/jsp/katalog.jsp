<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Katalog</title>
</head>
<body>
	<h1>Katalog</h1>
	<table border="1">
			<tr>
				<th>Název</th>
				<th>Cena bez DPH</th>
				<th>DPH</th>
				<th>Cena s DPH</th>
			</tr>
		<c:forEach var="p" items="${polozky}">
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
					<form action="kosik.do" style="display: inline">
						<input type="hidden" name="akce" value="update" />
						<input type="hidden" name="polId" value="${p.id }" />
						<c:choose>
							<c:when test="${empty mapKosik[p.id] }">
								<input type="text" name="cnt" value="0" size="3"/>
							</c:when>
							<c:otherwise>
								<input type="text" name="cnt" value="${mapKosik[p.id].pocet}" size="3"/>
							</c:otherwise>
						</c:choose>
							
						<input type="submit" value="Do košíku">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	[<a href="kosik.do">Obsah košíku</a>]<br/>
	[<a href="sprava.do">Správa katalogu</a>]<br/>
</body>
</html>