package page;

import org.openqa.selenium.WebDriver;

public class DepositPage extends AbstractPage {

	public DepositPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Enter Account Number Textbox
	 */
	public void enterAccountNumber(String accountNumber) {
		waitForControl(driver, LiveGuru99.DepositPage.ACCOUNT_NUMBER_TEXTBOX, timeWait);
		type(driver, LiveGuru99.DepositPage.ACCOUNT_NUMBER_TEXTBOX, accountNumber);
		sleep(1);
	}

	/**
	 * Enter Amount Textbox
	 */
	public void enterAmount(String amount) {
		waitForControl(driver, LiveGuru99.DepositPage.AMOUNT_TEXTBOX, timeWait);
		type(driver, LiveGuru99.DepositPage.AMOUNT_TEXTBOX, amount);
		sleep(1);
	}

	/**
	 * Enter Description Textbox
	 */
	public void enterDescription(String description) {
		waitForControl(driver, LiveGuru99.DepositPage.DESCRIPTION_TEXTBOX, timeWait);
		type(driver, LiveGuru99.DepositPage.DESCRIPTION_TEXTBOX, description);
		sleep(1);
	}

	/**
	 * click Submit
	 */
	public void clickSubmitButton() {
		waitForControl(driver, LiveGuru99.NewCustomerPage.SUBMIT_BUTTON, timeWait);
		click(driver, LiveGuru99.NewCustomerPage.SUBMIT_BUTTON);
	}

	/**
	 * check 'Add new customer' display
	 */
	public boolean isAddNewCustomerDisplay(String messageContent) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.CHECK_ADD_CUSTOMER_DISPLAY, messageContent, timeWait);
		return isControlDisplayed(driver, LiveGuru99.NewCustomerPage.CHECK_ADD_CUSTOMER_DISPLAY, messageContent);
	}

	/**
	 * get value 'Amount Credited' field
	 */
	public String getAmountCredited() {
		waitForControl(driver, LiveGuru99.DepositPage.GET_AMOUNT_DEPOSIT, timeWait);
		String amount = getText(driver, LiveGuru99.DepositPage.GET_AMOUNT_DEPOSIT);
		return amount;
	}

	/**
	 * get value 'Current Amount' field
	 */
	public String getCurrentAmount() {
		waitForControl(driver, LiveGuru99.DepositPage.GET_CURRENT_AMOUNT, timeWait);
		String currentAmount = getText(driver, LiveGuru99.DepositPage.GET_CURRENT_AMOUNT);
		return currentAmount;
	}

	private WebDriver driver;
}