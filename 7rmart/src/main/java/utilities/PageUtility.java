package utilities;

//import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {// to help page class method create common
	public WebDriver driver;

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		;

	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		;

	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void dragAndDrop(WebElement drag, WebElement drop) {
		Actions action = new Actions(driver);

		action.dragAndDrop(drag, drop).build().perform();
	}

	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void contextClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void click(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
	}

	public void javaScriptSendKeys(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='data';", element);
	}

	public void javaScriptClick(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollByScrollHeight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	public void scrollByXY(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)", "");

	}
}
