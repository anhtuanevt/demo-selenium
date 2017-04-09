package page;

import org.openqa.selenium.WebDriver;

public class NewCustomerPage extends AbstractPage {
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Enter Customer Name Textbox
	 */
	public void enterCustomerName(String customerName) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.CUSTOMER_NAME_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.CUSTOMER_NAME_TEXTBOX, customerName);
		sleep(1);
	}

	/**
	 * Enter Date Of Birth Textbox
	 */
	public void enterDateOfBirth(String dateOfBirth) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.DATE_OF_BIRTH_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
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
	 * Enter Pasword Textbox
	 */
	public void enterPassword(String password) {
		waitForControl(driver, LiveGuru99.NewCustomerPage.PASSWORD_TEXTBOX, timeWait);
		type(driver, LiveGuru99.NewCustomerPage.PASSWORD_TEXTBOX, password);
		sleep(1);
	}

	/**
	 * click Gender radio button
	 */
	public void clickGenderRadioButton() {
		waitForControl(driver, LiveGuru99.NewCustomerPage.GENDER_RADIOBUTTON, timeWait);
		click(driver, LiveGuru99.NewCustomerPage.GENDER_RADIOBUTTON);
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
	 * click Continue
	 */
	public void clickContinue() {
		waitForControl(driver, LiveGuru99.NewCustomerPage.CONTINUE_BUTTON, timeWait);
		click(driver, LiveGuru99.NewCustomerPage.CONTINUE_BUTTON);
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

	private WebDriver driver;
}