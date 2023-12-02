<%@ page import="com.onlineShopping.dbHandler.DataFetcher"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy Shopping</title>
<link rel="stylesheet" href="styleh.css">
</head>
<body>
	<%
	List<String> prodList = DataFetcher.fetchProductsInfo();
	%>

	<header>
		<h1>Happy Shopping</h1>
		<nav>
			<ul>
				<li><a href="#" class="view-cart"> <i
						class="fas fa-shopping-cart"></i> <span> <a href="cart.jsp">
								<button class="btn add-to-cart">View Cart</button>
						</a>
					</span> <span> <a href="login.jsp">
								<button class="btn logout"
									style="background-color: red; color: #fff; border: none; padding: 10px 15px;">Logout</button>
						</a>
					</span>
				</a></li>
			</ul>
		</nav>
	</header>

	<main>
		<%
		String[] prodArr2 = null;
		for (int i = 0; i < prodList.size(); i++) {
			String[] prodArr = ((String) prodList.get(i)).split(":");
		%>
		<section class="product">
			<img src="images/<%=prodArr[4]%>" alt="Product 1">
			<h2><%=prodArr[1]%></h2>
			<p><%=prodArr[2]%></p>
			<span class="price"><%=prodArr[3]%></span>
			<form method="post" action="add-to-cart">
				<input type="hidden" name="productId"
					value="<%=Integer.parseInt(prodArr[0])%>"> <input
					type="submit" value="Add to Cart" class="btn add-to-cart">
			</form>
		</section>
		<%
		}
		%>
	</main>
</body>
</html>