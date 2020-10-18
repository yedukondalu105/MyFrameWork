package com.nit.testproj.pages;

import org.openqa.selenium.WebDriver;

import com.nit.testproj.components.SearchSuggestion;
import com.nit.testproj.components.SearchWidget;

public class GoogleSearchPage {
	
	public WebDriver driver;
	public SearchWidget sw;
	public SearchSuggestion ss;
	public GoogleSearchPage(WebDriver driver) {
		
		this.driver=driver;
		sw=new SearchWidget(this.driver);
		ss=new SearchSuggestion(this.driver);
	}
	
	
	public void goToURL(String url) {
		driver.get(url);
	}
	
	public SearchWidget getSearchWidget() {
		return sw;
	}
	
	public SearchSuggestion getSearchSuggestion() {
		return ss;
	}

}
