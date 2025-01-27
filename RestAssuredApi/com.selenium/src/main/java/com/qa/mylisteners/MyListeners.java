package com.qa.mylisteners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import qa.utilties.ExtentReporter;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extst;
	@Override
	public void onStart(ITestContext context) {
		extentReport =ExtentReporter.generateReport();
	}
	

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getName();
		extst = extentReport.createTest(name);
		extst.log(Status.INFO,name+"started execting");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		String name = result.getName();
		extst.log(Status.PASS, name+"got successfully executed");
		
}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		//typecasting is important beacuse it return object class intance
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		if (driver == null) {
	        System.out.println("WebDriver is null. TestContext may not have been initialized correctly.");
	        return;  // Exit if WebDriver is null
	    }
		//typecasting to takeSceenShot(interface)
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String  dateText = date.toString();
		String t = dateText.replace(" ", "_").replace(":", "_");
		String path =System.getProperty("user.dir")+"\\ScreenShots\\"+name+".png";
		System.out.println(path);
		File des = new File(path);
		try {
			Files.copy(file.toPath(), des.toPath(),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extst.addScreenCaptureFromPath(path);
		extst.log(Status.INFO, result.getThrowable());
		extst.log(Status.FAIL,name+"got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		extst.log(Status.INFO, result.getThrowable());
		extst.log(Status.SKIP, name+"got skip");

	}

	
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		File file  = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
