package com.webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.SetUpReporting;

public abstract class Page extends SetUpReporting{
	
    
	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 60);
	}
	
	//abstract methods:
	
	public abstract String getPageTitle();
	public abstract String getTextOfElement(By locator);
	public abstract WebElement getElement(By locator);
	public abstract List<WebElement> getElements(By locator);
	public abstract void waitForElementPresent(By locator);
	
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
	
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);	
		}
		catch (Exception e) {
			log.error("WEBTESTS: Error while getInstance for a new instance of class: "+pageClass);
		}
		return null;
	
	}


}
