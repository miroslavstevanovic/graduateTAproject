package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalSystemPage extends Page {

	@FindBy(xpath = "//div[contains(@class, 'box generalbox info')]/div[1]/p[1]")
	private WebElement infoBox;

	private By byInfoBox = new By.ByXPath("//div[contains(@class, 'box generalbox info')]/div[1]/p[1]");

	public InternalSystemPage(WebDriver driver) {
		super(driver);
		waitForPageToBeLoaded(driver, byInfoBox, 5);
		
	}
	
/**
 * Get text from info box
 * @return {String}
 */
	
	public String getInfoBoxText() {
		return infoBox.getText();
	}
	
}
