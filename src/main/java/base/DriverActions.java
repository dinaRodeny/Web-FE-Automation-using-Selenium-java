package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Attachment;
import pages.TestBase;
import utils.MyLogger;

public class DriverActions extends TestBase {
	private WebDriver driver;
	WebDriverWait wait;

	public DriverActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// open url using navigate to track history
		public WebDriver ReturnDriver() {
			return driver;
		}
		
	// ************************************URLNavigation**********************************************
	// open url using navigate to track history
	public void openURL_History(String URL) {
		MyLogger.info("navigate to : " + URL);
		driver.navigate().to(URL);
	}

	// open url using get() and not care about history
	public void openURL(String URL) {
		MyLogger.info("Open URL : " + URL);
		driver.get(URL);
	}

	// refresh page
	public void reloadPage() {
		MyLogger.info("Refresh Page");
		driver.navigate().refresh();
	}

	// Keyboard simulation
	public void keyboardPress(Keys key) {
		Actions action = new Actions(driver);
		MyLogger.info("Enter Key : " + key.toString());
		action.sendKeys(key).perform();
	}

	// Get title from page
	public String TitleGet() {
		String result = driver.getTitle();
		MyLogger.info("Get Title String : " + result);
		return result;
	}

	// ***********************************Buttons & CheckBoxes*****************************************
	// click on button
	public void clickOn(By element) {
		MyLogger.info("Wait Element to be Visible and Clickable");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		MyLogger.info("Click on button or link Element");
		driver.findElement(element).click();
	}

	// hover on button
	public void hoverOn(By element) {
		MyLogger.info("Wait Hoverer Element to be Visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions action = new Actions(driver);
		MyLogger.info("Hover on Element");
		action.moveToElement(driver.findElement(element)).perform();
	}

	// select checkbox
	public void SelectCheckbox(By element) {
		MyLogger.info("Check if element is not selected");
		if (!driver.findElement(element).isSelected())
		{
			MyLogger.info("element is not selected --> Select Element");
			driver.findElement(element).click();
		}
	}

	// deselect checkbox
	public void DeselectCheckbox(By element) {
		MyLogger.info("Check if element is selected");
		if (driver.findElement(element).isSelected())
		{
			MyLogger.info("element is selected --> Unselect Element");
			driver.findElement(element).click();
		}
			
	}

	// select checkbox
	public void ActionClick(By element) {
		MyLogger.info("Wait Element to be Visible and Clickable");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions act = new Actions(driver);
		MyLogger.info("Click on button or link Element using Actions");
		act.moveToElement(driver.findElement(element)).click().perform();
	}
	
	
	public void ScrollToBottomOfPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		MyLogger.info("Scroll To Bottom");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void ScrollToElement(By element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		MyLogger.info("Scroll To Element");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	}
	
	// ***********************************Buttons & CheckBoxes*****************************************
	public void AcceptAlerts()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		MyLogger.info("Click on the ‘OK’ button of the alert.");
		driver.switchTo().alert().accept();
	}
	
