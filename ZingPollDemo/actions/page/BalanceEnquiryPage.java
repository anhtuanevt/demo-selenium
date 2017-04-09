package page;

import org.openqa.selenium.WebDriver;

public class BalanceEnquiryPage extends AbstractPage {

	public BalanceEnquiryPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Enter Account Number Textbox
	 */

	public void enterAccountNumber(String accountNumber) {
		waitForControl(driver, LiveGuru99.WithdrawallPage.ACCOUNT_NUMBER_TEXTBOX, timeWait);
		type(driver, LiveGuru99.WithdrawallPage.ACCOUNT_NUMBER_TEXTBOX, accountNumber);
		sleep(1);
	}

	/**
	 * Enter Amount Textbox
	 */

	public void enterAmount(String amount) {
		waitForControl(driver, LiveGuru99.WithdrawallPage.AMOUNT_TEXTBOX, timeWait);
		type(driver, LiveGuru99.WithdrawallPage.AMOUNT_TEXTBOX, amount);
		sleep(1);
	}

	/**
	 * click Submit
	 */

	public void clickSubmitButton() {
		waitForControl(driver, LiveGuru99.NewCustomerPage.SUBMIT_BUTTON, timeWait);
		click(driver, LiveGuru99.NewCustomerPage.SUBMIT_BUTTON);
		sleep(2);
	}

	/**
	 * check 'Add new customer' display
	 */
	public boolean isAddNewCustomerDisplay(String messageContent) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.CHECK_ADD_CUSTOMER_DISPLAY, messageContent, timeWait);
		return isControlDisplayed(driver, LiveGuru99.NewCustomerPage.CHECK_ADD_CUSTOMER_DISPLAY, messageContent);
	}

	/**
	 * get value 'Balance' field
	 */
	public String getBalance() {
		waitForControl(driver, LiveGuru99.BalanceEnquiryPage.GET_AMOUNT_DEPOSIT, timeWait);
		String balance = getText(driver, LiveGuru99.BalanceEnquiryPage.GET_AMOUNT_DEPOSIT);
		return balance;
	}

	/**
	 * check 'Fund Transfer Details' display
	 */
	public boolean isFundTransferDetailsDisplay(String messageContent) {
		waitForControl(driver, LiveGuru99.FundTransferPage.CHECK_FUN_TRANSFER_DISPLAY, messageContent, timeWait);
		return isControlDisplayed(driver, LiveGuru99.FundTransferPage.CHECK_FUN_TRANSFER_DISPLAY, messageContent);
	}

	private WebDriver driver;
}