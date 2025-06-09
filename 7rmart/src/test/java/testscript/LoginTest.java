package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;

	@Test(groups = {
			"regression" }, description = "Verifying User is able to login with valid credentials", priority = 1, retryAnalyzer = retry.Retry.class) // for
																																						// regression
																																						// testing,after
	public void verifyLoginPageWithCorrectUserNameandCorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepage = loginpage.clickSigninButton();// object of homepage

		boolean ishomepageavailable = loginpage.isDashboardDisplayed();
		Assert.assertTrue(ishomepageavailable, Constants.LOGININCORRECTUSERNAMECORRECTPWD);// true
	}

	@Test(description = "Verifying user is able to login with valid username and invalid password", priority = 2, groups = {
			"smoke" }, retryAnalyzer = retry.Retry.class)
	public void verifyLoginPageWithCorrectUserNameandIncorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepage = loginpage.clickSigninButton();
		boolean ishomepagenotavailable = loginpage.isAlertisDisplayed();
		Assert.assertTrue(ishomepagenotavailable, Constants.LOGININCORRECTPASSWORD);
	}

	@Test(description = "Verifying user is able to login with invalid username and valid Password", priority = 3)
	public void verifyLoginPageWithIncorrectUserNameandCorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSigninButton();
		boolean ishomepagenotavailable = loginpage.isAlertisDisplayed();
		Assert.assertTrue(ishomepagenotavailable, Constants.LOGININCORRECTUSERNAME);

	}

	@Test(retryAnalyzer = retry.Retry.class, dataProvider = "LoginProvider", description = "Verifying user is able to login with invalid username and invalid password") // dataprovider

	public void verifyLoginPageWithIncorrectUserNameandIncorrectPassword(String username, String password)
			throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSigninButton();
		boolean ishomepagenotavailable = loginpage.isAlertisDisplayed();
		Assert.assertTrue(ishomepagenotavailable, Constants.LOGININCORRECTUSERNAMEINCORRECTPWD);
	}

	@DataProvider(name = "LoginProvider") // for identify testcase
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getStringData(4, 0, "loginpage"), ExcelUtility.getStringData(4, 1, "loginpage") } };

	}

}
