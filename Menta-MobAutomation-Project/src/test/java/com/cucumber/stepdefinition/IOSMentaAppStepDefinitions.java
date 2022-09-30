package com.cucumber.stepdefinition;

import java.util.List;
import java.util.Objects;

import org.testng.Assert;

import com.appium.utility.Constants;
import com.utility.LogCapture;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;


public class IOSMentaAppStepDefinitions 
{
	@Given("^ios menta app is installed on the device and launched successfully$")
	public void ios_menta_app_is_installed_on_the_device_and_launched_successfully() throws Throwable 
	{
		
		if(Constants.CONFIG.getProperty("isLocalJenkins").equals("true"))
		{
			Assert.assertEquals("PASS", Constants.key.launchAppIOS());
			LogCapture.info("IOS Menta Application installed and launched successfully...");
		}
		else if(Constants.CONFIG.getProperty("isBrowserstackJenkins").equals("true"))
		{
			Thread.sleep(10000);
			
			 String vDeviceID = Constants.CONFIG.getProperty("bIOSDevice");
		        LogCapture.info("Menta Application is launching on  device "+vDeviceID+"....");
		        //System.out.println(vBrowserName);
		        
		        try {
		            if (!Constants.JenkinsBrowser.isEmpty() || !Constants.JenkinsBrowser.equals("")) {
		            	vDeviceID = Constants.JenkinsBrowser;
		                LogCapture.info("Device ID is :" + vDeviceID);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			
		        
		        String vVersion = Constants.CONFIG.getProperty("bIOSVersion");
		        LogCapture.info("Menta Application is launching on  device version "+vVersion+"....");
		        //System.out.println(vBrowserName);
		        try {
		            if (!Constants.BrowserStack.isEmpty() || !Constants.BrowserStack.equals("")) {
		            	vVersion = Constants.BrowserStack;
		                LogCapture.info("Device Version is :" + vVersion);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } 
			
		    
		    String rep = vDeviceID.replaceAll("-", " ");    
		    
			Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.launchAppIOSBrowserstack(rep, vVersion));
			LogCapture.info("Application installed and launched successfully......!!!!");
		}    
		
	}

	@When("^ios user clink on the Sign in button$")
	public void ios_user_clink_on_the_Sign_in_button() throws Throwable 
	{
		String vObjSignInBtn = Constants.IOSMentaOR.getProperty("SignInBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSignInBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjSignInBtn));
		LogCapture.info("IOS User clicked on Sign In button...");
	}

	@Then("^ios user should navigate to menta login screen$")
	public void ios_user_should_navigate_to_menta_login_screen() throws Throwable 
	{
	    String vObjLoginScreen = Constants.IOSMentaOR.getProperty("LoginScreen");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoginScreen));
	    LogCapture.info("IOS User is on menta login screen...");
	}

	@When("^ios user provides menta Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void ios_user_provides_menta_Username_and_Password(String email, String pass) throws Throwable 
	{
		String vObjEmailInput = Constants.IOSMentaOR.getProperty("EmailInput");
		String vObjPassInput = Constants.IOSMentaOR.getProperty("PassInput");
		String vObjDoneBtn = Constants.IOSMentaOR.getProperty("DoneBtn");
		
		String vEmail = Constants.IOSTestData.getProperty(email);
		String vPass = Constants.IOSTestData.getProperty(pass);
		
		Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vEmail));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		
		Assert.assertEquals("PASS", Constants.key.click(vObjPassInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassInput, vPass));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		
		LogCapture.info("IOS User entered email and password successfully...");
		
	}

	@When("^ios user click on the menta login button$")
	public void ios_user_click_on_the_menta_login_button() throws Throwable 
	{
	    String vObjLoginBtn = Constants.IOSMentaOR.getProperty("LoginBtn");
	    Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
	    LogCapture.info("IOS User clicked on login button...");
	}
	
