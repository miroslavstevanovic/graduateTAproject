package library.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(className = "logininfo")
	private WebElement loginfoLabel;
	
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;
	
	@FindBy(xpath = "//input[contains(@value, 'Go')]")
	private WebElement goButton;	
	
	@FindBy(css = "a[title='My Account']")
	private WebElement myAccount;
	
	@FindBy(css = "a[title='My Profile']")
	private WebElement myProfile;
	
	@FindBy(css = "a[title='Endava University']")
	private WebElement endavaUniversity;
	
	@FindBy(css = "a[title='Internal systems self help']")
	private WebElement internalSystemSelfHelp;
	
	
	private WebDriver driver;
	
	public HomePage (WebDriver driver){
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver, this);
	}
	/**
	 * Get text from login label
	 * @return (String)
	 */
	public String getTextFromLogInfoLabel(){

		return loginfoLabel.getText();
	}
	/**
	 * Type Search Value Into Search Field
	 * @param (String)
	 * @return (HomePage)
	 */
	public HomePage typeSearchValueIntoSearchField(String value){
		searchInputField.sendKeys(value);
		return this;
	}
	
	public SearchResultPage clickOnGoButton(){
		//goButton.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", goButton);
		return new SearchResultPage(driver);
}
	/**
	 * Click dropdown menu
	 * @return (HomePage)
	 */
	public HomePage clickOnMyAccount(){
		myAccount.click();
		return this;
	}
	/**
	 * Click on my profile
	 * @return (My Profile)
	 */
	public MyProfilePage clickOnMyProfile(){
		myProfile.click();
		return new MyProfilePage(driver);
	}
	/**
	 * Click on endava university
	 * @return (Endava University)
	 */
	public HomePage clickOnEndavaUniversity(){
		endavaUniversity.click();
		return this;
	}
	
	public InternalSystemPage clickOnISSH(){
		   internalSystemSelfHelp.click();
		   return new InternalSystemPage(driver);
		   
	}
	
}
	


