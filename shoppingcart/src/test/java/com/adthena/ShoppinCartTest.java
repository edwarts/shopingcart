package com.adthena;

import static org.junit.Assert.*;

import org.junit.Test;

import com.adthena.model.AppleOnlyDiscount;
import com.adthena.model.Product;
import com.adthena.model.ProductFactory;
import com.adthena.model.ShoppingCart;
import com.adthena.model.ShoppingCartFactory;
import com.adthena.model.inferces.iProduct;
import com.adthena.model.inferces.iShoppingCart;

public class ShoppinCartTest {

	@Test
	public void ShosppingCartGenerate() {
		iShoppingCart sc=new ShoppingCartFactory().getShoppingCart("HashMapShoppingCart");
		assertTrue(sc instanceof ShoppingCart);
		sc=new ShoppingCartFactory().getShoppingCart("");
		assertEquals(null, sc);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void ShoppingCartOp()
	{
		iShoppingCart sc=new ShoppingCartFactory().getShoppingCart("HashMapShoppingCart");
		iProduct apple=new ProductFactory().getProduct("Apple");
		assertTrue(apple instanceof Product);
		assertTrue(apple.getProductName()=="Apple");
		assertTrue(apple.getProductPrice()==1.0);
		sc.add(apple, 1);
		double[] basketPrice=sc.calculateTotal(new AppleOnlyDiscount());
		assertTrue(basketPrice[1]==0.9);
		assertTrue(basketPrice[0]==1.0);
		iProduct bread=new ProductFactory().getProduct("Bread");
		sc.add(bread,2);
		basketPrice=sc.calculateTotal(new AppleOnlyDiscount());
		assertTrue(basketPrice[1]==2.5);
		assertTrue(basketPrice[0]==2.6);
		//add something exist
		sc.add(apple, 1);
		basketPrice=sc.calculateTotal(new AppleOnlyDiscount());
		assertTrue(basketPrice[1]==3.4);
		assertTrue(basketPrice[0]==3.6);
		
	}
	

}
