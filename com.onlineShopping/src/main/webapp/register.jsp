<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer Registration</title>
		<link rel ="stylesheet" type="text/css" href="styler.css">
	</head>
	<body>
		<h2>Register Here</h2><br>
		<div class="register">
			<form method="post" action="reg">
				<label><b>User Name
				</b>
				</label><br>
				<input type="text" name="UserName" id="textBox" placeholder="UserName">
				<br><br>
				<label><b>Email
				</b>
				</label><br>
				<input type="text" name="Email" id="textBox" placeholder="gamail@gmail.com">
				<br><br>
				<label><b>Password
				</b>
				</label><br>
				<input type="password" name="Password" id="textBox" placeholder="password">
				<br><br>
				<label><b>Gender
				</b>
				</label><br>
				<input type="radio" name="gender" value="male"> Male
				<input type="radio" name="gender" value="female"> Female
				<input type="radio" name="gender" value="other"> Other
				<label><b>Address
				</b>
				</label>
				<textarea rows="2" cols="20" name="address"id="textBox" class="for"></textarea>
				<br><br>
				<input type="submit" id="submit" value="Register">
				<br><br>
				<a href="login.jsp">Already register? Sign in instead of registering</a>
			</form>
		
		</div>
	</body>
</html>