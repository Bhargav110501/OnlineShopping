package com.onlineShopping.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataInjector {
	
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/onlineshopping";
	static String un = "root";
	static String pass = "Bhargav@1105";
	
	
	@SuppressWarnings("finally")
	public static String addCustomer(String userName, String Email, String Password, String gender, String address) {
		String sql = "INSERT INTO `customer` VALUES (?, ?, ?, ?, ?)";
		String regStatus = "";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, un, pass);
			PreparedStatement ps = con.prepareStatement(sql);
			
				ps.setString(1, userName);
				ps.setString(2, Email);
				ps.setString(3, Password);
				ps.setString(4, gender);
				ps.setString(5, address);
				
				ps.executeUpdate();
				
				regStatus = "success";
		}catch(Exception e) {
			System.out.println("Problem in adding customer");
			e.printStackTrace();
			regStatus = "fail";
		}finally {
			return regStatus;
		}
	}
	public static boolean addProduct(int pid, String pname, String pdesc, int pprice, String pimg) {
	    String sql = "INSERT INTO product VALUES(?, ?, ?, ?, ?)";
	    try {
	        Class.forName(driver);
	        Connection con = DriverManager.getConnection(url, un, pass);
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, pid);
	        ps.setString(2, pname);
	        ps.setString(3, pdesc);
	        ps.setInt(4, pprice);
	        ps.setString(5, pimg);

	        // Execute the INSERT statement
	        int rowsAffected = ps.executeUpdate();

	        // Check if any rows were affected
	        if (rowsAffected > 0) {
	            System.out.println("Insert success");
	            return true;
	        } else {
	            System.out.println("No rows affected, insert failed");
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println("Problem in adding product");
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
