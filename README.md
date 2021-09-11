# AuthorizationTest
Authorization test

src\test\java\ru\mirapolis:
+ ConfigFileReader.java - Read data from configuration file
+ LoginParameters.java - Contains parameters for running tests
+ SelectorsLoginPage.java - Contains selectors for page elements (login fields, login button)
+ TestLoginPage.java - Run tests with parameters
+ WebDriverSettings.java - Contains fixtures @Before, @After (starting the browser and closing it)

configs:
+ Configuration.properties - Contains data about driver path, timeout, host, browser

resources - The folder contains drivers for browsers Chrome, Firefox, Edge
