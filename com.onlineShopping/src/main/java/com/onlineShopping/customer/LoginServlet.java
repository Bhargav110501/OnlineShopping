package com.onlineShopping.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("UserName");
		String Password = req.getParameter("Password");
		boolean val = Validator.isValid(userName, Password);
		if (val == true && userName.equals("admin")) {
            resp.sendRedirect("admin.jsp");
        } else if (val == true) {
            resp.sendRedirect("home.jsp");
        } else {
            System.out.println("Authentication failed for user: " + userName);
            resp.sendRedirect("login.jsp");
        }
	}

}
