package webtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.ExtentTS;
import com.utils.RandomDataGenerator;
import com.webpages.BusBattleFieldPage;
import com.webpages.HomePage;
import com.webpages.LoginPage;

public class TC03_BattleTakeABus extends BaseTest{
	
	public String expBusHeader = "Inside the Bus";
	
	@Test(priority=1,groups= {"web"})
	public void verifyTheTakeTheBusBattleField() {
		
		try {
		
		page.getInstance(LoginPage.class).startJourney("StartingTest");//to overcome an issue
		userName = "WebKal "+RandomDataGenerator.generateRandomString();
		ExtentTS.getInstance().getExtent().info("User assigned with username "+ userName);
		HomePage pg = page.getInstance(LoginPage.class).startJourney(userName);
		Assert.assertTrue(pg.getHPHeader().contains(homepageHeader));
		BusBattleFieldPage bpg = pg.clickOnTakeTheBus();
		bpg.startBusBattleField();
		Assert.assertEquals(bpg.getBusHeader(),expBusHeader);
		ExtentTS.getInstance().getExtent().info("Battle field bus loaded correctly");
		}
		catch(Exception e)
		{
			log.error("Error while running test: verifyTheTakeTheBusBattleField",e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	@Test(priority=2,groups= {"web"})
	public void verifyTimeUpModalTakeTheBusBattleField() {
		
		try {
		
		boolean modalPresent = page.getInstance(BusBattleFieldPage.class).verifyBusTimesUpModal();
		Assert.assertTrue(modalPresent);
		ExtentTS.getInstance().getExtent().info("Time up modal correctly loaded after waiting for some time");
		page.getInstance(BusBattleFieldPage.class).doBusTryAgain();
		Assert.assertEquals(page.getInstance(BusBattleFieldPage.class).getBusHeader(),expBusHeader);
		ExtentTS.getInstance().getExtent().info("Clicked on Try Again and returned to the battle field page");
		boolean modalPresentAgain = page.getInstance(BusBattleFieldPage.class).verifyBusTimesUpModal();
		Assert.assertTrue(modalPresentAgain);
		HomePage pg = page.getInstance(BusBattleFieldPage.class).doBusReturnHome();
		Assert.assertTrue(pg.getHPHeader().contains(homepageHeader));
		driver.navigate().forward();
		}
		catch(Exception e)
		{
			log.error("Error while running test: verifyTimeUpModalTakeTheBusBattleField",e.getMessage());
			e.printStackTrace();
		}
		
	}
	

}
