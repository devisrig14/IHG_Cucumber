package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExecutor {

	public static WebDriver driver;
	public static String userDir = System.getProperty("user.dir");
	public static Common common = new Common();
	public static corporateUser_Obj corpUser_Obj = new corporateUser_Obj();

	public static ExtentTest logger;
	public static Properties prop = new Properties();


	/*@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}*/
	
	}
