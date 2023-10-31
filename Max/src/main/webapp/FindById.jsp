<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "findById" method="get">
<input type = "search" placeholder = "search" name = "id">
<input type = "submit">
<table border="1">
<ul>
<tr>
<td>userName:${dto.name}</td>
<td>email:${dto.email}<td>
<td>phoneNo:${dto.phoneNo}</td>
<td>address:${dto.address}</td>
</tr>
</ul>
</table>
</form>

</body>
</html>