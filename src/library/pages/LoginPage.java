package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.data.Property;

public class LoginPage {

	@FindBy(id = "username")
	private WebElement usernameInputField;

	@FindBy(id = "password")
	private WebElement passwordInputField;

	@FindBy(id = "loginbtn")
	private WebElement loginButton;

	@FindBy(className = "error")
	private WebElement errorLable;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		driver.get(Property.URL);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Type username into username field
	 * 
	 * @param username
	 *            (String)
	 * @return (LoginPage)
	 */
	public LoginPage typeUsername(String username) {

		usernameInputField.sendKeys(username);
		return this;
	}

	/**
	 * Type password into password field
	 * 
	 * @param password
	 *            (String)
	 * @return (LogiPage)
	 */
	public LoginPage typePassword(String password) {

		passwordInputField.sendKeys(password);
		return this;
	}

	/**
	 * Click on Login button
	 * 
	 * @return Homepage
	 */
	public HomePage clickOnLoginButton() {
		loginButton.click();
		return new HomePage(driver);
	}

	/**
	 * Click on Login button
	 * 
	 * @return LoginPage
	 */
	public LoginPage clickOnLoginButtonWrongData() {
		loginButton.click();
		return this; // new LoginPage(driver);
	}

	public String getTextFromErrorLable() {
		return errorLable.getText();

	}
}
