package com.adthena.model;

import java.util.HashMap;

import com.adthena.model.inferces.iDiscountStrategy;

public class AppleOnlyDiscount implements iDiscountStrategy {

	private HashMap<String, Double> discount=new HashMap<String, Double>();
	public AppleOnlyDiscount() {
		discount.put("Apple", 0.9);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public HashMap<String, Double> getPriceAfterDiscount() {
		
		return discount;
	}

	@Override
	public String showDiscountContent() {
		// TODO Auto-generated method stub
		return "Apples have a 10%";
	}

}
