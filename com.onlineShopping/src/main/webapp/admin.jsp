<%@ page import="com.onlineShopping.dbHandler.DataFetcher"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin home</title>
<link rel="stylesheet" href="stylea.css">
</head>
<body>
	<%
	List<String> userList = DataFetcher.fetchUsersInfo();
	List<String> prodList = DataFetcher.fetchProductsInfo();
	%>

	<div class="panel">
		<div class="buttoncontainer">
			<a href="#tab1">View customers</a>
            <a href="#tab2">View products info</a>
            <a href="#tab3">Add new product</a>
		</div>
		<div class="content-container">
			<div class="tab active" id="tab1">
				<table border>
					<thead>
						<tr>
							<th>Username</th>
							<th>Email</th>
							<th>Gender</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>

						<%
						for (int i = 0; i < userList.size(); i++) {
							String[] custArr = ((String) userList.get(i)).split(":");
						%>

						<tr>
							<td><%=custArr[0]%></td>
							<td><%=custArr[1]%></td>
							<td><%=custArr[2]%></td>
							<td><%=custArr[3]%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<div class="tab" id="tab2">
				<table border>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <%
                for(int i = 0; i < prodList.size(); i++) {
                    String[] prodArr = ((String)prodList.get(i)).split(":");
            %>
            <tr>
                <td><%= prodArr[0] %></td>
                <td><%= prodArr[1] %></td>
                <td><%= prodArr[2] %></td>
                <td><%= prodArr[3] %></td>
                <td><img src="images/<%= prodArr[4] %>" alt="Product <%= prodArr[0] %>"></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
			</div>
			<div class="tab" id="tab3">
				<form action="addP" method="post">
					<div class="form-group">
						<label for="product-id">Product ID:</label> <input type="text"
							id="product-id" name="product-id" required>
					</div>
					<br> <br>
					<div class="form-group">
						<label for="product-name">Product Name:</label> <input type="text"
							id="product-name" name="product-name" required>
					</div>
					<br> <br>
					<div class="form-group">
						<label for="product-description">Product Description:</label> <input
							type="text" id="product-description" name="product-description"
							required>
					</div>
					<br> <br>
					<div class="form-group">
						<label for="product-price">Product Price:</label> <input
							type="text" id="product-price" name="product-price" required>
					</div>
					<br> <br>
					<div class="form-group">
						<label for="product-image">Product Image:</label> <input
							type="text" id="product-image" name="product-image" required>
					</div>
					<br> <br>
					<button type="submit">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
