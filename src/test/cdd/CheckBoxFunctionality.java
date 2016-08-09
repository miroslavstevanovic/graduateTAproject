package test.cdd;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class CheckBoxFunctionality {
	
	private WebDriver driver;
	
	boolean b = false;
	boolean isChecked = false;
	
	LoginPage loginPage;
	HomePage homepage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	
	String logInMessage;
	

	String expectedLoginMessage = "You are logged in as";
	String searchValue = "career";

	@BeforeClass
	public void beforeClass() {

		System.out.println("Test: Start");

		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);

	}

	@Test
	public void f() {

		try {
			// System.out.println("Step: Type password");
			loginPage.typePassword(Property.password);
			loginPage.typeUsername(Property.username);
			homepage = loginPage.clickOnLoginButton();

			String loginMessage = homepage.getTextFromLogInfoLabel();
			
			assert loginMessage.contains(expectedLoginMessage) : "You are not logged in";
			
			homepage.typeSearchValueIntoSearchField(searchValue);
			searchResult = homepage.clickOnGoButton();
			cddPage = searchResult.clickOnCDDLink();
			
			
			
			cddPage.checkFirstCheckBox();
			isChecked = true;
			
			
			loginPage = cddPage.clickOnLogOutLink();

			loginPage.typePassword(Property.password);
			loginPage.typeUsername(Property.username);
			homepage = loginPage.clickOnLoginButton();
			loginMessage = homepage.getTextFromLogInfoLabel();
			assert loginMessage.contains(expectedLoginMessage) : "You are not logged in";
			homepage.typeSearchValueIntoSearchField(searchValue);
			searchResult = homepage.clickOnGoButton();
			cddPage = searchResult.clickOnCDDLink();
			assert cddPage.isCheckBoxSelected() : "Check box should be selected";
			cddPage.checkFirstCheckBox();
			loginPage = cddPage.clickOnLogOutLink();
			
			System.out.println("Test passed");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	@AfterClass
	public void afterClass() {
		
		
		driver.quit();
	if (isChecked){
		driver = new FirefoxDriver ();
		loginPage = new LoginPage(driver);
		loginPage.typePassword(Property.password);
		loginPage.typeUsername(Property.username);
		homepage = loginPage.clickOnLoginButton();
		logInMessage = homepage.getTextFromLogInfoLabel();
		assert logInMessage.contains(expectedLoginMessage) : "You are not logged in";
		homepage.typeSearchValueIntoSearchField(searchValue);
		searchResult = homepage.clickOnGoButton();
		cddPage = searchResult.clickOnCDDLink();
		assert cddPage.isCheckBoxSelected() : "Check box should be selected";
		cddPage.unCheckFirstCheckBox();
		loginPage = cddPage.clickOnLogOutLink();
		driver.quit();
	}
	}
	}

