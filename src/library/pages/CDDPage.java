package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CDDPage {
	
	@FindBy(xpath = "//input[contains(@title, 'CDD Animation Scripts')]")
	private WebElement firstCheckBox;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutLink;
	
	private WebDriver driver;
	
	public CDDPage (WebDriver driver){
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
	}
	
	public CDDPage checkFirstCheckBox(){
		firstCheckBox.click();
		Sleeper.sleepTightInSeconds(3);
		return this;
	}
	
	public LoginPage clickOnLogOutLink(){
		logOutLink.click();
		return new LoginPage(driver);
	}
	

	public boolean isCheckBoxSelected(){
		String attributeValue = firstCheckBox.getAttribute("title");
		if (attributeValue.contains("Mark as complete")) {
			return false;
			
		}else return true;
	}
		
}
