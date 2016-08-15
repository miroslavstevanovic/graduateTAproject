package test.endavaUniversity;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.HomePage;
import library.pages.InternalSystemPage;
import library.pages.LoginPage;
import library.util.Prepare;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class TestEndavaUniversity {

	private WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	InternalSystemPage internalSystemPage;
	String message;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Enter in before class");
		//driver = new FirefoxDriver();
		driver = Prepare.chromeDriver();
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();

		loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.password);
		homepage = loginPage.clickOnLoginButton();

		message = homepage.getTextFromLogInfoLabel();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

		homepage.clickOnEndavaUniversity();
		Sleeper.sleepTightInSeconds(3);
		internalSystemPage = homepage.clickOnISSH();
	}

	@Test
	public void f() {
		System.out.println("Enter in test Test endava university");
		Sleeper.sleepTightInSeconds(3);
		message = internalSystemPage.getInfoBoxText();
		System.out.println(message);
		assert message.contains(Property.infoText) : "There is no category description";
		System.out.println("Test passed");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Enter in after class");
		loginPage = homepage.clickOnLogOutLink();
		driver.quit();
	}

}

