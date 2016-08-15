package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import library.data.Property;

public class LoginPage extends Page {

	@FindBy(id = "username")
	private WebElement usernameInputField;

	@FindBy(id = "password")
	private WebElement passwordInputField;

	@FindBy(id = "loginbtn")
	private WebElement loginButton;

	@FindBy(className = "error")
	private WebElement errorLable;

	private By byLoginBtn = new By.ById("loginbtn");

	public LoginPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
		driver.get(Property.URL);
		waitForPageToBeLoaded(driver, byLoginBtn, 5);
	}

	/**
	 * Type username into username fiel
	 * @param username (String)
	 * @return (LoginPage)
	 */
	public LoginPage typeUsername(String username) {
		usernameInputField.sendKeys(username);
		return this;
	}

	/**
	 * Type password into password field
	 * @param password (String)
	 * @return (LogiPage)
	 */
	public LoginPage typePassword(String password) {

		passwordInputField.sendKeys(password);
		return this;
	}

	/**
	 * Click on Login button
	 * @return Homepage
	 */
	public HomePage clickOnLoginButton() {
		loginButton.click();
		return new HomePage(driver);
	}

	/**
	 * Click on Login button
	 * @return LoginPage
	 */
	public LoginPage clickOnLoginButtonWrongData() {
		loginButton.click();
		return this; // new LoginPage(driver);
	}

	public String getTextFromErrorLable() {
		return errorLable.getText();

	}

	/**
	 * Clear user and pass fields
	 * @return (LoginPage)
	 */
	public LoginPage clearUsernameAndPasswordFields() {
		usernameInputField.clear();
		passwordInputField.clear();
		return this;
	}
}
