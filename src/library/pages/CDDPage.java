package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

public class CDDPage extends Page {

	@FindBy(xpath = "//input[contains(@title, 'CDD Animation Scripts')]")
	private WebElement firstCheckBox;

	private By byFirstCheckBox = new By.ByXPath("//input[contains(@title, 'CDD Animation Scripts')]");

	public CDDPage(WebDriver driver) {
		super(driver);
		waitForPageToBeLoaded(driver, byFirstCheckBox, 5);
	}

	/**
	 * Check on first check box
	 * 
	 * @return (CDDPage)
	 */
	public CDDPage checkFirstCheckBox() {

		if (!isCheckBoxSelected()) {
			firstCheckBox.click();
		}

		Sleeper.sleepTightInSeconds(3);
		return this;
	}

	/**
	 * Uncheck on first check box
	 * 
	 * @return (CDDPage)
	 */
	public CDDPage unCheckFirstCheckBox() {

		if (isCheckBoxSelected()) {
			firstCheckBox.click();
		}

		Sleeper.sleepTightInSeconds(3);
		return this;
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
