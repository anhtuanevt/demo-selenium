package common;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class AbstractTest {

	protected WebDriver openBrowser(String browser, String url) {
		Browser br = new Browser();
		WebDriver driver = br.launch(browser, url);
		if (driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("firefox") || driver.toString().toLowerCase().contains("internetexplorer")) {
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.focus();");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public void closeBrowser(WebDriver driver) {
		try {
			driver.quit();
			System.gc();
			if (driver.toString().toLowerCase().contains("chrome")) {
				String cmd = "taskkill /IM chromedriver.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				String cmd = "taskkill /IM IEDriverServer.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected String getUniqueCharacters() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static char getRandomChar() {
		int rnd = (int) (Math.random() * 52); // or use Random or whatever
		char base = (rnd < 26) ? 'A' : 'a';
		return (char) (base + rnd % 26);
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(getRandomChar());
		}
		return sb.toString();
	}

	protected String getUniqueNumber() {
		Random rand = new Random();
		int number = rand.nextInt(90000000) + 1;
		String numberString = Integer.toString(number);
		return numberString;
	}

	protected String getUniqueFourNumbers() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(9000) + 1;
		} while (number < 1000);
		String numberString = Integer.toString(number);
		return numberString;
	}

	protected boolean verifyTrue(boolean condition, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				if (condition == true)
					log.info("===PASSED===");
				else
					log.info("===FAILED===");
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertTrue(condition);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return verifyTrue(condition, false);
	}

	protected boolean verifyFalse(boolean condition, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				if (condition == false)
					log.info("===PASSED===");
				else
					log.info("===FAILED===");
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return verifyFalse(condition, false);
	}

	protected boolean verifyEquals(Object actual, Object expected, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertEquals(actual, expected);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertEquals(actual, expected);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver driver;
	protected AutomationControl control = new AutomationControl();
	protected final Log log;
}
