package com.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTS {

		//Singleton design Pattern
		//private constructor so that no one else can create object of this class
		private ExtentTS() {
			
		}
		
		private static ExtentTS instance  = new ExtentTS();
		
		public static ExtentTS getInstance() {
			return instance;
		}
		
		
		//factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
		ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
		
		public ExtentTest getExtent() {
			return extent.get();
		}
		
		public void setExtent(ExtentTest extentTestObject) {
			extent.set(extentTestObject);
		}
		
		public void removeExtentObject() {
			extent.remove();
		}
	

}
