package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;// public

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//input[@name='username']")
	WebElement uid;
	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signin;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement wrongpassword;

	public LoginPage enterUserName(String username) {
		uid.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		pwd.sendKeys(password);
		return this;// same page not go any other pages
	}

	public HomePage clickSigninButton() {

		signin.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();// return
	}

	public boolean isAlertisDisplayed() {
		return wrongpassword.isDisplayed();
	}

}
