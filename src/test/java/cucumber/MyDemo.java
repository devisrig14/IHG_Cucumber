package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.TestExecutor;

public class MyDemo extends TestExecutor {

	@Given("As a user I launch browser enter url of IHG")
	public void as_a_user_I_launch_browser_enter_url_of_IHG() {
		try {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\devisri.g\\Documents\\IHG\\My_ID\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://myid-int.ihg.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {

		driver.findElement(By.xpath(corpUserObj.username)).clear();
		driver.findElement(By.xpath(corpUserObj.username)).sendKeys("yerrams");

		driver.findElement(By.xpath(corpUserObj.password)).clear();
		driver.findElement(By.xpath(corpUserObj.password)).sendKeys("P@ssw0rd1");

		driver.findElement(By.xpath(corpUserObj.login)).click();
		common.waitExplicitlyForPageToLoad("Home", 60);

	}

	@Then("IHG Home page should display")
	public void ihg_Home_page_should_display() {
		common.isElementExist(corpUserObj.landingPageLogo, "landingPageLogo");
	}

	@Then("click on Intelligence")
	public void click_on_Intelligence() {
		common.isElementExist(corpUserObj.intelligence, "Intelligence");
		common.clickByXPath(corpUserObj.intelligence, "Intelligence");
		pauseSeconds(2);
	}

	@Then("Advanced analytics")
	public void advanced_analytics() {
		common.isElementExist(corpUserObj.advancedAnalytics, "AdvancedAnalytics");
		common.clickByXPath(corpUserObj.advancedAnalytics, "AdvancedAnalytics");
		pauseSeconds(2);
	}

	@Then("It should navigate to Analytics page")
	public void it_should_navigate_to_Analytics_page() {
		common.waitExplicitlyForPageToLoad("Advanced Analytics", 60);
		common.isElementExist(corpUserObj.advancedAnalytics, "AdvancedAnalytics");
	}

	@When("user enters the user name in search user field")
	public void user_enters_the_user_name_in_search_user_field() {
		common.isElementExist(corpUserObj.searchUser, "searchUserName ");
		common.getObjectByXpath(corpUserObj.searchUser).clear();
		common.inputbyxpath(corpUserObj.searchUser, "searchUserName", "003574");
		common.isElementExist(corpUserObj.runSerach, "runSerach");
		common.clickByXPath(corpUserObj.runSerach, "runSerach");
	}

	@Then("User details should display")
	public void user_details_should_display() {
		common.waitExplicitlyForPresence("//div[text()='003574']", 60);
		common.clickByXPath("//div[text()='003574']", "User");

	}

	@Then("verify the email id and network id whether it's auto populated")
	public void verify_the_email_id_and_network_id_whether_it_s_auto_populated() {
		String email = common.getObjectByXpath(corpUserObj.email).getText();
		System.out.println("------------------------" + email);
		if (email.isEmpty()) {
			System.out.println("User email is not generated");
			// logger.log(LogStatus.FAIL, "User email is not generated");
		} else {
			System.out.println("User email is generated");
			// logger.log(LogStatus.PASS, "User email is not generated");
		}

		String networkID = common.getObjectByXpath(corpUserObj.networkId).getText();
		System.out.println("------------------------========" + networkID);

		if (networkID.isEmpty()) {
			System.out.println("networkId is not generated");
			// logger.log(LogStatus.FAIL, "networkId is not generated");
		} else {
			System.out.println("networkId is generated");
			// logger.log(LogStatus.PASS, "networkId is not generated");
		}
	}

	@When("user clicks on Home")
	public void user_clicks_on_Home() {
		common.getObjectByXpath(corpUserObj.homeBtn).click();

	}

	@Then("user should land in Home page")
	public void user_should_land_in_Home_page() {
		common.waitExplicitlyForPresence(corpUserObj.addRemoveBtn, 60);
	}

	@When("user clicks on Add or Remove  button")
	public void user_clicks_on_Add_or_Remove_button() {
		
		common.clickByXPath(corpUserObj.addRemoveBtn);
		common.waitExplicitlyForPresence(corpUserObj.addRemoveUserSearch, 60);
	}

	@Then("Enters the username and it should display with the user information")
	public void enters_the_username_and_it_should_display_with_the_user_information() {
		common.waitExplicitlyForClickable(corpUserObj.addaccessUserChckbx, 200);
		common.getObjectByXpath(corpUserObj.addRemoveUserSearch).clear();
		pauseSeconds(1);
		common.getObjectByXpath(corpUserObj.addRemoveUserSearch).sendKeys("003574");
		pauseSeconds(1);
		common.clickByXPath(corpUserObj.userSearchBtn);

		common.waitExplicitlyForClickable(corpUserObj.addaccessUserChckbx, 200);

		common.clickByXPath(corpUserObj.addaccessUserChckbx);
		common.clickByXPath(corpUserObj.ManageAccess);

	}

	@When("user clicks on Manage access")
	public void user_clicks_on_Manage_access() {
		common.clickByXPath(corpUserObj.ManageAccess);
	}

	@Then("user should can view all the access")
	public void user_should_can_view_all_the_access() {
		common.jsScrollToElement(corpUserObj.HotelLocationAccess);

	}

	
	@Then("clicks on Hotel Location Access")
	public void clicks_on_Hotel_Location_Access() {
		common.clickByXPath(corpUserObj.HLA_Chkbx);

	}

	@Then("Click on Continue")
	public void Click_On_Continue() {

		 pauseSeconds(6);
		 /*Actions actions = new Actions(driver); 
		 WebElement elementLocator = driver.findElement(By.xpath(corpUserObj.continueBtn1));
		 actions.click(elementLocator).perform();*/
	
		WebElement element = driver.findElement(By.xpath(corpUserObj.continueBtn1));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	@Then("Enter the Hotel information and click on OK")
	public void enter_the_Hotel_information_and_click_on_OK() {
		common.waitExplicitlyForPresence(corpUserObj.completeWorkItem, 60);

		common.getObjectByXpath(corpUserObj.countrydrpdwn).click();
		pauseSeconds(2);
		driver.findElement(By.xpath(corpUserObj.country)).sendKeys("Chile");
		pauseSeconds(2);
		driver.findElement(By.xpath(corpUserObj.suggestion)).click();
		pauseSeconds(1);

		common.getObjectByXpath(corpUserObj.hotelDrpdown).click();
		pauseSeconds(2);
		driver.findElement(By.xpath(corpUserObj.HotelName)).sendKeys("iqqex");
		pauseSeconds(1);
		driver.findElement(By.xpath(corpUserObj.suggestion)).click();
		pauseSeconds(1);
		
		common.jsScrollToElement(corpUserObj.jobTitle);
		common.getObjectByXpath(corpUserObj.jobTitleDrpdown).click();
		pauseSeconds(2);
		driver.findElement(By.xpath(corpUserObj.jobTitle)).sendKeys("Hotel IT admin");
		pauseSeconds(1);
		driver.findElement(By.xpath(corpUserObj.suggestion)).click();
		
		
		pauseSeconds(3);
		common.jsScrollToElement(corpUserObj.ok);
		common.clickByXPath(corpUserObj.ok);
	}
	
	@Then("Enter the Hotel information to remove and click on OK")
	public void enter_the_Hotel_information_to_remove_and_click_on_OK() {
		
		common.getObjectByXpath(corpUserObj.hoteldrpdown_Remove).click();
		pauseSeconds(2);
		driver.findElement(By.xpath(corpUserObj.HotelName_Remove)).sendKeys("iqqex");
		pauseSeconds(1);
		driver.findElement(By.xpath(corpUserObj.suggestion)).click();
		pauseSeconds(1);
		
		common.jsScrollToElement(corpUserObj.jobTitle_Remove);
		common.getObjectByXpath(corpUserObj.jobTitleDrpdown_Remove).click();
		pauseSeconds(2);
		driver.findElement(By.xpath(corpUserObj.jobTitle_Remove)).sendKeys("Hotel IT admin");
		pauseSeconds(1);
		driver.findElement(By.xpath(corpUserObj.suggestion)).click();
		
		pauseSeconds(3);
		common.jsScrollToElement(corpUserObj.ok);
		common.clickByXPath(corpUserObj.ok);
		
		pauseSeconds(3);
		common.getObjectByXpath(corpUserObj.removeConfirmarion_Chckbx);
		common.clickByXPath(corpUserObj.ok);
		
	}


	@Then("validate whether the access is added or removed")
	public void validate_whether_the_access_is_added() {
		common.getObjectByXpath(corpUserObj.trackMyRequest).click();
		//common.waitExplicitlyForPresence(corpUserObj.status, 160);
		String status = common.getObjectByXpath(corpUserObj.status).getText();
		System.out.println("================================="+status);
		
		while(!status.equalsIgnoreCase("complete")) {
			System.out.println("In while loop");
			pauseSeconds(100);
			driver.navigate().refresh();
			
			if (common.getSizeOfElementsSelected(corpUserObj.status) != 0) {
				status = common.getObjectByXpath(corpUserObj.status).getText();
				System.out.println("After refresh status ========== "+status);
				continue;
			}else {
				System.out.println("else loop");
				break;
			}
			
		}
		
		common.getObjectByXpath(corpUserObj.homeBtn).click();
		
	}
	
	@Then("clicks on Hotel Location Access to remove")
	public void clicks_on_Hotel_Location_Access_to_remove() {
		common.clickByXPath(corpUserObj.HLA_Chkb_Remove);
		
	}

	@Then("clicks on the access to Remove")
	public void clicks_on_the_access_to_Remove() {
		common.clickByXPath(corpUserObj.removeAccess);
	}

	@Then("validate whether the access is removed")
	public void validate_whether_the_access_is_removed() {
		common.getObjectByXpath(corpUserObj.trackMyRequest);
		common.waitExplicitlyForPresence(corpUserObj.status, 160);
	}
	
	@Then("signout from the application")
	public void signout_from_the_application() {
		common.clickByXPath(corpUserObj.userMenu);
		common.clickByXPath(corpUserObj.logOut);
	}

	@Then("Close Browser")
	public void closeBrowser() {
		driver.quit();
	}

	public void pauseSeconds(int i) {
		try {
			Thread.sleep(1000 * 1);
		} catch (InterruptedException e) {
		}
	}
}
