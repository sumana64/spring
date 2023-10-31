<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<form action="register" method="post">
	
		<div class="p-3 mb-2 bg-info text-emphasis-warning">
		

			<div class="mb-3">
				<label class="form-label">UserName</label> <input type="text"
					class="form-control" placeholder="UserName" name="userName"
					required="required">
			</div>

			<div class="mb-3">
				<label class="form-label">Email</label> <input type="email"
					class="form-control" placeholder="Email" name="email"
					required="required">
			</div>

			<div class="mb-3">
				<label class="form-label">PhoneNo</label> <input type="tel"
					class="form-control" placeholder="PhoneNo" name="phoneNo"
					required="required">
			</div>

			<div class="mb-3">
				<label class="form-label">Address</label> <input type="text"
					class="form-control" placeholder="Address" name="address"
					required="required">
			</div>

			<div class="mb-3">
				<label class="form-label">PassWord</label> <input type="PassWord"
					class="form-control" placeholder="PassWord" name="passWord"
					required="required">
			</div>
			<br>

			<div class="mb-3">
				<label class="form-label">Gender</label> <input type="text"
					class="form-control" placeholder="Gender" name="gender"
					required="required">
			</div>
			<br>
			
			<div class="mb-3">
				<label class="form-label">ShoppingFor</label> <input type="text"
					class="form-control" placeholder="ShoppingFor" name="shoppingFor"
					required="required">
			</div>
			<br>
	    
				
			</select> <br> <input type="submit" class="btn btn-success">
	</form>
	         <c:forEach items="${voilation}" var="voilation">
              <h1>${voilation.messageTemplate}</h1>
	          </c:forEach>
	         
            
</body>
</html>