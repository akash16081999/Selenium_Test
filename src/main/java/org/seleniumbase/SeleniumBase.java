package org.seleniumbase;

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
	
	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	private void setDriver(WebDriver driver) {
		tdriver.set(driver);

	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return tdriver.get();
	}


	@Override
	public void setUp(String url) {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
		driver.get(url);
		setWait(10);

	}

	/*
	 * public WebDriver getDriver() { return driver; }
	 */

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
		setDriver(driver);

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
		getDriver().get(url);

	}

	@Override
	public void close() {

		getDriver().close();
	}

	@Override
	public void quite() {
		getDriver().quit();
	}

	@Override
	public WebElement element(Locators findType, String elemValue) {

		switch (findType) {
		case id:
			return getDriver().findElement(By.id(elemValue));

		case name:

			return getDriver().findElement(By.name(elemValue));

		case classname:
			return getDriver().findElement(By.className(elemValue));

		case xpath:
			return getDriver().findElement(By.xpath(elemValue));

		case linktext:
			return getDriver().findElement(By.linkText(elemValue));

		case partiallinktext:
			return driver.findElement(By.partialLinkText(elemValue));

		case cssselector:
			return getDriver().findElement(By.cssSelector(elemValue));

		default:
			throw new IllegalArgumentException("Unexpected value: " + findType);

		}

	}

	@Override
	public void url(String urlLink) {
		getDriver().get(urlLink);
	}

	@Override
	public Alert switchToAlert() {

		Alert alert = getDriver().switchTo().alert();
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

		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));

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
		return getDriver().switchTo().frame(framename);

	}

	@Override
	public WebDriver switchToFrameByElement(WebElement ele) {
		return getDriver().switchTo().frame(ele);

	}

	@Override
	public WebDriver switchToFrameByIndex(int index) {
		return driver.switchTo().frame(index);

	}

}
