package com.adthena;

import com.adthena.model.AppleOnlyDiscount;
import com.adthena.model.ProductFactory;
import com.adthena.model.ShoppingCartFactory;
import com.adthena.model.inferces.iDiscountStrategy;
import com.adthena.model.inferces.iProductFactory;
import com.adthena.model.inferces.iShoppingCart;
import com.adthena.utility.InputHelper;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Intpu Basket itemName" );
        String input;
        iShoppingCart isc=new ShoppingCartFactory().getShoppingCart("HashMapShoppingCart");// we can use the args[0] as shoppingCart type and args[1] as the different discount type
        iProductFactory ipf=new ProductFactory();
        iDiscountStrategy ids=new AppleOnlyDiscount();
        do {
        	  input=System.console().readLine();
              if(InputHelper.validate(input)==0)
              {
              	System.out.println("Invalidate Input");
              }
              else if (InputHelper.validate(input)==1){
				
			 }
              else if (InputHelper.validate(input)==2) {
				String[] product=InputHelper.splitInputBySpace(input);
				for(String oneProduct:product)
				{
					isc.add(ipf.getProduct(oneProduct), 1);//1 by default
				}
				isc.calculateTotal( ids);
				isc.showShoppingCartContent(ids);
			}
              
		} while (input=="exit");
      
    }
}
