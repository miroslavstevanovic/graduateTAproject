package test.login;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class TNGAnnotations {

	private static WebDriver driver;

	LoginPage loginPage;
	HomePage homepage;
	SearchResultPage searchResult;
	CDDPage cddPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		loginPage.clearUsernameAndPasswordFields();
		System.out.println("Before Method");
	}

	@Test
	public void f() {

		loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.passwordWrong);
		loginPage.clickOnLoginButtonWrongData();

		String message = loginPage.getTextFromErrorLable();
		System.out.println(message);

		assert message.contains("Invalid login") : "Error : You are logged in";

		System.out.println("Test passed");
	}

	@Test(dependsOnMethods = "f")
	public void f2() {
		loginPage.typeUsername(Property.usernameWrong);
		loginPage.typePassword(Property.password);
		loginPage.clickOnLoginButtonWrongData();
		Sleeper.sleepTightInSeconds(3);

		String message = loginPage.getTextFromErrorLable();
		System.out.println(message);

		assert message.contains("Invalid login") : "Error : You are logged in";

		System.out.println("Test passed");
	}

	@Test(dependsOnMethods = "f2")
	public void f3() {
		loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.password);
		homepage = loginPage.clickOnLoginButton();

		String message = homepage.getTextFromLogInfoLabel();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

		System.out.println("Test passed");
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("Usao u After Class");
		driver.quit();
	}

}
