package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//
public class MyListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Sucess function is invoked");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure funtion is invoked");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on skipp function invoked");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish function is invoked");
		
	}
	
	

}
