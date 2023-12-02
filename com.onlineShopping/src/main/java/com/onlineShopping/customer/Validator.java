package com.onlineShopping.customer;

import com.onlineShopping.dbHandler.DataFetcher;

public class Validator {
	
	public static boolean isValid(String userName, String password) {
        try {
            String dbPass = DataFetcher.fetchPassword(userName);
            return password.equals(dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}