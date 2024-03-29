package pages;

import java.util.ArrayList;
import java.util.List;

public class CorporateUserObj {
	
	public String username = "//input[@id='username']";
	public String password = "//input[@id='password']";
	public String login = "//input[@id='submitBtn']";
	public String iHGLogo = "//img[@src='./images/ihgbrandmark.png']";
	public String environment = "//input[@value='QA']";
	public String landingPageLogo = "//img[@alt='SailPoint Logo']";
	public String home = "//i[@class='fa fa-home']";
	public String intelligence = "(//*[contains(text(),'Intelligence')]//preceding::a[@role='menuitem'])[17]";
	public String advancedAnalytics = "(//a[contains(text(),'Advanced Analytics')])[1]";
	public String searchUser = "//input[@id='identitySearchForm:userName']";
	public String runSerach  = "//div[@id='preIdentitySearchBtn']";
	public String advAnalytics_page = "//h1[text()='Advanced Analytics']";
	public String userChkbx = "//div[@class='x-grid-row-checker']";
	public String email = "(//tr[@class='odd']/td[2])[2]";
	public String networkId = "(//tr[@class='odd']/td[2])[3]";
	public String addRemoveBtn = "//div[contains(text(),'Add or Remove Access')]";
	public String homeBtn = "//a[@href='/identityiq/home.jsf']";
	public String addRemoveUserSearch = "//input[@id='userSearchText']";
	public String userSearchBtn = "//button[@id='userSearchBtn']";
	public String addaccessUserChckbx = "(//*[@role='checkbox'])[1]";
	public String ManageAccess = "//span[text()='Manage Access']"; 
	public String HotelLocationAccess = "//b[text()=' Hotel Location Access']";
	public String HotelIt_Remove = "//b[text()=' Hotel IT Administration']";
	public String HLA_Chkbx = "//*[@sp-label=' Hotel Location Access' and @role='checkbox']";
	public String HLA_Chkb_Remove  = "//*[@sp-label='Remove  Hotel IT Administration' and @role='checkbox']";
	public String completeWorkItem = "//*[text()=' Complete Work Item']";
	public String country = "//input[@id='field-8a53f2aa5d1048ea015d2ffbb4800baa-country']";
	public String HotelName = "//input[@id='field-8a53f2aa5d1048ea015d2ffbb4800baa-propertyName']";
	public String HotelName_Remove = "//input[@id='field-8a53f2aa61f9904f0161f99215a8001e-propertyName']";
	public String jobTitle = "//input[@id='field-8a53f2aa5d1048ea015d2ffbb4800baa-title']";
	public String jobTitle_Remove = "//input[@id='field-8a53f2aa61f9904f0161f99215a8001e-title']";
	public String ok = "//button[contains(text(),'Ok')]";
	public String removeAccess = "//a[@id='removeAccessBtn']";
	public String continueBtn = "//button[@id='reviewAccessSubmitBtn']";
	public String continueBtn1 = "(//button[contains(.,'Continue')])[1]";
	public String trackMyRequest = "//div[contains(text(),'Track My Requests')]";
	public String status = "//*[@class='text-info ng-binding']//..//..//..//..//..//..//..//..//..//*[@class='label label-state label-match-size label-info']";
	public String countrydrpdwn = "//*[@data-input-id='field-8a53f2aa5d1048ea015d2ffbb4800baa-country']";
	public String hotelDrpdown = "//button[@data-input-id='field-8a53f2aa5d1048ea015d2ffbb4800baa-propertyName']";
	public String jobTitleDrpdown = "//button[@data-input-id='field-8a53f2aa5d1048ea015d2ffbb4800baa-title']";
	public String suggestion = "//a[@class='suggest-item ng-scope']";
	public String firstname = "(//tr[@class='odd'])[1]/td[2]";
	public String lastname = "(//tr[@class='even'])[2]/td[2]";
	public String hoteldrpdown_Remove = "//button[@data-input-id='field-8a53f2aa61f9904f0161f99215a8001e-propertyName']";
	public String jobTitleDrpdown_Remove = "//button[@data-input-id='field-8a53f2aa61f9904f0161f99215a8001e-title']";
	public String removeConfirmarion_Chckbx = "//input[@type='checkbox']";
	public String userMenu = "//a[@id='userMenu']";
	public String logOut = "//a[normalize-space(.) = 'Logout']";
	 
	
	/*public void dbValidation() {
		String fname = Common.getObjectByXpath(firstname).getText();
		String lname = Common.getObjectByXpath(lastname).getText();
		String Email = Common.getObjectByXpath(email).getText();
		String networkID = Common.getObjectByXpath(networkId).getText();
		
		List<String> userInfo = new ArrayList<String>();
		userInfo.add(fname);
		userInfo.add(lname);
		userInfo.add(Email);
		userInfo.add(networkID);
		
		for(int i=0; i<userInfo.size(); i++) {
			if(dbtext.equals(userInfo.get(i)));
		}
		
		
	}*/
	
}

