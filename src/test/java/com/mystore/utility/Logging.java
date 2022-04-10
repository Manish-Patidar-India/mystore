package com.mystore.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {

	public static Logger logger = LogManager.getLogger(Logging.class.getName());

	public void startTestCase(String testcaseName) {

		logger.info("=========================================" + testcaseName
				+ " Test Started================================");
	}

	public void endTestCase(String testcaseName) {

		logger.info("=========================================" + testcaseName
				+ " Test Ended================================");
	}

	public static void logInfo(String message) {

		logger.info(message);
	}

	public static void logError(String message) {

		logger.error(message);
	}

	public static void logWarn(String message) {

		logger.warn(message);
	}

	public static void debug(String message) {

		logger.debug(message);
	}

}
