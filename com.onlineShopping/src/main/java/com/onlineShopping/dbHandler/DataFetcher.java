package com.onlineShopping.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineShopping.product.Product;

public class DataFetcher {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/onlineshopping";
	static String un = "root";
	static String pass = "Bhargav@1105";

	public static String fetchPassword(String UserName) {
		String sql = "SELECT Password FROM customer WHERE UserName = ?";
		String dbPass = "";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, un, pass);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, UserName);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dbPass = rs.getString("Password");
			}
		} catch (Exception e) {
			System.out.println("Login issues");
			e.printStackTrace();
		}
		return dbPass;
	}

	public static List<String> fetchUsersInfo() {
		String sql = "SELECT userName, Email, gender, address FROM customer";
		List<String> userList = new ArrayList<>();

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, un, pass);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userEntry = rs.getString("userName") + ":" + rs.getString("Email") + ":" + rs.getString("gender")
						+ ":" + rs.getString("address");
				userList.add(userEntry);
			}
		} catch (Exception e) {
			System.err.println("Error fetching user information: " + e.getMessage());
		}

		return userList;
	}

	public static List<String> fetchProductsInfo() {
		String sql = "SELECT pid, pname, pdesc, pprice, pimg FROM product";
		List<String> prodList = new ArrayList<>();

		try {
			Class.forName(driver);
			try (Connection con = DriverManager.getConnection(url, un, pass);
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String prodEntry = rs.getInt("pid") + ":" + rs.getString("pname") + ":" + rs.getString("pdesc")
							+ ":" + rs.getInt("pprice") + ":" + rs.getString("pimg");
					prodList.add(prodEntry);
				}
			}
		} catch (Exception e) {
			System.err.println("Problem in fetching products");
			e.printStackTrace();
		}
		return prodList;
	}

	public static Product getProductById(int pid) {
		String sql = "SELECT pname, pprice FROM product WHERE pid = ?";
	    Product p = null;

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, un, pass);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
	            String pname = rs.getString("pname");
	            int pprice = rs.getInt("pprice");

	            p = new Product(pid, pname, pprice);
	        }
		} catch (Exception e) {
			System.out.println("Problem in fetching the product");
			e.printStackTrace();
		}
		return p;
	}

}
