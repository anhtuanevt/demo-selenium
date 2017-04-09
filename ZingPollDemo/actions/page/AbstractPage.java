package page;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.AutomationControl;

public class AbstractPage {

	public void click(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, timeWait);
		element = control.findElement(driver, controlName);
		element.click();
	}

	public void click(WebDriver driver, String controlName, String value) {
		waitForControl(driver, controlName, value, timeWait);
		element = control.findElement(driver, controlName, value);
		element.click();
	}

	// Unicode Character 'BACKSPACE' (U0008)
	public void type(WebDriver driver, String controlName, String value) {
		waitForControl(driver, controlName, timeWait);
		element = control.findElement(driver, controlName);
		element.clear();
		element.sendKeys("\u0008" + value);
	}

	public void selectItemCombobox(WebDriver driver, String controlName, String item) {
		element = control.findElement(driver, controlName);
		Select select = new Select(element);
		select.selectByVisibleText(item);
	}

	public void selectItemCombobox(WebDriver driver, String controlName, String value, String item) {
		element = control.findElement(driver, controlName, value);
		Select select = new Select(element);
		select.selectByVisibleText(item);
	}

	public String getItemSelectedCombobox(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		Select select = new Select(element);
		String itemSelected = select.getFirstSelectedOption().getText();
		return itemSelected;
	}

	public String getItemSelectedCombobox(WebDriver driver, String controlName, String value) {
		element = control.findElement(driver, controlName, value);
		Select select = new Select(element);
		String itemSelected = select.getFirstSelectedOption().getText();
		return itemSelected;
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
		sleep(2);
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void openURL(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void waitForAlert(WebDriver driver) {
		new WebDriverWait(driver, 60).ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptJavascriptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissJavascriptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextJavascriptAlert(WebDriver driver) {
		String message;
		try {
			Alert alert = driver.switchTo().alert();
			message = alert.getText();
			alert.accept();
		} catch (final WebDriverException e) {
			message = null;
		}
		return message;
	}

	public void acceptJavascriptPrompt(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert().sendKeys(value);
		alert.accept();
	}

	public void waitForAjaxDone(WebDriver driver) {
		while (true) {
			Boolean ajaxIsComplete = (Boolean) executeJavaScript(driver, "return jQuery.active == 0");
			if (ajaxIsComplete)
				break;
			sleep(5);
		}
	}

	public static void waitForAjax(WebDriver driver) {
		new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (Boolean) js.executeScript("return jQuery.active == 0");
			}
		});
	}

	public void waitUntilAjaxRequestCompletes(WebDriver driver) {
		new FluentWait<WebDriver>(driver).withTimeout(45, TimeUnit.SECONDS).pollingEvery(15, TimeUnit.SECONDS).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor jsExec = (JavascriptExecutor) d;
				return (Boolean) jsExec.executeScript("return jQuery.active == 0");
			}
		});
	}

	public void waitForControlNotDisplayed(WebDriver driver, final String controlName, long timeout) {
		try {
			By by = control.getBy(driver, controlName);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAttributeValue(WebDriver driver, String controlName, String attribute) {
		waitForControl(driver, controlName, timeWait);
		element = control.findElement(driver, controlName);
		return element.getAttribute(attribute);
	}

	public void doubleClick(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, timeWait);
		Actions action = new Actions(driver);
		element = control.findElement(driver, controlName);
		action.doubleClick(element).perform();
	}

	public int countElement(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, timeWait);
		return control.findElements(driver, controlName).size();
	}

	public void moveMouseToElement(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, timeWait);
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, controlName), 156, 20);
		action.build().perform();
	}

	public WebElement getElement(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		return element;
	}

	public Object executeJavaScript(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeJavaScript(WebDriver driver, String javaSript, String controlName) {
		try {
			element = control.findElement(driver, controlName);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript, element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void scrollToBottomPage(WebDriver driver) {
		executeJavaScript(driver, "window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	public void scrollPageToElement(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, 5);
		element = control.findElement(driver, controlName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		sleep(2);
	}

	public String randomString() {
		Random rand = new Random();
		int number = rand.nextInt(9000) + 1;
		String numberString = Integer.toString(number);
		return numberString;
	}

	public void uncheckTheCheckbox(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		if (element.isSelected()) {
			click(driver, controlName);
		}
	}

	public boolean isCheckboxChecked(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		return element.isSelected();
	}

	public void dragAndDrop(WebDriver driver, String sourceControl, String targetControl) {
		WebElement source = control.findElement(driver, sourceControl);
		WebElement target = control.findElement(driver, targetControl);
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target);
		action.perform();
	}

	public boolean isControlDisplayed(WebDriver driver, String controlName) {
		try {
			element = control.findElement(driver, controlName);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String controlName, String value) {
		try {
			element = control.findElement(driver, controlName, value);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isControlSelected(WebDriver driver, String controlName) {
		try {
			element = control.findElement(driver, controlName);
			return element.isSelected();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isControlEnabled(WebDriver driver, String controlName) {
		try {
			element = control.findElement(driver, controlName);
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForControl(WebDriver driver, final String controlName, long timeout) {
		try {
			By by = control.getBy(driver, controlName);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForControl(WebDriver driver, final String controlName, String value, long timeout) {
		try {
			By by = control.getBy(driver, controlName, value);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(WebDriver driver, String controlName) {
		try {
			waitForControl(driver, controlName, timeWait);
			WebElement element = control.findElement(driver, controlName);
			return element.getText();
		} catch (Exception e) {
			return null;
		}
	}

	public void sleep(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void checkTheCheckbox(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		if (!element.isSelected()) {
			click(driver, controlName);
		}
	}

	public void checkTheCheckbox(WebDriver driver, String controlName, String value) {
		element = control.findElement(driver, controlName, value);
		if (!element.isSelected()) {
			click(driver, controlName, value);
		}
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

	public String getControlHref(WebDriver driver, String controlName) {
		return getAttributeValue(driver, controlName, "href");
	}
	
	/*----	Page abstract 	----*/
	public NewCustomerPage goToNewCustomerPage(WebDriver driver){
		try {
			waitForControl(driver, LiveGuru99.AbstractPage.NEW_CUSTOMER_LINK, timeWait);
			driver.get(getControlHref(driver, LiveGuru99.AbstractPage.NEW_CUSTOMER_LINK));
			sleep(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getNewCustomerPage(driver);
	}
	
	public EditCustomerPage gotoEditCustomerPage(WebDriver driver){
		try {
			waitForControl(driver, LiveGuru99.AbstractPage.EDIT_CUSTOMER_LINK, timeWait);
			driver.get(getControlHref(driver, LiveGuru99.AbstractPage.EDIT_CUSTOMER_LINK));
			sleep(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getEditCustomerPage(driver);
	}
	
	public NewAccountPage gotoNewAccountPage(WebDriver driver){
		try {
			waitForControl(driver, LiveGuru99.AbstractPage.NEW_ACCOUNT_LINK, timeWait);
			driver.get(getControlHref(driver, LiveGuru99.AbstractPage.NEW_ACCOUNT_LINK));
			sleep(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getNewAccountPage(driver);
	}
	
	public DepositPage gotoDepositPage(WebDriver driver){
		try {
			waitForControl(driver, LiveGuru99.AbstractPage.DEPOSIT_LINK, timeWait);
			driver.get(getControlHref(driver, LiveGuru99.AbstractPage.DEPOSIT_LINK));
			sleep(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getDepositPage(driver);
	}
	
	public WithdrawallPage gotoWithdrawallPage(WebDriver driver){
		try {
			waitForControl(driver, LiveGuru99.AbstractPage.WITHDRAWAL_LINK, timeWait);
			driver.get(getControlHref(driver, LiveGuru99.AbstractPage.WITHDRAWAL_LINK));
			sleep(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getWithdrawallPage(driver);
	}
	
	public FundTransferPage gotoFundTransferPage(WebDriver driver){
		try {
			waitForControl(driver, LiveGuru99.AbstractPage.FUND_TRANSFER_LINK, timeWait);
			driver.get(getControlHref(driver, LiveGuru99.AbstractPage.FUND_TRANSFER_LINK));
			sleep(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getFundTransferPage(driver);
	}
	
	public BalanceEnquiryPage gotoBalanceEnquiryPage(WebDriver driver){
		try {
			waitForControl(driver, LiveGuru99.AbstractPage.BALANCE_ENQUIRY_LINK, timeWait);
			driver.get(getControlHref(driver, LiveGuru99.AbstractPage.BALANCE_ENQUIRY_LINK));
			sleep(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getBalanceEnquiryPage(driver);
	}
	
	
	protected AutomationControl control = new AutomationControl();
	protected int timeWait = 30;
	protected int timeSleep = 2;
	protected WebElement element;
}
