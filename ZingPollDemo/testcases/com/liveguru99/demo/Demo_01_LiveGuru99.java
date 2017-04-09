package com.liveguru99.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.AbstractTest;
import common.Constants;
import page.BalanceEnquiryPage;
import page.DepositPage;
import page.EditCustomerPage;
import page.FundTransferPage;
import page.HomePage;
import page.LoginPage;
import page.NewAccountPage;
import page.NewCustomerPage;
import page.PageFactory;
import page.WithdrawallPage;

public class Demo_01_LiveGuru99 extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void setup(String browser, String url) {
		driver = openBrowser(browser, url);
		loginPage = PageFactory.getLoginPage(driver);
		
		
		username = Constants.USERNAME;
		password = Constants.PASSWORD;
		customerName = "AUTOMATION " + getRandomString(8);
		dateOfBirth = "16/10/1989";
		address = "PO Box 911 8331 Duis Avenue";
		addressNew = "1883 Cursus Avenue";
		city = "Tampa";
		cityNew = "Houston";
		state = "FL";
		stateNew = "Texas";
		pin = "466250";
		pinNew = "166455";
		mobile = "4555442476";
		mobileNew = "4779728081";
		email = "auto" + getUniqueFourNumbers() + "@mail.com";
		emailNew = "newauto" + getUniqueFourNumbers() + "@mail.com";
		successAddNewCustomer = "Customer Registered Successfully!!!";
		successEditCustomer = "Customer details updated Successfully!!!";
		initialDeposit = "50000";
		successNewAccount = "Account Generated Successfully!!!";
		successDeposit = "Transaction details of Deposit for Account ";
		successWithdrawal = "Transaction details of Withdrawal for Account ";
		successTransfer = "Fund Transfer Details";
		successBalanceDetails = "Balance Details for Account ";
		payeerAccountNumber = "18302";

