package com.mystore.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mystore.common.Base;

public class Screenshot extends Base {

	public static String getScreenshot(String testName) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File(System.getProperty("user.dir") + "/screenshots/" + testName + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
		return path;
	}

}
