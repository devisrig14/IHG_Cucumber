package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.TestExecutor;

public class MyDemo extends TestExecutor {

	@Given("As a user I launch browser enter url of IHG")
	public void as_a_user_I_launch_browser_enter_url_of_IHG() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://myid-int.ihg.com");
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {

		driver.findElement(By.xpath(corpUser_Obj.username)).clear();
		driver.findElement(By.xpath(corpUser_Obj.username)).sendKeys("yerrams");

		driver.findElement(By.xpath(corpUser_Obj.password)).clear();
		driver.findElement(By.xpath(corpUser_Obj.password)).sendKeys("P@ssw0rd1");

		driver.findElement(By.xpath(corpUser_Obj.login)).click();
		common.waitExplicitlyForPageToLoad("Home", 60);

	}

	@Then("IHG Home page should display")
	public void ihg_Home_page_should_display() {
		common.isElementExist(corpUser_Obj.landingPageLogo, "landingPageLogo");
	}

	@Then("click on Intelligence")
	public void click_on_Intelligence() {
		common.isElementExist(corpUser_Obj.intelligence, "Intelligence");
		common.clickByXPath(corpUser_Obj.intelligence, "Intelligence");
	}

	@Then("Advanced analytics")
	public void advanced_analytics() {
		common.isElementExist(corpUser_Obj.advancedAnalytics, "AdvancedAnalytics");
		common.clickByXPath(corpUser_Obj.advancedAnalytics, "AdvancedAnalytics");
	}

	@Then("It should navigate to Analytics page")
	public void it_should_navigate_to_Analytics_page() {
		common.waitExplicitlyForPageToLoad("Advanced Analytics", 60);
		common.isElementExist(corpUser_Obj.advancedAnalytics, "AdvancedAnalytics");
	}

	@When("user enters the user name in search user field")
	public void user_enters_the_user_name_in_search_user_field() {
		common.isElementExist(corpUser_Obj.searchUser, "searchUserName ");
		common.getObjectByXpath(corpUser_Obj.searchUser).clear();
		common.inputbyxpath(corpUser_Obj.searchUser, "searchUserName", "003574");
		common.isElementExist(corpUser_Obj.runSerach, "runSerach");
		common.clickByXPath(corpUser_Obj.runSerach, "runSerach");
	}

	@Then("User details should display")
	public void user_details_should_display() {
		common.waitExplicitlyForPresence("//div[text()='003574']", 60);
		common.clickByXPath("//div[text()='003574']", "User");

	}

	@Then("verify the email id and network id whether it's auto populated")
	public void verify_the_email_id_and_network_id_whether_it_s_auto_populated() {
		String email = common.getObjectByXpath(corpUser_Obj.email).getText();
		System.out.println("------------------------"+email);
		if (email.isEmpty()) {
			System.out.println("User email is not generated");
			// logger.log(LogStatus.FAIL, "User email is not generated");
		} else {
			System.out.println("User email is generated");
			// logger.log(LogStatus.PASS, "User email is not generated");
		}

		String networkID = common.getObjectByXpath(corpUser_Obj.networkId).getText();
		System.out.println("------------------------========"+networkID);
		
		if (networkID.isEmpty()) {
			System.out.println("networkId is not generated");
			//logger.log(LogStatus.FAIL, "networkId is not generated");
		} else {
			System.out.println("networkId is generated");
			//logger.log(LogStatus.PASS, "networkId is not generated");
		}
	}

	@When("user clicks on Home")
	public void user_clicks_on_Home() {
		common.getObjectByXpath(corpUser_Obj.homeBtn).click();

	}

	@Then("user should land in Home page")
	public void user_should_land_in_Home_page() {
		common.waitExplicitlyForPresence(corpUser_Obj.addRemoveBtn, 60);
	}

	@When("user clicks on Add or Remove  button")
	public void user_clicks_on_Add_or_Remove_button() {
		common.clickByXPath(corpUser_Obj.addRemoveBtn);
		common.waitExplicitlyForPresence(corpUser_Obj.addRemoveUserSearch, 60);
	}

	@Then("Enters the username and it should display with the user information")
	public void enters_the_username_and_it_should_display_with_the_user_information() {
		common.getObjectByXpath(corpUser_Obj.addRemoveUserSearch).clear();
		common.getObjectByXpath(corpUser_Obj.addRemoveUserSearch).sendKeys("003574");

		common.clickByXPath(corpUser_Obj.userSearchBtn);

		common.waitExplicitlyForClickable(corpUser_Obj.addaccessUserChckbx, 150);

		common.clickByXPath(corpUser_Obj.addaccessUserChckbx);
		common.clickByXPath(corpUser_Obj.ManageAccess);

	}

	@When("user clicks on Manage access")
	public void user_clicks_on_Manage_access() {
		common.clickByXPath(corpUser_Obj.ManageAccess);
	}

	@Then("user should can view all the access")
	public void user_should_can_view_all_the_access() {
		common.jsScrollToElement(corpUser_Obj.HotelLocationAccess);

	}

	
	@Then("clicks on Hotel Location Access")
	public void clicks_on_Hotel_Location_Access() {
		common.clickByXPath(corpUser_Obj.HLA_Chkbx);
		
	}

	@Then("Click on Continue")
	public void Click_On_Continue() {
		
		/*Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(corpUser_Obj.continueBtn));
		actions.doubleClick(elementLocator).perform();*/
		
		WebElement element = driver.findElement(By.xpath(corpUser_Obj.continueBtn));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		//driver.findElement(By.xpath(corpUser_Obj.continueBtn)).click();
		//common.clickByXPath(corpUser_Obj.continueBtn);
	}

	@Then("Enter the Hotel information and click on OK")
	public void enter_the_Hotel_information_and_click_on_OK() {
		common.waitExplicitlyForPresence(corpUser_Obj.completeWorkItem, 60);
		
		common.getObjectByXpath(corpUser_Obj.country).clear();
		common.SelectByVisible(corpUser_Obj.country, "GERMANY", "Country selected");
		
		common.getObjectByXpath(corpUser_Obj.HotelName).clear();
		common.SelectByIndex(corpUser_Obj.HotelName, 1 , "Hotel name selected");
		
		common.getObjectByXpath(corpUser_Obj.jobTitle).clear();
		common.SelectByVisible(corpUser_Obj.jobTitle, "Hotel IT Admin", "Job Title selected");
		
		common.clickByXPath(corpUser_Obj.ok);
	}

	@Then("validate whether the access is added")
	public void validate_whether_the_access_is_added() {
	}

	@Then("clicks on the access to Remove")
	public void clicks_on_the_access_to_Remove() {
		common.clickByXPath(corpUser_Obj.removeAccess);
	}


	@Then("validate whether the access is removed")
	public void validate_whether_the_access_is_removed() {
	}

	
	@Then("Close Browser")
	public void closeBrowser() {
		driver.quit();
	}
}
