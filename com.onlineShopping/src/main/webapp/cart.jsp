<%@ page import="com.onlineShopping.product.Product"%>
<%@ page import="com.onlineShopping.product.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<link rel="stylesheet" href="stylec.css">
</head>
<body>

	<header>
		<h1>Your Shopping Cart</h1>
		<nav>
			<ul>
				<li><a href="home.jsp" class="button">Continue Shopping</a></li>
				<li>
					<form action="clear-cart" method="get">
						<button type="submit" class="button">Clear cart</button>
					</form>
				</li>
			</ul>
		</nav>
	</header>

	<main>
		<section class="cart">
			<table border="1">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<%
					Cart cart = (Cart) session.getAttribute("cart");
					if (cart != null && !cart.getItems().isEmpty()) {
						for (Product item : cart.getItems()) {
					%>
					<tr>
						<td><%=item.getPname()%></td>
						<td><%=item.getPprice()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="2">Your cart is empty.</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<div class="total">
				<p>
					Total:
					<%=cart != null ? cart.getTotal() : 0.0%></p>
			</div>
		</section>
	</main>
	<!-- 
	<div class="total">
		<p>
			Total:
			//<%=cart != null ? cart.getTotal() : 0.0%></p>
	</div>
	 -->
</body>
</html>
