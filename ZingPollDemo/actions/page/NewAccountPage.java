package page;

import org.openqa.selenium.WebDriver;

public class NewAccountPage extends AbstractPage {
	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Enter Customer Name Textbox
	 */

	public void enterCustomerID(String customerID) {
		waitForControl(driver, LiveGuru99.EditCustomerPage.CUSTOMER_ID_TEXTBOX, timeWait);
		type(driver, LiveGuru99.EditCustomerPage.CUSTOMER_ID_TEXTBOX, customerID);
		sleep(1);
	}

	/**
	 * select Account Type
	 */
	public void selectAccountType(String productType) {
		waitForControl(driver, LiveGuru99.NewAccountPage.ACCOUNT_TYPE_COMBOBOX, timeWait);
		selectItemCombobox(driver, LiveGuru99.NewAccountPage.ACCOUNT_TYPE_COMBOBOX, productType);
	}

	/**
	 * Enter Initial Deposit Textbox
	 */

	public void enterInitialDeposit(String deposit) {
		waitForControl(driver, LiveGuru99.NewAccountPage.INITIAL_DEPOSIT_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewAccountPage.INITIAL_DEPOSIT_TEXTBOX, deposit);
		sleep(1);
	}

	/**
	 * click Submit
	 */

	public void clickSubmitButton() {
		waitForControl(driver, LiveGuru99.NewAccountPage.SUBMIT_BUTTON, timeWait);
		click(driver, LiveGuru99.NewAccountPage.SUBMIT_BUTTON);
	}

	/**
	 * check 'Add new customer' display
	 */
	public boolean isAddNewCustomerDisplay(String messageContent) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.CHECK_ADD_CUSTOMER_DISPLAY, messageContent, timeWait);
		return isControlDisplayed(driver, LiveGuru99.NewCustomerPage.CHECK_ADD_CUSTOMER_DISPLAY, messageContent);
	}

	/**
	 * get value 'Customer ID' field
	 */
	public String getCustomerID() {
		waitForControl(driver, LiveGuru99.NewCustomerPage.GET_CUSTOMER_ID, timeWait);
		String customerID = getText(driver, LiveGuru99.NewCustomerPage.GET_CUSTOMER_ID);
		return customerID;
	}

	/**
	 * get value 'Current Amount' field
	 */
	public String getCurrentAmount() {
		waitForControl(driver, LiveGuru99.NewAccountPage.GET_CURRENT_AMOUNT, timeWait);
		String currentAmount = getText(driver, LiveGuru99.NewAccountPage.GET_CURRENT_AMOUNT);
		return currentAmount;
	}

	private WebDriver driver;
}