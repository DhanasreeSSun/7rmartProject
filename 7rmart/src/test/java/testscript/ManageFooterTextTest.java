package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	HomePage homepage;
	ManageFooterTextPage managefootertextpage;

	@Test(description = "verify FooterText Information sussessfully Update in FooterText page", retryAnalyzer = retry.Retry.class)
	public void verify_User_Is_Able_to_Update_ManageFooterTextPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepage = loginpage.clickSigninButton();
		String address = ExcelUtility.getStringData(1, 0, "managefootertext");
		String email = ExcelUtility.getStringData(1, 1, "managefootertext");
		String phone = ExcelUtility.getLongData(1, 2, "managefootertext");

		managefootertextpage = homepage.clickOn_ManageFooterText_MoreInfoButtonin_Homepage();
		managefootertextpage.clickOn_ActionButtonin_list_footertext()
				.enterAddress_in_textboxforAddressof_editpage(address).enterEmail_in_textboxforEmailof_editpage(email)
				.enterPhoneNumberinPhoneFieldof_editpage(phone).clickOnUpdateButtonof_editpage();
		boolean greenalertvar = managefootertextpage.isAlertDisplayedForFooterTextUpdatedSuccessfully();
		Assert.assertTrue(greenalertvar, Constants.UPDATEFOOTERTEXTERROR);

	}

	@Test(description = "Verify UpdateButton is displayed in ManageFooterText Page", retryAnalyzer = retry.Retry.class)
	public void verifyUpdateButtonDisplayedSuccessfully_in_ManageFooterPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		homepage = loginpage.clickSigninButton();
		managefootertextpage = homepage.clickOn_ManageFooterText_MoreInfoButtonin_Homepage();
		managefootertextpage.clickOn_ActionButtonin_list_footertext();
		boolean updatebtnvisiblevar = managefootertextpage.isUpdateButtonDisplayedSuccessfully();
		Assert.assertTrue(updatebtnvisiblevar, Constants.UPDATEBUTTONNOTDISPLAYED);
	}

}
