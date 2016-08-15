package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.util.Wait;

public class HomePage extends Page{
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;
	
	@FindBy(xpath = "//input[contains(@value, 'Go') and contains(@type, 'submit')]")
	private WebElement goButton;
	
	@FindBy(css = "a[title='My Account']")
	private WebElement myAccount;
	
	@FindBy(css = "a[title='My Profile']")
	private WebElement myProfile;
	
	@FindBy(css = "a[title='Endava University']")
	private WebElement endavaUniversity;
	
	@FindBy(css = "a[title='Internal systems self help']")
	private WebElement internalSystemSelfHelp;
	
	private By bySearchInputField = new By.ById("shortsearchbox");
	private By goBtn = new ByXPath("//input[contains(@value, 'Go') and contains(@type, 'submit')]");
	
	public HomePage (WebDriver driver){
		super(driver);
		waitForPageToBeLoaded(driver, goBtn, 5);
		
	
	}
	
	/**
	 * Type Search Value Into Search Field
	 * @param (String)
	 * @return (HomePage)
	 */
	public HomePage typeSearchValueIntoSearchField(String value){
		Wait.untilWebElementPresent(driver, bySearchInputField, 5);
		System.out.println("typeSearchValueIntoSearchField("+value+")");
		searchInputField.sendKeys(value);
		return this;
	}
	
	public SearchResultPage clickOnGoButton(){
		//goButton.click();
		System.out.println("clickOnGoButton()");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", goButton);
		return new SearchResultPage(driver);
}
	/**
	 * Click dropdown menu
	 * @return (HomePage)
	 */
	public HomePage clickOnMyAccount(){
		System.out.println("clickOnMyAccount()");
		myAccount.click();
		return this;
	}
	/**
	 * Click on my profile
	 * @return (My Profile)
	 */
	public MyProfilePage clickOnMyProfile(){
		System.out.println("clickOnMyProfile()");
		myProfile.click();
		return new MyProfilePage(driver);
	}
	/**
	 * Click on endava university
	 * @return (Endava University)
	 */
	public HomePage clickOnEndavaUniversity(){
		System.out.println("clickOnEndavaUniversity()");
		endavaUniversity.click();
		return this;
	}

	public InternalSystemPage clickOnISSH() {
		System.out.println("clickOnISSH()");
		internalSystemSelfHelp.click();
		return new InternalSystemPage(driver);

	}

}
	


