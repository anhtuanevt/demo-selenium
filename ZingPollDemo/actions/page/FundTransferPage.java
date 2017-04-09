package page;

import org.openqa.selenium.WebDriver;

public class FundTransferPage extends AbstractPage {
	public FundTransferPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Enter Payer Account Number Textbox
	  */
	
	public void enterPayerAccountNumber(String payerAccountNumber) {
		waitForControl(driver, LiveGuru99.FundTransferPage.PAYER_ACCOUNT_NUMBER_TEXTBOX, timeWait);
		type(driver, LiveGuru99.FundTransferPage.PAYER_ACCOUNT_NUMBER_TEXTBOX, payerAccountNumber);
		sleep(1);
	}	
	
	/**
	 * Enter Payeer Account Number Textbox
	  */
	
	public void enterPayeerAccountNumber(String payeerAccountNumber) {
		waitForControl(driver, LiveGuru99.FundTransferPage.PAYEER_ACCOUNT_NUMBER_TEXTBOX, timeWait);
		type(driver, LiveGuru99.FundTransferPage.PAYEER_ACCOUNT_NUMBER_TEXTBOX, payeerAccountNumber);
		sleep(1);
	}	
	
	/**
	 * Enter Amount Textbox
	  */
	
	public void enterAmount(String amount) {
		waitForControl(driver, LiveGuru99.FundTransferPage.AMOUNT_TEXTBOX, timeWait);
		type(driver, LiveGuru99.FundTransferPage.AMOUNT_TEXTBOX, amount);
		sleep(1);
	}		
	
	
	/**
	 * Enter Description Textbox
	  */
	
	public void enterDescription(String description) {
		waitForControl(driver, LiveGuru99.FundTransferPage.DESCRIPTION_TEXTBOX, timeWait);
		type(driver, LiveGuru99.FundTransferPage.DESCRIPTION_TEXTBOX, description);
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
	 * check 'Fund Transfer Details' display
	 */
	public boolean isFundTransferDetailsDisplay(String messageContent) {
		waitForControl(driver, LiveGuru99.FundTransferPage.CHECK_FUN_TRANSFER_DISPLAY, messageContent, timeWait);
		return isControlDisplayed(driver, LiveGuru99.FundTransferPage.CHECK_FUN_TRANSFER_DISPLAY, messageContent);
	}
	
	/**
	 * get value 'Amount' field
	 */
	public String getAmount() {
		waitForControl(driver, LiveGuru99.FundTransferPage.GET_AMOUNT_DEPOSIT, timeWait);
		String amount = getText(driver, LiveGuru99.FundTransferPage.GET_AMOUNT_DEPOSIT);
		return amount;
	}
	
	/**
	 * get value 'Current Amount' field
	 */
	public String getCurrentAmount() {
		waitForControl(driver, LiveGuru99.WithdrawallPage.GET_CURRENT_AMOUNT, timeWait);
		String currentAmount = getText(driver, LiveGuru99.WithdrawallPage.GET_CURRENT_AMOUNT);
		return currentAmount;
	}
	
	private WebDriver driver;
}