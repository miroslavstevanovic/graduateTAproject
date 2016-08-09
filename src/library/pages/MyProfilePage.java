package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

	@FindBy(css = "a[href*='mailto']")
	private WebElement emailLabel;

	@FindBy(linkText = "Career Development Discussion")
	private WebElement careerLabel;

	@FindBy(linkText = "Log out")
	private WebElement logOutLable;

	private WebDriver driver;

	public MyProfilePage(WebDriver driver) {
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
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
