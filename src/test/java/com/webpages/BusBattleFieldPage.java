package com.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusBattleFieldPage extends BasePage{
	
	private By busBattleField = By.id("bus_intro_modal");
	private By startBusBattlefield = By.id("bus_timer_start");
	private By startBusHeaderModal = By.xpath("//h5[text()='You have taken the public bus..']");
	private By busHeader = By.id("bus_title");
	private By busTimeUpModal = By.xpath("//h5[contains(text(),'Up!')]");
	private By busTimeUpTryAgainButton = By.xpath("//button[text()='Try again']");
	private By busReturnHomeButton = By.xpath("//button[text()=' Return Home']");
	private By busWrnAnsModal = By.xpath("//h5[contains(text(),'sound right!')]");
	private By busWrnAnsTryAgainButton = By.xpath("//button[text()='Try again']");
	private By busAnswerOne = By.id("bus_answer_1");
	private By busAnswerTwo = By.id("bus_answer_2");
	private By busTryNextBattleButton = By.id("close_correct_modal_btn");
	private By busCheckYourScroreButton = By.id("leaderboard_link");
	
	
	public BusBattleFieldPage(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean verifyBusStartModalTitle() {
		return verifyElementPresent(startBusHeaderModal);
	}
	
	public boolean verifyBusBattleFieldIsLaunched() {
		return verifyElementPresent(busBattleField);
	}
	
	public void startBusBattleField() {
		getElement(startBusBattlefield).click();
	}
	
	public String getBusHeader() {
		return getTextOfElement(busHeader);
	}
	
	public boolean verifyBusTimesUpModal() {
		return verifyElementPresent(busTimeUpModal);
	}
	
	public void doBusTryAgain() {
		getElement(busTimeUpTryAgainButton).click();
	}
	
	public HomePage doBusReturnHome() {
		getElement(busReturnHomeButton).click();
		return getInstance(HomePage.class);
	}
	
	public boolean verifyWrongAnswerModal() {
		return verifyElementPresent(busWrnAnsModal);
		
	}
	
	public void retryBusBattleFieldQuestion() {
		getElement(busWrnAnsTryAgainButton).click();
	}
	
	public void clickAnswerOne() {
		getElement(busAnswerOne).click();
	}
	
	public void clickAnswerTwo() {
		getElement(busAnswerTwo).click();
	}
	
	public CafeBattleFieldPage performNextBattle() {
		getElement(busTryNextBattleButton).click();
		return getInstance(CafeBattleFieldPage.class);
	}
	
	
	public LeaderBoardPage performCheckYourScore() {
		getElement(busCheckYourScroreButton).click();
		return getInstance(LeaderBoardPage.class);
	}

}
