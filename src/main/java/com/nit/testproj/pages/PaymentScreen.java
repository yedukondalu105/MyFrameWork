package com.nit.testproj.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nit.testproj.components.payments.OrderComponent;
import com.nit.testproj.components.payments.UserInformation;

public class PaymentScreen {
	
	private WebDriver driver;
	private UserInformation userInformation;
	private OrderComponent order;
	private PaymentOption paymentOption;
	public PaymentScreen(WebDriver driver) {
		this.driver=driver;
		//this.userInformation=
	}
	
	public UserInformation getUserInformation() {
		return new UserInformation(driver);
	}

	public OrderComponent getOrder() {
		return new OrderComponent(driver);
	}

	public void setPaymentOption(PaymentOption paymentOption) {
		this.paymentOption = paymentOption;
		
	}
	public void pay(Map<String,String> paymentDetails) {
		paymentOption.enterPaymentInformation(paymentDetails);
	}
	public void goTo(String url) {
		driver.get(url);
	}
}
