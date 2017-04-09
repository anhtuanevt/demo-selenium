package page;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void isSignInPopupDisplay(String userName) {
		waitForControl(driver, LiveGuru99.HomePage.HOME_PAGE_TITLE, userName, timeWait);
		isControlDisplayed(driver, LiveGuru99.HomePage.HOME_PAGE_TITLE, userName);
	}

	private WebDriver driver;
}
