package com.nit.template;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {
	private WebDriver driver;
	private ShoppingTemplate shoppingTemplate;
	Map<String,String> data;
	public ShoppingPage(WebDriver driver,Map<String,String> data) {
		this.driver=driver;
		this.data=data;
		PageFactory.initElements(driver, this);
	}
	
	public void shopProduct(ShoppingTemplate shoppingTemplate) {
		shoppingTemplate.shop();
	}

	
}
