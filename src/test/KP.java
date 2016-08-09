package test;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.HomePage;
import library.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class KP {

	LoginPage loginPage1;
	HomePage homePage1;
	public static WebDriver driver;

	@BeforeClass
	public void beforeClass() {
	
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		loginPage1 = new LoginPage(driver);
	}

	@Test
	public void f() {
		
	

		Sleeper.sleepTightInSeconds(5);

	}

	@AfterClass
	public void afterClass() {
	}

}
