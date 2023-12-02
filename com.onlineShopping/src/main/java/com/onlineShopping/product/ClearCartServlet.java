package com.onlineShopping.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/clear-cart")
public class ClearCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Get the session
	    HttpSession session = req.getSession();

	    // Retrieve the Cart object from the session
	    Cart cart = (Cart) session.getAttribute("cart");

	    // Check if the cart is not null
	    if (cart != null) {
	        cart.clearCart();
	        // Log a message to check if the cart is being cleared
	        System.out.println("Cart cleared");

	        // Update the cart in the session
	        session.setAttribute("cart", cart);
	    }

	    req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}
}
