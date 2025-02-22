package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoterDemo {
	ExtentSparkReporter sparkTemplate;
	ExtentReports reports;
	ExtentTest test;

	public ExtentRepoterDemo() {
		sparkTemplate = new ExtentSparkReporter("./TestReports.html");

		// created the acutal report.
		reports = new ExtentReports();
		reports.attachReporter(sparkTemplate);
	}

	public static ExtentRepoterDemo getInstanceReporter() {

		return new ExtentRepoterDemo();

	}

	public void saveReport() {
		reports.flush();
	}

	public void createTest(String TestDiscription) {
		test = reports.createTest(TestDiscription);

		/*
		 * switch (status.toLowerCase()) {
		 * 
		 * case "pass": test.pass("static data");
		 * 
		 * break;
		 * 
		 * case "fail": test.fail("static data"); break; default: throw new
		 * IllegalArgumentException("Unexpected value: " + status);
		 * 
		 * }
		 */

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * // the below line code will generate a tempplate for the actual report will
	 * be // created. ExtentSparkReporter sparkTemplate = new
	 * ExtentSparkReporter("./TestReports.html");
	 * 
	 * // created the acutal report. ExtentReports reports = new ExtentReports();
	 * 
	 * ExtentTest test = reports.createTest("Login with Valid data");
	 * test.pass("username entered"); test.pass("password entered");
	 * 
	 * ExtentTest test2 = reports.createTest("Login with InValid data");
	 * test2.fail("username entered Invalid"); test2.pass("password entered");
	 * 
	 * // this will create the reports at the end of all test execution completed.
	 * reports.flush();
	 * 
	 * }
	 */
}
