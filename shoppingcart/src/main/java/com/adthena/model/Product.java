package com.adthena.model;

import com.adthena.model.inferces.iProduct;

public class Product implements iProduct {

	public String _productName;
	public double _productPrice;
	public Product(String productName,double productPrice)
	{
		_productName=productName;
		_productPrice=productPrice;
	}
	public String getProductName() {
		// TODO Auto-generated method stub
		return _productName;
	}

	public double getProductPrice() {
		// TODO Auto-generated method stub
		return _productPrice;
	}

}
