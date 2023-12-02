package com.onlineShopping.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineShopping.dbHandler.DataInjector;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("UserName");
		String Email = req.getParameter("Email");
		String Password = req.getParameter("Password");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		
		String status = DataInjector.addCustomer(userName, Email, Password, gender, address);
		
		resp.sendRedirect("login.jsp");
	}
}
