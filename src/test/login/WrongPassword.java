package test.login;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class WrongPassword {

	LoginPage loginPage;

	private static WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
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

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
