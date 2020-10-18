package com.nit.testproj.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public interface Utility {
		
		public static String printScreen(WebDriver driver,String testName) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
			
			TakesScreenshot scr=(TakesScreenshot)driver;
		    File src=scr.getScreenshotAs(OutputType.FILE);
		    String path=null;
		    try {
		    	path=System.getProperty("user.dir")+"/resources/screenshots/"+testName+"/"+timeStamp+".png";
				FileUtils.copyFile(src, new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    return path;
		}
}
