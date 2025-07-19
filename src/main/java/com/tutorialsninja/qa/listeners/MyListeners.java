package com.tutorialsninja.qa.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utilities.MyExtentReporter;
import com.tutorialsninja.qa.utilities.Utilities;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
		
		 extentReport =MyExtentReporter.generateExtentReport();
		
		//System.out.println("Execution of Project tests started");
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName+" started executing");
		
//		System.out.println(testName + "started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS,testName+" got successfully executed");
		
		
		//System.out.println(testName + "got successfully executed");
	}
	
	@Override
public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
	
		if(driver!=null) {
			String destinationScreenshotPath = Utilities.captureScreenShot(driver,result.getName());
		try {
			extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
	      } catch (Throwable e) {
	            e.printStackTrace();
	        }
	    } else {
	        extentTest.log(Status.WARNING, "WebDriver was null, screenshot not captured");
	    }
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		 extentTest.log(Status.INFO,result.getThrowable());
		 extentTest.log(Status.SKIP,testName + "got skipped");
		
//		System.out.println(testName + "got skipped");
//		System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
//		String pathOfExtentReport = System.getProperty("user.dir")+"/test-output/ExtentReports/";
//		File extentReport1 = new File(pathOfExtentReport);
//
//		try {
//			Desktop.getDesktop().browse(extentReport1.toURI());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		
		//System.out.println("Execution completed");
	}
	
	

}
