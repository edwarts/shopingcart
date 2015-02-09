package com.adthena.model.inferces;

public interface iShoppingCart {
	public void add(iProduct product,int qty);
	public void remove(iProduct prodcut);
	public double[] calculateTotal(iDiscountStrategy discountS);
	public void showShoppingCartContent(iDiscountStrategy discountS);
}
