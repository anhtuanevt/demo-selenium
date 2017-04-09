package page;

import org.openqa.selenium.WebDriver;


public class WithdrawallPage extends AbstractPage {
	
	public WithdrawallPage(WebDriver driver) {
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
	 * Enter Description Textbox
	 */
	
	public void enterDescription(String description) {
		waitForControl(driver, LiveGuru99.WithdrawallPage.DESCRIPTION_TEXTBOX, timeWait);
		type(driver, LiveGuru99.WithdrawallPage.DESCRIPTION_TEXTBOX, description);
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
		waitForControl(driver, LiveGuru99.WithdrawallPage.GET_AMOUNT_DEPOSIT, timeWait);
		String amount = getText(driver, LiveGuru99.WithdrawallPage.GET_AMOUNT_DEPOSIT);
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