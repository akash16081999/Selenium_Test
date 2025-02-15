package org.ee.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumbase.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.ReadExcel;

public class TC_002_DashboardTest {

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal();

	public void setDriver(WebDriver driver) {
		tdriver.set(driver);
	}

	public WebDriver getDriver() {
		return tdriver.get();
	}

	@BeforeMethod
	private void startWeb() {

		driver = new ChromeDriver();

		setDriver(driver);

		getDriver().manage().window().maximize();

	}

	WebDriver driver = null;

	@Test()
	public void testMethodOne() {

		System.out.println(getDriver().getCurrentUrl() + " " + Thread.currentThread().getId());

		getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/account");

		

		System.out.println(tdriver.hashCode() + "thread copy "+"fist method");

	}

	@Test()
	public void testMethodTwo() {
		
		System.out.println(tdriver.hashCode() + "thread copy "+"2nd method");
		// tdriver.get().manage().window().maximize();
		System.out.println(getDriver().getCurrentUrl() + " " + Thread.currentThread().getId());
		getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/account");

	}

}
