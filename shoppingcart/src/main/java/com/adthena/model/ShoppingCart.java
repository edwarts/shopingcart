package com.adthena.model;

import java.util.HashMap;
import java.util.Map.Entry;

import com.adthena.model.inferces.iDiscountStrategy;
import com.adthena.model.inferces.iProduct;
import com.adthena.model.inferces.iShoppingCart;

public class ShoppingCart implements iShoppingCart{

	HashMap<iProduct, Integer> carts=new HashMap<iProduct, Integer>(); //use hashmap and the product  here is temporal to use as the key
	//this is simple shoppingcart and we do not have a rule to generate the product id
	public void add(iProduct product,int qty) {
		// TODO Auto-generated method stub
		carts.put(product, Integer.valueOf(qty));
		
	}

	public void remove(iProduct prodcut) {
		carts.remove(prodcut);
		
	}

	public double calculateTotal(iDiscountStrategy discountS) {
		// TODO Auto-generated method stub
	    if(carts.isEmpty())
	    {
		return 0;
	    }
	    else {
	    	double totalPrice=0.0;
	    	HashMap<String, Double> discoutnList=discountS.getPriceAfterDiscount();//use the HashMap here is to get the fast retrieve of the discount
	    	while(carts.entrySet().iterator().hasNext())
	    	{
	    		Entry<iProduct,Integer> oneProduct=carts.entrySet().iterator().next();
	    		if(discoutnList.containsKey(oneProduct.getKey().getProductName()))
	    		{
	    			totalPrice+=oneProduct.getKey().getProductPrice()*discoutnList.get(oneProduct.getKey())*oneProduct.getValue();
	    		}
	    		else {
	    			totalPrice+=oneProduct.getKey().getProductPrice()*oneProduct.getValue();
				}
	    	}
	    	
	    	return totalPrice;
		}
	   
	}

	public void showShoppingCartContent(iDiscountStrategy discountS) {
		// TODO Auto-generated method stub
		
	}

	
}
