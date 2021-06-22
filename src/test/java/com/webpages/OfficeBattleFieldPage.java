package com.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfficeBattleFieldPage extends BasePage{

	public OfficeBattleFieldPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By officeBattleField = By.id("office_intro_modal");
	private By startOfficeBattlefield = By.id("start");
	private By startOfficeHeaderModal = By.xpath("//h5[text()='You are seated at a restaurant..']");
	private By officeHeader = By.id("restaurant_title");
	private By ofcTryNextBattleButton = By.id("close_correct_modal_btn");
	private By busAnswerOne = By.id("office_answer_1");
	private By busAnswerTwo = By.id("office_answer_2");
	private By ofcWrnAnsModal = By.xpath("//h5[contains(text(),'sound right!')]");
	private By ofcWrnAnsTryAgainButton = By.xpath("//button[text()='Try again']");
	
	
	public boolean verifyOfficeStartModalTitle() {
		return verifyElementPresent(startOfficeHeaderModal);
	}
	
	public boolean verifyOfficeBattleFieldIsLaunched() {
		return verifyElementPresent(officeBattleField);
	}
	
	public void startOfficeBattleField() {
		getElement(startOfficeBattlefield).click();
	}
	
	public String getOfficeHeader() {
		return getTextOfElement(officeHeader);
	}
	public BusBattleFieldPage performNextBattle() {
		getElement(ofcTryNextBattleButton).click();
		return getInstance(BusBattleFieldPage.class);
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
	
	public void retryOfcBattleFieldQuestion() {
		getElement(ofcWrnAnsTryAgainButton).click();
	}
}
