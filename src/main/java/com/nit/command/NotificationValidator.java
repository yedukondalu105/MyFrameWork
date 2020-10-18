package com.nit.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

public class NotificationValidator  extends ElementValidator{

	private final WebElement button;
	private final WebElement notification;
	
	public NotificationValidator(WebElement button,WebElement notification) {
		this.button=button;
		this.notification=notification;
	}
	
	@Override
	public boolean validate() {
		this.button.click();
		boolean appearanceStatus=this.notification.isDisplayed();
		Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
		boolean disAppearanceStatus=this.notification.isDisplayed();
		return appearanceStatus && (!disAppearanceStatus);
	}

}
