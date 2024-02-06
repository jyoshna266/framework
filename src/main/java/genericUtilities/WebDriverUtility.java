package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	WebDriver driver;
	
	/**
	 * this class contains all reasuble all reasuable method to perform driver realeted operations 
	 * @author 91630
	 */
	public WebDriver launchBrowserAndMaximize(String browser) {
		switch(browser) {
		case"chrome":
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;	
		default:
				System.out.println("Invalid Browser Info");
		}
		driver.manage().window().maximize();
		return driver;
		}
	public void navigateToApp(String url) {
		driver.get(url);
	}
	/**
	 * *this method is an implicity wait statement which waits until element is found 
	 * @param time
	 */
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		/**
		 * this method waits until element is displeyed on the web page 
		 * @paramp
		 */
	}
	public WebElement explicitWait(long time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
/**
 * this method waits until element on the web page is enabled to recieve to review click 
 * @param element
 * @param time
 * @return
 */
	public WebElement explicitWait( WebElement element,long time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method is used to wait until title appears on the web page 
	 * @param time
	 * @param title
	 * @return
	 */
	public Boolean explicitWait(long time,String title) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * this method is used to mouse hover on an element 
	 * @param element
	 */
	public void mouseHoverToElement(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * this method is used to double click on an element 
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * this method is used to perform right click on an element 
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
		/**
		 * this method is used to drag and drop an element to traget location 
		 * @param element
		 * @paramtaget
		 */
	}
	public void dragAndDropAnElement(WebElement element,WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}
	/**
	 * this method is used to swicth to frame based on specific index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		/**
		 * this method is used to swicth to frame baased on specific id or name attribute
		 * idorattribute
		 */
	}
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
		/**
		 * this method is used to swicth back to the default web page 
		 */
	}
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * this method is used to select an element from the drag and drop down bases on elemnt index 
	 * @param element 
	 * @param value 
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
		
	}
	public void selectFromDropdown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}	
	public void selectFromDropdown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * 
	 * @param text
	 * @param element
	 */
	public void selectFromDropdown(String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);;
	}	
	public List<WebElement> getDropdownList(WebElement element){
		Select select=new Select(element);
		return select.getOptions();
	}

public void captureScreenshot(WebDriver driver, JavaUtility jutil,String className) {
	TakeScreenshort ts = (TakescreenShrot)driver;
	File src = ts.get ScreenshotAs(outputType.FILE);
	File dest = new File("./screenshot"
			+className+"_"+jutil.getCurrentTime()+".png");
	try {
		File.copyFile(src,dest);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
public void scrollTillElement(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeAsyncScript("arguments[0]scrollIntoView(true)",element);
}
public void handleAlert(String status) {
	Alert al = driver.switchTo().alert();
	if(status.equalsIgnoreCase("ok"))
		al.accept();
	else
		al.dismiss();
}
public void switchTochildBrowser() {
	Set<String>windowIDs = driver.getWindowHandle();
	for(String window : windowIDs) {
		
		driver.switchTo().window(window);
	}
	public void closeBrowser() {
		driver.close();
	}
	public void quitAllWindows() {
		driver.quit();
	}
}
	}
		
	
	}
}
