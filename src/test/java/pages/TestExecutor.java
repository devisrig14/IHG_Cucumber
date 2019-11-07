package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class TestExecutor {

	public static WebDriver driver;
	public static String userDir = System.getProperty("user.dir");
	public static Common common = new Common();
	public static CorporateUserObj corpUserObj = new CorporateUserObj();

	public static ExtentTest logger;
	public static Properties prop = new Properties();


	public TestExecutor() {
	   System.out.println("Init");
	   
	}
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
