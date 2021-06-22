package webtests;

import com.utils.SetUpReporting;
import com.webpages.BasePage;
import com.webpages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.utils.DriverFactory;
import com.utils.ReadConfig;

public class BaseTest extends SetUpReporting  {

	public static WebDriver driver;
	public Page page;
	public static String userName;
	ReadConfig readconfig = new ReadConfig();// reading the config.properties file
	public String siteURL = readconfig.getapplicationURL();
	public String loginPageTitle = readconfig.getLoginPageTitle();
	public String homePageTitle = readconfig.getHomePageTitle();
	public String WebTestDataPath = readconfig.getWebTestDataPath();
	public String homepageHeader= readconfig.getHomepageHeader();
	public static String BrowserVal;

	@Parameters("Browser") 

	@BeforeClass(alwaysRun=true)

	public void browserSetup(String Brow)
	{

		if(Brow.equals("Chrome"))
		{
			try
			{
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				DriverFactory.getInstance().setDriver(driver);
				driver = DriverFactory.getInstance().getDriver();
				driver.manage().window().maximize();
				BrowserVal="Chrome";
			}
			catch(Exception e)
			{
				log.error("error while launching chrome");
				e.getMessage();
			}
		}

		else if(Brow.equals("Firefox"))
		{
			try
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				DriverFactory.getInstance().setDriver(driver);
				driver = DriverFactory.getInstance().getDriver();
				driver.manage().window().maximize();
				BrowserVal="Firefox";

			}	
			catch(Exception e)
			{
				log.error("error while launching Firefox");
				e.getMessage();
			}
		}
		
		else if(Brow.equals("Edge"))
		{
			try
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				DriverFactory.getInstance().setDriver(driver);
				driver = DriverFactory.getInstance().getDriver();
				driver.manage().window().maximize();
				BrowserVal="Edge";
			}	
			catch(Exception e)
			{
				log.error("error while launching Edge Browser");
				e.getMessage();
			}
		}
		

		driver.get(siteURL);
		page =new BasePage(driver);
	}

	
	@AfterSuite()
	
	public void Teardown() {

		driver.quit();
	}

}
