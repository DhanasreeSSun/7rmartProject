package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.LoginPage;
import pages.AdminUsersPage;
import pages.HomePage;
//import pages.LogOutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	AdminUsersPage adminuserspage;
	HomePage homepage;// moreinfo in homepage

	@Test(retryAnalyzer = retry.Retry.class, description = "Verifying Admin user can add new users successfully")

	public void verifyWhetherUserIsAbleAddAdminUsers() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		homepage = loginpage.clickSigninButton();

		FakerUtility fakerutility = new FakerUtility();

		String username_AdminUserTest = fakerutility.creatARandomFirstName();
		String password_AdminUserTest = fakerutility.creatARandomLastName();

		String userType = ExcelUtility.getStringData(2, 2, "adminuser");

		adminuserspage = homepage.adminUsersMoreInfo();
		adminuserspage.newUserAdminUser().enter_AdminUsersInfoUsername(username_AdminUserTest)
				.enter_AdminUsersInfoPassword(password_AdminUserTest).choose_AdminUsersTypeSelect(userType)
				.saveAdminUsersInfo();

		boolean successalertvar = adminuserspage.isSuccessfullAlertdisplayed();
		Assert.assertTrue(successalertvar, Constants.ADDADMINUSERERROR);

	}

}
