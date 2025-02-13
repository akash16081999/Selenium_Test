package org.seleniumbase;

import java.util.Properties;

import org.assertions.AssertionManager;
import org.pageObjectManager.PageManager;
import org.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

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
	public void startWeb() {

		setUp(Browsers.CHROME, PropertiesReader.getInstancePropertyReader().getBaseUrl());

		pagemanager = new PageManager(driver, wait);
		assertmanager = new AssertionManager(driver);

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
