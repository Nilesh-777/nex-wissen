package com.app;

import java.util.List;
import java.util.Optional;

import com.app.model.*;
import com.app.repository.JDBCRepository;

public class App {
	public static void main(String[] args) {
		Product product = new Product("MI", 3000.00, "MOBILE");
		JDBCRepository dbAccess = new JDBCRepository();

		// dbAccess.save(product);
		//
		dbAccess.delete(106);
		//
		// dbAccess.update(105, 61000.20);
		//
		// Optional<Product> optional = dbAccess.findById(105);
		// Product product2 = optional.get();
		// System.out.println(product2);
		//
		// List<Product> products = dbAccess.findAll();

		List<Product> products = dbAccess.test();
		
		 for(Product p: products)
		 System.out.println(p);

	}
}
