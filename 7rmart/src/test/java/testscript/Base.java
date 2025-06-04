package testscript;

import java.io.FileInputStream;
import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.IOException;
import java.time.Duration;
//import java.util.Properties;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;
//import constant.Constants;
//import utilities.ScreenshotUtility;
import utilities.WaitUtility;



public class Base {
	public WebDriver driver;
	public ScreenshotUtility scrshot;
	public FileInputStream fs;
	public Properties pr;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser)throws Exception//value goes here
	{
		try
		{
			pr=new Properties();//for maintain and flexible
			fs=new FileInputStream(Constants.CONFIGFILE);
			pr.load(fs);
		}
		catch(Exception e)
		{
			System.out.println("Invalid");
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else
		{
			throw new Exception("Invalid");
		}
		driver.get(pr.getProperty("url"));//Already in config.properties
		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));//from wait utility
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun=true)
	public void quitAndClose(ITestResult iTestResult) throws IOException
	{
		if(iTestResult.getStatus()==ITestResult.FAILURE)
		{
			scrshot=new ScreenshotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
			
		}
		//driver.quit();
	}

}
