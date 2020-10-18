package com.nit.template;

public abstract class ShoppingTemplate {
	
	public abstract void launchSite();
	public abstract void searchProduct();
	public abstract void selectProduct();
	
	public void shop() {
		launchSite();
		searchProduct();
		selectProduct();
		
	}
}
