package page;

import org.openqa.selenium.WebDriver;

public class EditCustomerPage extends AbstractPage {
	public EditCustomerPage(WebDriver driver) {
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
	 * Enter Address Textbox
	 */
	public void enterAddress(String address) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.ADDRESS_TEXTAREA, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.ADDRESS_TEXTAREA, address);
		sleep(1);
	}

	/**
	 * Enter City Textbox
	 */

	public void enterCity(String city) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.CITY_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.CITY_TEXTBOX, city);
		sleep(1);
	}

	/**
	 * Enter State Textbox
	 */

	public void enterState(String state) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.STATE_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.STATE_TEXTBOX, state);
		sleep(1);
	}

	/**
	 * Enter Pin Textbox
	 */

	public void enterPin(String pin) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.PIN_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.PIN_TEXTBOX, pin);
		sleep(1);
	}

	/**
	 * Enter Mobile Textbox
	 */

	public void enterMobile(String mobile) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.MOBILE_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.MOBILE_TEXTBOX, mobile);
		sleep(1);
	}

	/**
	 * Enter Email Textbox
	 */

	public void enterEmail(String email) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.EMAIL_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.EMAIL_TEXTBOX, email);
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

	private WebDriver driver;
}