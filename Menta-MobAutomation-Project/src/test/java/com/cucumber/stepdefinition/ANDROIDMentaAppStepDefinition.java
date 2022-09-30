package com.cucumber.stepdefinition;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.appium.utility.Constants;
import com.utility.LogCapture;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class ANDROIDMentaAppStepDefinition 
{
	
//	@Given("^android menta app is installed on the device and launched successfully\"([^\"]*)\"$")
//	public void android_menta_app_is_installed_on_the_device_and_launched_successfully(String device) throws Throwable 
//	{
//		LogCapture.info(device + " Application is launching....");
//        String vBrowserName = Constants.CONFIG.getProperty("device");
//        System.out.println(vBrowserName);
//        
//        try {
//            if (!Constants.JenkinsBrowser.isEmpty() || !Constants.JenkinsBrowser.equals("")) {
//                vBrowserName = Constants.JenkinsBrowser;
//                LogCapture.info("Device ID is :" + vBrowserName);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.launchAppUsingDeviceId(vBrowserName));  
//        LogCapture.info("Device ID is :" + vBrowserName);		   
//		LogCapture.info("Menta Application installed and launched successfully......!!!!");
//	}
	
	@Given("^android menta app is installed on the device and launched successfully$")
	public void android_menta_app_is_installed_on_the_device_and_launched_successfully() throws Throwable 
	{
		String vMentaAppPackage = Constants.CONFIG.getProperty("appPackageMenta");
		String vMentaAppActivity = Constants.CONFIG.getProperty("appActivityMenta");
		
		if(Constants.CONFIG.getProperty("isLocalJenkins").equals("true"))
		{
			Thread.sleep(10000);		
	        String vDeviceID = Constants.CONFIG.getProperty("device");
	        LogCapture.info("Menta Application is launching on  device "+vDeviceID+"....");
	        //System.out.println(vBrowserName);
	        Constants.JenkinsBrowser= (Objects.equals(Constants.JenkinsBrowser, "null")) ? "" : "";
	        try {
	            if (!Constants.JenkinsBrowser.isEmpty() || !Constants.JenkinsBrowser.equals("")) {
	            	vDeviceID = Constants.JenkinsBrowser;
	                LogCapture.info("Device ID is :" + vDeviceID);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.launchAppUsingDeviceId(vDeviceID , vMentaAppPackage , vMentaAppActivity));  
	        LogCapture.info("Device ID is :" + vDeviceID);		   
			LogCapture.info("Menta Application installed and launched successfully......!!!!");
		}
		else if(Constants.CONFIG.getProperty("isBrowserstackJenkins").equals("true"))
		{
			Thread.sleep(10000);
			
			 String vDeviceID = Constants.CONFIG.getProperty("bDevice");
		        LogCapture.info("Menta Application is launching on  device "+vDeviceID+"....");
		        //System.out.println(vBrowserName);
		        //Constants.JenkinsBrowser= (Objects.equals(Constants.JenkinsBrowser, "null")) ? "" : "";
		        try {
		            if (!Constants.JenkinsBrowser.isEmpty() || !Constants.JenkinsBrowser.equals("")) {
		            	vDeviceID = Constants.JenkinsBrowser;
		                LogCapture.info("Device ID is :" + vDeviceID);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			
		        
		        String vVersion = Constants.CONFIG.getProperty("bVersion");
		        LogCapture.info("Menta Application is launching on  device version "+vVersion+"....");
		        //System.out.println(vBrowserName);
		        //Constants.BrowserStack= (Objects.equals(Constants.BrowserStack, "null")) ? "" : "";
		        try {
		            if (!Constants.BrowserStack.isEmpty() || !Constants.BrowserStack.equals("")) {
		            	vVersion = Constants.BrowserStack;
		                LogCapture.info("Device Version is :" + vVersion);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } 
			
		    
		    String rep = vDeviceID.replaceAll("-", " ");    
		    
			Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.launchAppANDROIDBrowserstack(rep , vVersion));
			LogCapture.info("Application installed and launched successfully......!!!!");
		}    
	}
	
	@When("^android user clink on the Sign in button$")
	public void android_user_clink_on_the_Sign_in_button() throws Throwable 
	{
		String vObjSignInBtn = Constants.ANDROIDMentaOR.getProperty("SignInBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSignInBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjSignInBtn));
		Constants.key.pause(1200);
		LogCapture.info("Android user clicked on Sign in button...");
	}
	
	@Then("^android user should navigate to menta login screen$")
	public void android_user_should_navigate_to_menta_login_screen() throws Throwable 
	{
		String vObjMentaLoginScreen = Constants.ANDROIDMentaOR.getProperty("MentaLoginScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMentaLoginScreen));
		LogCapture.info("Android user is on menta login screen...");
	}
	
	@When("^android user provides menta Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void android_user_provides_menta_Username_and_Password(String email, String pass) throws Throwable 
	{
		String vObjEmailInput = Constants.ANDROIDMentaOR.getProperty("EmailInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailInput));
		   
		String vObjPasswordInput = Constants.ANDROIDMentaOR.getProperty("PassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPasswordInput));
		  
		String vMentaEmail = Constants.ANDROIDTestData.getProperty(email);
		String vMentaPass = Constants.ANDROIDTestData.getProperty(pass);
		  
		//Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vMentaEmail));
		   
		//Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, vMentaPass));
		//((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		LogCapture.info("Android user entered email and password successfully...");
	}
	
	@When("^android user click on the menta login button$")
	public void android_user_click_on_the_menta_login_button() throws Throwable 
	{
		String vObjMainLoginBtn = Constants.ANDROIDMentaOR.getProperty("MainLoginBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMainLoginBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjMainLoginBtn));
		LogCapture.info("Android user clicked on Login button...");
	}
	
	@Then("^android app should load the menta dashboard screen$")
	public void android_app_should_load_the_menta_dashboard_screen() throws Throwable 
	{
		String vObjMentaDashboardScreen = Constants.ANDROIDMentaOR.getProperty("MentaDashboardScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMentaDashboardScreen));
		LogCapture.info("Android user is on menta Dashboard screen...");
	}
	
	@When("^android user click on (Pocket Account|Create Pocket plus|Pocket Submit) button$")
	public void android_user_click_on_Pocket_Account_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Pocket Account"))
		{
			String vObjPocketAccountPlus = Constants.ANDROIDMentaOR.getProperty("PocketAccountPlus");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketAccountPlus));
			Assert.assertEquals("PASS", Constants.key.click(vObjPocketAccountPlus));
			LogCapture.info("Android user clicked on Pocket Account option...");
		}
		else if(optionValue.equalsIgnoreCase("Create Pocket plus"))
		{
			String vObjCreatePocketPlusBtn = Constants.ANDROIDMentaOR.getProperty("CreatePocketPlusBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCreatePocketPlusBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCreatePocketPlusBtn));
			LogCapture.info("Android user clicked on Create Pocket plus button...");
		}
		else if(optionValue.equalsIgnoreCase("Pocket Submit"))
		{
			String vObjPocketSubmitBtn = Constants.ANDROIDMentaOR.getProperty("PocketSubmitBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketSubmitBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjPocketSubmitBtn));
			LogCapture.info("Android user clicked on Pocket Submit button...");
		}
	}
	
	@Then("^android user land on (Pocket Account|Create Pocket|Pocket Created) screen$")
	public void android_user_land_on_Pocket_Account_screen(String optionValue) throws Throwable 
	{	
		if(optionValue.equalsIgnoreCase("Pocket Account"))
		{
			String vObjPocketAccountScreen = Constants.ANDROIDMentaOR.getProperty("PocketAccountScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketAccountScreen));
			LogCapture.info("Android user is on Pocket Account screen...");
		}
		else if(optionValue.equalsIgnoreCase("Create Pocket"))
		{
			String vObjCreatePocketScreen = Constants.ANDROIDMentaOR.getProperty("CreatePocketScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCreatePocketScreen));
			LogCapture.info("Android user is on Create Pocket screen...");
		}
		else if(optionValue.equalsIgnoreCase("Pocket Created"))
		{
			String vObjPocketCreatedPopup = Constants.ANDROIDMentaOR.getProperty("PocketCreatedPopup");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketCreatedPopup));
			System.out.println(Constants.key.readText(vObjPocketCreatedPopup));
			((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
			LogCapture.info("Android user is on Pocket Created Pop-up screen...");
		}
	}
	
	@When("^android user enter the pocket name\"([^\"]*)\"$")
	public void android_user_enter_the_pocket_name(String pocketName) throws Throwable 
	{
		String vObjPocketNameInput = Constants.ANDROIDMentaOR.getProperty("PocketNameInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketNameInput));
		
		Assert.assertEquals("PASS", Constants.key.click(vObjPocketNameInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPocketNameInput, pocketName));
		((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		LogCapture.info("Android user entered Pocket Name successfully..."+pocketName);
	}
	
	@Then("^android user verify newly added pocket should be displayed on the Pocket Account screen\"([^\"]*)\"$")
	public void android_user_verify_newly_added_pocket_should_be_displayed_on_the_Pocket_Account_screen(String pockName) throws Throwable 
	{
		try
		{
			String vObjPocketsList = Constants.ANDROIDMentaOR.getProperty("PocketsList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketsList));
		
			int SizeOfPocketsList = Constants.key.getElementList(vObjPocketsList).size();
			List<MobileElement> lists = Constants.key.getElementList(vObjPocketsList);
			for(int i=0 ; i<SizeOfPocketsList ;i++)
			{
				String val = lists.get(i).getText();
				if(val.equalsIgnoreCase(pockName))
				{
					Assert.assertEquals(val, pockName);
					LogCapture.info("Android user verified newly added pocket..."); 
					break;
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	
	@When("^android user select the pocket edit option\"([^\"]*)\"$")
	public void android_user_select_the_pocket_edit_option(String data) throws Throwable 
	{
		try
		{
			String vObjPocketsList = Constants.ANDROIDMentaOR.getProperty("PocketsList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketsList));
			
			List<MobileElement> list = Constants.key.getElementList(vObjPocketsList);
			//System.out.println(list.size());
			
			String vObjEditPocketOptn = Constants.ANDROIDMentaOR.getProperty("EditPocketOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEditPocketOptn));
			
			List<MobileElement> list1 = Constants.key.getElementList(vObjEditPocketOptn);
			//System.out.println(list1.size());
			
			for(int i=0 ; i<list.size() ; i++)
			{
				String val = list.get(i).getText();
				//System.out.println(val);
		     	if(val.equalsIgnoreCase(data))
				{
					list1.get(i).click();
					LogCapture.info("Android user selected the edit pocket option...");
					break;
				}   
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	
	@When("^android user click on (Add Money|Next|Add a card|Add|card Next|Menta Checking Account|Close Pocket|Withdraw|Go To Pocket Dashboard|close cross) button$")
	public void android_user_click_on_Add_Money_button(String optionValue) throws Throwable 
	{
	    if(optionValue.equalsIgnoreCase("Add Money"))
	    {
	    	String vObjAddMoneyBtn = Constants.ANDROIDMentaOR.getProperty("AddMoneyBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddMoneyBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjAddMoneyBtn));
	    	LogCapture.info("Android user clicked on Add Money button...");
	    }
	    else if(optionValue.equalsIgnoreCase("Next"))
	    {
	    	String txt = "Next";
	    	Constants.key.scrollDownUI(txt);
	    	
	    	String vObjAmntNextBtn = Constants.ANDROIDMentaOR.getProperty("AmntNextBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAmntNextBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjAmntNextBtn));
	    	LogCapture.info("Android user clicked on Next button...");
	    }
	    else if(optionValue.equalsIgnoreCase("Add a card"))
	    {
	    	String vObjAddaCardBtn = Constants.ANDROIDMentaOR.getProperty("AddaCardBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddaCardBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjAddaCardBtn));
	    	LogCapture.info("Android user clicked on Add a card button...");
	    }
	    else if(optionValue.equalsIgnoreCase("Add"))
	    {
	    	String vObjAddBtn = Constants.ANDROIDMentaOR.getProperty("AddBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjAddBtn));
	    	LogCapture.info("Android user clicked on Add button...");
	    }
	    else if(optionValue.equalsIgnoreCase("card Next"))
	    {
	    	String vObjCardNextBtn = Constants.ANDROIDMentaOR.getProperty("CardNextBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNextBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjCardNextBtn));
	    	LogCapture.info("Android user clicked on Next button...");
	    }
	    else if(optionValue.equalsIgnoreCase("Menta Checking Account"))
	    {
	    	String vObjMentaCheckingAccBtn = Constants.ANDROIDMentaOR.getProperty("MentaCheckingAccBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMentaCheckingAccBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjMentaCheckingAccBtn));
	    	LogCapture.info("Android user clicked on Menta Checking Account button...");
	    }
	    else if(optionValue.equalsIgnoreCase("Close Pocket"))
	    {
	    	String vObjClosePocket = Constants.ANDROIDMentaOR.getProperty("ClosePocket");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjClosePocket));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjClosePocket));
	    	LogCapture.info("Android user clicked on Close Pocket button...");
	    }
	    else if(optionValue.equalsIgnoreCase("Withdraw"))
	    {
	    	String vObjWithdrawMoneyBtn = Constants.ANDROIDMentaOR.getProperty("WithdrawMoneyBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWithdrawMoneyBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjWithdrawMoneyBtn));
	    	LogCapture.info("Android user clicked on Withdraw button...");
	    }
	    else if(optionValue.equalsIgnoreCase("Go To Pocket Dashboard"))
	    {
	    	String vObjGoToPocketDashboardBtn = Constants.ANDROIDMentaOR.getProperty("GoToPocketDashboardBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGoToPocketDashboardBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjGoToPocketDashboardBtn));
	    	LogCapture.info("Android user clicked on Go To Pocket Dashboard button...");
	    }
	    else if(optionValue.equalsIgnoreCase("close cross"))
	    {
	    	String vObjClosePocketCrossBtn = Constants.ANDROIDMentaOR.getProperty("ClosePocketCrossBtn");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjClosePocketCrossBtn));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjClosePocketCrossBtn));
	    	LogCapture.info("Android user clicked on Cross Close button...");
	    }
	}
	
	@When("^android user click on Go To Pocket Dashboard withdraw button$")
	public void android_user_click_on_Go_To_Pocket_Dashboard_withdraw_button() throws Throwable 
	{
		String vObjGoToPocketDashboardWithdrawBtn = Constants.ANDROIDMentaOR.getProperty("GoToPocketDashboardWithdrawBtn");
    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGoToPocketDashboardWithdrawBtn));
    	Assert.assertEquals("PASS", Constants.key.click(vObjGoToPocketDashboardWithdrawBtn));
    	LogCapture.info("Android user clicked on Go To Pocket Dashboard button...");
	}
	
	@Then("^android user land on (add money|card created|withdraw money) screen$")
	public void android_user_land_on_add_money_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("add money"))
		{
			String vObjAddMoneyScreen = Constants.ANDROIDMentaOR.getProperty("AddMoneyScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddMoneyScreen));
			LogCapture.info("Android user is on add money keypad screen...");
		}
		else if(optionValue.equalsIgnoreCase("card created"))
		{
			String vObjCardCreatedScreen = Constants.ANDROIDMentaOR.getProperty("CardCreatedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardCreatedScreen));
			System.out.println(Constants.key.readText(vObjCardCreatedScreen));
			((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
			LogCapture.info("Android user is on Card Created screen...");
		}
		else if(optionValue.equalsIgnoreCase("withdraw money"))
		{
			String vObjAddMoneyScreen = Constants.ANDROIDMentaOR.getProperty("AddMoneyScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddMoneyScreen));
			LogCapture.info("Android user is on withdraw money keypad screen...");
		}
	}
	
	@When("^android user enters the \"([^\"]*)\"$")
	public void android_user_enters_the(String data) throws Throwable 
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
				String vObjOne = Constants.ANDROIDMentaOR.getProperty("One");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
				Assert.assertEquals("PASS", Constants.key.click(vObjOne));
				break;
			case "2":
				System.out.println("2");
				String vObjTwo = Constants.ANDROIDMentaOR.getProperty("Two");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
				Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
				break;
			case "3":
				System.out.println("3");
				String vObjThree = Constants.ANDROIDMentaOR.getProperty("Three");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
				Assert.assertEquals("PASS", Constants.key.click(vObjThree));
				break;
			case "4":
				System.out.println("4");
				String vObjFour = Constants.ANDROIDMentaOR.getProperty("Four");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
				Assert.assertEquals("PASS", Constants.key.click(vObjFour));
				break;
			case "5":
				System.out.println("5");
				String vObjFive = Constants.ANDROIDMentaOR.getProperty("Five");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
				Assert.assertEquals("PASS", Constants.key.click(vObjFive));
				break;
			case "6":
				System.out.println("6");
				String vObjSix = Constants.ANDROIDMentaOR.getProperty("Six");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
				Assert.assertEquals("PASS", Constants.key.click(vObjSix));
				break;
			case "7":
				System.out.println("7");
				String vObjSeven = Constants.ANDROIDMentaOR.getProperty("Seven");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
				Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
				break;
			case "8":
				System.out.println("8");
				String vObjEight = Constants.ANDROIDMentaOR.getProperty("Eight");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
				Assert.assertEquals("PASS", Constants.key.click(vObjEight));
				break;
			case "9":
				System.out.println("9");
				String vObjNine = Constants.ANDROIDMentaOR.getProperty("Nine");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
				Assert.assertEquals("PASS", Constants.key.click(vObjNine));
				break;
			case "0":
				System.out.println("0");
				String vObjZero = Constants.ANDROIDMentaOR.getProperty("Zero");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
				Assert.assertEquals("PASS", Constants.key.click(vObjZero));
				break;
			case ".":
				System.out.println(".");
				String vObjDott = Constants.ANDROIDMentaOR.getProperty("Dott");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
				Assert.assertEquals("PASS", Constants.key.click(vObjDott));
				break;
			default:
				System.out.println("Not a number");
			}
		}
		LogCapture.info("Amount entered successfully..." + data);
	}
	
	@Then("^android user land on Fund your pocket screen$")
	public void android_user_land_on_Fund_your_pocket_screen() throws Throwable 
	{
		String vObjFundYourPocketScreen = Constants.ANDROIDMentaOR.getProperty("FundYourPocketScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFundYourPocketScreen));
		LogCapture.info("Android user is on Fund your pocket screen...");
	}
	
	@Then("^android user land on Withdraw money into account screen$")
	public void android_user_land_on_Withdraw_money_into_account_screen() throws Throwable 
	{
		String vObjWithdrawMnyOptnsScreen = Constants.ANDROIDMentaOR.getProperty("WithdrawMnyOptnsScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWithdrawMnyOptnsScreen));
		LogCapture.info("Android user is on Withdraw money into menta account or linked account screen...");
	}
	
	@When("^android user enters the (card number|expiry date|security code|card name|Zip Code) \"([^\"]*)\"$")
	public void android_user_enters_the_card_number(String optionValue , String data) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("card number"))
		{
			String vObjCardNumberInput = Constants.ANDROIDMentaOR.getProperty("CardNumberInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNumberInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNumberInput, data));
			LogCapture.info("Android user entered Card Number successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("expiry date"))
		{
			String vObjExpiryDateInput = Constants.ANDROIDMentaOR.getProperty("ExpiryDateInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpiryDateInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpiryDateInput, data));
			LogCapture.info("Android user entered Expity Date successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("security code"))
		{
			String vObjSecurityCodeInput = Constants.ANDROIDMentaOR.getProperty("SecurityCodeInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSecurityCodeInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSecurityCodeInput, data));
			LogCapture.info("Android user entered Security Code successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("card name"))
		{
			String vObjCardNameInput = Constants.ANDROIDMentaOR.getProperty("CardNameInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNameInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNameInput, data));
			LogCapture.info("Android user entered Card Name successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Zip Code"))
		{
			String vObjZipCodeInput = Constants.ANDROIDMentaOR.getProperty("ZipCodeInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZipCodeInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjZipCodeInput, data));
			LogCapture.info("Android user entered Zip Code successfully..."+data);
		}
	}
	
	@When("^android user select the newly created card$")
	public void android_user_select_the_newly_created_card() throws Throwable 
	{
	    String vObjSelectCard = Constants.ANDROIDMentaOR.getProperty("SelectCard");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectCard));
	    Assert.assertEquals("PASS", Constants.key.click(vObjSelectCard));
	    LogCapture.info("Android user selected newly created card...");
	}
	
	@When("^android user enter the security code\"([^\"]*)\"$")
	public void android_user_enter_the_security_code(String data) throws Throwable 
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
				String vObjOne = Constants.ANDROIDMentaOR.getProperty("One");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
				Assert.assertEquals("PASS", Constants.key.click(vObjOne));
				break;
			case "2":
				System.out.println("2");
				String vObjTwo = Constants.ANDROIDMentaOR.getProperty("Two");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
				Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
				break;
			case "3":
				System.out.println("3");
				String vObjThree = Constants.ANDROIDMentaOR.getProperty("Three");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
				Assert.assertEquals("PASS", Constants.key.click(vObjThree));
				break;
			case "4":
				System.out.println("4");
				String vObjFour = Constants.ANDROIDMentaOR.getProperty("Four");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
				Assert.assertEquals("PASS", Constants.key.click(vObjFour));
				break;
			case "5":
				System.out.println("5");
				String vObjFive = Constants.ANDROIDMentaOR.getProperty("Five");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
				Assert.assertEquals("PASS", Constants.key.click(vObjFive));
				break;
			case "6":
				System.out.println("6");
				String vObjSix = Constants.ANDROIDMentaOR.getProperty("Six");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
				Assert.assertEquals("PASS", Constants.key.click(vObjSix));
				break;
			case "7":
				System.out.println("7");
				String vObjSeven = Constants.ANDROIDMentaOR.getProperty("Seven");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
				Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
				break;
			case "8":
				System.out.println("8");
				String vObjEight = Constants.ANDROIDMentaOR.getProperty("Eight");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
				Assert.assertEquals("PASS", Constants.key.click(vObjEight));
				break;
			case "9":
				System.out.println("9");
				String vObjNine = Constants.ANDROIDMentaOR.getProperty("Nine");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
				Assert.assertEquals("PASS", Constants.key.click(vObjNine));
				break;
			case "0":
				System.out.println("0");
				String vObjZero = Constants.ANDROIDMentaOR.getProperty("Zero");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
				Assert.assertEquals("PASS", Constants.key.click(vObjZero));
				break;
			case ".":
				System.out.println(".");
				String vObjDott = Constants.ANDROIDMentaOR.getProperty("Dott");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
				Assert.assertEquals("PASS", Constants.key.click(vObjDott));
				break;
			default:
				System.out.println("Not a number");
			}
		}
		LogCapture.info("Android user entered security code........." + data);
	}
	
	@When("^android user verify Pocket Balance (before|After) adding the money$")
	public void android_user_verify_Pocket_Balance_before_adding_the_money(String optionValue) throws Throwable 
	{
	    if(optionValue.equalsIgnoreCase("before"))
	    {	
	    	String vObjPocketBalance = Constants.ANDROIDMentaOR.getProperty("PocketBalance");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketBalance));
			String b = Constants.key.readText(vObjPocketBalance);
			Constants.DataMap.put("Before", b);
	    }
	    else if(optionValue.equalsIgnoreCase("After"))
	    {
	    	String vObjPocketBalance = Constants.ANDROIDMentaOR.getProperty("PocketBalance");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketBalance));
			String a = Constants.key.readText(vObjPocketBalance);
			Constants.DataMap.put("After", a);
			System.out.println("Pocket Balance Is : "+Constants.DataMap);
	    }
	}
	
	@When("^android user verify Checking Account balance (before|After) adding money into pocket$")
	public void android_user_verify_Checking_Account_balance_before_adding_money_into_pocket(String optionValue) throws Throwable 
	{
	    if(optionValue.equalsIgnoreCase("before"))
	    {
	    	Constants.key.pause(500);
	    	String vObjCheckingAccBalance = Constants.ANDROIDMentaOR.getProperty("CheckingAccBalance");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCheckingAccBalance));
			String b = Constants.key.readText(vObjCheckingAccBalance);
			Constants.DataMap.put("Before", b);
	    }
	    else if(optionValue.equalsIgnoreCase("After"))
	    {	
	    	Constants.key.pause(500);
	    	String vObjCheckingAccBalance = Constants.ANDROIDMentaOR.getProperty("CheckingAccBalance");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCheckingAccBalance));
			String a = Constants.key.readText(vObjCheckingAccBalance);
			Constants.DataMap.put("After", a);
			System.out.println("Checking Account Balance Is : "+Constants.DataMap);
	    }
	}   
	
	@When("^android user click on Back button$")
	public void android_user_click_on_Back_button() throws Throwable 
	{
		((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		Constants.key.pause(500);
	}
	
	@Then("^android user land on (Amount Added|Close Pocket confirmation) screen$")
	public void android_user_land_on_Amount_Added_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Amount Added"))
		{
			String vObjAmountAddedUsingMCAScreen = Constants.ANDROIDMentaOR.getProperty("AmountAddedUsingMCAScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAmountAddedUsingMCAScreen));
			System.out.println(Constants.key.readText(vObjAmountAddedUsingMCAScreen));
			LogCapture.info("Android user is on Amount Added screen...");
		}
		else if(optionValue.equalsIgnoreCase("Close Pocket confirmation"))
		{
			String vObjConfClosePocketScreen = Constants.ANDROIDMentaOR.getProperty("ConfClosePocketScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfClosePocketScreen));
			
			String vObjYesSureBtn = Constants.ANDROIDMentaOR.getProperty("YesSureBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjYesSureBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjYesSureBtn));
			LogCapture.info("Android user is on confirmation screen and clicked on Yes,I'm sure. button...");
		}
	}
	
	@When("^android user select the Menta Account for deposite pocket money$")
	public void android_user_select_the_Menta_Account_for_deposite_pocket_money() throws Throwable 
	{
		String vObjDepositeMentaAccountBtn = Constants.ANDROIDMentaOR.getProperty("DepositeMentaAccountBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDepositeMentaAccountBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjDepositeMentaAccountBtn));
		LogCapture.info("Android user selcted the Menta Account option...");
	}
	
	@When("^android user click on (profile account|Privacy and Security|Set Pin|Change Pin) option$")
	public void android_user_click_on_profile_account_option(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("profile account"))
		{
			String vObjProfileAccountOptn = Constants.ANDROIDMentaOR.getProperty("ProfileAccountOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjProfileAccountOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjProfileAccountOptn));
			LogCapture.info("Android user clicked on Profile Account option...");
		}
		else if(optionValue.equalsIgnoreCase("Privacy and Security"))
		{
			String vObjPrivacySecurityOptn = Constants.ANDROIDMentaOR.getProperty("Privacy&SecurityOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPrivacySecurityOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjPrivacySecurityOptn));
			LogCapture.info("Android user clicked on Privacy and Security option...");
		}
		else if(optionValue.equalsIgnoreCase("Set Pin"))
		{
			String vObjSetPinOptn = Constants.ANDROIDMentaOR.getProperty("SetPinOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSetPinOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSetPinOptn));
			LogCapture.info("Android user clicked on Set Pin option...");
		}
		else if(optionValue.equalsIgnoreCase("Change Pin"))
		{
			String vObjChangePinOptn = Constants.ANDROIDMentaOR.getProperty("ChangePinOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChangePinOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjChangePinOptn));
			LogCapture.info("Android user clicked on Change Pin option...");
		}
	}
	
	@Then("^android user land on (profile account|Privacy and Security|Pin created|Update Pocket|Pin Changed) screen$")
	public void android_user_land_on_profile_account_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("profile account"))
		{
			String vObjProfileAccountScreen = Constants.ANDROIDMentaOR.getProperty("ProfileAccountScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjProfileAccountScreen));
			LogCapture.info("Android user is on Profile Account screen...");
		}
		else if(optionValue.equalsIgnoreCase("Privacy and Security"))
		{
			String vObjPrivacySecurityScreen = Constants.ANDROIDMentaOR.getProperty("Privacy&SecurityScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPrivacySecurityScreen));
			LogCapture.info("Android user is on Privacy and Security screen...");
		}
		else if(optionValue.equalsIgnoreCase("Pin created"))
		{
			String vObjPinCreatedScreen = Constants.ANDROIDMentaOR.getProperty("PinCreatedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPinCreatedScreen));
			System.out.println(Constants.key.readText(vObjPinCreatedScreen));
			LogCapture.info("Android user is on Pin Created successfully screen...");
		}
		else if(optionValue.equalsIgnoreCase("Update Pocket"))
		{
			String vObjUpdatePocketScreen = Constants.ANDROIDMentaOR.getProperty("UpdatePocketScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdatePocketScreen));
			LogCapture.info("Android user is on Update Pocket screen...");
		}
		else if(optionValue.equalsIgnoreCase("Pin Changed"))
		{
			String vObjPinChangedScreen = Constants.ANDROIDMentaOR.getProperty("PinChangedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPinChangedScreen));
			System.out.println(Constants.key.readText(vObjPinChangedScreen));
			LogCapture.info("Android user is on Pin Changed successfully screen...");
		}
	}
	
	@When("^android user enters the (pin|confirm pin)\"([^\"]*)\"$")
	public void android_user_enters_the_pin(String optionValue , String data) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("pin"))
		{
//			String vObjSetPinInput = Constants.ANDROIDMentaOR.getProperty("SetPinInput");
//			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSetPinInput));
//			Assert.assertEquals("PASS", Constants.key.click(vObjSetPinInput));
//			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSetPinInput, pin));
//			LogCapture.info("Android user entered Pin successfully..."+pin);
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
					String vObjOne = Constants.ANDROIDMentaOR.getProperty("One");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
					Assert.assertEquals("PASS", Constants.key.click(vObjOne));
					break;
				case "2":
					System.out.println("2");
					String vObjTwo = Constants.ANDROIDMentaOR.getProperty("Two");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
					Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
					break;
				case "3":
					System.out.println("3");
					String vObjThree = Constants.ANDROIDMentaOR.getProperty("Three");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
					Assert.assertEquals("PASS", Constants.key.click(vObjThree));
					break;
				case "4":
					System.out.println("4");
					String vObjFour = Constants.ANDROIDMentaOR.getProperty("Four");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
					Assert.assertEquals("PASS", Constants.key.click(vObjFour));
					break;
				case "5":
					System.out.println("5");
					String vObjFive = Constants.ANDROIDMentaOR.getProperty("Five");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
					Assert.assertEquals("PASS", Constants.key.click(vObjFive));
					break;
				case "6":
					System.out.println("6");
					String vObjSix = Constants.ANDROIDMentaOR.getProperty("Six");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
					Assert.assertEquals("PASS", Constants.key.click(vObjSix));
					break;
				case "7":
					System.out.println("7");
					String vObjSeven = Constants.ANDROIDMentaOR.getProperty("Seven");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
					Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
					break;
				case "8":
					System.out.println("8");
					String vObjEight = Constants.ANDROIDMentaOR.getProperty("Eight");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
					Assert.assertEquals("PASS", Constants.key.click(vObjEight));
					break;
				case "9":
					System.out.println("9");
					String vObjNine = Constants.ANDROIDMentaOR.getProperty("Nine");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
					Assert.assertEquals("PASS", Constants.key.click(vObjNine));
					break;
				case "0":
					System.out.println("0");
					String vObjZero = Constants.ANDROIDMentaOR.getProperty("Zero");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
					Assert.assertEquals("PASS", Constants.key.click(vObjZero));
					break;
				case ".":
					System.out.println(".");
					String vObjDott = Constants.ANDROIDMentaOR.getProperty("Dott");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
					Assert.assertEquals("PASS", Constants.key.click(vObjDott));
					break;
				default:
					System.out.println("Not a number");
				}
			}
			LogCapture.info("Android user entered pin successfully..." + data);
		}
		else if(optionValue.equalsIgnoreCase("confirm pin"))
		{
//			String vObjSetPinInput = Constants.ANDROIDMentaOR.getProperty("SetPinInput");
//			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSetPinInput));
//			Assert.assertEquals("PASS", Constants.key.click(vObjSetPinInput));
//			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSetPinInput, pin));
//			LogCapture.info("Android user entered Confirm Pin successfully..."+pin);
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
					String vObjOne = Constants.ANDROIDMentaOR.getProperty("One");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
					Assert.assertEquals("PASS", Constants.key.click(vObjOne));
					break;
				case "2":
					System.out.println("2");
					String vObjTwo = Constants.ANDROIDMentaOR.getProperty("Two");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
					Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
					break;
				case "3":
					System.out.println("3");
					String vObjThree = Constants.ANDROIDMentaOR.getProperty("Three");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
					Assert.assertEquals("PASS", Constants.key.click(vObjThree));
					break;
				case "4":
					System.out.println("4");
					String vObjFour = Constants.ANDROIDMentaOR.getProperty("Four");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
					Assert.assertEquals("PASS", Constants.key.click(vObjFour));
					break;
				case "5":
					System.out.println("5");
					String vObjFive = Constants.ANDROIDMentaOR.getProperty("Five");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
					Assert.assertEquals("PASS", Constants.key.click(vObjFive));
					break;
				case "6":
					System.out.println("6");
					String vObjSix = Constants.ANDROIDMentaOR.getProperty("Six");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
					Assert.assertEquals("PASS", Constants.key.click(vObjSix));
					break;
				case "7":
					System.out.println("7");
					String vObjSeven = Constants.ANDROIDMentaOR.getProperty("Seven");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
					Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
					break;
				case "8":
					System.out.println("8");
					String vObjEight = Constants.ANDROIDMentaOR.getProperty("Eight");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
					Assert.assertEquals("PASS", Constants.key.click(vObjEight));
					break;
				case "9":
					System.out.println("9");
					String vObjNine = Constants.ANDROIDMentaOR.getProperty("Nine");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
					Assert.assertEquals("PASS", Constants.key.click(vObjNine));
					break;
				case "0":
					System.out.println("0");
					String vObjZero = Constants.ANDROIDMentaOR.getProperty("Zero");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
					Assert.assertEquals("PASS", Constants.key.click(vObjZero));
					break;
				case ".":
					System.out.println(".");
					String vObjDott = Constants.ANDROIDMentaOR.getProperty("Dott");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
					Assert.assertEquals("PASS", Constants.key.click(vObjDott));
					break;
				default:
					System.out.println("Not a number");
				}
			}
			LogCapture.info("Android user entered pin successfully..." + data);
		}
	}
	
	@When("^android user click on Back to Profile Options button$")
	public void android_user_click_on_Back_to_Profile_Options_button() throws Throwable 
	{
		String vObjBackToProfileOptn = Constants.ANDROIDMentaOR.getProperty("BackToProfileOptn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBackToProfileOptn));
		Assert.assertEquals("PASS", Constants.key.click(vObjBackToProfileOptn));
		LogCapture.info("Android user clicked on Back to Profile Options button...");
	}
	
	@When("^android user click on Edit Pocket name option$")
	public void android_user_click_on_Edit_Pocket_name_option() throws Throwable 
	{
		String vObjEditPocketNameOptn = Constants.ANDROIDMentaOR.getProperty("EditPocketNameOptn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEditPocketNameOptn));
		Assert.assertEquals("PASS", Constants.key.click(vObjEditPocketNameOptn));
		LogCapture.info("Android user clicked on Edit Pocket option...");
	}

	@When("^android user enters the new pocket name\"([^\"]*)\"$")
	public void android_user_enters_the_new_pocket_name(String data) throws Throwable 
	{
		String vObjEditPocketNameInput = Constants.ANDROIDMentaOR.getProperty("EditPocketNameInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEditPocketNameInput));
		//Assert.assertEquals("PASS", Constants.key.click(vObjEditPocketNameInput));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjEditPocketNameInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEditPocketNameInput, data));
		//((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		LogCapture.info("Android user entered New Pocket Name successfully..."+data);
	}
	
	@When("^android user click on Update button$")
	public void android_user_click_on_Update_button() throws Throwable 
	{
		String vObjUpdatePocketNameBtn = Constants.ANDROIDMentaOR.getProperty("UpdatePocketNameBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdatePocketNameBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjUpdatePocketNameBtn));
		LogCapture.info("Ändroid user clicked on Update button...");
	}
	
	@When("^android user verify Pocket Balance (Before|After) Sending the money$")
	public void android_user_verify_Pocket_Balance_Before_Sending_the_money(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Before"))
		{
			String vObjPocketBalance = Constants.ANDROIDMentaOR.getProperty("PocketBalance");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketBalance));
			String b = Constants.key.readText(vObjPocketBalance);
			Constants.DataMap.put("Before", b);
		}
		else if(optionValue.equalsIgnoreCase("After"))
		{
			String vObjPocketBalance = Constants.ANDROIDMentaOR.getProperty("PocketBalance");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketBalance));
			String a = Constants.key.readText(vObjPocketBalance);
			Constants.DataMap.put("After", a);
			System.out.println("Pocket Balance Is : "+Constants.DataMap);
		}
	}
	
	@When("^android user click on (Send Money|amount Send|Send|Close) button$")
	public void android_user_click_on_Send_Money_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Send Money"))
		{
			String vObjSendBtn = Constants.ANDROIDMentaOR.getProperty("SendBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSendBtn));
			LogCapture.info("Android user clicked on Send Money button...");
		}
		else if(optionValue.equalsIgnoreCase("amount Send"))
		{
			String vObjSendBtn = Constants.ANDROIDMentaOR.getProperty("SendBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSendBtn));
			LogCapture.info("Android user clicked on amount Send button...");
		}
		else if(optionValue.equalsIgnoreCase("Send"))
		{
			String vObjSendBtn = Constants.ANDROIDMentaOR.getProperty("SendBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSendBtn));
			LogCapture.info("Android user clicked on Send button...");
		}
		else if(optionValue.equalsIgnoreCase("Close"))
		{
			String vObjCloseBtn = Constants.ANDROIDMentaOR.getProperty("CloseBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCloseBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseBtn));
			LogCapture.info("Android user clicked on Close button...");
		}
	}
	
	@When("^android user enters the beneficiary email\"([^\"]*)\"$")
	public void android_user_enters_the_beneficiary_email(String beneficiary) throws Throwable 
	{
		String vObjBeneficiaryEmailInput = Constants.ANDROIDMentaOR.getProperty("BeneficiaryEmailInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBeneficiaryEmailInput));
		
		String vBene = Constants.ANDROIDTestData.getProperty(beneficiary);
		
		Assert.assertEquals("PASS", Constants.key.click(vObjBeneficiaryEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBeneficiaryEmailInput, vBene));
		((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		LogCapture.info("Android user entered Beneficiary email successfully..."+vBene);
	}
	
	@When("^android user enters the note\"([^\"]*)\"$")
	public void android_user_enters_the_note(String data) throws Throwable 
	{
	    String vObjAddNoteInput = Constants.ANDROIDMentaOR.getProperty("AddNoteInput");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddNoteInput));
	    //Assert.assertEquals("PASS", Constants.key.click(vObjAddNoteInput));
	    Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddNoteInput, data));
	    //((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
	    LogCapture.info("Android user entered Note successfully..."+data);
	}	
	
	@Then("^android user land on Money sent screen$")
	public void android_user_land_on_Money_sent_screen() throws Throwable 
	{
		String vObjMoneySentScreen = Constants.ANDROIDMentaOR.getProperty("MoneySentScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMoneySentScreen));
		System.out.println(Constants.key.readText(vObjMoneySentScreen));
		LogCapture.info("Android user is on Money Sent screen...");
	}
	
	@When("^android user select the added beneficiary\"([^\"]*)\"$")
	public void android_user_select_the_added_beneficiary(String beneEmail) throws Throwable 
	{
		try
		{
			String vObjBeneficiaryList = Constants.ANDROIDMentaOR.getProperty("BeneficiaryList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBeneficiaryList));
			
			int BeneficiaryListSize = Constants.key.getElementList(vObjBeneficiaryList).size();
			//System.out.println(BeneficiaryListSize);
			
			String vBene = Constants.ANDROIDTestData.getProperty(beneEmail);
			
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
		 LogCapture.info("Android user selected the beneficiary from the added beneficiary list...");	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^android user click on (Checking Account|ADD CASH|Cash Add) button$")
	public void android_user_click_on_Checking_Account_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Checking Account"))
		{
			String vObjCheckingAccountBtn = Constants.ANDROIDMentaOR.getProperty("CheckingAccountBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCheckingAccountBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCheckingAccountBtn));
			LogCapture.info("Android user clicked on Checking Account button...");
		}
		else if(optionValue.equalsIgnoreCase("ADD CASH"))
		{
			String vObjADDCASHBtn = Constants.ANDROIDMentaOR.getProperty("ADDCASHBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjADDCASHBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjADDCASHBtn));
			LogCapture.info("Android user clicked on ADD CASH button...");
		}
		else if(optionValue.equalsIgnoreCase("Cash Add"))
		{
			String vObjAddCashBtn = Constants.ANDROIDMentaOR.getProperty("AddCashBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCashBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddCashBtn));
			LogCapture.info("Android user clicked on Add button...");
		}
	}
	
	@Then("^android user land on Checking Account screen$")
	public void android_user_land_on_Checking_Account_screen() throws Throwable 
	{
		String vObjCheckingAccountScreen = Constants.ANDROIDMentaOR.getProperty("CheckingAccountScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCheckingAccountScreen));
		LogCapture.info("Android user is on Checking Account screen...");
	}
	
	@Then("^android user verify Checking Account balance (Before|After) adding money into Menta Account$")
	public void android_user_verify_Checking_Account_balance_Before_adding_money_into_Menta_Account(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Before"))
		{
			Constants.key.pause(500);
			String vObjCABalanceTxt = Constants.ANDROIDMentaOR.getProperty("CABalanceTxt");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCABalanceTxt));
			String b = Constants.key.readText(vObjCABalanceTxt);
			Constants.DataMap.put("Before", b);
		}
		else if(optionValue.equalsIgnoreCase("After"))
		{
			Constants.key.pause(500);
			String vObjCABalanceTxt = Constants.ANDROIDMentaOR.getProperty("CABalanceTxt");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCABalanceTxt));
			String a = Constants.key.readText(vObjCABalanceTxt);
			Constants.DataMap.put("After", a);
			System.out.println("Checking Account Balance Is : "+Constants.DataMap);
		}
	}
	
	@Then("^android user land on Amount Added into Checking Account screen$")
	public void android_user_land_on_Amount_Added_into_Checking_Account_screen() throws Throwable 
	{
		String vObjAmountAddedIntoCAScreeen = Constants.ANDROIDMentaOR.getProperty("AmountAddedIntoCAScreeen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAmountAddedIntoCAScreeen));
		System.out.println(Constants.key.readText(vObjAmountAddedIntoCAScreeen));
		LogCapture.info("Android user is on Amount Added into Checking Account screen...");
	}
	
	@When("^android user click on Request button$")
	public void android_user_click_on_Request_button() throws Throwable 
	{
		String vObjRequestBtnCA = Constants.ANDROIDMentaOR.getProperty("RequestBtnCA");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRequestBtnCA));
		Assert.assertEquals("PASS", Constants.key.click(vObjRequestBtnCA));
		LogCapture.info("Android user clicked on Request button...");
	}
	
	@Then("^android user land on Money Request sent screen$")
	public void android_user_land_on_Money_Request_sent_screen() throws Throwable 
	{
		String vObjRequestSentScreen = Constants.ANDROIDMentaOR.getProperty("RequestSentScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRequestSentScreen));
		System.out.println(Constants.key.readText(vObjRequestSentScreen));
		LogCapture.info("Android user is on Money Request sent screen...");
	}
	
	@Then("^android user verify Checking Account balance (Before|After) sending the money to Menta user or beneficiary$")
	public void android_user_verify_Checking_Account_balance_Before_sending_the_money_to_Menta_user_or_beneficiary(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Before"))
		{
			Constants.key.pause(500);
			String vObjCABalanceTxt = Constants.ANDROIDMentaOR.getProperty("CABalanceTxt");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCABalanceTxt));
			String b = Constants.key.readText(vObjCABalanceTxt);
			Constants.DataMap.put("Before", b);
		}
		else if(optionValue.equalsIgnoreCase("After"))
		{
			Constants.key.pause(500);
			String vObjCABalanceTxt = Constants.ANDROIDMentaOR.getProperty("CABalanceTxt");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCABalanceTxt));
			String a = Constants.key.readText(vObjCABalanceTxt);
			Constants.DataMap.put("After", a);
			System.out.println("Checking Account Balance Is : "+Constants.DataMap);
		}
	}
	
	@When("^android user click on Checking Account Send button$")
	public void android_user_click_on_Checking_Account_Send_button() throws Throwable 
	{
		String vObjSendBtnCA = Constants.ANDROIDMentaOR.getProperty("SendBtnCA");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtnCA));
		Assert.assertEquals("PASS", Constants.key.click(vObjSendBtnCA));
		Constants.key.pause(700);
		LogCapture.info("Android user clicked on Send button...");
	}
	
	@When("^android user click on (Menu|Account) option$")
	public void android_user_click_on_Menu_option(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Menu"))
		{
			String vObjMenuIcon = Constants.ANDROIDMentaOR.getProperty("MenuIcon");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMenuIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjMenuIcon));
			LogCapture.info("Android user clicked on Menu option...");
		}
		else if(optionValue.equalsIgnoreCase("Account"))
		{
			String vObjAccountOptn = Constants.ANDROIDMentaOR.getProperty("AccountOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountOptn));
			LogCapture.info("Android user clicked on Account option...");
		}
	}
	
	@Then("^android user land on (Account|Create new Password|Password updated|Enters password) screen$")
	public void android_user_land_on_Account_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Account"))
		{
			String vObjAccountScreen = Constants.ANDROIDMentaOR.getProperty("AccountScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountScreen));
			LogCapture.info("Android user is on Account screen...");
		}
		else if(optionValue.equalsIgnoreCase("Create new Password"))
		{
			String vObjChangePassScreen = Constants.ANDROIDMentaOR.getProperty("ChangePassScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChangePassScreen));
			LogCapture.info("Android user is on Change Password screen...");
		}
		else if(optionValue.equalsIgnoreCase("Password updated"))
		{
			String vObjPassCreatedScreen = Constants.ANDROIDMentaOR.getProperty("PassCreatedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassCreatedScreen));
			System.out.println(Constants.key.readText(vObjPassCreatedScreen));
			LogCapture.info("Android user is on Password Updated screen...");
		}
		else if(optionValue.equalsIgnoreCase("Enters password"))
		{
			String vObjEnterssPasswordScreen = Constants.ANDROIDMentaOR.getProperty("EnterssPasswordScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEnterssPasswordScreen));
			LogCapture.info("Android user is on Enter Password screen...");
		}
	}
	
	@When("^android user click on Change Password textbox$")
	public void android_user_click_on_Change_Password_textbox() throws Throwable 
	{
		String vObjChangePassTxtBox = Constants.ANDROIDMentaOR.getProperty("ChangePassTxtBox");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChangePassTxtBox));
		Assert.assertEquals("PASS", Constants.key.click(vObjChangePassTxtBox));
		LogCapture.info("Android user select Change Password textbox...");
	}
	
	@When("^android user enters the Old password\"([^\"]*)\"$")
	public void android_user_enters_the_Old_password(String oldPass) throws Throwable 
	{
		String vObjOldPassInput = Constants.ANDROIDMentaOR.getProperty("OldPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOldPassInput));
		
		String vOldPass = Constants.ANDROIDTestData.getProperty(oldPass);
		
		Assert.assertEquals("PASS", Constants.key.click(vObjOldPassInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjOldPassInput, vOldPass));
		((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		LogCapture.info("Android user entered Old password successfully..."+vOldPass);
	}
	
	@When("^android user enters the New password\"([^\"]*)\"and Confirm password\"([^\"]*)\"$")
	public void android_user_enters_the_New_password_and_Confirm_password(String newPass, String confPass) throws Throwable 
	{
		String vObjNewPassInput = Constants.ANDROIDMentaOR.getProperty("NewPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNewPassInput));
		
		String vNewPass = Constants.ANDROIDTestData.getProperty(newPass);
		
		Assert.assertEquals("PASS", Constants.key.click(vObjNewPassInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjNewPassInput, vNewPass));
		((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		LogCapture.info("Android user entered New password successfully..."+vNewPass);
		
		String vObjConfirmPassInput = Constants.ANDROIDMentaOR.getProperty("ConfirmPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirmPassInput));
		
		String vConfPass = Constants.ANDROIDTestData.getProperty(confPass);
		
		Assert.assertEquals("PASS", Constants.key.click(vObjConfirmPassInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjConfirmPassInput, vConfPass));
		((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		LogCapture.info("Android user entered Confirm password successfully..."+vConfPass);
	}
	
	@When("^android user click on (Okay|Submit Password|Finish) button$")
	public void android_user_click_on_Okay_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Okay"))
		{
			String vObjOkayBtn = Constants.ANDROIDMentaOR.getProperty("OkayBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkayBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjOkayBtn));
			LogCapture.info("Android user clicked on Okay button...");
		}
		else if(optionValue.equalsIgnoreCase("Submit Password"))
		{
			String vObjSubmitPassBtn = Constants.ANDROIDMentaOR.getProperty("SubmitPassBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSubmitPassBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSubmitPassBtn));
			LogCapture.info("Android user clicked on Submit Password button...");
		}
		else if(optionValue.equalsIgnoreCase("Finish"))
		{
			String vObjOkayBtn = Constants.ANDROIDMentaOR.getProperty("OkayBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkayBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjOkayBtn));
			LogCapture.info("Android user clicked on Finish button...");
		}
	}
	
	@When("^android user click on Forgot Password link text$")
	public void android_user_click_on_Forgot_Password_link_text() throws Throwable 
	{
		String vObjForgotPassLinkText = Constants.ANDROIDMentaOR.getProperty("ForgotPassLinkText");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotPassLinkText));
		Assert.assertEquals("PASS", Constants.key.click(vObjForgotPassLinkText));
		LogCapture.info("Android user clicked on Forgot Password link text...");
	}
	
	@Then("^android user land on (Forgot Password|enter new password|Password changed) screen$")
	public void android_user_land_on_Forgot_Password_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Forgot Password"))
		{
			String vObjForgotPassScreen = Constants.ANDROIDMentaOR.getProperty("ForgotPassScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotPassScreen));
			LogCapture.info("Android user land on Forgot Password screen...");
		}
		else if(optionValue.equalsIgnoreCase("enter new password"))
		{
			String vObjEnterPassScreen = Constants.ANDROIDMentaOR.getProperty("EnterPassScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEnterPassScreen));
			LogCapture.info("Android user land on enter new password screen...");
		}
		else if(optionValue.equalsIgnoreCase("Password changed"))
		{
			String vObjPassCreatedScreen = Constants.ANDROIDMentaOR.getProperty("PassCreatedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassCreatedScreen));
			System.out.println(Constants.key.readText(vObjPassCreatedScreen));
			LogCapture.info("Android user is on Password Changed screen...");
		}
	}
		
	@When("^android user enters the (Email address|new password)\"([^\"]*)\"$")
	public void android_user_enters_the_Email_address(String optionValue , String data) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Email address"))
		{
			String vObjResetPassEmailInput = Constants.ANDROIDMentaOR.getProperty("ResetPassEmailInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetPassEmailInput));
			
			String vEmail = Constants.ANDROIDTestData.getProperty(data);
			Assert.assertEquals("PASS", Constants.key.click(vObjResetPassEmailInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjResetPassEmailInput, vEmail));
			((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
			LogCapture.info("Android user entered Email address successfully..."+vEmail);
		}
		else if(optionValue.equalsIgnoreCase("new password"))
		{
			String vObjPassInputResetPass = Constants.ANDROIDMentaOR.getProperty("PassInputResetPass");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassInputResetPass));
			
			String vPass = Constants.ANDROIDTestData.getProperty(data);
			Assert.assertEquals("PASS", Constants.key.click(vObjPassInputResetPass));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassInputResetPass, vPass));
			((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
			LogCapture.info("Android user entered new Password successfully..."+vPass);
		}
	}
	
	@When("^android user click on Reset Password Send button$")
	public void android_user_click_on_Reset_Password_Send_button() throws Throwable 
	{
		String vObjSendBtnResetPass = Constants.ANDROIDMentaOR.getProperty("SendBtnResetPass");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtnResetPass));
		Assert.assertEquals("PASS", Constants.key.click(vObjSendBtnResetPass));
		LogCapture.info("Android user clicked on Send button...");
	}
	
	@When("^android user select the Menta Spending Card$")
	public void android_user_select_the_Menta_Spending_Card() throws Throwable 
	{
		String vObjMentaSpendCard = Constants.ANDROIDMentaOR.getProperty("MentaSpendCard");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMentaSpendCard));
		Assert.assertEquals("PASS", Constants.key.click(vObjMentaSpendCard));
		LogCapture.info("Android user selects the Menta Spending Card...");
	}

	@When("^android user land on (Menta Spending Card|Card Ordered) screen$")
	public void android_user_land_on_Menta_Spending_Card_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Menta Spending Card"))
		{
			String vObjMentaSPendCardScreen = Constants.ANDROIDMentaOR.getProperty("MentaSPendCardScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMentaSPendCardScreen));
			LogCapture.info("Android user land on Menta Spending Card screen...");
		}		
		else if(optionValue.equalsIgnoreCase("Card Ordered"))
		{
			String vObjCardOrderedSuccess = Constants.ANDROIDMentaOR.getProperty("CardOrderedSuccess");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardOrderedSuccess));
			System.out.println(Constants.key.readText(vObjCardOrderedSuccess));
			LogCapture.info("Android user land on Card Ordered successfully screen...");
		}
	}

	@When("^android user select the (Order A Card|Card Settings|Replace Card|Add Vitual Card) option$")
	public void android_user_select_the_Order_A_Card_option(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Order A Card"))
		{
			String vObjOrderACardOptn = Constants.ANDROIDMentaOR.getProperty("OrderACardOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOrderACardOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjOrderACardOptn));
			LogCapture.info("Android user selects the Order A Card option...");
		}		
		else if(optionValue.equalsIgnoreCase("Card Settings"))
		{
			String vObjCardSettingsOptn = Constants.ANDROIDMentaOR.getProperty("CardSettingsOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardSettingsOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCardSettingsOptn));
			LogCapture.info("Android user selects the Card Settings option...");
		}
		else if(optionValue.equalsIgnoreCase("Replace Card"))
		{
			String vObjReplaceCardOptn = Constants.ANDROIDMentaOR.getProperty("ReplaceCardOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReplaceCardOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjReplaceCardOptn));
			LogCapture.info("Android user selects the Replace Card option...");
		}
		else if(optionValue.equalsIgnoreCase("Add Vitual Card"))
		{
			String vObjAddVirtualCardOptn = Constants.ANDROIDMentaOR.getProperty("AddVirtualCardOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddVirtualCardOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddVirtualCardOptn));
			LogCapture.info("Android user selects the Add Vitual Card option...");
		}
	}
	
	@When("^android user click on (Yes|Go to Checking Dashboard|Lost Card|Loss|Block|Confirm|Apply|Refuse|PayBack) button$")
	public void android_user_click_on_Yes_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Yes"))
		{
			String vObjYesBtnPhysicalCard = Constants.ANDROIDMentaOR.getProperty("YesBtnPhysicalCard");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjYesBtnPhysicalCard));
			Assert.assertEquals("PASS", Constants.key.click(vObjYesBtnPhysicalCard));
			LogCapture.info("Android user clicked on Yes button...");
		}
		else if(optionValue.equalsIgnoreCase("Go to Checking Dashboard"))
		{
			String vObjGoToCheckingDashBtn = Constants.ANDROIDMentaOR.getProperty("GoToCheckingDashBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGoToCheckingDashBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjGoToCheckingDashBtn));
			LogCapture.info("Android user clicked on Go to Checking Dashboard button...");
		}
		else if(optionValue.equalsIgnoreCase("Lost Card"))
		{
			String vObjLostCardBtn = Constants.ANDROIDMentaOR.getProperty("LostCardBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLostCardBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLostCardBtn));
			LogCapture.info("Android user clicked on Lost Card button...");
		}
		else if(optionValue.equalsIgnoreCase("Loss"))
		{
			String vObjLossBtn = Constants.ANDROIDMentaOR.getProperty("LossBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLossBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLossBtn));
			LogCapture.info("Android user clicked on Loss button...");
		}
		else if(optionValue.equalsIgnoreCase("Block"))
		{
			String vObjBlockBtn = Constants.ANDROIDMentaOR.getProperty("BlockBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBlockBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjBlockBtn));
			LogCapture.info("Android user clicked on Block button...");
		}
		else if(optionValue.equalsIgnoreCase("Confirm"))
		{
			String vObjConfirmBtn = Constants.ANDROIDMentaOR.getProperty("ConfirmBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirmBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjConfirmBtn));
			LogCapture.info("Android user clicked on Confirm button...");
		}
		else if(optionValue.equalsIgnoreCase("Apply"))
		{
			String vObjApplyBtn = Constants.ANDROIDMentaOR.getProperty("ApplyBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjApplyBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjApplyBtn));
			LogCapture.info("Android user clicked on Apply button...");
		}
		else if(optionValue.equalsIgnoreCase("Refuse"))
		{
			String vObjRefuseBtn = Constants.ANDROIDMentaOR.getProperty("RefuseBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRefuseBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjRefuseBtn));
			Constants.key.pause(700);
			LogCapture.info("Android user clicked on Refuse button...");
		}
		else if(optionValue.equalsIgnoreCase("PayBack"))
		{
			String vObjPaybackBtn = Constants.ANDROIDMentaOR.getProperty("PaybackBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaybackBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjPaybackBtn));			
			LogCapture.info("Android user clicked on Payback button...");
		}
	}
	
	@Then("^android user land on (Block Card|Card Blocked|Card Settings|Card Replaced|Virtual Card Created|Transactions|Payment accept) screen$")
	public void android_user_land_on_Block_Card_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Block Card"))
		{
			String vObjBlockCardScreen = Constants.ANDROIDMentaOR.getProperty("BlockCardScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBlockCardScreen));
			LogCapture.info("Android user land on Block Card screen...");
		}
		else if(optionValue.equalsIgnoreCase("Card Blocked"))
		{
			String vObjCardBlockedScreen = Constants.ANDROIDMentaOR.getProperty("CardBlockedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardBlockedScreen));
			System.out.println(Constants.key.readText(vObjCardBlockedScreen));
			Assert.assertEquals("PASS", Constants.key.click(vObjCardBlockedScreen));
			LogCapture.info("Android user land on Card Blocked successfully screen...");
		}
		else if(optionValue.equalsIgnoreCase("Card Settings"))
		{
			String vObjCardSettingsScreen = Constants.ANDROIDMentaOR.getProperty("CardSettingsScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardSettingsScreen));
			LogCapture.info("Android user land on Card Settings screen...");
		}
		else if(optionValue.equalsIgnoreCase("Card Replaced"))
		{
			String vObjCardReplacedScreen = Constants.ANDROIDMentaOR.getProperty("CardReplacedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardReplacedScreen));
			System.out.println(Constants.key.readText(vObjCardReplacedScreen));
			Assert.assertEquals("PASS", Constants.key.click(vObjCardReplacedScreen));
			LogCapture.info("Android user land on Card Replaced successfully screen...");
		}
		else if(optionValue.equalsIgnoreCase("Virtual Card Created"))
		{
			String vObjVCCreatedScreen = Constants.ANDROIDMentaOR.getProperty("VCCreatedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjVCCreatedScreen));
			System.out.println(Constants.key.readText(vObjVCCreatedScreen));
			Assert.assertEquals("PASS", Constants.key.click(vObjVCCreatedScreen));
			LogCapture.info("Android user land on Virtual Card Created successfully screen...");
		}
		else if(optionValue.equalsIgnoreCase("Transactions"))
		{
			String vObjTransactionsScreen = Constants.ANDROIDMentaOR.getProperty("TransactionsScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionsScreen));
			LogCapture.info("Android user land on Transactions screen...");
		}
		else if(optionValue.equalsIgnoreCase("Payment accept"))
		{
			String vObjPaymentSuccessScreen = Constants.ANDROIDMentaOR.getProperty("PaymentSuccessScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentSuccessScreen));
			System.out.println(Constants.key.readText(vObjPaymentSuccessScreen));
			LogCapture.info("Android user land on Payment accept screen...");
		}
	}
	
	@When("^android user select the existing card$")
	public void android_user_select_the_existing_card() throws Throwable 
	{
		String vObjSelectExistingCard = Constants.ANDROIDMentaOR.getProperty("SelectExistingCard");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectExistingCard));
		Assert.assertEquals("PASS", Constants.key.click(vObjSelectExistingCard));
		LogCapture.info("Android user selected the Card...");
	}
	
	@When("^android user click on (Online Payment|ATM Withdrawal) option$")
	public void android_user_click_on_Online_Payment_option(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Online Payment"))
		{
			String vObjOnlinePaymentOptn = Constants.ANDROIDMentaOR.getProperty("OnlinePaymentOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOnlinePaymentOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjOnlinePaymentOptn));
			LogCapture.info("Android user selects the Online Payment toggle switch...");
		}
		else if(optionValue.equalsIgnoreCase("ATM Withdrawal"))
		{
			String vObjATMWithdrawalOptn = Constants.ANDROIDMentaOR.getProperty("ATMWithdrawalOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjATMWithdrawalOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjATMWithdrawalOptn));
			LogCapture.info("Android user selects the ATM Withdrawal toggle switch...");
		}
	}
	
	@When("^android user land on Card Settings changes apply screen$")
	public void android_user_land_on_Card_Settings_changes_apply_screen() throws Throwable 
	{
		String vObjCSChangesApply = Constants.ANDROIDMentaOR.getProperty("CSChangesApply");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCSChangesApply));
		System.out.println(Constants.key.readText(vObjCSChangesApply));
		Assert.assertEquals("PASS", Constants.key.click(vObjCSChangesApply));
		LogCapture.info("Android user land on card settings changes apply screen...");
	}
	
	@Then("^android menta app should be closed$")
	public void android_menta_app_should_be_closed() throws Throwable 
	{
		Constants.key.quitApp();
		LogCapture.info("Android app is closed...");
	}
	
	@When("^android user click on Transactions Box$")
	public void android_user_click_on_Transactions_Box() throws Throwable 
	{
		String vObjTransactionsBox = Constants.ANDROIDMentaOR.getProperty("TransactionsBox");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionsBox));
		Assert.assertEquals("PASS", Constants.key.click(vObjTransactionsBox));
		LogCapture.info("Android user clicked on Transactions Box...");
	}
	
	@Then("^android user select the request base on note \"([^\"]*)\" and amount \"([^\"]*)\"$")
	public void android_user_select_the_request_base_on_note_and_amount(String reqData, String reqAmt) throws Throwable 
	{
		try
		{
			String vObjTransactionsList = Constants.ANDROIDMentaOR.getProperty("TransactionsList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionsList));
		
			int transactionSize = Constants.key.getElementList(vObjTransactionsList).size();
			//System.out.println(transactionSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjTransactionsList);
			for (int i = 0; i < transactionSize; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if (val.equalsIgnoreCase(reqData))
				{
					String vObjTransactionsAmountList = Constants.ANDROIDMentaOR.getProperty("TransactionsAmountList");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionsAmountList));
					
					String vObjTransactionsApproveBtnList = Constants.ANDROIDMentaOR.getProperty("TransactionsApproveBtnList");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionsApproveBtnList));
				
					int TransactionAmountSize = Constants.key.getElementList(vObjTransactionsAmountList).size();
					
					List<MobileElement> lists2 = Constants.key.getElementList(vObjTransactionsApproveBtnList);
					List<MobileElement> lists1 = Constants.key.getElementList(vObjTransactionsAmountList);
					for (int j = 0; j < TransactionAmountSize; j++) 
					{
						String val1 = lists1.get(j).getText();
						//System.out.println(val1);
						if (val1.equalsIgnoreCase(reqAmt))
						{
							lists2.get(j).click();
							break;
						}
					}
				}
			}
			LogCapture.info("Android user select the specified request...");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	@When("^android user click on (Linked Banks|Link Debit Card) option$")
	public void android_user_click_on_Linked_Banks_option(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Linked Banks"))
		{
			String vObjLinkedBanksOptn = Constants.ANDROIDMentaOR.getProperty("LinkedBanksOptn");
		    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLinkedBanksOptn));
		    Assert.assertEquals("PASS", Constants.key.click(vObjLinkedBanksOptn));
		    LogCapture.info("Android user clicked on Linked Banks option...");
		}	    
	    else if(optionValue.equalsIgnoreCase("Link Debit Card"))
	    {
	    	String vObjLinkDebitCardOptn = Constants.ANDROIDMentaOR.getProperty("LinkDebitCardOptn");
		    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLinkDebitCardOptn));
		    Assert.assertEquals("PASS", Constants.key.click(vObjLinkDebitCardOptn));
		    LogCapture.info("Android user clicked on Link Debit Card option...");
	    }
	}
	
	@Then("^android user land on (Linked Banks|Cards|Card deleted) screen$")
	public void android_user_land_on_Linked_Banks_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Linked Banks"))
		{
			String vObjLinkedBankScreen = Constants.ANDROIDMentaOR.getProperty("LinkedBankScreen");
		    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLinkedBankScreen));
		    LogCapture.info("Android user land on Linked Banks screen...");
		}
		else if(optionValue.equalsIgnoreCase("Cards"))
		{
			String vObjCardsScreen = Constants.ANDROIDMentaOR.getProperty("CardsScreen");
		    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardsScreen));
		    LogCapture.info("Android user land on Cards screen...");
		}
		else if(optionValue.equalsIgnoreCase("Card deleted"))
		{
			String vObjCardDeletedScreen = Constants.ANDROIDMentaOR.getProperty("CardDeletedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardDeletedScreen));
			System.out.println(Constants.key.readText(vObjCardDeletedScreen));
			((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
			LogCapture.info("Android user land on Card Deleted screen...");
		}
	}
	
	@When("^android user selecting the card \"([^\"]*)\"$")
	public void android_user_selecting_the_card(String cardName) throws Throwable 
	{
		try
		{
			String vObjCardNameList = Constants.ANDROIDMentaOR.getProperty("CardNameList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNameList));
			
			List<MobileElement> list = Constants.key.getElementList(vObjCardNameList);
			//System.out.println(list.size());
			
			String vObjSelectCardList = Constants.ANDROIDMentaOR.getProperty("SelectCardList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectCardList));
			List<MobileElement> list1 = Constants.key.getElementList(vObjSelectCardList);
			//System.out.println(list1.size());
			
			for(int i=0 ; i<list.size() ; i++)
			{
				String val = list.get(i).getText();
				//System.out.println(val);
				if(val.equalsIgnoreCase(cardName))
				{
					list1.get(i).click();
					break;
				}
			}
			LogCapture.info("Android user selected the specified card...");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^android user click on Remove Card button$")
	public void android_user_click_on_Remove_Card_button() throws Throwable 
	{
		String vObjRemoveCardBtn = Constants.ANDROIDMentaOR.getProperty("RemoveCardBtn");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRemoveCardBtn));
	    Assert.assertEquals("PASS", Constants.key.click(vObjRemoveCardBtn));
	    LogCapture.info("Android user clicked on Remove Card button...");
	}
	
	@When("^android user click on (Apply new loan|Loan Next|Accept Contract|Agreement Next|Fee Accept|Make Payment) button$")
	public void android_user_click_on_LOANS_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Apply new loan"))
		{
			String vObjApplyNewLoanBtn = Constants.ANDROIDMentaOR.getProperty("ApplyNewLoanBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjApplyNewLoanBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjApplyNewLoanBtn));
			LogCapture.info("Android user clicked on Apply new loan button...");
		}
		else if(optionValue.equalsIgnoreCase("Loan Next"))
		{
			String vObjLoanNextBtn = Constants.ANDROIDMentaOR.getProperty("LoanNextBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoanNextBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLoanNextBtn));
			LogCapture.info("Android user clicked on Next button...");
		}
		else if(optionValue.equalsIgnoreCase("Accept Contract"))
		{		
			String vObjTermAndConditionScreen = Constants.ANDROIDMentaOR.getProperty("TermAndConditionScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTermAndConditionScreen));
			
			String vObjAcceptBtn = Constants.ANDROIDMentaOR.getProperty("AcceptBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAcceptBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAcceptBtn));
			LogCapture.info("Android user clicked on Accept Contract button...");
		}
		else if(optionValue.equalsIgnoreCase("Agreement Next"))
		{
			String vObjAgreementNextBtn = Constants.ANDROIDMentaOR.getProperty("AgreementNextBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAgreementNextBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAgreementNextBtn));
			LogCapture.info("Android user clicked on Next button...");
		}
		else if(optionValue.equalsIgnoreCase("Fee Accept"))
		{
			String vObjFeeAcceptBtn = Constants.ANDROIDMentaOR.getProperty("FeeAcceptBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFeeAcceptBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjFeeAcceptBtn));
			LogCapture.info("Android user clicked on I Accept button...");
		}
		else if(optionValue.equalsIgnoreCase("Make Payment"))
		{
			String vObjMakePaymentBtn = Constants.ANDROIDMentaOR.getProperty("MakePaymentBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMakePaymentBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjMakePaymentBtn));
			LogCapture.info("Android user clicked on Make Payment button...");
		}
	}
	
	@Then("^android user land on Loan Agreement screen$")
	public void android_user_land_on_Loan_Agreement_screen() throws Throwable 
	{	
		String vObjAgreementScreen = Constants.ANDROIDMentaOR.getProperty("AgreementScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAgreementScreen));
		LogCapture.info("Android user land on Loan Agreement screen...");
	}
	
	@Then("^android user land on Loan Dashboard screen$")
	public void android_user_land_on_Loan_Dashboard_screen() throws Throwable 
	{
		String vObjLoanDashboardScreen = Constants.ANDROIDMentaOR.getProperty("LoanDashboardScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoanDashboardScreen));
		LogCapture.info("Android user land on Loan Dashboard screen...");
	}
	
	@When("^android user select the loan amount from dropdown\"([^\"]*)\"$")
	public void android_user_select_the_loan_amount_from_dropdown(String loanAmount) throws Throwable 
	{
	    try
	    {
	    	String vObjSelectAmtDropDown = Constants.ANDROIDMentaOR.getProperty("SelectAmtDropDown");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectAmtDropDown));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjSelectAmtDropDown));
	    	
	    	String vObjLoanAmountList = Constants.ANDROIDMentaOR.getProperty("LoanAmountList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoanAmountList));
			
			int LoanAmtList = Constants.key.getElementList(vObjLoanAmountList).size();
			System.out.println(LoanAmtList);
			
			List<MobileElement> lists = Constants.key.getElementList(vObjLoanAmountList);
			for(int i=0 ; i<LoanAmtList ; i++)
			{
				String amntTxt = lists.get(i).getText();
				System.out.println(amntTxt);
				if(amntTxt.equalsIgnoreCase(loanAmount))
				{
					lists.get(i).click();
					break;
				}
			}			
	    	LogCapture.info("Android user selected the loan amount..."+loanAmount);
	    }
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}
	}
	
	@When("^android user select the loan tenure\"([^\"]*)\"$")
	public void android_user_select_the_loan_tenure(String loanTenure) throws Throwable 
	{
		try
	    {
	    	String vObjSelectTenureDropDown = Constants.ANDROIDMentaOR.getProperty("SelectTenureDropDown");
	    	Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectTenureDropDown));
	    	Assert.assertEquals("PASS", Constants.key.click(vObjSelectTenureDropDown));
	    	
	    	String vObjTenureList = Constants.ANDROIDMentaOR.getProperty("TenureList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTenureList));
			
			int Tenure = Constants.key.getElementList(vObjTenureList).size();
			System.out.println(Tenure);
			
			List<MobileElement> lists = Constants.key.getElementList(vObjTenureList);
			for(int i=0 ; i<Tenure ; i++)
			{
				String tenureTxt = lists.get(i).getText();
				System.out.println(tenureTxt);
				if(tenureTxt.equalsIgnoreCase(loanTenure))
				{
					lists.get(i).click();
					break;
				}
			}			
	    	LogCapture.info("Android user selected the Tenure..."+loanTenure);
	    }
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}
	}
	
	@When("^android user selects Terms and Condition checkbox$")
	public void android_user_selects_Terms_and_Condition_checkbox() throws Throwable 
	{
		String vObjTermsConditionCheckbox = Constants.ANDROIDMentaOR.getProperty("TermsConditionCheckbox");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTermsConditionCheckbox));
		Assert.assertEquals("PASS", Constants.key.click(vObjTermsConditionCheckbox));
		LogCapture.info("Android user select the Terms and Condition checkbox...");
		//Constants.key.pause(15000);
	}
	
	@When("^android user select the newly created loan using Loan Name\"([^\"]*)\" and Tenure\"([^\"]*)\" and PaymentMethod \"([^\"]*)\" and code\"([^\"]*)\"$")
	public void android_user_select_the_newly_created_loan_using_Loan_Name_and_Tenure_and_PaymentMethod_and_code(String loanName, String loanTenure, String paymentMethod , String code) throws Throwable 
	{
		int loanInt=Integer.parseInt(loanTenure);  		
		try
		{
			for(int i=1 ; i<loanInt ; i++)
			{
				String vObjEMIPayAmountTxt = Constants.ANDROIDMentaOR.getProperty("EMIPayAmountTxt");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEMIPayAmountTxt));
				String vEmiAmount = Constants.key.readText(vObjEMIPayAmountTxt);
				System.out.println(vEmiAmount);		
				String actualEmi = vEmiAmount.substring(2, vEmiAmount.length());
				Constants.DataMap.put("EMIAmnt", actualEmi);
				
				String vObjLoanList = Constants.ANDROIDMentaOR.getProperty("LoanList");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoanList));
				
				String vObjLoanNameList = Constants.ANDROIDMentaOR.getProperty("LoanNameList");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoanNameList));				
				int LoanName = Constants.key.getElementList(vObjLoanNameList).size();
				System.out.println(LoanName);
				
				String vObjSelectLoanList = Constants.ANDROIDMentaOR.getProperty("SelectLoanList");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectLoanList));
				List<MobileElement> lists = Constants.key.getElementList(vObjSelectLoanList);
				
				for(int j=0 ; j<LoanName ; j++)
				{
					String val = lists.get(j).getText();
					System.out.println(val);
					
					if(val.equalsIgnoreCase(loanName))
					{
						lists.get(i).click();
						break;
					}
				}
				
				android_user_click_on_EMI_Make_Payment_button();
				android_user_enters_the_EMI_Amount();
				android_user_click_on_EMI_Amount_Next_button();
				android_user_select_the_Payment_Method_for_EMI(paymentMethod);
				android_user_click_on_Make_Payment_Okay_button();
				android_user_enter_the_security_code(code);
				android_user_click_on_Pay_button();
				android_user_click_on_Go_To_Dashboard_button();
				android_app_should_load_the_menta_dashboard_screen();
				android_user_click_on_LOANS_button();
				android_user_land_on_Loan_Dashboard_screen();
				//android_user_select_the_newly_created_loan_using_Loan_Name_and_Tenure_and_PaymentMethod_and_code(loanName,loanTenure,paymentMethod,code);
			}
			LogCapture.info("Android user selected the loan using loan name..."+loanName);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	@When("^android user click on EMI Make Payment button$")
	public void android_user_click_on_EMI_Make_Payment_button() throws Throwable 
	{
		String vObjEMIMakePaymentBtn = Constants.ANDROIDMentaOR.getProperty("EMIMakePaymentBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEMIMakePaymentBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjEMIMakePaymentBtn));
		LogCapture.info("Android user clicked on Make Payment button...");
	}
	
	@When("^android user enters the EMI Amount$")
	public void android_user_enters_the_EMI_Amount() throws Throwable 
	{
		
		
		String amount = Constants.DataMap.get("EMIAmnt");
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
				String vObjOne = Constants.ANDROIDMentaOR.getProperty("One");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
				Assert.assertEquals("PASS", Constants.key.click(vObjOne));
				break;
			case "2":
				System.out.println("2");
				String vObjTwo = Constants.ANDROIDMentaOR.getProperty("Two");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
				Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
				break;
			case "3":
				System.out.println("3");
				String vObjThree = Constants.ANDROIDMentaOR.getProperty("Three");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
				Assert.assertEquals("PASS", Constants.key.click(vObjThree));
				break;
			case "4":
				System.out.println("4");
				String vObjFour = Constants.ANDROIDMentaOR.getProperty("Four");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
				Assert.assertEquals("PASS", Constants.key.click(vObjFour));
				break;
			case "5":
				System.out.println("5");
				String vObjFive = Constants.ANDROIDMentaOR.getProperty("Five");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
				Assert.assertEquals("PASS", Constants.key.click(vObjFive));
				break;
			case "6":
				System.out.println("6");
				String vObjSix = Constants.ANDROIDMentaOR.getProperty("Six");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
				Assert.assertEquals("PASS", Constants.key.click(vObjSix));
				break;
			case "7":
				System.out.println("7");
				String vObjSeven = Constants.ANDROIDMentaOR.getProperty("Seven");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
				Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
				break;
			case "8":
				System.out.println("8");
				String vObjEight = Constants.ANDROIDMentaOR.getProperty("Eight");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
				Assert.assertEquals("PASS", Constants.key.click(vObjEight));
				break;
			case "9":
				System.out.println("9");
				String vObjNine = Constants.ANDROIDMentaOR.getProperty("Nine");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
				Assert.assertEquals("PASS", Constants.key.click(vObjNine));
				break;
			case "0":
				System.out.println("0");
				String vObjZero = Constants.ANDROIDMentaOR.getProperty("Zero");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
				Assert.assertEquals("PASS", Constants.key.click(vObjZero));
				break;
			case ".":
				System.out.println(".");
				String vObjDott = Constants.ANDROIDMentaOR.getProperty("Dott");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
				Assert.assertEquals("PASS", Constants.key.click(vObjDott));
				break;
			default:
				System.out.println("Not a number");
			}
		}
		LogCapture.info("Amount entered successfully..." + amount);
	}
	
	@When("^android user select the Payment Method for EMI\"([^\"]*)\"$")
	public void android_user_select_the_Payment_Method_for_EMI(String paymentMethod) throws Throwable 
	{
		try
	    {
			String vObjPaymentMethod = Constants.ANDROIDMentaOR.getProperty("PaymentMethod");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethod));
			Assert.assertEquals("PASS", Constants.key.click(vObjPaymentMethod));
	    	
	    	String vObjPaymentMethodList = Constants.ANDROIDMentaOR.getProperty("PaymentMethodList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethodList));
			
			int payMethod = Constants.key.getElementList(vObjPaymentMethodList).size();
			System.out.println(payMethod);
			
			List<MobileElement> lists = Constants.key.getElementList(vObjPaymentMethodList);
			for(int i=0 ; i<payMethod ; i++)
			{
				String methodTxt = lists.get(i).getText();
				System.out.println(methodTxt);
				if(methodTxt.equalsIgnoreCase(paymentMethod))
				{
					lists.get(i).click();
					break;
				}
			}			
	    	LogCapture.info("Android user selected the payment method as a..."+paymentMethod);
	    }
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}		
	}
	
	@When("^android user click on EMI Amount Next button$")
	public void android_user_click_on_EMI_Amount_Next_button() throws Throwable 
	{
		String vObjNextBtnEMIAmnt = Constants.ANDROIDMentaOR.getProperty("NextBtnEMIAmnt");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNextBtnEMIAmnt));
		Assert.assertEquals("PASS", Constants.key.click(vObjNextBtnEMIAmnt));
		LogCapture.info("Android user clicked on Make Payment button...");
	}
	
	@When("^android user click on Make Payment Okay button$")
	public void android_user_click_on_Make_Payment_Okay_button() throws Throwable 
	{
		String vObjOkayMakePaymentBtn = Constants.ANDROIDMentaOR.getProperty("OkayMakePaymentBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkayMakePaymentBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjOkayMakePaymentBtn));
		LogCapture.info("Android user clicked on Okay button...");
	}
	
	@Then("^Loan Closed button should be displayed on android app$")
	public void loan_Closed_button_should_be_displayed_on_android_app() throws Throwable 
	{
		String vObjCloseLoanBtn = Constants.ANDROIDMentaOR.getProperty("CloseLoanBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCloseLoanBtn));
		LogCapture.info("Loan Closed button is displayed on android app...");
	}
	
	@When("^android user click on Pay button$")
	public void android_user_click_on_Pay_button() throws Throwable 
	{
		String vObjPayBtn = Constants.ANDROIDMentaOR.getProperty("PayBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPayBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjPayBtn));
		LogCapture.info("Android user clicked on Pay button...");
	}
	
	@When("^android user click on Go To Dashboard button$")
	public void android_user_click_on_Go_To_Dashboard_button() throws Throwable 
	{
	    String vObjGoToDashboardBtn = Constants.ANDROIDMentaOR.getProperty("GoToDashboardBtn");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGoToDashboardBtn));
	    Assert.assertEquals("PASS", Constants.key.click(vObjGoToDashboardBtn));
	    Constants.key.pause(500);
	    LogCapture.info("Android user clicked on Go To Dashboard button...");	    
	}
	
	@When("^android user click on LOANS button$")
	public void android_user_click_on_LOANS_button() throws Throwable 
	{
		String vObjLOANSBtn = Constants.ANDROIDMentaOR.getProperty("LOANSBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLOANSBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjLOANSBtn));
		LogCapture.info("Android user clicked on LOANS button...");	
	}
	
	/*   Registration Code    */
	@When("^android user click on the Sign Up button$")
	public void android_user_click_on_the_Sign_Up_button() throws Throwable 
	{
		String vObjSignUpBtn = Constants.ANDROIDMentaOR.getProperty("SignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSignUpBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjSignUpBtn));
		LogCapture.info("Android user clicked on Sign Up button...");
	}
	
	@When("^android user register the users depends on\"([^\"]*)\"and\"([^\"]*)\"$")
	public void android_user_register_the_users_depends_on_and(String regCount, String regPass) throws Throwable 
	{
		int rc = Integer.parseInt(regCount); 
		//System.out.println(regCount);
		
		for(int i=1 ; i<rc ; i++)
		{
			android_user_enter_the_registration_email_address();			
			android_user_enter_the_registration_password(regPass);
			android_user_enter_the_registration_confirm_password(regPass);
			//Constants.key.pause(1000);
			android_user_click_on_register_button();
			android_user_click_on_registration_confirm_button();
			android_user_click_on_the_Sign_Up_button();
		}
	}
	
	@When("^android user enter the registration email address$")
	public void android_user_enter_the_registration_email_address() throws Throwable 
	{
		String vDomainExtension =  Constants.ANDROIDTestData.getProperty("EmailDomain") ;
		
		String email = Constants.key.generateEmail(4, vDomainExtension);
		
		String vObjRegEmailInput = Constants.ANDROIDMentaOR.getProperty("RegEmailInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRegEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRegEmailInput, email));
		LogCapture.info("Android user entered registration email successfully..."+email);
	}
	
	@When("^android user enter the registration password\"([^\"]*)\"$")
	public void android_user_enter_the_registration_password(String regPass) throws Throwable 
	{
		String vRegPass = Constants.ANDROIDTestData.getProperty(regPass);
		
		String vObjRegPassInput = Constants.ANDROIDMentaOR.getProperty("RegPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRegPassInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRegPassInput, vRegPass));
		LogCapture.info("Android user entered password successfully..."+vRegPass);
	}
	
	@When("^android user enter the registration confirm password\"([^\"]*)\"$")
	public void android_user_enter_the_registration_confirm_password(String regPass) throws Throwable 
	{
		String vRegPass = Constants.ANDROIDTestData.getProperty(regPass);
		
		String vObjRegConfirmPassInput = Constants.ANDROIDMentaOR.getProperty("RegConfirmPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRegConfirmPassInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRegConfirmPassInput, vRegPass));
		LogCapture.info("Android user entered confirm password successfully..."+vRegPass);
	}
	
	@When("^android user click on register button$")
	public void android_user_click_on_register_button() throws Throwable 
	{
		String vObjRegisterBtn = Constants.ANDROIDMentaOR.getProperty("RegisterBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRegisterBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjRegisterBtn));
		LogCapture.info("Android user clicked on Register button...");
	}
	
	@When("^android user click on registration confirm button$")
	public void android_user_click_on_registration_confirm_button() throws Throwable 
	{
		String vObjRegConfirmBtn = Constants.ANDROIDMentaOR.getProperty("RegConfirmBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRegConfirmBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjRegConfirmBtn));
		LogCapture.info("Android user clicked on Confirm button...");
	}
	
	/*    ACH Implementation    */
	@When("^android user click on (Add Ach|Ach Submit) button$")
	public void android_user_click_on_Add_Ach_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Add Ach"))
		{
			Constants.key.pause(500);
			String vObjAddAchBtn = Constants.ANDROIDMentaOR.getProperty("AddAchBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddAchBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddAchBtn));
			LogCapture.info("Android user clicked on Add Ach button...");
		}
		else if(optionValue.equalsIgnoreCase("Ach Submit"))
		{
			String vObjAchSubmitBtn = Constants.ANDROIDMentaOR.getProperty("AchSubmitBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchSubmitBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAchSubmitBtn));
			LogCapture.info("Android user clicked on Submit button...");
		}
	}
	
	
	@When("^android user enters the (Identification number|Middle Name|Ach Zip Code|Ach Country Code) \"([^\"]*)\"$")
	public void android_user_enters_the_Identification_number(String optionValue , String data) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Identification number"))
		{
			String vObjIdentificationInput = Constants.ANDROIDMentaOR.getProperty("IdentificationInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIdentificationInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIdentificationInput, data));
			LogCapture.info("Android user entered Identification successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Middle Name"))
		{
			String vObjMiddleNameInput = Constants.ANDROIDMentaOR.getProperty("MiddleNameInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMiddleNameInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjMiddleNameInput, data));
			LogCapture.info("Android user entered Middle Name successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Ach Zip Code"))
		{
//			String txt = "Country Code";
//			Constants.key.scrollDownUI(txt);
			
			String vObjAchZipCodeInput = Constants.ANDROIDMentaOR.getProperty("AchZipCodeInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchZipCodeInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAchZipCodeInput, data));
			LogCapture.info("Android user entered Ach Zip Code successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Ach Country Code"))
		{
//			String txt = "Country Code";
//			Constants.key.scrollDownUI(txt);
			
			String vObjAchCountryCode = Constants.ANDROIDMentaOR.getProperty("AchCountryCode");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchCountryCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAchCountryCode, data));
			LogCapture.info("Android user entered Ach Country Code successfully..."+data);
		}
	}
	
	@When("^android user enters the Debitors (Institution Name|Identification|Institution Identification) \"([^\"]*)\"$")
	public void android_user_enters_the_Debitors_Institution_Name(String optionValue , String data) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Institution Name"))
		{
			String txt = "Submit";
			Constants.key.scrollDownUI(txt);
			
			String vObjInstitutionNameInput = Constants.ANDROIDMentaOR.getProperty("InstitutionNameInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInstitutionNameInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjInstitutionNameInput, data));
			LogCapture.info("Android user entered Institution Name successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Identification"))
		{
			String vObjDebitorIdentificationInput = Constants.ANDROIDMentaOR.getProperty("DebitorIdentificationInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitorIdentificationInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDebitorIdentificationInput, data));
			LogCapture.info("Android user entered Identification successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Institution Identification"))
		{		
			String vObjInstitutionIdenInput = Constants.ANDROIDMentaOR.getProperty("InstitutionIdenInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInstitutionIdenInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjInstitutionIdenInput, data));
			LogCapture.info("Android user entered Institution Identification successfully..."+data);				
		}
	}
	
	@When("^android user enters the Reason \"([^\"]*)\"$")
	public void android_user_enters_the_Reason(String reason) throws Throwable 
	{
//		String txt = "Submit";
//		Constants.key.scrollDownUI(txt);
		String vObjReasonInput = Constants.ANDROIDMentaOR.getProperty("ReasonInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReasonInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjReasonInput, reason));
		LogCapture.info("Android user entered reason successfully..."+reason);
	}
	
	@When("^android user click on Save this information checkbox$")
	public void android_user_click_on_Save_this_information_checkbox() throws Throwable 
	{
	    String vObjSaveAchInfoChkBox = Constants.ANDROIDMentaOR.getProperty("SaveAchInfoChkBox");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSaveAchInfoChkBox));
	    Assert.assertEquals("PASS", Constants.key.click(vObjSaveAchInfoChkBox));
	    LogCapture.info("Android user click on Save information checkbox...");
	}
	
	@Then("^android user is on Transfer through Ach screen$")
	public void android_user_is_on_Transfer_through_Ach_screen() throws Throwable 
	{
	    String vObjTransferThroAchScreen = Constants.ANDROIDMentaOR.getProperty("TransferThroAchScreen");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransferThroAchScreen));
	    String vTransfertxt = Constants.key.readText(vObjTransferThroAchScreen);
	    System.out.println(vTransfertxt);
	    LogCapture.info("Android use is on transferred success screen...");
	}
	
	@Then("^android user land on Debitors account info screen$")
	public void android_user_land_on_Debitors_account_info_screen() throws Throwable 
	{
		String vObjDebitorsAccInfoScreen = Constants.ANDROIDMentaOR.getProperty("DebitorsAccInfoScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitorsAccInfoScreen));
		LogCapture.info("Android user is on Debitor's Account Information screen...");
	}
	
	@When("^android user select the added Ach card base on \"([^\"]*)\" and \"([^\"]*)\"$")
	public void android_user_select_the_added_Ach_card_base_on_and(String cardName, String cardNo) throws Throwable 
	{
		try
		{
			String vObjAchCardNameList = Constants.ANDROIDMentaOR.getProperty("AchCardNameList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchCardNameList));
			
			int cardListSize = Constants.key.getElementList(vObjAchCardNameList).size();
			//System.out.println("Card Name List : "+cardListSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjAchCardNameList);
			for(int i=0 ; i<cardListSize ; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				
				if(val.equalsIgnoreCase(cardName))
				{
					String vObjAchCardNoList = Constants.ANDROIDMentaOR.getProperty("AchCardNoList");
					//Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchCardNoList));
					
					String vObjAchCardRadioList = Constants.ANDROIDMentaOR.getProperty("AchCardRadioList");
					//Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchCardRadioList));
					
					int cardNoList = Constants.key.getElementList(vObjAchCardNoList).size();
					//System.out.println("Card No List Size : "+cardNoList);
					List<MobileElement> lists1 = Constants.key.getElementList(vObjAchCardNoList);
					
					List<MobileElement> radioList = Constants.key.getElementList(vObjAchCardRadioList);
					
					for (int j=0 ; j<cardNoList ; j++)
					{
						String val1 = lists1.get(j).getText();
						//System.out.println(val1);
						if(val1.equalsIgnoreCase(cardNo))
						{
							radioList.get(j).click();
							break;
						}
					}
					
				}
			}			
			LogCapture.info("Android user selected the Ach card..."+cardName);
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^android user click on View Card button$")
	public void android_user_click_on_View_Card_button() throws Throwable 
	{
		String vObjViewCardBtn = Constants.ANDROIDMentaOR.getProperty("ViewCardBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjViewCardBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjViewCardBtn));
		LogCapture.info("Android user clicked on View Card button...");
	}
	
	@When("^android user click on Ach Next button$")
	public void android_user_click_on_Ach_Next_button() throws Throwable 
	{
	    String vObjAchNextBtn = Constants.ANDROIDMentaOR.getProperty("AchNextBtn");
	    Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchNextBtn));
	    Assert.assertEquals("PASS", Constants.key.click(vObjAchNextBtn));
	    LogCapture.info("Android user clicked on Next button...");
	}
	
	@When("^android user click on Back to Pocket Dashboard arrow$")
	public void android_user_click_on_Back_to_Pocket_Dashboard_arrow() throws Throwable 
	{
		String vObjBackArrowPocket = Constants.ANDROIDMentaOR.getProperty("BackArrowPocket");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBackArrowPocket));
		Assert.assertEquals("PASS", Constants.key.click(vObjBackArrowPocket));
		LogCapture.info("Android user click Back Arrow...");
	}

	@When("^android user click on Link Bank plus button$")
	public void android_user_click_on_Link_Bank_plus_button() throws Throwable 
	{
		String vObjLinkBankPlusBtn = Constants.ANDROIDMentaOR.getProperty("LinkBankPlusBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLinkBankPlusBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjLinkBankPlusBtn));
		LogCapture.info("Android user click on Link Bank option...");
		
		String vObjExisAchCardLabel = Constants.ANDROIDMentaOR.getProperty("ExisAchCardLabel");
		try
		{
			int vXCord = 55;
			int vYCord = 824;
			Assert.assertEquals("PASS", Constants.key.androidSwipe(vObjExisAchCardLabel, vXCord, vYCord));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}

	@Then("^android user land on Ach Account added screen$")
	public void android_user_land_on_Ach_Account_added_screen() throws Throwable 
	{
		String vObjAchCreatedScreen = Constants.ANDROIDMentaOR.getProperty("AchCreatedScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchCreatedScreen));
		String vAccAddedTxt = Constants.key.readText(vObjAchCreatedScreen);
		System.out.println(vAccAddedTxt);
		LogCapture.info("Android user land on Ach Account added screen...");
	}
	
	@Then("^android user land on Ach Account Creation Failed screen$")
	public void android_user_land_on_Ach_Account_Creation_Failed_screen() throws Throwable 
	{
		String vObjInValidAchScreen = Constants.ANDROIDMentaOR.getProperty("InValidAchScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInValidAchScreen));
		String vTxtFailed = Constants.key.readText(vObjInValidAchScreen);
		System.out.println(vTxtFailed);
		LogCapture.info("Android user land on Failed to create Ach Account screen...");
	}
	
	@When("^android user verify that the pocket should not be create\"([^\"]*)\"$")
	public void android_user_verify_that_the_pocket_should_not_be_create(String data) throws Throwable 
	{
		String originalXpath = "//*[@text='"+data+"']";
		
		
		
//		try
//		{
//			String vObjPocketsList = Constants.ANDROIDMentaOR.getProperty("PocketsList");
//			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketsList));
//			
//			List<MobileElement> list = Constants.key.getElementList(vObjPocketsList);
//			//System.out.println(list.size());
//			
//			for(int i=0 ; i<list.size() ; i++)
//			{
//				String val = list.get(i).getText();
//				//System.out.println(val);
//				if(!val.equalsIgnoreCase(data))
//				{
//					Assert.assertEquals("PASS", Constants.key.VerifyText(val, data));
//					break;
//				}
//				else
//				{
//					Assert.assertEquals("FAIL", Constants.key.VerifyText(val, data));
//					break;
//				}
//			}
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}		
	}
	
	@When("^android user select the added Ach first card from list$")
	public void android_user_select_the_added_Ach_first_card_from_list() throws Throwable 
	{
		String vObj = "//*[@text='HDFC']";
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObj));
		Assert.assertEquals("PASS", Constants.key.click(vObj));
		LogCapture.info("Android user select the Ach card...");
	}
	
}
