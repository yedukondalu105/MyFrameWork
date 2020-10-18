package com.nit.command;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	//buttons
	@FindBy(css="div.button-box button.btn-info")
	private WebElement infoButton;
	
	@FindBy(css="div.button-box button.btn-warning")
	private WebElement warningButton;
	
	@FindBy(css="div.button-box button.btn-success")
	private WebElement successButton;
	
	@FindBy(css="div.button-box button.btn-danger")
	private WebElement dangerButton;
	
	//Notification Alerts
	@FindBy(css="div.jq-icon-info")
	private WebElement infoAlert;
	
	@FindBy(css="div.jq-icon-warning")
	private WebElement warningAlert;
	
	@FindBy(css="div.jq-icon-success")
	private WebElement successAlert;

	@FindBy(css="div.jq-icon-error")
	private WebElement dangerAlert;
	
	//Dismissal Alerts
	@FindBy(xpath="//h4[text()='Dissmissal Alert']/../div[contains(@class,'alert-info')]")
	private WebElement dismissInfoAlert;
	
	@FindBy(xpath="//h4[text()='Dissmissal Alert']/../div[contains(@class,'alert-warning')]")
	private WebElement dismissWarningAlert;
	
	@FindBy(xpath="//h4[text()='Dissmissal Alert']/../div[contains(@class,'alert-success')]")
	private WebElement dismissSuccessAlert;
	
	@FindBy(xpath="//h4[text()='Dissmissal Alert']/../div[contains(@class,'alert-danger')]")
	private WebElement dismissDangerAlert;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void goTo(String url) {
		driver.get(url);
	}
	public List<ElementValidator> getElementValidators(){
		List<ElementValidator> eleVals=new ArrayList();
		eleVals.add(new NotificationValidator(infoButton, infoAlert));
		eleVals.add(new NotificationValidator(warningButton, warningAlert));
		eleVals.add(new NotificationValidator(successButton, successAlert));
		eleVals.add(new NotificationValidator(dangerButton, dangerAlert));
		
		eleVals.add(new DismissalAlertValidator(dismissInfoAlert));
		eleVals.add(new DismissalAlertValidator(dismissWarningAlert));
		eleVals.add(new DismissalAlertValidator(dismissSuccessAlert));
		eleVals.add(new DismissalAlertValidator(dismissDangerAlert));
		
		return eleVals;
	}
	
}
