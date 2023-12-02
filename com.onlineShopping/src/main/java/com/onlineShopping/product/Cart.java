package com.onlineShopping.product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	public void addItem(Product product) {
		items.add(product);
	}
	
	public List<Product> getItems(){
		return items;
	}
	
	public void clearCart() {
        items.clear();
    }
	
	public int getTotalItems() {
        return items.size();
    }
	
	public double getTotal() {
	    double total = 0.0;
	    for (Product item : items) {
	        if (item != null) {
	            total += item.getPprice();
	        }
	    }
	    return total;
	}

}
