package com.nit.testproj.components.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformation {
	private WebDriver driver;
	@FindBy(id="fn")
	private WebElement firstName;
	
	@FindBy(id="ln")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement emailEle;
	
	public UserInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterDetails(String fn,String ln,String email) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailEle.sendKeys(email);
	}
	
	
}
