package com.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CafeBattleFieldPage extends BasePage{

	private By cafeBattleField = By.id("restaurant_intro_modal");
	private By startcafeBattlefield = By.id("restaurant_timer_start");
	private By startcafeHeaderModal = By.xpath("//h5[text()='You are seated at a restaurant..']");
	private By cafeHeader = By.id("restaurant_title");
	private By cafeTryNextBattleButton = By.id("close_correct_modal_btn"); 
	private By busAnswerOne = By.id("bus_answer_1");
	private By busAnswerTwo = By.id("bus_answer_2");
	private By ofcWrnAnsModal = By.xpath("//h5[contains(text(),'sound right!')]");
	private By ofcWrnAnsTryAgainButton = By.xpath("//button[text()='Try again']");
	
	public CafeBattleFieldPage(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean verifycafeStartModalTitle() {
		return verifyElementPresent(startcafeHeaderModal);
	}
	
	public boolean verifycafeBattleFieldIsLaunched() {
		return verifyElementPresent(cafeBattleField);
	}
	
	public void startcafeBattleField() {
		getElement(startcafeBattlefield).click();
	}

	public String getCafeHeader() {
		return getTextOfElement(cafeHeader);
	}
	public OfficeBattleFieldPage performNextBattle() {
		getElement(cafeTryNextBattleButton).click();
		return getInstance(OfficeBattleFieldPage.class);
	}
	public void clickAnswerOne() {
		getElement(busAnswerOne).click();
	}
	
	public void clickAnswerTwo() {
		getElement(busAnswerTwo).click();
	}
	public boolean verifyWrongAnswerModal() {
		return verifyElementPresent(ofcWrnAnsModal);
		
	}
	
	public void retryBusBattleFieldQuestion() {
		getElement(ofcWrnAnsTryAgainButton).click();
	}

}
