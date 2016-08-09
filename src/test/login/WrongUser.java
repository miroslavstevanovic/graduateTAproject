package test.login;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class WrongUser {

	LoginPage loginPage;

	private static WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.out.println("Test: Start");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
	}

	@Test
	public void f() {
		loginPage.typeUsername(Property.usernameWrong);
		loginPage.typePassword(Property.password);
		loginPage.clickOnLoginButtonWrongData();
		Sleeper.sleepTightInSeconds(3);

		Sleeper.sleepTightInSeconds(3);
		String message = loginPage.getTextFromErrorLable();
		System.out.println(message);

		assert message.contains("Invalid login") : "Error : You are logged in";

		System.out.println("Test passed");
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
