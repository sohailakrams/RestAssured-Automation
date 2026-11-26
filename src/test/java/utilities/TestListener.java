package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {
	ExtentReports extent = ExtentManager.getInstance();

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Execution Started");
	}

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTestManager.setTest(extent.createTest(result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
		ExtentTestManager.removeTest();

		System.out.println("Execution Complete");
	}
}
