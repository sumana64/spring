<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<form action="update" method="post">

		<div class="p-3 mb-2 bg-info text-emphasis-warning">

			<div class="mb-3">
				<label class="form-label">Id</label> <input type="number"
					class="form-control" placeholder="UserName" name="id"
					required="required" readonly value="${dto.id}">
			</div>

				<label class="form-label">UserName</label> <input type="text"
					class="form-control" placeholder="UserName" name="userName"
					required="required" value="${dto.userName}">
			</div>

			<div class="mb-3">
				<label class="form-label">Email</label> <input type="email"
					class="form-control" placeholder="Email" name="email"
					required="required" readonly value="${dto.email}">
			</div>

			<div class="mb-3">
				<label class="form-label">PhoneNo</label> <input type="tel"
					class="form-control" placeholder="PhoneNo" name="phoneNo"
					required="required" value="${dto.phoneNo}">
			</div>

			<div class="mb-3">
				<label class="form-label">Address</label> <input type="text"
					class="form-control" placeholder="Address" name="address"
					required="required" value="${dto.address}">
			</div>

			<div class="mb-3">
				<label class="form-label">PassWord</label> <input type="PassWord"
					class="form-control" placeholder="PassWord" name="passWord"
					required="required" value="${dto.passWord}">
			</div>
			<br>

			<div class="mb-3">
				<label class="form-label">Gender</label> <input type="text"
					class="form-control" placeholder="Gender" name="gender"
					required="required" value="${dto.gender}">
			</div>
			<br>

			<div class="mb-3">
				<label class="form-label">ShoppingFor</label> <input type="text"
					class="form-control" placeholder="ShoppingFor" name="shoppingFor"
					required="required" value="${dto.shoppingFor}">
			</div>
			<br> </select> <br> <input type="submit" value="update"
				class="btn btn-success">
	</form>

	<h1>${dto}</h1>
	<h1>${updatemessage}</h1>





</body>




</html>