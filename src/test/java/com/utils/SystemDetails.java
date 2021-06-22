package com.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SystemDetails {
	
	public static String getBrowserName() {
	RemoteWebDriver driver = (RemoteWebDriver) DriverFactory.getInstance().getDriver();
	Capabilities browserCap = driver.getCapabilities();
	String browserName = browserCap.getBrowserName();
	return browserName;
	}
}
