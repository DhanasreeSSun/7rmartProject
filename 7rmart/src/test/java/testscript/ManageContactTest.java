package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	ManageContactPage managecontactpage;
	HomePage homepage;

	@Test(description = "verify contact details update in ContactUsPage successfully", retryAnalyzer = retry.Retry.class)
	public void verifyUserisAbletoUpdateContactDetailsSuccessfullyinContactUsPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		homepage = loginpage.clickSigninButton();
		String phone = ExcelUtility.getLongData(1, 0, "contactus");
		String email = ExcelUtility.getStringData(1, 1, "contactus");
		String address = ExcelUtility.getStringData(1, 2, "contactus");
		String deliverytime = ExcelUtility.getIntegerData(1, 3, "contactus");
		String deliverychargelimit = ExcelUtility.getIntegerData(1, 4, "contactus");

		managecontactpage = homepage.click_onManageContact_MoreInfoButtonInHomePage();
		managecontactpage.clickOnActionButtonInlist_contact().enterPhoneNumberinPhoneTextField(phone)
				.enterEmailinEmailTextField(email).enterAddressInAddressTextField(address)
				.enterDeliveryTime_in_DeliveryTimeTextField(deliverytime)
				.enterDeliveryChargeLimitinDeliveryChargeTextField(deliverychargelimit).clickOnUpdateButton();
		boolean successfulupdatevar = managecontactpage.isGreenAlertDisplayedForSuccessfulUpdate();
		Assert.assertTrue(successfulupdatevar, Constants.UPDATECONTACTERROR);

	}

	@Test(description = "verify the update button is visible in ContactUsPage", retryAnalyzer = retry.Retry.class)
	public void verifyUpdateButtoninContactUsPageDisplayedSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepage = loginpage.clickSigninButton();
		managecontactpage = homepage.click_onManageContact_MoreInfoButtonInHomePage();
		managecontactpage.clickOnActionButtonInlist_contact();
		boolean updatebtnvisiblityvar = managecontactpage.isUpdateButtonVisibleInContactUsPage();
		Assert.assertTrue(updatebtnvisiblityvar, Constants.UPDATEBUTTONDISPLAYERROR);
	}

}
