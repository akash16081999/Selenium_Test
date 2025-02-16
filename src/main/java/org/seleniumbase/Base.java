package org.seleniumbase;

import java.util.Properties;

import org.assertions.AssertionManager;
import org.openqa.selenium.WebDriver;
import org.pageObjectManager.PageManager;
import org.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import utils.ExtentRepoterDemo;
import utils.PropertiesReader;

@Listeners(utils.ExtentReportManager.class) // use this annotation if we want to trigger the
//                                               listener class without executing the xml file manually everytime.
public class Base extends SeleniumBase {

	protected PageManager pagemanager;

	protected AssertionManager assertmanager;

	// public ExtentRepoterDemo demo;

	/*
	 * @BeforeClass public void createReportGeneration() { demo =
	 * ExtentRepoterDemo.getInstanceReporter();
	 * 
	 * }
	 */

	@BeforeMethod
	@Parameters("browser_name")
	public void startWeb(String BrowserName) {

		setUp(BrowserName);

		pagemanager = new PageManager(getDriver(), wait);
		assertmanager = new AssertionManager(getDriver());

		System.out.println(driver.toString());

		// demo.createTest(new Object() {}.getClass().getEnclosingMethod().getName());

	}

	@AfterMethod
	public void stopWeb() {
		quite();
	}

	/*
	 * @AfterClass public void flushReport() {
	 * 
	 * demo.saveReport();
	 * 
	 * }
	 */

}
