package com.nit.testproj.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	public WebDriver driver;
	public WebDriverWait wait;
	public AbstractComponent(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,120);
	}

	public void waitUntilPageLoads() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int counter=0;
		while(counter<60) {
			boolean state=js.executeScript("return document.readyState").toString().equals("complete");
			if(state) {
				break;
			}
			counter++;
		}
}
	
}
