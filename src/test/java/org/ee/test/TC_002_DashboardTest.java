package org.ee.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumbase.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_002_DashboardTest {

	//WebDriver driver = null;


	@Test
	public void testMethodOne() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl() + " " + Thread.currentThread().getId());

		driver.get(
				"https://github.com/akash16081999/Selenium_Test/blob/master/src/main/java/org/pageObjectManager/PageManager.java");

	}

	@Test
	public void testMethodTwo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl() + " " + Thread.currentThread().getId());
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/account");

	}

}
