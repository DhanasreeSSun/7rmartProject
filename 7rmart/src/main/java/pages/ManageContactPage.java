package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ManageContactPage {
	public WebDriver driver;
	
	PageUtility pageutility=new PageUtility();
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
//	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
//	WebElement ManageContactMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement ActioninContactus;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement Phone;
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	@FindBy(xpath = "//textarea[@id='content' and @name='address']")
	WebElement Address;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement DeliveryTime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement DeliveryChargeLimit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement Update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement GreenAlertContact;
//	public void clickOnManageContactMoreInfoButtonInHomePage()
//	{
//		
//		ManageContactMoreInfo.click();
//	}
	public ManageContactPage clickOnActionButtonInlist_contact()
	{
		
		ActioninContactus.click();
		return this;
	}
	public ManageContactPage enterPhoneNumberinPhoneTextField(String phone)
	{
		Phone.clear();
		Phone.sendKeys(phone);
		return this;
	}
	public ManageContactPage enterEmailinEmailTextField(String email)
	{
		Email.clear();
		Email.sendKeys(email);
		return this;
	}
	public ManageContactPage enterAddressInAddressTextField(String address)
	{
		Address.clear();
		Address.sendKeys(address);
		return this;
	}
	public ManageContactPage enterDeliveryTimeinDeliveryTimeTextField(String deliverytime)
	{
		DeliveryTime.clear();
		DeliveryTime.sendKeys(deliverytime);
		return this;
	}
	public ManageContactPage enterDeliveryChargeLimitinDeliveryChargeTextField(String deliverychargelimit)
	{
		DeliveryChargeLimit.clear();
		DeliveryChargeLimit.sendKeys(deliverychargelimit);
		return this;
	}
	public boolean isUpdateButtonVisibleInContactUsPage()
	{
		return Update.isDisplayed();
	}
	
	public ManageContactPage clickOnUpdateButton()
	{
		//Update.click();
		
		pageutility.javaScriptClick(Update, driver);
		return this;
	}
	public boolean isGreenAlertDisplayedForSuccessfulUpdate()
	{
		return GreenAlertContact.isDisplayed();
		
	}


}