		log.info("Pre-condition - Step 01: Login to HomePage");
		homePage = loginPage.loginToHomePage(username, password);
	}

	@Test(groups = { "regression" }, description = "Create New Customer Account and get Customer ID")
	public void DemoGuru_001_CreateNewCustomerAccountAndGetCustomerID() {
		log.info("DemoGuru_001 - Step 01: Go to New Customer page");
		newCustomerPage = homePage.goToNewCustomerPage(driver);

		log.info("DemoGuru_001 - Step 02: Input 'CUSTOMER NAME'");
		newCustomerPage.enterCustomerName(customerName);

		log.info("DemoGuru_001 - Step 03: Input 'DATE OF BIRTH'");
		newCustomerPage.enterDateOfBirth(dateOfBirth);

		log.info("DemoGuru_001 - Step 04: Input 'ADDRESS'");
		newCustomerPage.enterAddress(address);

		log.info("DemoGuru_001 - Step 05: Input 'CITY'");
		newCustomerPage.enterCity(city);

		log.info("DemoGuru_001 - Step 06: Input 'STATE'");
		newCustomerPage.enterState(state);

		log.info("DemoGuru_001 - Step 07: Input 'PIN'");
		newCustomerPage.enterPin(pin);

		log.info("DemoGuru_001 - Step 08: Input 'MOBILE'");
		newCustomerPage.enterMobile(mobile);

		log.info("DemoGuru_001 - Step 09: Input 'EMAIL'");
		newCustomerPage.enterEmail(email);

		log.info("DemoGuru_001 - Step 10: Input 'PASSWORD'");
		newCustomerPage.enterPassword(password);

		log.info("DemoGuru_001 - Step 11: Select 'GENDER'");
		newCustomerPage.clickGenderRadioButton();

		log.info("DemoGuru_001 - Step 12: Click 'SUBMIT' button");
		newCustomerPage.clickSubmitButton();

		log.info("DemoGuru_001 - Step 13: Verify message displays with content 'Customer Registered Successfully!!!'");
		verifyTrue(newCustomerPage.isAddNewCustomerDisplay(successAddNewCustomer));
		
		newCustomerPage.isAddNewCustomerDisplay(successAddNewCustomer);

		log.info("DemoGuru_001 - Step 14: Get value 'CUSTOMER ID'");
		customerID = newCustomerPage.getCustomerID();
	}

	@Test(groups = { "regression" }, description = "Edit customer account and check edited successfully")
	public void DemoGuru_002_EditCustomerAccountAndCheckEditSuccessfull() {
		log.info("DemoGuru_002 - Step 01: Go to Edit Customer page");
		editCustomerPage = newCustomerPage.gotoEditCustomerPage(driver);

		log.info("DemoGuru_002 - Step 02: Input 'CUSTOMER NAME'");
		editCustomerPage.enterCustomerID(customerID);

		log.info("DemoGuru_002 - Step 03: Click 'SUBMIT' button");
		editCustomerPage.clickSubmitButton();

		log.info("DemoGuru_002 - Step 04: Input 'ADDRESS'");
		editCustomerPage.enterAddress(addressNew);

		log.info("DemoGuru_002 - Step 05: Input 'CITY'");
		editCustomerPage.enterCity(cityNew);

		log.info("DemoGuru_002 - Step 06: Input 'STATE'");
		editCustomerPage.enterState(stateNew);

		log.info("DemoGuru_002 - Step 07: Input 'PIN'");
		editCustomerPage.enterPin(pinNew);

		log.info("DemoGuru_002 - Step 08: Input 'MOBILE'");
		editCustomerPage.enterMobile(mobileNew);

		log.info("DemoGuru_002 - Step 09: Input 'EMAIL'");
		editCustomerPage.enterEmail(emailNew);

		log.info("DemoGuru_002 - Step 10: Click 'SUBMIT' button");
		editCustomerPage.clickSubmitButton();

		log.info("DemoGuru_002 - Step 11: Verify message displays with content 'Customer details updated Successfully!!!'");
		verifyTrue(editCustomerPage.isAddNewCustomerDisplay(successEditCustomer));
	}

	@Test(groups = { "regression" }, description = "Add new account and check created successfully, then verify 'Current Amount' and 'Initial Deposit' are equal")
	public void DemoGuru_003_AddNewAccountAndGetAccountID() {
		log.info("DemoGuru_003 - Step 01: Go to New Account page");
		newAccountPage = editCustomerPage.gotoNewAccountPage(driver);

		log.info("DemoGuru_003 - Step 02: Input 'CUSTOMER NAME'");
		newAccountPage.enterCustomerID(customerID);

		log.info("DemoGuru_003 - Step 03: Select 'CUSTOMER NAME'");
		newAccountPage.selectAccountType("Current");

		log.info("DemoGuru_003 - Step 04: Input 'INITIAL DEPOSIT'");
		newAccountPage.enterInitialDeposit(initialDeposit);

		log.info("DemoGuru_003 - Step 05: Click 'SUBMIT' button");
		newAccountPage.clickSubmitButton();

		log.info("DemoGuru_003 - Step 06: Verify message displays with content 'Account Generated Successfully!!!'");
		verifyTrue(newAccountPage.isAddNewCustomerDisplay(successNewAccount));

		log.info("DemoGuru_003 - Step 07: Get value 'ACCOUNT ID'");
		accountID = newAccountPage.getCustomerID();

		log.info("DemoGuru_003 - Step 08: Verify 'CURRENT AMOUNT' and 'INITIAL DEPOSIT' are equal");
		currentAmount = newAccountPage.getCurrentAmount();
		verifyEquals(currentAmount, "50000");
	}

	@Test(groups = { "regression" }, description = "Transfer money into a current account and check account balance equal 55,000")
	public void DemoGuru_004_TransferMoneyIntoCurrentAccountAndCheckAccountBalanceEqual50000() {
		log.info("DemoGuru_004 - Step 01: Go to Deposit page");
		depositPage = newAccountPage.gotoDepositPage(driver);

		log.info("DemoGuru_004 - Step 02: Input 'ACCOUNT NUMBER'");
		depositPage.enterAccountNumber(accountID);

		log.info("DemoGuru_004 - Step 03: Input 'AMOUNT'");
		depositPage.enterAmount("5000");

		log.info("DemoGuru_004 - Step 04: Input 'DESCRIPTION'");
		depositPage.enterDescription("Deposit");

		log.info("DemoGuru_004 - Step 05: Click 'SUBMIT' button");
		depositPage.clickSubmitButton();

		log.info("DemoGuru_004 - Step 06: Verify message displays with content 'Transaction details of Deposit for Account Number'");
		verifyTrue(depositPage.isAddNewCustomerDisplay(successDeposit + accountID));

		log.info("DemoGuru_004 - Step 07: Verify 'AMOUNT CREDITED' equal 5,000");
		amountCredit = depositPage.getAmountCredited();
		verifyEquals(amountCredit, "5000");

		log.info("DemoGuru_004 - Step 08: Verify 'CURRENT BALANCE' equal 55,000");
		currentAmount = depositPage.getCurrentAmount();
		verifyEquals(currentAmount, "55000");
	}

	@Test(groups = { "regression" }, description = "Withdraw money from current account and check account balance equal 40,000")
	public void DemoGuru_005_WithdrawMoneyFromCurrentAccountAndCheckAccountBalanceEqual40000() {
		log.info("DemoGuru_005 - Step 01: Go to Withdrawal page");
		withdrawalPage = depositPage.gotoWithdrawallPage(driver);

		log.info("DemoGuru_005 - Step 02: Input 'ACCOUNT NUMBER'");
		withdrawalPage.enterAccountNumber(accountID);

		log.info("DemoGuru_005 - Step 03: Input 'AMOUNT'");
		withdrawalPage.enterAmount("15000");

		log.info("DemoGuru_005 - Step 04: Input 'DESCRIPTION'");
		withdrawalPage.enterDescription("Withdrawal");

		log.info("DemoGuru_005 - Step 05: Click 'SUBMIT' button");
		withdrawalPage.clickSubmitButton();

		log.info("DemoGuru_005 - Step 06: Verify message displays with content 'Transaction details of Withdrawal for Account number'");
		verifyTrue(withdrawalPage.isAddNewCustomerDisplay(successWithdrawal + accountID));

		log.info("DemoGuru_005 - Step 07: Verify 'AMOUNT CREDITED' equal 15,000");
		amountDebited = withdrawalPage.getAmountCredited();
		verifyEquals(amountDebited, "15000");

		log.info("DemoGuru_005 - Step 08: Verify 'CURRENT BALANCE' equal 40,000");
		currentAmount = withdrawalPage.getCurrentAmount();
		verifyEquals(currentAmount, "40000");
	}

	@Test(groups = { "regression" }, description = "Transfer the money into another account and check amount equal 10,000")
	public void DemoGuru_006_TransferTheMoneyIntoOtherAccountAccountAndCheckAmountEqual10000() {
		log.info("DemoGuru_006 - Step 01: Go to Fund Transfer page");
		fundTransferPage = withdrawalPage.gotoFundTransferPage(driver);

		log.info("DemoGuru_006 - Step 02: Input 'PAYER ACCOUNT NUMBER'");
		fundTransferPage.enterPayerAccountNumber(accountID);

		log.info("DemoGuru_006 - Step 03: Input 'PAYEER ACCOUNT NUMBER'");
		fundTransferPage.enterPayeerAccountNumber(payeerAccountNumber);

		log.info("DemoGuru_006 - Step 04: Input 'AMOUNT'");
		fundTransferPage.enterAmount("10000");

		log.info("DemoGuru_006 - Step 05: Input 'DESCRIPTION'");
		fundTransferPage.enterDescription("Transfer");

		log.info("DemoGuru_006 - Step 06: Click 'SUBMIT' button");
		fundTransferPage.clickSubmitButton();

		log.info("DemoGuru_006 - Step 07: Verify message displays with content 'Fund Transfer Details'");
		verifyTrue(fundTransferPage.isFundTransferDetailsDisplay(successTransfer));

		log.info("DemoGuru_006 - Step 08: Verify 'AMOUNT' equal 10,000");
		amountTransfer = fundTransferPage.getAmount();
		verifyEquals(amountTransfer, "10000");
	}

	@Test(groups = { "regression" }, description = "Check current account balance equal 30,000")
	public void DemoGuru_007_CheckCurrentAccountBalanceEqual30000() {
		log.info("DemoGuru_007 - Step 01: Go to Balance Enquiry page");
		balanceEnquiryPage = fundTransferPage.gotoBalanceEnquiryPage(driver);

		log.info("DemoGuru_007 - Step 02: Input 'ACCOUNT NUMBER'");
		balanceEnquiryPage.enterAccountNumber(accountID);

		log.info("DemoGuru_007 - Step 03: Click 'SUBMIT' button");
		balanceEnquiryPage.clickSubmitButton();

		log.info("DemoGuru_007 - Step 04: Verify message displays with content 'Balance Details for Account Number'");
		verifyTrue(balanceEnquiryPage.isFundTransferDetailsDisplay(successBalanceDetails));

		log.info("DemoGuru_007 - Step 05: Verify 'BALANCE' equal 30,000");
		balance = balanceEnquiryPage.getBalance();
		verifyEquals(balance, "30000");
	}

	@AfterClass
	public void tearDown() {
		 closeBrowser(driver);
	}

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private NewCustomerPage newCustomerPage;
	private EditCustomerPage editCustomerPage;
	private NewAccountPage newAccountPage;
	private DepositPage depositPage;
	private WithdrawallPage withdrawalPage;
	private FundTransferPage fundTransferPage;
	private BalanceEnquiryPage balanceEnquiryPage;
	public String username, password;
	private String customerName, dateOfBirth, address, email, city, state, pin, mobile, successAddNewCustomer, customerID;
	private String addressNew, cityNew, stateNew, pinNew, mobileNew, emailNew, successEditCustomer;
	private String initialDeposit, successNewAccount, accountID, currentAmount, successDeposit;
	private String amountCredit, successWithdrawal, amountDebited,payeerAccountNumber;
	private String amountTransfer, successTransfer, balance, successBalanceDetails;
}
