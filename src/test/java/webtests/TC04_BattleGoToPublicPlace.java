package webtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.ExtentTS;
import com.utils.RandomDataGenerator;
import com.webpages.CafeBattleFieldPage;
import com.webpages.HomePage;
import com.webpages.LoginPage;

public class TC04_BattleGoToPublicPlace extends BaseTest{
	
	public String expResHeader = "At the Restaurant";
	
	@Test(priority=1,groups= {"web"})
	public void verifyTheGoToPublicPlaceBattle() {
		
		try {
		
		page.getInstance(LoginPage.class).startJourney("StartingTest");//to overcome an issue
		userName = "WebKal "+RandomDataGenerator.generateRandomString();
		ExtentTS.getInstance().getExtent().info("User assigned with username "+ userName);
		HomePage pg = page.getInstance(LoginPage.class).startJourney(userName);
		Assert.assertTrue(pg.getHPHeader().contains(homepageHeader));
		CafeBattleFieldPage cpg = pg.clickOnGotoPublicPlace();
		cpg.startcafeBattleField();
		Assert.assertEquals(cpg.getCafeHeader(),expResHeader);
		ExtentTS.getInstance().getExtent().info("Battle field bus loaded correctly");
		}
		catch(Exception e)
		{
			log.error("Error while running test: verifyTheGoToPublicPlaceBattle",e.getMessage());
			e.printStackTrace();
		}
	} 

}
