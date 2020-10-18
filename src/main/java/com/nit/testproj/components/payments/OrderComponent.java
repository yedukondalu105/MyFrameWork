package com.nit.testproj.components.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponent {
	private WebDriver driver;
	public OrderComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="buy")
	private WebElement buyNow;
	
	@FindBy(id="ordernumber")
	private WebElement orderNumber;
	
	public String placeOrder() {
		buyNow.click();
		return orderNumber.getText();
	}
	
}
