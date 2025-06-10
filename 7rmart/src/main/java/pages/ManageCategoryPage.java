package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	PageUtility pageutility = new PageUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * @FindBy(xpath =
	 * "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']"
	 * ) WebElement ManageCategoryMoreInfo;
	 */
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButtoninListCategories;
	@FindBy(xpath = "//input[@id='category']")
	WebElement CategoryinAddCategory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement SelectGroupsselectable;
	@FindBy(xpath = "//li[@id='134-selection']")
	WebElement selection;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//input[@value='yes' and @name='top_menu']")
	WebElement RadioShowOnTopMenuYes;
	@FindBy(xpath = "//input[@value='no' and @name='top_menu']")
	WebElement RadioShowOnTopMenuNo;
	@FindBy(xpath = "//input[@value='yes' and @name='show_home']")
	WebElement RadioShowOnLeftMenuYes;
	@FindBy(xpath = "//input[@value='no' and @name='show_home']")
	WebElement RadioShowOnLetMenuNo;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement SuccessfullySaveGreenAlertForSave;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=2405&page_ad=1' and @class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	// @FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	// public List<WebElement> DeleteButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement DeletesuccessGreenAlert;

	/*
	 * public ManageCategoryPage clickOnManageCategoryMoreInfo() {
	 * ManageCategoryMoreInfo.click(); return this; }
	 */

	public ManageCategoryPage clickOnNewButtoninlist_category() {
		NewButtoninListCategories.click();
		return this;
	}

	public ManageCategoryPage enterCategoryinCategoryaddPage(String category) {
		CategoryinAddCategory.sendKeys(category);
		return this;

	}

	public ManageCategoryPage clickOnSelectablefromSelectGroups() {
		SelectGroupsselectable.click();
		return this;
	}

	public ManageCategoryPage clickOnSelectedGroups() {
		selection.click();
		return this;

	}

	public ManageCategoryPage clickOnChooseFileandChooseFile() throws AWTException {

		fileuploadutility.fileUploadUsingSendKeys(chooseFile, Constants.FANCYITEMSSTATIONARY);
		return this;
		// chooseFile.sendKeys("C:\\Users\\user\\Desktop\\photos\\CategoriesFoeProject\\Fooditems.jpg");
	}

	public ManageCategoryPage chooseanOptionFromTheRadioButtonForShowOnTopMenu(String value) {

		WaitUtility waitutility = new WaitUtility();
		waitutility.explicitwaitForElementToBeVisible(driver, RadioShowOnTopMenuYes);
		pageutility.scrollByScrollHeight(driver);

		if ("yes".equalsIgnoreCase(value)) {

			pageutility.javaScriptClick(RadioShowOnTopMenuYes, driver);
		} else {

			pageutility.javaScriptClick(RadioShowOnTopMenuNo, driver);
		}
		return this;
	}

	public ManageCategoryPage chooseanOptionFromTheRadioButtonForShowOnLeftMenu(String value) {

		if ("no".equalsIgnoreCase(value)) {
			pageutility.javaScriptClick(RadioShowOnLetMenuNo, driver);
		} else {
			pageutility.javaScriptClick(RadioShowOnLeftMenuYes, driver);
		}
		return this;

	}

	public ManageCategoryPage clickOnSaveButton_in_ManageCategory() {

		pageutility.javaScriptClick(saveButton, driver);
		return this;
	}

	public boolean isSuccessfullGreenAlertDisplayedForSave() {
		return SuccessfullySaveGreenAlertForSave.isDisplayed();
	}

	/*
	 * public void ClickDeleteButton(int index) { DeleteButton.get(index).click(); }
	 */
	public void clickDeleteButton_in_ManageCategoryPage() {
		deleteButton.click();

		driver.switchTo().alert().accept();

	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public boolean isSuccessfullGreenAlertForDeleteisDisplayed() {

		return DeletesuccessGreenAlert.isDisplayed();
	}
}