	@When("^ios user click on LATER button$")
	public void ios_user_click_on_LATER_button() throws Throwable 
	{
		String vObjLATERBtn = Constants.IOSMentaOR.getProperty("LATERBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLATERBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjLATERBtn));
		LogCapture.info("IOS User clicked on LATER button...");
	}
	
	@Then("^ios app should load the menta dashboard screen$")
	public void ios_app_should_load_the_menta_dashboard_screen() throws Throwable 
	{
	    String vObjMentaDashboard = Constants.IOSMentaOR.getProperty("MentaDashboard");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMentaDashboard));
	    LogCapture.info("IOS User is on menta dashboard page...");
	}
	
	@When("^ios user click on (Checking Account|Add Cash|Add card|Add|Ok) button$")
	public void ios_user_click_on_Checking_Account_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Checking Account"))
		{
			String vObjCheckingAccountOptn = Constants.IOSMentaOR.getProperty("CheckingAccountOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCheckingAccountOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCheckingAccountOptn));
			LogCapture.info("IOS User clicked on Checking Account button...");
		}
		else if(optionValue.equalsIgnoreCase("Add Cash"))
		{
			String vObjAddCashBtn = Constants.IOSMentaOR.getProperty("AddCashBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCashBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddCashBtn));
			LogCapture.info("IOS User clicked on Add Cash button...");
		}
		else if(optionValue.equalsIgnoreCase("Add card"))
		{
			String vObjAddCardBtn = Constants.IOSMentaOR.getProperty("AddCardBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCardBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddCardBtn));
			LogCapture.info("IOS User clicked on Add card button...");
		}
		else if(optionValue.equalsIgnoreCase("Add"))
		{
			String vObjADDBtn = Constants.IOSMentaOR.getProperty("ADDBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjADDBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjADDBtn));
			LogCapture.info("IOS User clicked on Add button...");
		}
		else if(optionValue.equalsIgnoreCase("Ok"))
		{
			String vObjOkBtn = Constants.IOSMentaOR.getProperty("OkBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
			LogCapture.info("IOS User clicked on Ok button...");
			//Constants.key.pause(2000);
		}
	}
	
	@Then("^ios user land on (Checking Account|Transactions) screen$")
	public void ios_user_land_on_Checking_Account_screen(String optionValue) throws Throwable 
	{
	    if(optionValue.equalsIgnoreCase("Checking Account"))
	    {
	    	String vObjCheckingAccountScreen = Constants.IOSMentaOR.getProperty("CheckingAccountScreen");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCheckingAccountScreen));
	    	LogCapture.info("IOS User is on Checking Account screen...");
	    }
	    else if(optionValue.equalsIgnoreCase("Transactions"))
	    {
	    	String vObjTransactionScreen = Constants.IOSMentaOR.getProperty("TransactionScreen");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionScreen));
	    	LogCapture.info("IOS User is on Transaction Screen screen...");
	    }
	}
	
	@When("^ios user select the newly created card$")
	public void ios_user_select_the_newly_created_card() throws Throwable 
	{
		String vObjSelectCard = Constants.IOSMentaOR.getProperty("SelectCard");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectCard));
		Assert.assertEquals("PASS", Constants.key.click(vObjSelectCard));
		LogCapture.info("IOS User selected the added card...");
	}
	
	@Then("^ios user land on Amount Added into Checking Account screen$")
	public void ios_user_land_on_Amount_Added_into_Checking_Account_screen() throws Throwable 
	{
		String vObjAmntAddIntoCAScreen = Constants.IOSMentaOR.getProperty("AmntAddIntoCAScreen");
    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAmntAddIntoCAScreen));
    	String vAmntAddTxt = Constants.key.readText(vObjAmntAddIntoCAScreen);
    	System.out.println(vAmntAddTxt);
    	LogCapture.info("IOS User is on Amount added screen...");
	}
	
	@When("^ios user click on Go To Dashboard button$")
	public void ios_user_click_on_Go_To_Dashboard_button() throws Throwable 
	{
		String vObjGoToDashboardBtn = Constants.IOSMentaOR.getProperty("GoToDashboardBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGoToDashboardBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjGoToDashboardBtn));
		LogCapture.info("IOS User clicked on Go To Dashboard button...");
	}
	
	@When("^ios user enters the \"([^\"]*)\"$")
	public void ios_user_enters_the(String data) throws Throwable 
	{
		String amount = data;
		// System.out.println(amount);
		String str[] = amount.split("");
		// System.out.println(str.length);

		for (int i = 0; i < str.length; i++) 
		{
			Constants.TempData = str[i];
				switch (Constants.TempData) 
				{
					case "1":
							System.out.println("1");
							String vObjOne = Constants.IOSMentaOR.getProperty("One");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
							Assert.assertEquals("PASS", Constants.key.click(vObjOne));
							break;
					case "2":
							System.out.println("2");
							String vObjTwo = Constants.IOSMentaOR.getProperty("Two");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
							Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
							break;
					case "3":
							System.out.println("3");
							String vObjThree = Constants.IOSMentaOR.getProperty("Three");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
							Assert.assertEquals("PASS", Constants.key.click(vObjThree));
							break;
					case "4":
							System.out.println("4");
							String vObjFour = Constants.IOSMentaOR.getProperty("Four");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
							Assert.assertEquals("PASS", Constants.key.click(vObjFour));
							break;
					case "5":
							System.out.println("5");
							String vObjFive = Constants.IOSMentaOR.getProperty("Five");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
							Assert.assertEquals("PASS", Constants.key.click(vObjFive));
							break;
					case "6":
							System.out.println("6");
							String vObjSix = Constants.IOSMentaOR.getProperty("Six");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
							Assert.assertEquals("PASS", Constants.key.click(vObjSix));
							break;
					case "7":
							System.out.println("7");
							String vObjSeven = Constants.IOSMentaOR.getProperty("Seven");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
							Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
							break;
					case "8":
							System.out.println("8");
							String vObjEight = Constants.IOSMentaOR.getProperty("Eight");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
							Assert.assertEquals("PASS", Constants.key.click(vObjEight));
							break;
					case "9":
							System.out.println("9");
							String vObjNine = Constants.IOSMentaOR.getProperty("Nine");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
							Assert.assertEquals("PASS", Constants.key.click(vObjNine));
							break;
					case "0":
							System.out.println("0");
							String vObjZero = Constants.IOSMentaOR.getProperty("Zero");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
							Assert.assertEquals("PASS", Constants.key.click(vObjZero));
							break;
					case ".":
							System.out.println(".");
							String vObjDott = Constants.IOSMentaOR.getProperty("Dot");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
							Assert.assertEquals("PASS", Constants.key.click(vObjDott));
							break;
					default:
						System.out.println("Not a number");
		}
		}
		LogCapture.info("IOS User enters amount successfully..." + data);
	}
	
	@When("^ios user enters the card number \"([^\"]*)\"$")
	public void ios_user_enters_the_card_number(String cardno) throws Throwable 
	{
		String vObjDebitCardNoInput = Constants.IOSMentaOR.getProperty("DebitCardNoInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardNoInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDebitCardNoInput, cardno));
		LogCapture.info("IOS User entered card number successfully..."+cardno);
	}
	
	@When("^ios user enters the expiry date \"([^\"]*)\"$")
	public void ios_user_enters_the_expiry_date(String expDate) throws Throwable 
	{
		String vObjExpirationDateInput = Constants.IOSMentaOR.getProperty("ExpirationDateInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpirationDateInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpirationDateInput, expDate));
		LogCapture.info("IOS User entered expiry date successfully..."+expDate);
	}
	
	@When("^ios user enters the security code \"([^\"]*)\"$")
	public void ios_user_enters_the_security_code(String code) throws Throwable 
	{
		String vObjCVVInput = Constants.IOSMentaOR.getProperty("CVVInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCVVInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCVVInput, code));
		LogCapture.info("IOS User entered security successfully..."+code);
	}
	
	@When("^ios user enters the Zip Code \"([^\"]*)\"$")
	public void ios_user_enters_the_Zip_Code(String zipCode) throws Throwable 
	{
		String vObjZipCodeInput = Constants.IOSMentaOR.getProperty("ZipCodeInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZipCodeInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjZipCodeInput, zipCode));
		LogCapture.info("IOS User entered Zip code successfully..."+zipCode);
	}
	
	@When("^ios user enters the CVV\"([^\"]*)\"$")
	public void ios_user_enters_the_CVV(String data) throws Throwable 
	{
		String amount = data;
		// System.out.println(amount);
		String str[] = amount.split("");
		// System.out.println(str.length);

		for (int i = 0; i < str.length; i++) 
		{
			Constants.TempData = str[i];
				switch (Constants.TempData) 
				{
					case "1":
							System.out.println("1");
							String vObjOne = Constants.IOSMentaOR.getProperty("One");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
							Assert.assertEquals("PASS", Constants.key.click(vObjOne));
							break;
					case "2":
							System.out.println("2");
							String vObjTwo = Constants.IOSMentaOR.getProperty("Two");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
							Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
							break;
					case "3":
							System.out.println("3");
							String vObjThree = Constants.IOSMentaOR.getProperty("Three");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
							Assert.assertEquals("PASS", Constants.key.click(vObjThree));
							break;
					case "4":
							System.out.println("4");
							String vObjFour = Constants.IOSMentaOR.getProperty("Four");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
							Assert.assertEquals("PASS", Constants.key.click(vObjFour));
							break;
					case "5":
							System.out.println("5");
							String vObjFive = Constants.IOSMentaOR.getProperty("Five");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
							Assert.assertEquals("PASS", Constants.key.click(vObjFive));
							break;
					case "6":
							System.out.println("6");
							String vObjSix = Constants.IOSMentaOR.getProperty("Six");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
							Assert.assertEquals("PASS", Constants.key.click(vObjSix));
							break;
					case "7":
							System.out.println("7");
							String vObjSeven = Constants.IOSMentaOR.getProperty("Seven");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
							Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
							break;
					case "8":
							System.out.println("8");
							String vObjEight = Constants.IOSMentaOR.getProperty("Eight");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
							Assert.assertEquals("PASS", Constants.key.click(vObjEight));
							break;
					case "9":
							System.out.println("9");
							String vObjNine = Constants.IOSMentaOR.getProperty("Nine");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
							Assert.assertEquals("PASS", Constants.key.click(vObjNine));
							break;
					case "0":
							System.out.println("0");
							String vObjZero = Constants.IOSMentaOR.getProperty("Zero");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
							Assert.assertEquals("PASS", Constants.key.click(vObjZero));
							break;
					case ".":
							System.out.println(".");
							String vObjDott = Constants.IOSMentaOR.getProperty("Dot");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
							Assert.assertEquals("PASS", Constants.key.click(vObjDott));
							break;
					default:
						System.out.println("Not a number");
		}
		}
		LogCapture.info("IOS User enters CVV successfully..." + data);
	}
	
	@When("^ios user click on (Request|Refuse|Pay back|Send|Next|CONFIRM|Back to Profile Option|CLOSE|Remove this card) button$")
	public void ios_user_click_on_Request_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Request"))
		{
			String vObjRequestBtnCA = Constants.IOSMentaOR.getProperty("RequestBtnCA");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRequestBtnCA));
			Assert.assertEquals("PASS", Constants.key.click(vObjRequestBtnCA));
			LogCapture.info("IOS User clicked on Request button...");
		}
		else if(optionValue.equalsIgnoreCase("Refuse"))
		{
			String vObjRefuseBtn = Constants.IOSMentaOR.getProperty("RefuseBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRefuseBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjRefuseBtn));
			Constants.key.pause(1000);
			LogCapture.info("IOS User clicked on Refuse button...");
		}
		else if(optionValue.equalsIgnoreCase("Pay back"))
		{
			String vObjPaybackBtn = Constants.IOSMentaOR.getProperty("PaybackBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaybackBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjPaybackBtn));
			LogCapture.info("IOS User clicked on Pay back button...");
		}
		else if(optionValue.equalsIgnoreCase("Send"))
		{
			String vObjSendBtn = Constants.IOSMentaOR.getProperty("SendBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSendBtn));
			Constants.key.pause(1000);
			LogCapture.info("IOS User clicked on Send button...");
		}
		else if(optionValue.equalsIgnoreCase("Next"))
		{
			String vObjNextBtn = Constants.IOSMentaOR.getProperty("NextBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNextBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjNextBtn));
			LogCapture.info("IOS User clicked on Next button...");
		}
		else if(optionValue.equalsIgnoreCase("CONFIRM"))
		{
			String vObjCONFIRMBtn = Constants.IOSMentaOR.getProperty("CONFIRMBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCONFIRMBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCONFIRMBtn));
			LogCapture.info("IOS User clicked on CONFIRM button...");
		}
		else if(optionValue.equalsIgnoreCase("Back to Profile Option"))
		{
			String vObjBacktoProfileOption = Constants.IOSMentaOR.getProperty("BacktoProfileOption");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBacktoProfileOption));
			Assert.assertEquals("PASS", Constants.key.click(vObjBacktoProfileOption));
			LogCapture.info("IOS User clicked on Back to Profile Option button...");
		}
		else if(optionValue.equalsIgnoreCase("CLOSE"))
		{
			String vObjCLOSEBtn = Constants.IOSMentaOR.getProperty("CLOSEBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCLOSEBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCLOSEBtn));
			LogCapture.info("IOS User clicked on CLOSE button...");
		}
		else if(optionValue.equalsIgnoreCase("Remove this card"))
		{
			String vObjRemovethiscardBtn = Constants.IOSMentaOR.getProperty("RemovethiscardBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRemovethiscardBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjRemovethiscardBtn));
			LogCapture.info("IOS User clicked on Remove this card button...");
		}
	}
	
	@When("^ios user click on Confirm button$")
	public void ios_user_click_on_Confirm_button() throws Throwable 
	{
		String vObjConfirmBtn = Constants.IOSMentaOR.getProperty("ConfirmBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirmBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjConfirmBtn));
		LogCapture.info("IOS User clicked on Confirm button...");
	}
	
	@Then("^ios user land on Money Request sent screen$")
	public void ios_user_land_on_Money_Request_sent_screen() throws Throwable 
	{
		String vObjOkBtn = Constants.IOSMentaOR.getProperty("OkBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
		LogCapture.info("IOS User is on Money Request sent successfully...");
	}
	
	@Then("^ios menta app should be closed$")
	public void ios_menta_app_should_be_closed() throws Throwable 
	{
		Constants.key.quitApp();
	}
	
	@When("^ios user enters the beneficiary email\"([^\"]*)\"$")
	public void ios_user_enters_the_beneficiary_email(String beneMail) throws Throwable 
	{
		String vBeneEmail = Constants.IOSTestData.getProperty(beneMail);
		
		String vObjBeneficiaryEmailInput = Constants.IOSMentaOR.getProperty("BeneficiaryEmailInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBeneficiaryEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBeneficiaryEmailInput, vBeneEmail));
		LogCapture.info("IOS User entered beneficiary mail successfully..."+vBeneEmail);
	}
	
	@When("^ios user enters the note\"([^\"]*)\"$")
	public void ios_user_enters_the_note(String note) throws Throwable 
	{
		String vObjAddNoteInput = Constants.IOSMentaOR.getProperty("AddNoteInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddNoteInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddNoteInput, note));
		LogCapture.info("IOS User entered note successfully...");
	}
	
	@When("^ios user click on Transactions Box$")
	public void ios_user_click_on_Transactions_Box() throws Throwable 
	{
		String vObjTransactionBoxBtn = Constants.IOSMentaOR.getProperty("TransactionBoxBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionBoxBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjTransactionBoxBtn));
		LogCapture.info("IOS User clicked on Transaction Box...");
	}
	
	@When("^ios user select the request base on note \"([^\"]*)\" and amount \"([^\"]*)\"$")
	public void ios_user_select_the_request_base_on_note_and_amount(String reqData, String reqAmt) throws Throwable 
	{
		try
		{
			String vObjRequestMsgList = Constants.IOSMentaOR.getProperty("RequestMsgList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRequestMsgList));
			
			int transactionSize = Constants.key.getElementList(vObjRequestMsgList).size();
			//System.out.println(transactionSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjRequestMsgList);
			
			for (int i = 0; i<transactionSize; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				
				if(val.equalsIgnoreCase(reqData))
				{
					String vObjRequestedAmountPayList = Constants.IOSMentaOR.getProperty("RequestedAmountPayList");										
					String vObjPayArrowBtnList = Constants.IOSMentaOR.getProperty("PayArrowBtnList");					
				
					int TransactionAmountSize = Constants.key.getElementList(vObjRequestedAmountPayList).size();
					
					List<MobileElement> lists2 = Constants.key.getElementList(vObjPayArrowBtnList);
					List<MobileElement> lists1 = Constants.key.getElementList(vObjRequestedAmountPayList);
					
					for (i = 0; i < TransactionAmountSize; i++) 
					{
						String val1 = lists1.get(i).getText();
						//System.out.println(val1);
						if (val1.equalsIgnoreCase(reqAmt))
						{
							lists2.get(i).click();
							break;
						}
					}
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		LogCapture.info("IOS User select the specified request...");
	}
	
	@When("^ios user enters the pin\"([^\"]*)\"$")
	public void ios_user_enters_the_pin(String data) throws Throwable 
	{
		String amount = data;
		// System.out.println(amount);
		String str[] = amount.split("");
		// System.out.println(str.length);

		for (int i = 0; i < str.length; i++) 
		{
			Constants.TempData = str[i];
				switch (Constants.TempData) 
				{
					case "1":
							System.out.println("1");
							String vObjOne = Constants.IOSMentaOR.getProperty("One");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
							Assert.assertEquals("PASS", Constants.key.click(vObjOne));
							break;
					case "2":
							System.out.println("2");
							String vObjTwo = Constants.IOSMentaOR.getProperty("Two");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
							Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
							break;
					case "3":
							System.out.println("3");
							String vObjThree = Constants.IOSMentaOR.getProperty("Three");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
							Assert.assertEquals("PASS", Constants.key.click(vObjThree));
							break;
					case "4":
							System.out.println("4");
							String vObjFour = Constants.IOSMentaOR.getProperty("Four");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
							Assert.assertEquals("PASS", Constants.key.click(vObjFour));
							break;
					case "5":
							System.out.println("5");
							String vObjFive = Constants.IOSMentaOR.getProperty("Five");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
							Assert.assertEquals("PASS", Constants.key.click(vObjFive));
							break;
					case "6":
							System.out.println("6");
							String vObjSix = Constants.IOSMentaOR.getProperty("Six");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
							Assert.assertEquals("PASS", Constants.key.click(vObjSix));
							break;
					case "7":
							System.out.println("7");
							String vObjSeven = Constants.IOSMentaOR.getProperty("Seven");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
							Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
							break;
					case "8":
							System.out.println("8");
							String vObjEight = Constants.IOSMentaOR.getProperty("Eight");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
							Assert.assertEquals("PASS", Constants.key.click(vObjEight));
							break;
					case "9":
							System.out.println("9");
							String vObjNine = Constants.IOSMentaOR.getProperty("Nine");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
							Assert.assertEquals("PASS", Constants.key.click(vObjNine));
							break;
					case "0":
							System.out.println("0");
							String vObjZero = Constants.IOSMentaOR.getProperty("Zero");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
							Assert.assertEquals("PASS", Constants.key.click(vObjZero));
							break;
					case ".":
							System.out.println(".");
							String vObjDott = Constants.IOSMentaOR.getProperty("Dot");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
							Assert.assertEquals("PASS", Constants.key.click(vObjDott));
							break;
					default:
						System.out.println("Not a number");
		}
		}
		LogCapture.info("IOS User enters Pin successfully..." + data);
	}
	
	@When("^ios user select the added beneficiary\"([^\"]*)\"$")
	public void ios_user_select_the_added_beneficiary(String beneEmail) throws Throwable 
	{
		try
		{
			String vObjBeneficiaryList = Constants.IOSMentaOR.getProperty("BeneficiaryList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBeneficiaryList));
			
			int BeneficiaryListSize = Constants.key.getElementList(vObjBeneficiaryList).size();
			//System.out.println(BeneficiaryListSize);
			
			String vBene = Constants.IOSTestData.getProperty(beneEmail);
			
			List<MobileElement> lists = Constants.key.getElementList(vObjBeneficiaryList);
			for(int i=0 ; i<BeneficiaryListSize ; i++)
			{
				String beneTxt = lists.get(i).getText();
				//System.out.println(beneTxt);
				if(beneTxt.equalsIgnoreCase(vBene))
				{
					lists.get(i).click();
					break;
				}
			}			
		 LogCapture.info("IOS User selected the beneficiary from the added beneficiary list...");	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^ios user click on (profile account|Privacy and Security|Linked Bank|Link Debit Card) option$")
	public void ios_user_click_on_profile_account_option(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("profile account"))
		{
			String vObjProfileOptn = Constants.IOSMentaOR.getProperty("ProfileOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjProfileOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjProfileOptn));
			LogCapture.info("IOS User clicked on Profile option...");
		}
		else if(optionValue.equalsIgnoreCase("Privacy and Security"))
		{
			String vObjPrivacyAndSecurityOptn = Constants.IOSMentaOR.getProperty("PrivacyAndSecurityOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPrivacyAndSecurityOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjPrivacyAndSecurityOptn));
			LogCapture.info("IOS User clicked on Privacy and Security option...");
		}
		else if(optionValue.equalsIgnoreCase("Linked Bank"))
		{
			String vObjLinkedBankOptn = Constants.IOSMentaOR.getProperty("LinkedBankOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLinkedBankOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLinkedBankOptn));
			LogCapture.info("IOS User clicked on Linked Bank option...");
		}
		else if(optionValue.equalsIgnoreCase("Link Debit Card"))
		{
			String vObjLinkedDebitCardOptn = Constants.IOSMentaOR.getProperty("LinkedDebitCardOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLinkedDebitCardOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLinkedDebitCardOptn));
			LogCapture.info("IOS User clicked on Link Debit Card option...");
		}
	}
	
	@Then("^ios user land on (profile account|Privacy and Security|Pin created|Money sent|Linked Bank|Cards) screen$")
	public void ios_user_land_on_profile_account_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("profile account"))
		{
			String vObjProfileScreen = Constants.IOSMentaOR.getProperty("ProfileScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjProfileScreen));
			LogCapture.info("IOS User is on Profile Account screen...");
		}
		else if(optionValue.equalsIgnoreCase("Privacy and Security"))
		{
			String vObjPrivacyAndSecurityScreen = Constants.IOSMentaOR.getProperty("PrivacyAndSecurityScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPrivacyAndSecurityScreen));
			LogCapture.info("IOS User is on Privacy and Security screen...");
		}
		else if(optionValue.equalsIgnoreCase("Pin created"))
		{
			String vObjPinCreatedScreen = Constants.IOSMentaOR.getProperty("PinCreatedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPinCreatedScreen));
			String vText = Constants.key.readText(vObjPinCreatedScreen);
			System.out.println(vText);
			LogCapture.info("IOS User is on Pin created successfully screen...");
		}
		else if(optionValue.equalsIgnoreCase("Money sent"))
		{				
			String vObjCLOSEBtn = Constants.IOSMentaOR.getProperty("CLOSEBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCLOSEBtn));
			LogCapture.info("IOS User is on Money sent screen...");
		}
		else if(optionValue.equalsIgnoreCase("Linked Bank"))
		{
			String vObjLinkedBankScreen = Constants.IOSMentaOR.getProperty("LinkedBankScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLinkedBankScreen));
			LogCapture.info("IOS User is on Linked Bank screen...");
		}
		else if(optionValue.equalsIgnoreCase("Cards"))
		{
			String vObjCardScreen = Constants.IOSMentaOR.getProperty("CardScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardScreen));
			LogCapture.info("IOS User is on Cards screen...");
		}

	}
	
	@When("^ios user click on SECURITY toggle switch$")
	public void ios_user_click_on_SECURITY_toggle_switch() throws Throwable 
	{
		String vObjSecurityToggle = Constants.IOSMentaOR.getProperty("SecurityToggle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSecurityToggle));
		Assert.assertEquals("PASS", Constants.key.click(vObjSecurityToggle));
		LogCapture.info("IOS User clicked on SECURITY toggle switch...");
	}
	
	@When("^ios user enters the confirm pin\"([^\"]*)\"$")
	public void ios_user_enters_the_confirm_pin(String data) throws Throwable 
	{
		String amount = data;
		// System.out.println(amount);
		String str[] = amount.split("");
		// System.out.println(str.length);

		for (int i = 0; i < str.length; i++) 
		{
			Constants.TempData = str[i];
				switch (Constants.TempData) 
				{
					case "1":
							System.out.println("1");
							String vObjOne = Constants.IOSMentaOR.getProperty("One");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
							Assert.assertEquals("PASS", Constants.key.click(vObjOne));
							break;
					case "2":
							System.out.println("2");
							String vObjTwo = Constants.IOSMentaOR.getProperty("Two");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
							Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
							break;
					case "3":
							System.out.println("3");
							String vObjThree = Constants.IOSMentaOR.getProperty("Three");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
							Assert.assertEquals("PASS", Constants.key.click(vObjThree));
							break;
					case "4":
							System.out.println("4");
							String vObjFour = Constants.IOSMentaOR.getProperty("Four");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
							Assert.assertEquals("PASS", Constants.key.click(vObjFour));
							break;
					case "5":
							System.out.println("5");
							String vObjFive = Constants.IOSMentaOR.getProperty("Five");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
							Assert.assertEquals("PASS", Constants.key.click(vObjFive));
							break;
					case "6":
							System.out.println("6");
							String vObjSix = Constants.IOSMentaOR.getProperty("Six");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
							Assert.assertEquals("PASS", Constants.key.click(vObjSix));
							break;
					case "7":
							System.out.println("7");
							String vObjSeven = Constants.IOSMentaOR.getProperty("Seven");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
							Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
							break;
					case "8":
							System.out.println("8");
							String vObjEight = Constants.IOSMentaOR.getProperty("Eight");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
							Assert.assertEquals("PASS", Constants.key.click(vObjEight));
							break;
					case "9":
							System.out.println("9");
							String vObjNine = Constants.IOSMentaOR.getProperty("Nine");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
							Assert.assertEquals("PASS", Constants.key.click(vObjNine));
							break;
					case "0":
							System.out.println("0");
							String vObjZero = Constants.IOSMentaOR.getProperty("Zero");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
							Assert.assertEquals("PASS", Constants.key.click(vObjZero));
							break;
					case ".":
							System.out.println(".");
							String vObjDott = Constants.IOSMentaOR.getProperty("Dot");
							Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
							Assert.assertEquals("PASS", Constants.key.click(vObjDott));
							break;
					default:
						System.out.println("Not a number");
		}
		}
		LogCapture.info("IOS User enters Confirm Pin successfully..." + data);
	}
	
	@When("^ios user selecting the card base on last four digit\"([^\"]*)\"$")
	public void ios_user_selecting_the_card_base_on_last_four_digit(String cardNo) throws Throwable 
	{
		String no = Constants.key.lastDigits(cardNo);
		//System.out.println(no);
		try
		{
			String vObjCardLists = Constants.IOSMentaOR.getProperty("CardLists");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardLists));
			
			int cardListSize = Constants.key.getElementList(vObjCardLists).size();
			//System.out.println(cardListSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjCardLists);
			
			for(int i = 0 ; i<cardListSize ; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				String actCard = Constants.key.lastDigits(val);
				//.out.println(actCard);
				if(actCard.equalsIgnoreCase(no))
				{
					lists.get(i).click();
					break;
				}
			}
			LogCapture.info("IOS User select the specified card...");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^ios user click on (Pocket Account|Create Pocket plus|Add Money) button$")
	public void ios_user_click_on_Pocket_Account_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Pocket Account"))
		{
			String vObjPocketAccountOptn = Constants.IOSMentaOR.getProperty("PocketAccountOptn");
		    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketAccountOptn));
		    Assert.assertEquals("PASS", Constants.key.click(vObjPocketAccountOptn));
		    LogCapture.info("IOS User clicked on Pocket Account button...");
		}
		else if(optionValue.equalsIgnoreCase("Create Pocket plus"))
		{
			String vObjCreatePocketBtn = Constants.IOSMentaOR.getProperty("CreatePocketBtn");
		    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCreatePocketBtn));
		    Assert.assertEquals("PASS", Constants.key.click(vObjCreatePocketBtn));
		    LogCapture.info("IOS User clicked on Create Pocket plus button...");
		}
		else if(optionValue.equalsIgnoreCase("Add Money"))
		{
			Constants.key.pause(1500);
			String vObjAddMoneyBtn = Constants.IOSMentaOR.getProperty("AddMoneyBtn");
		    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddMoneyBtn));
		    Assert.assertEquals("PASS", Constants.key.click(vObjAddMoneyBtn));
		    LogCapture.info("IOS User clicked on Add Money button...");
		}
	}
	
	@Then("^ios user land on (Pocket Account|Create Pocket|Fund your Pocket|Amount Added) screen$")
	public void ios_user_land_on_Pocket_Account_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Pocket Account"))
		{
			String vObjPocketAccountScreen = Constants.IOSMentaOR.getProperty("PocketAccountScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketAccountScreen));
			LogCapture.info("IOS User is on Pocket Account screen...");
		}
		else if(optionValue.equalsIgnoreCase("Create Pocket"))
		{
			String vObjCreateNewPocketScreen = Constants.IOSMentaOR.getProperty("CreateNewPocketScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCreateNewPocketScreen));
			LogCapture.info("IOS User is on Create Pocket screen...");
		}
		else if(optionValue.equalsIgnoreCase("Fund your Pocket"))
		{
			String vObjFundYourPocketScreen = Constants.IOSMentaOR.getProperty("FundYourPocketScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFundYourPocketScreen));
			LogCapture.info("IOS User is on Fund your Pocket screen...");
		}
		else if(optionValue.equalsIgnoreCase("Amount Added"))
		{
			String vObjGoToDashboardBtn = Constants.IOSMentaOR.getProperty("GoToDashboardBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGoToDashboardBtn));
			LogCapture.info("IOS User is on Amount Added screen...");
		}
	}
	
	@When("^ios user enter the pocket name\"([^\"]*)\"$")
	public void ios_user_enter_the_pocket_name(String pocketName) throws Throwable 
	{
		String vObjPocketNameInput = Constants.IOSMentaOR.getProperty("PocketNameInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketNameInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPocketNameInput, pocketName));
		LogCapture.info("IOS User entered Pocket Name successfully..."+pocketName);
	}
	
	@When("^ios user enters the Debit Card number\"([^\"]*)\"$")
	public void ios_user_enters_the_Debit_Card_number(String debitCardNo) throws Throwable 
	{
		String vObjDebitCardInput = Constants.IOSMentaOR.getProperty("DebitCardInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDebitCardInput, debitCardNo));
		LogCapture.info("IOS User entered Debit Card Number successfully..."+debitCardNo);
	}
	
	@When("^ios user click on Done button$")
	public void ios_user_click_on_Done_button() throws Throwable 
	{
		String vObjDoneBtn = Constants.IOSMentaOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDoneBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("IOS User click on Done button...");
	}
	
	@Then("^ios user verify newly added pocket should be displayed on the Pocket Account screen\"([^\"]*)\"$")
	public void ios_user_verify_newly_added_pocket_should_be_displayed_on_the_Pocket_Account_screen(String pocketName) throws Throwable 
	{
		try
		{
			String vObjPocketList = Constants.IOSMentaOR.getProperty("PocketList");
			
			int pocketListSize = Constants.key.getElementList(vObjPocketList).size();
			//System.out.println(cardListSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjPocketList);
			
			for(int i = 0 ; i<pocketListSize ; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				
				if(val.equalsIgnoreCase(pocketName))
				{
					Assert.assertEquals(val, pocketName);
					LogCapture.info("IOS User verify newly added Pocket...");
					break;
				}
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
