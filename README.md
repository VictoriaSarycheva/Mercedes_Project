Dear Hiring Team,

I have downloaded my project with the tests.

* You don't need to download any WebDrivers before, the library in the project should take care of that.
* Please, find the variable "**SAVE_DOCUMENT_URL**" in the class src/test/java/constants/ProjectConstants.java and change the path for the actual for you.
* For changing the browser before starting the tests, please,
  - open the "Run/Debug Configurations" ->
  - JUnit ->
  - click on the "Edit configuration templates..." ->
  - choose the "All in package" option if you want to start firstly all tests in one browser ->
  - input into the "Environment variables" option "BROWSER=chrome" or "BROWSER=firefox" and save the properties
    
* I faced a problem that I wasn't able to solve till now it's a cookies popup. I tried to reach the buttons by xpath and tried many options how to pass the configuration for a WebDriver to block third-party cookies but for some reason, no one method didn't help me.
So, I need to ask you to run all tests in debug mode with a point on
  - .clickOnYourStateDropdown() method
  - or .fillLocationData(NEW_SOUTH_WALES_STATE, WALES_POST_CODE),
depends on the case but everywhere it's the first method in a test.

* In the "**ContactCardTest**" class you will find a test that corresponds to the scenario in the task description.
* I didn't add the additional checks exactly to the same case since in real life I follow the principle that tests should be atomic and don't contain several checks from different areas. But you can find several more examples of checks in "**ChoosingLocationPopupTest**" and "**AvailableVehiclesFilterTest**" classes

Thank you for following the instructions!

I will be very appreciative of extended feedback about this work
