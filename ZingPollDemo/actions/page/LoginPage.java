package page;

import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeIntoEmail(String email) {
		waitForControl(driver, LiveGuru99.LoginPage.USERNAME_TEXTBOX, timeWait);
		type(driver, LiveGuru99.LoginPage.USERNAME_TEXTBOX, email);
	}

	public void typeIntoPassword(String password) {
		waitForControl(driver, LiveGuru99.LoginPage.PASSWORD_TEXTBOX, timeWait);
		type(driver, LiveGuru99.LoginPage.PASSWORD_TEXTBOX, password);
	}

	public HomePage loginToHomePage(String email, String password) {
		typeIntoEmail(email);
		typeIntoPassword(password);
		click(driver, LiveGuru99.LoginPage.LOGIN_BUTTON);
		return PageFactory.getHomePage(driver);
	}

	
	private WebDriver driver;
}
