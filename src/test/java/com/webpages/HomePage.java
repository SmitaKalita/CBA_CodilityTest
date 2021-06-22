package com.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {

	private By areYouGame = By.xpath("//*[@id='news']");
	private By takeBus = By.xpath("//*[@id='bus']");
	private By goToPublicPlace = By.xpath("//*[@id='restaurant']");
	private By goToOffice=By.xpath("//*[@id='office']");
	private By header=By.id("welcome_text");
	private By tickerItem1 = By.xpath("//div[contains(text(),'Regularly and thoroughly clean your hands with an alcohol-based hand rub or wash them with soap and water.')]");
	private By tickerItem2 =By.xpath("//div[contains(text(),'Maintain at least 1 metre (3 feet) distance between yourself and others.')]");
	private By tickerItem3 =By.xpath("//div[contains(text(),'Avoid going to crowded places.')]");
	private By tickerItem4 =By.xpath("//div[contains(text(),'Avoid touching eyes, nose and mouth.')]");
	private By tickerItem5 =By.xpath("//div[contains(text(),'Stay home and self-isolate even with minor symptoms such as cough, headache, mild fever, until you recover.')]");
	private By tickerItem6 =By.xpath("//div[contains(text(),'Keep up to date on the latest information from trusted sources.')]");
	private By tickerItem7 =By.xpath("//div[contains(text(),'Visit ')]");


	public HomePage(WebDriver driver) {
		super(driver);

	}

	public WebElement getAreYouGameEle() {
		return getElement(areYouGame) ;
	}


	public WebElement getTakeBusEle() {
		return getElement(takeBus);
	}

	public WebElement getPublicPlaceEle() {
		return getElement(goToPublicPlace);
	}

	public WebElement getOfficeEle() {
		return getElement(goToOffice);
	}

	public WebElement getTickerItem1() {
		return getElement(tickerItem1);
	}

	public WebElement getTickerItem2() {
		return getElement(tickerItem2);
	}

	public WebElement getTickerItem3() {
		return getElement(tickerItem3);
	}

	public WebElement getTickerItem4() {
		return getElement(tickerItem4);
	}

	public WebElement getTickerItem5() {
		return getElement(tickerItem5);
	}

	public WebElement getTickerItem6() {
		return getElement(tickerItem6);
	}

	public WebElement getTickerItem7() {
		return getElement(tickerItem7);
	}


	public String getHPHeader() {
		return getTextOfElement(header);
	}

	public void waitForHPHeader() {
		waitForElementPresent(header);
	}

	public String getHPTitle() {
		return getPageTitle();
	}

	public boolean checkElementsVisibility() {

		if(getAreYouGameEle().isDisplayed() && getTakeBusEle().isDisplayed() && getPublicPlaceEle().isDisplayed() && getOfficeEle().isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean checkTickerItems() {

		if(getTickerItem1().isDisplayed() && getTickerItem2().isDisplayed() && getTickerItem3().isDisplayed() && getTickerItem4().isDisplayed() && getTickerItem5().isDisplayed() && getTickerItem6().isDisplayed() && getTickerItem7().isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public BusBattleFieldPage clickOnTakeTheBus() {
		getTakeBusEle().click();
		return getInstance(BusBattleFieldPage.class);
	}

	public CafeBattleFieldPage clickOnGotoPublicPlace() {
		getPublicPlaceEle().click();
		return getInstance(CafeBattleFieldPage.class);
	}

	public OfficeBattleFieldPage clickOnGoToOffice() {
		getOfficeEle().click();
		return getInstance(OfficeBattleFieldPage.class);
	}





}
