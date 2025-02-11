package org.ee.seleniumbase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.ExpectedExceptionsHolder;

public class SeleniumBase implements ReusableComponents {

	public WebDriver driver;

	protected WebDriverWait wait;

	long maxWaitTime = 20;
	long timeouts = 10;

	@Override
	public void setUp(String url) {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
		driver.get(url);
		setWait(10);

	}

	@Override
	public void setUp(Browsers Browsername, String url) {
		setWait(10);
		switch (Browsername) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + Browsername);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
		driver.get(url);

	}

	@Override
	public void close() {

		driver.close();
	}

	@Override
	public void quite() {
		driver.quit();
	}

	@Override
	public WebElement element(Locators findType, String elemValue) {

		switch (findType) {
		case id:
			return driver.findElement(By.id(elemValue));

		case name:

			return driver.findElement(By.name(elemValue));

		case classname:
			return driver.findElement(By.className(elemValue));

		case xpath:
			return driver.findElement(By.xpath(elemValue));

		case linktext:
			return driver.findElement(By.linkText(elemValue));

		case partiallinktext:
			return driver.findElement(By.partialLinkText(elemValue));

		case cssselector:
			return driver.findElement(By.cssSelector(elemValue));

		default:
			throw new IllegalArgumentException("Unexpected value: " + findType);

		}

	}

	@Override
	public void url(String urlLink) {
		driver.get(urlLink);
	}

	@Override
	public Alert switchToAlert() {

		Alert alert = driver.switchTo().alert();
		return alert;

	}

	@Override
	public void click(WebElement elem) {

		elementToBeClickable(elem).click();

	}

	@Override
	public void sendkeys(WebElement elem, String Data) {

		visibilityOfElement(elem).sendKeys(Data);

		// elem.sendKeys(Data);

	}

	public void setWait(long seconds) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

	}

	public WebDriverWait getWait() {
		return wait;
	}

	@Override
	public WebDriver switchToWindow(int index) {

		Set<String> all_windows = driver.getWindowHandles();

		ArrayList<String> windows = new ArrayList<String>(all_windows);
		WebDriver window = driver.switchTo().window(windows.get(index));
		return window;

	}

	public WebElement visibilityOfElement(WebElement ele) {

		return wait.withMessage("element not visible").until(ExpectedConditions.visibilityOf(ele));

	}

	public WebElement elementToBeClickable(WebElement ele) {

		return wait.withMessage("element not clickable within the time")
				.until(ExpectedConditions.elementToBeClickable(ele));

	}

	@Override
	public WebDriver switchToFrameByString(String framename) {
		return driver.switchTo().frame(framename);

	}

	@Override
	public WebDriver switchToFrameByElement(WebElement ele) {
		return driver.switchTo().frame(ele);

	}

	@Override
	public WebDriver switchToFrameByIndex(int index) {
		return driver.switchTo().frame(index);

	}

}
