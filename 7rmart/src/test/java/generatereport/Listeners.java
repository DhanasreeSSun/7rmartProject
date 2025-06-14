package generatereport;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtendReportUtility;

public class Listeners implements ITestListener {// ITestListener is interface
	ExtentTest test;

	ExtentReports extent = ExtendReportUtility.createExtentReports();// Extendreport call here
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();// for not overlap while multipletestcase

	public void onTestStart(ITestResult result) {// check console and after other actions are performed

		ITestListener.super.onTestStart(result);// report added to -fetch testcase name and add to report
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {// liste console,if passed report is testpassed

		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {// if status is fail ,add fail to report and reason for failure is
													// added to the report

		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);// graphical representation
	}

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {// important method

		ITestListener.super.onFinish(context);
		extent.flush();// importance is report is generated only after call the flush()
	}
}
