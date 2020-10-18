package com.nit.testproj.tests;

import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.nit.testproj.pages.GoogleSearchPage;
import com.nit.testproj.pages.SearchResultsPage;
import com.nit.testproj.utilities.Util_Properties;
import com.nit.testproj.utilities.Utility;

public class HandlingXML implements Utility{
	
	
 @Test
  public void googlepage() throws InterruptedException {
	 try {
	   DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance(); 
	   
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document d=(Document) db.parse("./products.xml");
		XPath xp=XPathFactory.newInstance().newXPath();
		NodeList nl=(NodeList) xp.compile("//product1/name").evaluate(d, XPathConstants.NODESET);
		System.out.println("No of Products::"+nl.getLength());
		System.out.println("Node text::"+nl.item(0).getTextContent());
		//nl.item(0).setTextContent("laptop");
		//System.out.println("Node text::"+nl.item(0).getTextContent());
		
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (XPathExpressionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
	 
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	 
	  
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	
	  
  }


}
