package org.ee.seleniumbase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.ExtentRepoterDemo;

public class Base extends SeleniumBase {

	static String URL = "https://test-manage.eateasy.ae/";
	public ExtentRepoterDemo demo;

	@BeforeClass
	public void createReportGeneration() {
		demo = ExtentRepoterDemo.getInstanceReporter();

	}

	@BeforeMethod
	public void startWeb() {

		setUp(Browsers.CHROME, URL);

	}

	@AfterMethod
	public void stopWeb() {
		quite();

	}

	@AfterClass
	public void flushReport() {

		demo.saveReport();

	}

}
