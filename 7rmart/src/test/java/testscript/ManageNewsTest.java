package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
//import pages.LogOutPage;
import pages.ManageNewspage;
import utilities.ExcelUtility;
//import utilities.WaitUtility;

public class ManageNewsTest extends Base{
	//WaitUtility wait=new WaitUtility();
	ManageNewspage managenewspage;
	HomePage homepage;

	@Test(description="Enter News Informations in ManageNewsPage",retryAnalyzer=retry.Retry.class)
	public void manageNewsmethod() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clickSigninButton();
		String news=ExcelUtility.getStringData(1, 0,"managenewspage");
		//ManageNewspage managenewspage=new ManageNewspage(driver);
		managenewspage=homepage.moreInfolink();
    	managenewspage.newsLink().newstext(news).savebutton();
//		managenewspage.newstext(news);
//		managenewspage.savebutton();	
		boolean ismanagenewsdispvar=managenewspage.isAlertMsgDisplayed();
		Assert.assertTrue(ismanagenewsdispvar,Constants.NEWSUPDATEERROR);
		
		
	}
}
