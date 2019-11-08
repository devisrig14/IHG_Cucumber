Feature:  Corporate user access

Scenario: Verify the functionality for corporate user
Given As a user I launch browser enter url of IHG
When user enters username and password
Then IHG Home page should display
Then click on Intelligence
And Advanced analytics
Then It should navigate to Analytics page
When user enters the user name in search user field
Then User details should display
And verify the email id and network id whether it's auto populated
When user clicks on Home
Then user should land in Home page 

When user clicks on Add or Remove  button
Then Enters the username and it should display with the user information
When user clicks on Manage access
Then user should can view all the access
Then clicks on Hotel Location Access
And Click on Continue
Then Enter the Hotel information and click on OK
Then user should land in Home page
Then validate whether the access is added
Then user should land in Home page 

When user clicks on Add or Remove  button
Then Enters the username and it should display with the user information
When user clicks on Manage access
And clicks on the access to Remove
Then clicks on Hotel Location Access to remove
And Click on Continue
Then user should land in Home page
Then validate whether the access is removed
Then user should land in Home page 

Then Close Browser


