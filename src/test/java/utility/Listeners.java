package utility;



import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mindtree.reusable.BaseTest;



public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	String screenshotPath = null;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, "TestCase Execution Started");
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "TestCase Execution Started");
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}
	public void onTestFailure(ITestResult result) {

		try {
			screenshotPath = getscreenshotpath(result.getName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		test.fail(result.getClass().getName() + " test failed",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		test.log(Status.FAIL, "UnSuccessful");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			screenshotPath = getscreenshotpath(result.getName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		test.log(Status.PASS, "Successful");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getClass().getName() + " test failed",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		test.log(Status.SKIP, "UnSuccessful");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getClass().getName() + " test failed",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		test.log(Status.FAIL, "UnSuccessful");
	}
}