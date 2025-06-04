package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class ManageNewspage {
	public WebDriver driver;
	
	public ManageNewspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);//for initialize webelements
	}
	@FindBy(xpath="(//p[text()='Manage News']//parent::div)")WebElement managenews;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement ManageNewsmoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement news;
	@FindBy(xpath="//textarea[@id='news']")WebElement enternews;
	@FindBy(xpath="//button[@type='submit']")WebElement savebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	
//	public void moreInfolink()
//	{
//		 ManageNewsmoreinfo.click();	
//	}
	public ManageNewspage newsLink()
	{
		news.click();
		return this;
	}
	public ManageNewspage newstext(String enterednews)
	{
		enternews.sendKeys(enterednews);
		return this;
	}
	public ManageNewspage savebutton()
	{
		savebtn.click();
		return this;
	}
	public boolean isManageNewsDisplayed()
	{
		return managenews.isDisplayed();
	}
	public boolean isAlertMsgDisplayed()
	{
		return alertmsg.isDisplayed();
	}

}
