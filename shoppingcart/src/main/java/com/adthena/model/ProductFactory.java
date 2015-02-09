package com.adthena.model;

import com.adthena.model.inferces.iProduct;
import com.adthena.model.inferces.iProductFactory;

public class ProductFactory implements iProductFactory {

	//this is only a mock
	//real product list will be tr
	public iProduct getProduct(String instanceName) {
		switch (instanceName) {
		case "Apple":
			return new Product("Apple", 1.0);
		case "Milk":
			return new Product("Milk", 0.65);
		case "Bread":
			return new Product("Apple", 0.8);
		case "Soup":
			return new Product("Soup", 1.0);
		default:
			break;
		}
		return null;
	}

}
