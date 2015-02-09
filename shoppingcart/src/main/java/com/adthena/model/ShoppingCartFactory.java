package com.adthena.model;

import com.adthena.model.inferces.iShoppingCart;
import com.adthena.model.inferces.iShoppingCartFactory;

public class ShoppingCartFactory implements iShoppingCartFactory {

	public iShoppingCart getShoppingCart(String instanceName) {
		//we can have a range of implementation of shopping cart, the hashmap one is the basic
		switch (instanceName) {
		case "HashMapShoppingCart":
			return new ShoppingCart();
			

		default:
			return null;
			
		}
	}

}
