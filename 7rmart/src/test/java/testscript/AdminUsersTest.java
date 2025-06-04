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

public class AdminUsersTest extends Base{
	AdminUsersPage adminuserspage;
	HomePage homepage;//moreinfo in homepage
	@Test(retryAnalyzer=retry.Retry.class,description="Verifying Admin user can add new users successfully")//retest if fail//package name-retry,class name Retry
	
	public void adminUsersTest() throws IOException
	{
	    String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username).enterPassword(password);
	//loginpage.enterPassword(password);
	homepage=loginpage.clickSigninButton();
	//*******************************
	 //faker utility ->it randomly generate data.instance 
	FakerUtility fakerutility=new FakerUtility();
	 
	 String username_AdminUserTest= fakerutility.creatARandomFirstName();
	 String password_AdminUserTest= fakerutility.creatARandomLastName();
	 //String username_AdminUserTest=ExcelUtilities.getStringData(1, 0, "adminuserspage");
	 //String password_AdminUserTest=ExcelUtilities.getStringData(1, 1, "adminuserspage");
	 String userType=ExcelUtility.getStringData(2,2,"adminuser");
	//AdminUsersPage adminusespage=new AdminUsersPage(driver);
	//adminusespage.adminUsers();
	 adminuserspage=homepage.adminUsersMoreInfo();
	 adminuserspage.newUserAdminUser().adminUsersInfoUname(username_AdminUserTest).adminUsersInfoPwd(password_AdminUserTest).adminUsersTypeSelect(userType).saveAdminUsersInfo();
	//adminusespage.adminUsersInfoUname(username_AdminUserTest);//pass username faker utility
	//adminusespage.adminUsersInfoPwd(password_AdminUserTest);
	//adminusespage.adminUsersTypeSelect();
	//adminusespage.adminUsersTypeSelect(dropdown);
	// String userType=ExcelUtility.getStringData(1,0,"adminuser");//String admin page in excel
//	 adminusespage.adminUsersTypeSelect(userType);
//	adminusespage.saveAdminUsersInfo();
//	boolean wrongalertvar=adminusespage.userAlreadyExistAlertdisplayed();
//	Assert.assertTrue(wrongalertvar);
	//LogOutPage logoutpage=new LogOutPage(driver);
	//logoutpage.clickOnAdminAvatar();
	//logoutpage.clickOnLogoutButton();
	//logoutpage.isSignInButtonDisplayed();
    boolean successalertvar=adminuserspage.successfullAlertdisplayed();
    Assert.assertTrue(successalertvar,Constants.ADDADMINUSERERROR);
	
	}

}
//chaining of page=driver only pass once
//chaining of method=object can be call once and call as chain using '.'