<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<form action="findAll" method="get">
		<div style = "text-align": center;">
		<table class= "table">	
		<tbody>
				<tr>
					<th scope="col">name</th>
					<th scope="col">email</th>
					<th scope="col">phoneNo</th>
					<th scope="col">address</th>
				</tr>
			<tr>
			<c:forEach items="${dto}" var="dto">
				<td>${dto.name}</td>
				<td>${dto.email}</td>
				<td>${dto.phoneNo}</td>
				<td>${dto.address}</td>
			<td><a href="update?id=${dto.id}">update</a></td>
			<td><a href="deleteById?id=${dto.id}">Delete</a></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
         </div>
         <div class = "text-center">
          <input type="submit">
         </div> 
	</form>
	<h1>${success}</h1>
	<h1>${fail}</h1>
	<h1>${updatedMessage}</h1>

</body>
</html>