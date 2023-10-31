<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "findByEmail" method="get">
<input type = "search" placeholder = "search" name = "email">
<input type = "submit">
<table border="1">
<ul>
<c:forEach items="${dto}" var="dto">
<tr>
<td>userName:${dto.name}</td>
<td>email:${dto.email}<td>
<td>phoneNo:${dto.phoneNo}</td>
<td>address:${dto.address}</td>
</tr>
</c:forEach>
</ul>
</table>
</form>

</body>
</html>