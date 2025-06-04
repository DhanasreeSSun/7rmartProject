package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();// for usage in another classes

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'
	// and text()='More info ']")WebElement adminusersMoreInfo;
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(1)']")
	WebElement newuseradd;
	@FindBy(xpath = "//input[@id='username']")
	WebElement newusersusername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement newuserspassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement selectuser;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertalreadyexist;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successfulalert;

//public void adminUsers()
//{
//	adminusersMoreInfo.click();
//}
	public AdminUsersPage newUserAdminUser() {
		newuseradd.click();
		return this;
	}

	public AdminUsersPage adminUsersInfoUname(String username) {
		newusersusername.sendKeys(username);
		return this;
	}

	public AdminUsersPage adminUsersInfoPwd(String password) {
		newuserspassword.sendKeys(password);
		return this;
	}

	public AdminUsersPage adminUsersTypeSelect(String value) {

		
		pageutility.selectByVisibleText(selectuser, value);
		return this;

	}

	public AdminUsersPage saveAdminUsersInfo() {
		savebutton.click();
		// pageutility.mouseClick(savebutton);
		return this;
	}
	public boolean successfullAlertdisplayed() {
		return successfulalert.isDisplayed();

	}

	/*
	 * public void newAddedUserLogin() { newusersusername }
	 */
	/*
	 * public boolean userAlreadyExistAlertdisplayed() { return
	 * alertalreadyexist.isDisplayed();
	 * 
	 * }
	 */
	
}
