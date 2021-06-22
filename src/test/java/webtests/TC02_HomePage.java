package webtests;


import org.testng.Assert;
import org.testng.annotations.Test;


import com.utils.ExtentTS;
import com.utils.RandomDataGenerator;
import com.webpages.BusBattleFieldPage;
import com.webpages.CafeBattleFieldPage;
import com.webpages.HomePage;
import com.webpages.LoginPage;
import com.webpages.OfficeBattleFieldPage;

public class TC02_HomePage extends BaseTest

{
	public String hpHeader;

	@Test(priority = 1,groups= {"web","smoke"})

	public void verifyHomePageHeader()
	{
		try
		{
			userName = "WebKal "+RandomDataGenerator.generateRandomString();
			ExtentTS.getInstance().getExtent().info("User assigned with username "+ userName);
			hpHeader = page.getInstance(LoginPage.class).startJourney(userName).getHPHeader();
			Assert.assertTrue(hpHeader.contains(homepageHeader));
			ExtentTS.getInstance().getExtent().info("Expected header - Choose your battle field "+ userName+ " ïs displayed");

		}
		catch (Exception e)
		{
			log.error("Error while running test: verifyHomePageHeader",e.getMessage());
			e.printStackTrace();

		}


	}
	@Test(priority = 2,groups= {"web","smoke"})
	public void verifyAllBattleFieldsPresent()
	{
		try
		{	
			Boolean fieldsPresent=page.getInstance(HomePage.class).checkElementsVisibility();
			Assert.assertTrue(fieldsPresent);
			ExtentTS.getInstance().getExtent().info("All battle fields are present as expected");
		}
		catch (Exception e)
		{
			log.error("Error while running test: verifyAllBattleFieldsPresent",e.getMessage());
			e.printStackTrace();

		}


	}

	@Test(priority = 3,groups= {"web"})
	public void verifyAllHomePageTickerItemsPresent()
	{
		try
		{	
			Boolean fieldsPresent=page.getInstance(HomePage.class).checkTickerItems();
			Assert.assertTrue(fieldsPresent);
			ExtentTS.getInstance().getExtent().info("All ticker items are present as expected");
		}
		catch (Exception e)
		{
			log.error("Error while running test: verifyAllHomePageTickerItemsPresent",e.getMessage());
			e.printStackTrace();

		}


	}

	@Test(priority = 4,groups= {"web","smoke"})
	public void verifyBattleFieldTakeTheBusCanBeAccessed()
	{
		try
		{	
			BusBattleFieldPage pg=page.getInstance(HomePage.class).clickOnTakeTheBus();
			Boolean modalTitle= pg.verifyBusStartModalTitle();
			Assert.assertTrue(modalTitle);
			ExtentTS.getInstance().getExtent().info("Battle field take a bus is successfully launched");
			driver.navigate().back();
			Assert.assertTrue(hpHeader.contains(homepageHeader));
			ExtentTS.getInstance().getExtent().info("Back to homepage from battlefield take a bus is successful");
		}
		catch (Exception e)
		{
			log.error("Error while running test: verifyBattleFieldTakeTheBusCanBeAccessed",e.getMessage());
			e.printStackTrace();

		}


	}
	@Test(priority = 5,groups= {"web","smoke"})
	public void verifyBattleFieldGoToPublicPlaceCanBeAccessed()
	{
		try
		{	
			CafeBattleFieldPage pg=page.getInstance(HomePage.class).clickOnGotoPublicPlace();
			Boolean modalTitle= pg.verifycafeStartModalTitle();
			Assert.assertTrue(modalTitle);
			ExtentTS.getInstance().getExtent().info("Battle field go to public place is successfully launched");
			driver.navigate().back();
			Assert.assertTrue(hpHeader.contains(homepageHeader));
			ExtentTS.getInstance().getExtent().info("Back to homepage from battlefield go to public place is successful");
		}
		catch (Exception e)
		{
			log.error("Error while running test: verifyBattleFieldGoToPublicPlaceCanBeAccessed",e.getMessage());
			e.printStackTrace();

		}


	}

	@Test(priority = 6,groups= {"web","smoke"})
	public void verifyBattleFieldGoToOfficeCanBeAccessed()
	{
		try
		{	
			OfficeBattleFieldPage pg=page.getInstance(HomePage.class).clickOnGoToOffice();
			Boolean modalTitle= pg.verifyOfficeStartModalTitle();
			Assert.assertTrue(modalTitle);
			ExtentTS.getInstance().getExtent().info("Battle field go to office is successfully launched");
			driver.navigate().back();
			Assert.assertTrue(hpHeader.contains(homepageHeader));
			ExtentTS.getInstance().getExtent().info("Back to homepage from battlefield go to office is successful");
		}
		catch (Exception e)
		{
			log.error("Error while running test: verifyBattleFieldGoToPublicPlaceCanBeAccessed",e.getMessage());
			e.printStackTrace();

		}


	}

}
