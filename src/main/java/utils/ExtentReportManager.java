package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager implements ITestListener {

	ExtentSparkReporter sparkTemplate;
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		sparkTemplate = new ExtentSparkReporter("./TestReports.html");
		sparkTemplate.config().setDocumentTitle("Automation Test Report");
		reports = new ExtentReports();
		reports.attachReporter(sparkTemplate);

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Case Passed : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case Failed : " + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();

	}

}
