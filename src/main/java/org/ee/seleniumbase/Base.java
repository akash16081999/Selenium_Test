package org.ee.seleniumbase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.ExtentRepoterDemo;

public class Base extends SeleniumBase {

	static String URL = "https://test-manage.eateasy.ae/";
	public ExtentRepoterDemo demo;
	
	@BeforeSuite
	public void createReportGeneration() {
		ExtentRepoterDemo.getInstanceReporter();

	}
	

	@BeforeMethod
	public void startWeb() {

		setUp(Browsers.CHROME,URL);

	}

	@AfterMethod
	public void stopWeb() {
		quite();

	}
	
	@AfterSuite
	private void flushReport() {

     demo.

	}

}
