package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends Page {

	@FindBy(css = "a[href*='mailto']")
	private WebElement emailLabel;

	@FindBy(linkText = "Career Development Discussion")
	private WebElement careerLabel;

	@FindBy(linkText = "Log out")
	private WebElement logOutLable;

	private By byEmailLable = new By.ByCssSelector("a[href*='mailto']");

	public MyProfilePage(WebDriver driver) {
		super(driver);
		waitForPageToBeLoaded(driver, byEmailLable, 5);
		
		
	
	}

	public String getEmailAddress() {
		emailLabel.getText();
		return emailLabel.getText();
	}

	public String getTextFromCareerLable() {
		careerLabel.getText();
		return careerLabel.getText();
	}

	public LoginPage clickLogout() {
		logOutLable.click();
		Sleeper.sleepTightInSeconds(3);
		return new LoginPage(driver);
	}

}
