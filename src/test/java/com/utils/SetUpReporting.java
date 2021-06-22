package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SetUpReporting {
	static ReadConfig readconfig = new ReadConfig();
	public static Logger log;
	public static ExtentSparkReporter extentReporter;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String time;
	public static String timestamp;
	public static String reportName;
	
	@BeforeClass
	public static ExtentReports setup()
	{
		timestamp = new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").format(new Date());
		time = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
		reportName = "SuperHeroAndSuperVillain_Test_Report_"+timestamp+".html";
		extentReporter= new ExtentSparkReporter(readconfig.DirFilePath+"/test-output/Reports/ExtentReports"+time+""
				+ "/"+reportName);

		extentReporter.config().setDocumentTitle("SuperHeroAndSuperVillain Automation Report"); //title of the report
		extentReporter.config().setReportName("SuperHeroAndSuperVillain Automation Report");//name of Functional report
		extentReporter.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(extentReporter);
		report.setSystemInfo("Hostname", "Localhost");
		report.setSystemInfo("OS", "windows10");

		//initializing the logger here 
		log = LogManager.getLogger(SetUpReporting.class);
		return report;

	}

}
