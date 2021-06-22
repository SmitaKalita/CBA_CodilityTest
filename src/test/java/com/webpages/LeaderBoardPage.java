package com.webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeaderBoardPage extends BasePage{

	public LeaderBoardPage(WebDriver driver) {
		super(driver);
		
	}
	
	private By ldrBoardHeader = By.xpath("//p[text()='COVID-19 THE GAME - LEADERBOARD']");
	private By ldrBoardTableData = By.cssSelector("#showData>table>tbody>tr>td");
	private By continueFightingButton = By.id("leaderboard_link");
	private By tickerItem1 = By.xpath("//div[contains(text(),'Regularly and thoroughly clean your hands with an alcohol-based hand rub or wash them with soap and water.')]");
	private By tickerItem2 =By.xpath("//div[contains(text(),'Maintain at least 1 metre (3 feet) distance between yourself and others.')]");
	private By tickerItem3 =By.xpath("//div[contains(text(),'Avoid going to crowded places.')]");
	private By tickerItem4 =By.xpath("//div[contains(text(),'Avoid touching eyes, nose and mouth.')]");
	private By tickerItem5 =By.xpath("//div[contains(text(),'Stay home and self-isolate even with minor symptoms such as cough, headache, mild fever, until you recover.')]");
	private By tickerItem6 =By.xpath("//div[contains(text(),'Keep up to date on the latest information from trusted sources.')]");
	private By tickerItem7 =By.xpath("//div[contains(text(),'Visit ')]");

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
	
	public boolean verifyLeaderBoardHeader() {
		return verifyElementPresent(ldrBoardHeader);
	}
	
	public List<WebElement> getLeaderBoardData() {
		List<WebElement> data = getElements(ldrBoardTableData);
		return data;
	}
	
	public HomePage doContinueFighting() {
		getElement(continueFightingButton).click();
		return getInstance(HomePage.class);
	}

}
