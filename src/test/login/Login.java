package test.login;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class Login {

	private WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	SearchResultPage searchResult;
	CDDPage cddPage;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void f() {

		loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.password);
		homepage = loginPage.clickOnLoginButton();

		String message = homepage.getTextFromLogInfoLabel();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

		System.out.println("Test passed");
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
