package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.utils.ExtentTS;
import webtests.BaseTest;
import com.utils.SetUpReporting;

public class Listener implements ITestListener{

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		//before each test case
		if(result.getMethod().getMethodName().contains("API"))
		{
			test = report.createTest("API - "+ result.getMethod().getMethodName());
			ExtentTS.getInstance().setExtent(test);
		}
		else {
		test = report.createTest("WEB - "+SystemDetails.getBrowserName().toUpperCase() +" - "+ result.getMethod().getMethodName());
		ExtentTS.getInstance().setExtent(test);
		}
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTS.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
		ExtentTS.getInstance().removeExtentObject();
	}
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTS.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
		ExtentTS.getInstance().getExtent().log(Status.FAIL, result.getThrowable());

		//add screenshot for failed test.
		File src = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String screenshotPath = System.getProperty("user.dir")+
				"/test-output/Reports/Screenshots/"+result.getMethod().getMethodName()+" - "+actualDate+".jpeg";
		File dest = new File(screenshotPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ExtentTS.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
			ExtentTS.getInstance().removeExtentObject();

		} catch (Exception e) {
			e.printStackTrace();
		}



	}
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTS.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
		ExtentTS.getInstance().removeExtentObject();
	}

	@Override

	public void onStart(ITestContext context) {
		try {
			report = SetUpReporting.setup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onFinish(ITestContext context) {
		//close extent
		report.flush();
	}

}
