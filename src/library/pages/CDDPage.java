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

	public CDDPage(WebDriver driver) {
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Check on first check box
	 * 
	 * @return (CDDPage)
	 */
	public CDDPage checkFirstCheckBox() {

		if (!isCheckBoxSelected()) {
			logOutLink.click();
		}
		firstCheckBox.click();

		Sleeper.sleepTightInSeconds(3);
		return this;
	}
	
	/**
	 * Uncheck on first check box
	 * 
	 * @return (CDDPage)
	 */
	public CDDPage unCheckFirstCheckBox() {

		if (!isCheckBoxSelected()) {
			logOutLink.click();
		}
		firstCheckBox.click();

		Sleeper.sleepTightInSeconds(3);
		return this;
	}

	/**
	 * Click Log out link
	 * 
	 * @return (LoginPage)
	 */
	public LoginPage clickOnLogOutLink() {
		Sleeper.sleepTightInSeconds(3);
		return new LoginPage(driver);
	}

	/**
	 * Is check box selected
	 * 
	 * @return (Boolean)
	 */
	public boolean isCheckBoxSelected() {
		String attributeValue = firstCheckBox.getAttribute("title");
		if (attributeValue.contains("Mark as complete")) {
			return false;

		} else
			return true;
	}

}
