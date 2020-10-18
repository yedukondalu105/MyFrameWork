package com.nit.testproj.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.nit.testproj.common.BaseTest;
import com.nit.testproj.utilities.Utility;

public class lItestListener implements ITestListener {

	public lItestListener() {
		// TODO Auto-generated constructor stub
	}

	public void onFinish(ITestContext result) {
		//System.out.println(result.getName()+" case is finished");
		
	}

	public void onStart(ITestContext result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		 System.out.println(result.getName()+" is failed");
		 String path=Utility.printScreen(BaseTest.driver, result.getName());
		 BaseTest.test.log(Status.FAIL, result.getName());
		 try {
			BaseTest.test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" is started");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