	public void DismissAlerts()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		MyLogger.info("Click on the ‘Cancel’ button of the alert.");
		driver.switchTo().alert().dismiss();
	}
	
	public String GetTextFromALert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		MyLogger.info("Capture the alert message.");
		return driver.switchTo().alert().getText();
	}
	
	public void SendTextToAlert(String txt)
	{
		wait.until(ExpectedConditions.alertIsPresent());
		MyLogger.info("Send some data to alert box");
		driver.switchTo().alert().sendKeys(txt);
	}
	// ****************************************DropBox************************************************
	// Select from dropBox
	public void selectByVisibleText(By element, String text) {
		MyLogger.info("Wait Element to be Visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		MyLogger.info("Select Element in dropdown by visible text : " + text);
		Select dropbox = new Select(driver.findElement(element));
		dropbox.selectByVisibleText(text);
	}

	public void selectByValue(By element, String value) {
		MyLogger.info("Wait Element to be Visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		MyLogger.info("Select Element in dropdown by Value : " + value);
		Select dropbox = new Select(driver.findElement(element));
		dropbox.selectByValue(value);
	}

	public void selectByIndex(By element, int index) {
		MyLogger.info("Wait Element to be Visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		MyLogger.info("Select Element in dropdown by Index : " + index);
		Select dropbox = new Select(driver.findElement(element));
		dropbox.selectByIndex(index);
	}

	// ***************************************TextFields**********************************************
	// put text in field after clearing it
	public void textSet(By element, String text) {
		MyLogger.info("Wait Element to be Visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		MyLogger.info("Clear text in Field");
		driver.findElement(element).clear();
		MyLogger.info("Put text in Field");
		driver.findElement(element).sendKeys(text);
	}

	// Get text from element
	public String textGet(By element) {
		MyLogger.info("Wait Element to be Visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		String result = driver.findElement(element).getText();
		MyLogger.info("Text Returned from element is : " + result);
		return result;
	}

	public int countAllElements(By element)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		MyLogger.info("Count elements");
		return driver.findElements(element).size();
	}
	
	public String getTextOfElementIndex(By element,int index)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		MyLogger.info("get text of element with index" + index);
		return driver.findElements(element).get(index).getText();
	}
	// **************************************WindowClosure***************************************
	public void closeCurrentWindow() {
		MyLogger.info("close Current Window");
		driver.close();
	}

	public void closeAllWindows() {
		MyLogger.info("close All Windows");
		driver.quit();
	}

	// ******************************************Cookies*****************************************
	public void deleteAllCookies() {
		MyLogger.info("delete All Cookies");
		driver.manage().deleteAllCookies();
	}

	// ***************************************CheckElements**************************************
	public boolean isDisplayed(By element) {
		boolean flag;
		MyLogger.info("Check If Element Is displayed");
		if (driver.findElement(element).isDisplayed()) {
			flag = true;
			MyLogger.info("Element Is displayed");
		} else {
			flag = false;
			MyLogger.info("Element Is Not displayed");
		}
		return flag;
	}

	public boolean isNotExist(By element) {
		boolean flag;
		MyLogger.info("Check If Element Is NotExist");
		if (driver.findElements(element).isEmpty()) {
			flag = true;
			MyLogger.info("Element Is NotExist");
		} else {
			flag = false;
			MyLogger.info("Element Is Exist");
		}
		return flag;
	}

	public boolean checkElementType(By element, String type) {
		boolean flag = false;
		String elementtype = driver.findElement(element).getAttribute("type");
		MyLogger.info("Check If Element type "+ elementtype +" Is equal to given type " + type);
		if (elementtype.equals(type)) {
			MyLogger.info("Element types are equal");
			flag = true;
		} else {
			MyLogger.info("Element types aren't equal");
			flag = false;
		}
		return flag;
	}

	// ************************************Element Attributes***************************************
	public String getCSSValue(By element, String parameter) {
		MyLogger.info("Wait Element to be Visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		String result = driver.findElement(element).getCssValue(parameter);
		MyLogger.info("Get Element CSS value for parameter " + parameter + " -> " + result);
		return result;
	}

	// *********************************Wait****************************************
	public void Wait_Implicit(int timer)
	{
		MyLogger.info("Wait implicitly for " + timer + " seconds ");
		new WebDriverWait(driver, Duration.ofSeconds(timer));
		MyLogger.info("Wait Done");
	}
	
	public void Wait_Explicit_Until_Visibility(By element)
	{
		MyLogger.info("Wait Explicitly Until element is visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		MyLogger.info("Wait Done");
	}
	public void Wait_Explicit_Until_NonVisibility(By element)
	{
		MyLogger.info("Wait Explicitly Until element is invisible");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));	
		MyLogger.info("Wait Done");
	}
	// ************************************Screenshots***************************************
	@Attachment(value = "Page screenshot" , type = "image/png")
	public byte[] takeScreenShot(String TestMethodName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		MyLogger.info("Save screen shot");
		File source = ts.getScreenshotAs(OutputType.FILE);
		String time = java.time.LocalTime.now().toString().replace(":", "-").substring(0, 5);
		String date = java.time.LocalDate.now().toString();
		MyLogger.info("Save screen shot name with time -> "+ time+" and date -> " + date);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + date + "_" + time + "\\"
				+ TestMethodName + "_" + ThreadLocalRandom.current().nextInt() + ".png";

		try {
			MyLogger.info("copy screen shot to destination place : " + destination);
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ts.getScreenshotAs(OutputType.BYTES);
	}
}
