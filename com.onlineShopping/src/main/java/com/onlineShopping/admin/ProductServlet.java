package com.onlineShopping.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineShopping.dbHandler.DataInjector;

@WebServlet("/addP")
public class ProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int pid = Integer.parseInt(req.getParameter("product-id"));
		String pname = req.getParameter("product-name");
		String pdesc = req.getParameter("product-description");
		int pprice = Integer.parseInt(req.getParameter("product-price"));
		String pimg = req.getParameter("product-image");
		
		DataInjector.addProduct(pid, pname, pdesc, pprice, pimg);
	}
}
