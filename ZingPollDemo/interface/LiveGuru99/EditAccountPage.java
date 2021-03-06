package LiveGuru99;

public class EditAccountPage {
	public static final String CUSTOMER_NAME_TEXTBOX = "//input[@name='name']";
	public static final String DATE_OF_BIRTH_TEXTBOX = "//*[@id='dob']";
	public static final String ADDRESS_TEXTAREA = "//textarea [@name='addr']";
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String MOBILE_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String SUBMIT_BUTTON = "//input[@value='Submit']";
	public static final String CONTINUE_BUTTON = "//*[@id='customer']/tbody/tr/td/a[contains(text(),'Continue')]";
	public static final String CHECK_ADD_CUSTOMER_DISPLAY = "//tbody/tr/td/p[contains(.,'%s')]";
	public static final String GET_CUSTOMER_ID = "//tbody/tr[4]/td[2]";
}
