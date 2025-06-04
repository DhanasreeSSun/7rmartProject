package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException { //call in baseclass-aftermethod
 		TakesScreenshot scrShot = (TakesScreenshot) driver; //reference variable of TakesScrn,
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //create as a file call getScreenshotAs method to create image file
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); 
 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); 
 		if (!f1.exists()) { 
 			f1.mkdirs(); 
 		}
String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp+ ".png"; 
 		File finalDestination = new File(destination); 
 		FileHandler.copy(screenShot, finalDestination); //copy a file from one location to other location//FileHandler is class
 	}

}
//if test case fail for capture the screenshot of failed testcase
//interface used to take screenshot=TakesScreenshot
//failed in different time(17)so give timestamp
//new Date()=to get current date and convert to string so give format
//18-which folder screenshot is generaed,directory name is user.dir
//19=f1 is sirectory//20-mkdirs-makedirectory if the directory not exists
//22-destination -outputCreenShot-foldername//timeStamp-to get currehnt date//.png-image extension
//23=File finalDestination-put destination in file destination
//24=copy to final destination from temporay variable screenShot