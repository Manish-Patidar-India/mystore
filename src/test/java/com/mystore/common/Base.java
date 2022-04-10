package com.mystore.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static String browsername;

	@BeforeSuite
	public void loadConfigFile() throws IOException {

		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties");

		prop = new Properties();

		prop.load(f);

		ExtentManager.setExtent();

	}

	@BeforeMethod
	public static void launchApp() {

		browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@AfterSuite
	public void endExtentreport() {

		ExtentManager.EndReport();
	}

}
