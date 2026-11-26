package utilities;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	private static final ThreadLocal<ExtentTest> EXTENT_TEST = new ThreadLocal<>();

	public static ExtentTest getTest() {
		return EXTENT_TEST.get();
	}

	public static void setTest(ExtentTest test) {
		EXTENT_TEST.set(test);
	}

	public static void removeTest() {
		EXTENT_TEST.remove();
	}
}
