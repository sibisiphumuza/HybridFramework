package Tests;

import drivermanager.DriverManager;
import logsetup.Log;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constants.GlobalConstants;
import utilities.PropertyFileReader;
import webpage.HomePage;
import webpage.MyAccountPage;
import webpage.UserRegistrationPage;
import webpages.pagesections.MainMenuSection;
import decorators.Driver;
import decorators.DriverBase;
import decorators.DriverLogger;

public class BaseTest {

	public Driver driver;

	protected HomePage homePage; 
	protected MainMenuSection mainMenusection;
	protected UserRegistrationPage userRegistrationPage;
	protected MyAccountPage myAccountPage;

	String url = PropertyFileReader.readFile(GlobalConstants.OBJECT_PROPERTIES).get("url").toString();

	@Parameters({ "browser" })
	@BeforeMethod
	public void testInit(@Optional("chrome")String browser) {
		
		// Setup the driver of type Driver
		driver = new DriverLogger(new DriverBase());

		// Add the driver to the threadlocalmap from DriverManager
		DriverManager.setDriver(driver);
		Log.info("Driver set up successfull.");
		
		// Getting the driver from the Threadlocal internal hashmap
		DriverManager.getDriver().start(browser);
		Log.info("Browser "+browser+" started.");

		homePage = new HomePage();
		mainMenusection = new MainMenuSection();
		userRegistrationPage = new UserRegistrationPage();
		myAccountPage = new MyAccountPage();
	}

	@AfterMethod
	public void testCleanup() {
		if (DriverManager.getDriver() != null) {
			DriverManager.removeDriver();
		}
		Log.info("Driver quit successfully.");
	}

}
