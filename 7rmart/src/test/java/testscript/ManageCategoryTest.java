package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base {
	HomePage homepage;
	ManageCategoryPage managecategorypage;

	@Test(description = "verify the Items entered in ManageCategory Page should be entered successfully", retryAnalyzer = retry.Retry.class)
	public void verifyItemsinManageCategoryPageShouldBeEnteredSuccessfully() throws IOException, AWTException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		homepage = loginpage.clickSigninButton();
		String topradiobtn = ExcelUtility.getStringData(1, 2, "managecategory");
		String leftradiobtn = ExcelUtility.getStringData(2, 3, "managecategory");
		FakerUtility fakerutility = new FakerUtility();
		String category = fakerutility.creatARandomFirstName();

		managecategorypage = homepage.clickOnManageCategoryMoreInfo();
		managecategorypage.clickOnNewButtoninlist_category().enterCategoryinCategoryaddPage(leftradiobtn)
				.clickOnSelectablefromSelectGroups().clickOnChooseFileandChooseFile()
				.chooseanOptionFromTheRadioButtonForShowOnTopMenu(topradiobtn)
				.chooseanOptionFromTheRadioButtonForShowOnLeftMenu(leftradiobtn)
				.enterCategoryinCategoryaddPage(category).clickOnSaveButton_in_ManageCategory();

		boolean suuceesfullGreenalertvar = managecategorypage.isSuccessfullGreenAlertDisplayedForSave();
		Assert.assertTrue(suuceesfullGreenalertvar, Constants.ADDCATEGORYERROR);

	}

	@Test(description = "Verify the selected Item Delete from the ListCategories", retryAnalyzer = retry.Retry.class)
	public void verify_User_is_able_to_Delete_itemselectedForDelete_successfully_from_ListCategories() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepage = loginpage.clickSigninButton();
		managecategorypage = homepage.clickOnManageCategoryMoreInfo();
		managecategorypage.clickDeleteButton_in_ManageCategoryPage();
		boolean deletesuccessfulvar = managecategorypage.isSuccessfullGreenAlertForDeleteisDisplayed();
		Assert.assertTrue(deletesuccessfulvar, Constants.DELETECATEGORYERROR);
	}

}
