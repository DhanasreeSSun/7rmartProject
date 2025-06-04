package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement Adminavatar;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	WebElement Logout;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SignInButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")
	WebElement adminusersMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement ManageNewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	WebElement ManageContactMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement More_Info_ManageFooterText;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement ManageCategoryMoreInfo;

	public AdminUsersPage adminUsersMoreInfo() {
		adminusersMoreInfo.click();
		return new AdminUsersPage(driver);
	}
	public ManageNewspage moreInfolink()
	{
		 ManageNewsmoreinfo.click();
		return new ManageNewspage(driver);
	}
	public ManageContactPage clickOnManageContactMoreInfoButtonInHomePage()
	{
		
		ManageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}
	public ManageFooterTextPage clickOn_MoreInfoButtonin_homepage()
	{
		More_Info_ManageFooterText.click();
		return new ManageFooterTextPage(driver);
		
	}
	public ManageCategoryPage clickOnManageCategoryMoreInfo() {
		ManageCategoryMoreInfo.click();
		return new ManageCategoryPage(driver);
	}


	public void clickOnAdminAvatar() {
		Adminavatar.click();
	}

	public void clickOnLogoutButton() {
		Logout.click();
	}

	public boolean isSignInButtonDisplayed() {
		return SignInButton.isDisplayed();
	}
}
