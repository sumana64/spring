<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "findByPhoneNo" method="get">
<input type = "search" placeholder = "search" name = "phoneNo">
<input type = "submit">
<table border="1">
<ul>
<c:forEach items="${dto}" var="dto">
<tr>
<td>userName:${dto.userName}</td>
<td>email:${dto.email}<td>
<td>phoneNo:${dto.phoneNo}</td>
<td>address:${dto.address}</td>
<td>password:${dto.passWord}</td>
<td>gender:${dto.gender}</td>
<td>shopppingFor:${dto.shoppingFor}</td>
</tr>
</c:forEach>
</ul>
</table>
</form>

</body>
</html>