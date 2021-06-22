package com.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	private By warriorName = By.id("worrior_username");
	private By createWarrior = By.id("warrior");
	private By header = By.cssSelector("h2.summary");
	private By startJourney = By.xpath("//a[contains(text(),'Start your journey')]");


	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public WebElement getWarriorNameEle() {
		return getElement(warriorName) ;
	}


	public WebElement getCreateWarriorEle() {
		return getElement(createWarrior);
	}

	public String getWPHeader() {
		return getTextOfElement(header);
	}
	
	public void waitForWPHeader() {
		 waitForElementPresent(header);
	}
	
	public String getWPElementText() {
		return getTextOfElement(startJourney);
	}
	
	public WebElement getstartJourneyEle() {
		return getElement(startJourney);
	}

	public String getWPTitle() {
		return getPageTitle();
	}


	public void createWarrior(String userName)
	{
		
		getWarriorNameEle().sendKeys(userName);
		getCreateWarriorEle().click();
	}

	//Method overloading for create warrior without any name

	public void createWarrior()
	{
		
		getWarriorNameEle().sendKeys("");
		getCreateWarriorEle().click();
	}
	
	public HomePage startJourney(String userName) 
	{
	
		getWarriorNameEle().sendKeys(userName);
		getCreateWarriorEle().click();
		getstartJourneyEle().click();
		
		return getInstance(HomePage.class);
		
	}





}


