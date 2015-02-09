package com.adthena.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.adthena.model.inferces.iDiscountStrategy;
import com.adthena.model.inferces.iProduct;
import com.adthena.model.inferces.iShoppingCart;

public class ShoppingCart implements iShoppingCart{

	HashMap<iProduct, Integer> carts=new HashMap<iProduct, Integer>(); //use hashmap and the product  here is temporal to use as the key
	//this is simple shoppingcart and we do not have a rule to generate the product id
	public void add(iProduct product,int qty) {
		// TODO Auto-generated method stub
		if(carts.containsKey(product))
		{
			//exist
			int tmpQty=carts.get(product).intValue();
			carts.remove(product);
			carts.put(product, tmpQty+qty);
			
		}
		else {
			carts.put(product, Integer.valueOf(qty));
		}
		
		
	}

	public void remove(iProduct product) {
		if(carts.containsKey(product))
		{
		carts.remove(product);
		}
		
	}

	//inject the dependency in the method's parameter is the lowest level of coupling
	//in scala is easy to return a tuple because we just need two subtotal price
	public double[] calculateTotal(iDiscountStrategy discountS) {
		// TODO Auto-generated method stub
	    if(carts.isEmpty())
	    {
		return new double[]{0,0};
	    }
	    else {
	    	double totalPrice=0.0;
	    	double subtotalPrice=0.0;
	    	HashMap<String, Double> discoutnList=discountS.getPriceAfterDiscount();//use the HashMap here is to get the fast retrieve of the discount
	    	Iterator<Entry<iProduct, Integer>> it=carts.entrySet().iterator();
	    	while(it.hasNext())
	    	{
	    		Entry<iProduct,Integer> oneProduct=it.next();
	    		if(discoutnList.containsKey(oneProduct.getKey().getProductName()))
	    		{
	    			totalPrice+=oneProduct.getKey().getProductPrice()*discoutnList.get(oneProduct.getKey().getProductName())*oneProduct.getValue();
	    		}
	    		else {
	    			totalPrice+=oneProduct.getKey().getProductPrice()*oneProduct.getValue();
				}
	    		subtotalPrice+=oneProduct.getKey().getProductPrice()*oneProduct.getValue();
	    	}
	    	
	    	return new double[]{subtotalPrice,totalPrice};
		}
	   
	}

	public void showShoppingCartContent(iDiscountStrategy discountS) {
		// TODO Auto-generated method stub
		double[] priceToShow=calculateTotal(discountS);
		System.out.println("Subtotal:"+priceToShow[0]);
		String discountInfo=discountS.showDiscountContent();
		System.out.println(discountInfo);
		System.out.println("Total:"+priceToShow[1]);
		
		
		
	}

	
}
