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
		// loginpage.enterPassword(password);
		homepage = loginpage.clickSigninButton();// object of homepage
//		loginpage.enterUserName(username);
//		loginpage.enterPassword(password);

		boolean ishomepageavailable = loginpage.isDashboardDisplayed();
		Assert.assertTrue(ishomepageavailable, Constants.LOGININCORRECTUSERNAMECORRECTPWD);// true
	}

	@Test(description = "Verifying user is able to login with valid username and invalid password", priority = 2, groups = {
			"smoke" },retryAnalyzer=retry.Retry.class)
	public void verifyLoginPageWithCorrectUserNameandIncorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		homepage = loginpage.clickSigninButton();
		boolean ishomepagenotavailable = loginpage.isAlertisDisplayed();
		// Assert.assertTrue(ishomepagenotavailable,"HomePageIsLoadedWithIncorrectPassword");//copy
		// and paste to constantsclass,the message is shown when fail
		Assert.assertTrue(ishomepagenotavailable, Constants.LOGININCORRECTPASSWORD);
	}

	@Test(description = "Verifying user is able to login with invalid username and valid Password", priority = 3)
	public void verifyLoginPageWithIncorrectUserNameandCorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSigninButton();
		// loginpage.enterPassword(password);
		// loginpage.clickSigninButton();
		boolean ishomepagenotavailable = loginpage.isAlertisDisplayed();
		Assert.assertTrue(ishomepagenotavailable, Constants.LOGININCORRECTUSERNAME);

	}

	@Test(retryAnalyzer=retry.Retry.class,dataProvider = "LoginProvider", description = "Verifying user is able to login with invalid username and invalid password") // dataprovider
																																		// start
																																		// here
	public void verifyLoginPageWithIncorrectUserNameandIncorrectPassword(String username, String password)
			throws IOException {
		// String username=ExcelUtility.getStringData(4, 0, "loginpage");
		// String password=ExcelUtility.getStringData(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSigninButton();
		// loginpage.enterPassword(password);
		// loginpage.clickSigninButton();
		boolean ishomepagenotavailable = loginpage.isAlertisDisplayed();
		Assert.assertTrue(ishomepagenotavailable, Constants.LOGININCORRECTUSERNAMEINCORRECTPWD);
	}

	@DataProvider(name = "LoginProvider") // for identify testcase
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getStringData(4, 0, "loginpage"), ExcelUtility.getStringData(4, 1, "loginpage") } };

	}

}

//DataDrivenFramework-1)Excel
//2)Parameterization-@Parameters
//                   -@DataProvider
//techique to filled textdata//give in class level
//put at the end of class,used to test multiple datas//annotation used=@DataProvider
//put the data providerin @Test annotation
//getStringDta-method of excel
//DataProvider put at the end  of last case
//In which test case we need to apply this put @Testannotation
//we can put any name inside dataProvider here give LoginProvider
//run multiple setof data from a test case
//@Test(dataProvider="LoginProvider")//it can understand it is a data provider,
//then check whether there is LoginProvider,it pass two parameters usernam and password
//automatically fetch data and feed into method