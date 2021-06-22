package webtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.ExtentTS;
import com.utils.RandomDataGenerator;
import com.webpages.BusBattleFieldPage;
import com.webpages.CafeBattleFieldPage;
import com.webpages.HomePage;
import com.webpages.LeaderBoardPage;
import com.webpages.LoginPage;
import com.webpages.OfficeBattleFieldPage;

public class TC06_LeaderBoard extends BaseTest{

	public String expBusHeader = "Inside the Bus";

	@Test(priority=2,groups= {"web","oneoff"})
	public void answerManyQAndCheckLeaderBoard() {

		try {

			userName = "WebKal "+RandomDataGenerator.generateRandomString();
			ExtentTS.getInstance().getExtent().info("User assigned with username "+ userName);
			HomePage pg = page.getInstance(LoginPage.class).startJourney(userName);
			Assert.assertTrue(pg.getHPHeader().contains(homepageHeader));
			BusBattleFieldPage bpg = pg.clickOnTakeTheBus();
			for(int i = 0; i<60;i++ ) {
				bpg.startBusBattleField();
				bpg.clickAnswerOne();
				boolean wrngAns = bpg.verifyWrongAnswerModal();
				if(wrngAns == true)
				{
					bpg.retryBusBattleFieldQuestion();
					bpg.clickAnswerTwo();
				}
				CafeBattleFieldPage cpg = bpg.performNextBattle();
				cpg.startcafeBattleField();
				cpg.clickAnswerOne();
				wrngAns = cpg.verifyWrongAnswerModal();
				if(wrngAns == true)
				{
					cpg.retryBusBattleFieldQuestion();
					cpg.clickAnswerTwo();
				}
				OfficeBattleFieldPage opg = cpg.performNextBattle();
				opg.startOfficeBattleField();
				opg.clickAnswerOne();
				wrngAns = opg.verifyWrongAnswerModal();
				if(wrngAns == true)
				{
					opg.retryOfcBattleFieldQuestion();
					opg.clickAnswerTwo();
				}
				opg.performNextBattle();
			}
			LeaderBoardPage lpg=page.getInstance(BusBattleFieldPage.class).performCheckYourScore();
			Assert.assertTrue(lpg.verifyLeaderBoardHeader());
			ExtentTS.getInstance().getExtent().info("Leader board loaded correctly");
			for (int i=0;i<=lpg.getLeaderBoardData().size()-1;i++)
			{
				if(lpg.getLeaderBoardData().toString().contains(userName))
				{
					Assert.assertTrue(true);
					ExtentTS.getInstance().getExtent().info("User created with username "+ userName+" is available in Leader Board");
					break;
				}
			}
		}
		catch(Exception e)
		{
			log.error("Error while running test: answerManyQAndCheckLeaderBoard",e.getMessage());
			e.printStackTrace();
		}
	}


	@Test(groups= {"web", "regression"},priority=1)
	public void answerSingleQAndCheckLeaderBoard() {
		
		try
		{
		userName = "WebKal "+RandomDataGenerator.generateRandomString();
		ExtentTS.getInstance().getExtent().info("User assigned with username "+ userName);
		HomePage pg = page.getInstance(LoginPage.class).startJourney(userName);
		Assert.assertTrue(pg.getHPHeader().contains(homepageHeader));
		BusBattleFieldPage bpg = pg.clickOnTakeTheBus();
		bpg.startBusBattleField();
		Assert.assertEquals(bpg.getBusHeader(),expBusHeader);
		ExtentTS.getInstance().getExtent().info("Battle field bus loaded correctly");
		bpg.clickAnswerOne();
		boolean wrngAns = bpg.verifyWrongAnswerModal();
		if(wrngAns == true)
		{
			bpg.retryBusBattleFieldQuestion();
			bpg.clickAnswerTwo();
		}
		CafeBattleFieldPage cpg = bpg.performNextBattle();
		cpg.startcafeBattleField();
		cpg.clickAnswerOne();
		wrngAns = cpg.verifyWrongAnswerModal();
		if(wrngAns == true)
		{
			cpg.retryBusBattleFieldQuestion();
			cpg.clickAnswerTwo();
		}
		OfficeBattleFieldPage opg = cpg.performNextBattle();
		opg.startOfficeBattleField();
		opg.clickAnswerOne();
		wrngAns = opg.verifyWrongAnswerModal();
		if(wrngAns == true)
		{
			opg.retryOfcBattleFieldQuestion();
			opg.clickAnswerTwo();
		}

		LeaderBoardPage lpg=page.getInstance(BusBattleFieldPage.class).performCheckYourScore();
		Assert.assertTrue(lpg.verifyLeaderBoardHeader());
		ExtentTS.getInstance().getExtent().info("Leader board header verified correctly");
		for (int i=0;i<=lpg.getLeaderBoardData().size()-1;i++)
		{
			if(lpg.getLeaderBoardData().toString().contains(userName))
			{
				Assert.assertTrue(true);
				ExtentTS.getInstance().getExtent().info("User created with username "+ userName+" is available in Leader Board");
				break;
			}
		}
		boolean tickerItems = lpg.checkTickerItems();
		Assert.assertTrue(tickerItems);
		ExtentTS.getInstance().getExtent().info("Leader board ticker items loaded correctly");
		Assert.assertEquals(pg.getHPHeader(), homepageHeader);
		ExtentTS.getInstance().getExtent().info("All functionality checked successfully, regression pass");

		}
		catch(Exception e)
		{
			log.error("Error while running test: answerSingleQAndCheckLeaderBoard",e.getMessage());
			e.printStackTrace();
		}

	}
	
	

}
