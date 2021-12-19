package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("-----------------------Finish-----------------------------");
	}
	
	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("-----------------------Start------------------------------");
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("");
	}
	
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("TestFailures: ");
	}
	
	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("TestSkippeds: ");
	}
	
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("----------------Testing----------------");
	}
	
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test case is PASS");
	}
}
