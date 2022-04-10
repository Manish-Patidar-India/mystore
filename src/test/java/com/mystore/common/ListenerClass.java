package com.mystore.common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.utility.Screenshot;

public class ListenerClass extends ExtentManager implements ITestListener {

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignAuthor("Manish Patidar");

	}

	public void onTestSuccess(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, result.getName() + " is Passed");
		}

	}

	public void onTestFailure(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " is Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " is Failed", ExtentColor.RED));

			String imgpth = Screenshot.getScreenshot(result.getName());

			test.fail("Screenshot is Attached: ", MediaEntityBuilder.createScreenCaptureFromPath(imgpth).build());

		}

	}

	public void onTestSkipped(ITestResult result) {

		if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, result.getName() + " is Skipped");
		}

	}

	public void onFinish(ITestContext context) {

	}

}
