package com.nit.command;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator{
	
	private final WebElement dismissalAlert;
	
	public DismissalAlertValidator(WebElement dismissalAlert) {
		this.dismissalAlert=dismissalAlert;
	}
	@Override
	public boolean validate() {
			boolean result=dismissalAlert.isDisplayed();
			dismissalAlert.findElement(By.cssSelector("button.close")).click();
			boolean result2=true;
			try{
				result2=dismissalAlert.isDisplayed();
			}
			catch(NoSuchElementException ne) {
				result2=false;
			}
			return result && (!result2);
		
	}

}
