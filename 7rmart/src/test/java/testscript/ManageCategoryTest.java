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

//import utilities.FileUploadUtility;
//import utilities.PageUtility;

public class ManageCategoryTest extends Base {
	HomePage homepage;
	ManageCategoryPage managecategorypage;

	@Test(description="verify the Items entered in ManageCategory Page should be entered successfully",retryAnalyzer = retry.Retry.class)
	public void verifyItemsEnteredInManageCategoryPageShouldBeEnteredSuccessfully() throws IOException, AWTException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		homepage = loginpage.clickSigninButton();
		String topradiobtn = ExcelUtility.getStringData(1, 2, "managecategory");
		String leftradiobtn = ExcelUtility.getStringData(2, 3, "managecategory");
		FakerUtility fakerutility = new FakerUtility();
		String category = fakerutility.creatARandomFirstName();
		// ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage = homepage.clickOnManageCategoryMoreInfo();
		managecategorypage.clickOnNewButtoninlist_category().enterCategoryinCategoryaddPage(leftradiobtn)
				.clickOnSelectablefromSelectGroups().clickOnChooseFileandChooseFile()
				.chooseanOptionFromTheRadioButtonForShowOnTopMenu(topradiobtn)
				.chooseanOptionFromTheRadioButtonForShowOnLeftMenu(leftradiobtn).enterCategoryinCategoryaddPage(category).clickOnSaveButton();
//		FakerUtility fakerutility = new FakerUtility();
//		String category = fakerutility.creatARandomFirstName();
		// String category=ExcelUtility.getStringData(5, 0, "managecategory");
		// managecategorypage.enterCategoryinCategoryaddPage(category);
		// managecategorypage.clickOnSelectablefromSelectGroups();
		// managecategorypage.clickOnSelectedGroups();

		// managecategorypage.clickOnChooseFileandChooseFile();

		// managecategorypage.chooseanOptionFromTheRadioButtonForShowOnTopMenu(topradiobtn);
		// managecategorypage.chooseanOptionFromTheRadioButtonForShowOnLeftMenu(leftradiobtn);
		// String uploadfile=ExcelUtility.getStringData(3, 0, "fileupload");

		// managecategorypage.fileUploadUsingRobotClass();
		// managecategorypage.clickOnSaveButton();
		boolean suuceesfullGreenalertvar = managecategorypage.isSuccessfullGreenAlertDisplayedForSave();
		Assert.assertTrue(suuceesfullGreenalertvar,Constants.ADDCATEGORYERROR);

	}

	@Test(description="Verify the selected Item Delete from the ListCategories",retryAnalyzer = retry.Retry.class)
	public void verifyitemselectedForDeletesuccessfullyDeleteFromListCategories() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clickSigninButton();
		// int indextoDelete = 1;
		//ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage=homepage.clickOnManageCategoryMoreInfo();
		managecategorypage.clickDeleteButton();
		// String itemfordelete=ExcelUtility.getStringData(4, 0, "managecategory");
		// managecategorypage.clickOnDeleteButtoninActionandDeleteandItemfromListCategories();
		// managecategorypage.ClickDeleteButton(indextoDelete);// to delete based in
		// index
		// managecategorypage.confirmAlert();
		boolean deletesuccessfulvar = managecategorypage.isSuccessfullGreenAlertForDeleteisDisplayed();
		Assert.assertTrue(deletesuccessfulvar,Constants.DELETECATEGORYERROR);
	}

}
