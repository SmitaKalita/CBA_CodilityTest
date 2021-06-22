package webtests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.DataReader;
import com.utils.ExtentTS;
import com.utils.RandomDataGenerator;
import com.webpages.HomePage;
import com.webpages.LoginPage;

public class TC01_WelcomePage extends BaseTest{

	public String expectedTitle = "COVID-19 THE GAME";
	public String expectedHeader = "Tell me your warrior name";
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = DataReader.getDataFromExcel(WebTestDataPath);
		return testData.iterator();

	}
	
	@Test(priority = 1,groups= {"web","smoke"})

	public void verifyWelcomePageTitle()
	{
		try {
			page.getInstance(LoginPage.class).waitForWPHeader();
			String title = page.getInstance(LoginPage.class).getWPTitle();
			ExtentTS.getInstance().getExtent().info("Actual title from the test is "+ title);
			Assert.assertEquals(title, expectedTitle);
			ExtentTS.getInstance().getExtent().info("Actual title: " +title+ " is equal to expected title: "+expectedTitle);

		}
		catch(Exception e)
		{
			log.error("Error while running test: verifyWelcomePageTitle",e.getMessage());
			e.printStackTrace();

		}

	}

	@Test(priority = 2,groups= {"web"})

	public void verifyWelcomePageHeader()
	{
		try {
			String header = page.getInstance(LoginPage.class).getWPHeader();
			ExtentTS.getInstance().getExtent().info("Actual header from the test is "+ header);
			Assert.assertEquals(header, expectedHeader);
			ExtentTS.getInstance().getExtent().info("Actual header: " +header+ " is equal to expected header: "+expectedHeader);

		}
		catch(Exception e)
		{
			log.error("Error while running test: verifyWelcomePageHeader",e.getMessage());
			e.printStackTrace();

		}


	}

	
	@Test(dataProvider="getTestData",priority = 3,groups= {"web"})

	public void verifySuccessfulCreationOfWarrior(String User)
	{
		try {
			userName="";
			userName =  User + RandomDataGenerator.generateRandomString();
			ExtentTS.getInstance().getExtent().info("User assigned with username "+ userName);
			page.getInstance(LoginPage.class).createWarrior(userName);
			ExtentTS.getInstance().getExtent().info("User created with username "+ userName);
			String expStatusMsg = "Start your journey "+userName;
			String actStatusMsg = page.getInstance(LoginPage.class).getWPElementText();
			Assert.assertEquals(actStatusMsg, expStatusMsg);
			ExtentTS.getInstance().getExtent().info("Actual success msg: " +actStatusMsg+ " is equal to expected success msg: "+expStatusMsg);

		}
		catch(Exception e)
		{
			log.error("Error while running test: verifySuccessfulCreationOfWarrior",e.getMessage());
			e.printStackTrace();

		}


	}
	@Test(priority = 4,groups= {"web"})

	public void verifySuccessfulCreationOfWarriorAsGuest()
	{
		try {
			ExtentTS.getInstance().getExtent().info("User assigned with no username");
			page.getInstance(LoginPage.class).createWarrior();
			ExtentTS.getInstance().getExtent().info("User created with username as guest");
			String expStatusMsg = "Start your journey guest";
			String actStatusMsg = page.getInstance(LoginPage.class).getWPElementText();
			Assert.assertEquals(actStatusMsg, expStatusMsg);
			ExtentTS.getInstance().getExtent().info("Actual success msg: " +actStatusMsg+ " is equal to expected success msg: "+expStatusMsg);

		}
		catch(Exception e)
		{
			log.error("Error while running test: verifySuccessfulCreationOfWarriorAsGuest",e.getMessage());
			e.printStackTrace();

		}


	}
	@Test(priority = 5,groups= {"web","smoke"})

	public void verifyStartJourneyOfAHero()
	{
		try {
			userName = "";
			userName = "Web SK "+ RandomDataGenerator.generateRandomString();
			ExtentTS.getInstance().getExtent().info("User assigned with username "+ userName);
			HomePage pg = page.getInstance(LoginPage.class).startJourney(userName);
			String expHomePageHeader = "Choose your battle field "+userName;
			String actHomePageHeader = pg.getHPHeader();
			Assert.assertEquals(actHomePageHeader, expHomePageHeader);
			ExtentTS.getInstance().getExtent().info("Actual header" +actHomePageHeader+ " is equal to expected header: "+expHomePageHeader+". Successfully navigated to next page");
			
			
		}
		catch(Exception e)
		{
			log.error("Error while running test: verifyStartJourneyOfAHero",e.getMessage());
			e.printStackTrace();

		}


	}




}
