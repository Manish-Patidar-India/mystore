package com.mystore.common;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;

	public static void setExtent() throws IOException {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./Reports/MyReport.html");
		extent.attachReporter(spark);
		spark.loadXMLConfig(System.getProperty("user.dir") + "/src\\test\\resources\\extent-config.xml");

		extent.setSystemInfo("HostName", "My Host");
		extent.setSystemInfo("ProjectName", "My Store");
		extent.setSystemInfo("Tester", "Manish Patidar");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");

	}

	public static void EndReport() {

		extent.flush();
	}

}
