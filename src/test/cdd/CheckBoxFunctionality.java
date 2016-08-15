package test.cdd;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;
import library.util.Prepare;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
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

		//driver = new FirefoxDriver();
		driver = Prepare.chromeDriver();
		loginPage = new LoginPage(driver);

	}

	@Test(groups = "CheckBox")
	public void f() {

		try {
			System.out.println("Login");
			loginPage.typePassword(Property.password);
			loginPage.typeUsername(Property.username);
			homepage = loginPage.clickOnLoginButton();

			System.out.println("Verify Login");
			String loginMessage = homepage.getTextFromLogInfoLabel();
			assert loginMessage.contains(expectedLoginMessage) : "You are not logged in";
			
			System.out.println("Search 'career'");
			homepage.typeSearchValueIntoSearchField(searchValue);
			searchResult = homepage.clickOnGoButton();
			
			System.out.println("Click on CDD link");
			cddPage = searchResult.clickOnCDDLink();
			
			System.out.println("Check first checkbox");
			cddPage.checkFirstCheckBox();
			isChecked = true;
			
			System.out.println("Log out");
			loginPage = cddPage.clickOnLogOutLink();

			System.out.println("Login");
			loginPage.typePassword(Property.password);
			loginPage.typeUsername(Property.username);
			homepage = loginPage.clickOnLoginButton();
			
			System.out.println("Verify Login");
			loginMessage = homepage.getTextFromLogInfoLabel();
			assert loginMessage.contains(expectedLoginMessage) : "You are not logged in";
			
			System.out.println("Search 'career'");
			homepage.typeSearchValueIntoSearchField(searchValue);
			searchResult = homepage.clickOnGoButton();
			
			System.out.println("Click on CDD link");
			cddPage = searchResult.clickOnCDDLink();
			
			System.out.println("Verify is checkbox checked");
			assert cddPage.isCheckBoxSelected() : "Check box should be selected";
			cddPage.checkFirstCheckBox();
			
			System.out.println("Log out");
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
	System.out.println("After Class. Kill the driver.");
		
		driver.quit();
	if (isChecked){
		
		System.out.println("Enter in After Class. Back to default");
		driver = Prepare.chromeDriver();
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

