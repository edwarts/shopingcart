package com.adthena.model.inferces;

import java.util.HashMap;

public interface iDiscountStrategy {

	public HashMap<String, Double> getPriceAfterDiscount();
	public String showDiscountContent();
}
