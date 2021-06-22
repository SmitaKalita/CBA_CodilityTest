package com.webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getTextOfElement(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			waitForElementPresent(locator);
			element =driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			return element;
		}
		catch(Exception e) {
			log.error("WEBTest: Error occured while finding element: "+locator.toString() + " and error is: "+e.getMessage());
			e.printStackTrace();
		}
		return element;
	}
	
	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		try {
			waitForElementPresent(locator);
			elements =driver.findElements(locator);
			return elements;
		}
		catch(Exception e) {
			log.error("WEBTest: Error occured while finding elements: "+locator.toString() + " and error is: "+e.getMessage());
			e.printStackTrace();
		}
		return elements;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(locator));

		}
		catch(Exception e)
		{
			log.error("WEBTest: Error occured while waiting for an element: "
					+ ""+locator.toString() + " and error is: "+e.getMessage());
			e.printStackTrace();
		}


	}
	
	public boolean verifyElementPresent(By locator) {
		try
		{
			if(getElement(locator).isDisplayed()) {
				return true;
			}

		}
		catch(Exception e)
		{
			log.error("WEBTest: Error occured while verifying presence of an element: "
					+ ""+locator.toString() + " and error is: "+e.getMessage());
			e.printStackTrace();
		}
		return false;


	}
	


}
