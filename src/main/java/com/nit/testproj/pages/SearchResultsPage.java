package com.nit.testproj.pages;

import org.openqa.selenium.WebDriver;

import com.nit.testproj.components.NavigationBar_SearchResults;
import com.nit.testproj.components.SearchWidgetInSearchResults;

public class SearchResultsPage {
	
	
	public SearchWidgetInSearchResults sw_sr;
	public NavigationBar_SearchResults navigaBar_sr;
	public SearchResultsPage(WebDriver driver) {
		sw_sr=new SearchWidgetInSearchResults(driver);
		navigaBar_sr=new NavigationBar_SearchResults(driver);
		
	}
	
	public SearchWidgetInSearchResults getSearchWidgetInSearchResults() {
		return sw_sr;
	}
	public NavigationBar_SearchResults getNavigationBar_SearchResults() {
		return navigaBar_sr;
	}
	
}
