package webtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.ExtentTS;
import com.utils.RandomDataGenerator;
import com.webpages.OfficeBattleFieldPage;
import com.webpages.HomePage;
import com.webpages.LoginPage;

public class TC05_BattleGoToOffice extends BaseTest{
	
public String expOffHeader = "At the Office";
	
	@Test(priority=1,groups= {"web"})
	public void verifyGoToOfficeBattleField() {
		
		try {
		
		page.getInstance(LoginPage.class).startJourney("StartingTest");//to overcome an issue
		userName = "WebKal "+RandomDataGenerator.generateRandomString();
		ExtentTS.getInstance().getExtent().info("User assigned with username "+ userName);
		HomePage pg = page.getInstance(LoginPage.class).startJourney(userName);
		Assert.assertTrue(pg.getHPHeader().contains(homepageHeader));
		OfficeBattleFieldPage opg = pg.clickOnGoToOffice();
		opg.startOfficeBattleField();;
		Assert.assertEquals(opg.getOfficeHeader(),expOffHeader);
		ExtentTS.getInstance().getExtent().info("Battle field bus loaded correctly");
		}
		catch(Exception e)
		{
			log.error("Error while running test: verifyGoToOfficeBattleField",e.getMessage());
			e.printStackTrace();
		}
		
	} 

}
