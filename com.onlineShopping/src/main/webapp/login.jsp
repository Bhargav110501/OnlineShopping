<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Customer Login</title>
        <link rel="stylesheet" type="text/css" href="stylel.css">
    </head>
    <body>
        <br>
        <h2>Login to start shopping</h2><br>
        <div class="Login">
            <form id="Login" action="log" method="post">
                <!-- Input field for User Name -->
                <label><b>User Name</b></label>
                <input type="text" name="UserName" id="textBox" placeholder="UserName">
                <br><br>
                <!-- Input field for Password -->
                <label><b>Password</b></label>
                <input type="password" name="Password" id="textBox" placeholder="password">
                <br><br>
                <!-- Submit button -->
                <input type="submit" id="sub" value="Log In">
                <br><br>
                <!-- Link to the registration page -->
                <a href="register.jsp">New user? Register here</a>
            </form>
        </div>
    </body>
</html>
