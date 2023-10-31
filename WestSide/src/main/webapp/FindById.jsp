<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${success}</h1>
<h1>${fail}</h1>
<form action = "findById" method="get">
<input type = "search" placeholder = "search" name = "id">
<input type = "submit">
<table border="1">
<ul>
<tr>
<td>userName:${dto.userName}</td>
<td>email:${dto.email}<td>
<td>phoneNo:${dto.phoneNo}</td>
<td>address:${dto.address}</td>
<td>password:${dto.passWord}</td>
<td>gender:${dto.gender}</td>
<td>shopppingFor:${dto.shoppingFor}</td>
<td><a href = "deleteById?id=${dto.id}" class="btn btn-sm btn-danger m-1">Delete</a>
</tr>
</ul>
</table>
</form>
</body>
</html>

