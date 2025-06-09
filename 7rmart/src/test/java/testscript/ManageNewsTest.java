package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewspage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	ManageNewspage managenewspage;
	HomePage homepage;

	@Test(description = "Enter News Informations in ManageNewsPage", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToEnterNewsInManageNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepage = loginpage.clickSigninButton();
		String news = ExcelUtility.getStringData(1, 0, "managenewspage");
		managenewspage = homepage.moreInfolink();
		managenewspage.click_On_NewButton_in_list_newspage().enter_News_in_Newstext_Field(news).click_On_Savebutton();
		boolean ismanagenewsdispvar = managenewspage.isAlertMsgDisplayed();
		Assert.assertTrue(ismanagenewsdispvar, Constants.NEWSUPDATEERROR);

	}
}
