package library.pages;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.GetText;

public class HomePage {
	
	@FindBy(className = "logininfo")
	private WebElement loginfoLabel;
	
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;
	
	//@FindBy(css = "input[type= 'submit'][value= 'Go']") //moze i ovako, preko css//
	
	@FindBy(xpath = "//input[contains(@value, 'Go')]")
	private WebElement goButton;
	
	
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
		goButton.click();
		return new SearchResultPage(driver);
}
}
