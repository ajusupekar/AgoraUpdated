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

public class ANDROIDFinastraParentStepDef 
{
	@Given("^android finastra parent app is installed on the device and launched successfully$")
	public void android_finastra_parent_app_is_installed_on_the_device_and_launched_successfully() throws Throwable 
	{
		String vFinParentAppPackage = Constants.CONFIG.getProperty("appPackageFinParent");
		String vFinParentAppActivity = Constants.CONFIG.getProperty("appActivityFinParent");
		
		if(Constants.CONFIG.getProperty("isLocalJenkins").equals("true"))
		{
			Thread.sleep(10000);		
	        String vDeviceID = Constants.CONFIG.getProperty("device");
	        LogCapture.info("Finastra Parent Application is launching on  device "+vDeviceID+"....");
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
	        
	        Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.launchAppUsingDeviceId(vDeviceID , vFinParentAppPackage , vFinParentAppActivity));  
	        LogCapture.info("Device ID is :" + vDeviceID);		   
			LogCapture.info("Finastra Parent Application installed and launched successfully......!!!!");
		}
		else if(Constants.CONFIG.getProperty("isBrowserstackJenkins").equals("true"))
		{
			Thread.sleep(10000);
			
			 String vDeviceID = Constants.CONFIG.getProperty("bDevice");
		        LogCapture.info("Finastra Parent Application is launching on  device "+vDeviceID+"....");
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
		        LogCapture.info("Finastra Parent Application is launching on  device version "+vVersion+"....");
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

	@Then("^android user should navigate to finastra parent app login screen$")
	public void android_user_should_navigate_to_finastra_parent_app_login_screen() throws Throwable 
	{
		String vObjLoginPageTitle = Constants.ANDROIDFinastraParentOR.getProperty("LoginPageTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoginPageTitle));
		LogCapture.info("Android user is on login screen...");
	}

	@When("^android user provides finastra parent Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void android_user_provides_finastra_parent_Username_and_Password(String email, String pass) throws Throwable 
	{
		String vObjEmailInput = Constants.ANDROIDFinastraParentOR.getProperty("EmailInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailInput));
		
		String vObjPassInput = Constants.ANDROIDFinastraParentOR.getProperty("PassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassInput));
		
		String vEmail = Constants.ANDROIDTestData.getProperty(email);
		String vPass = Constants.ANDROIDTestData.getProperty(pass);
		
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vEmail));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassInput, vPass));
		LogCapture.info("Android user entered email address successfully..."+vEmail);
		LogCapture.info("Android user entered password successfully..."+vPass);
	}

	@When("^android user click on the finastra parent login button$")
	public void android_user_click_on_the_finastra_parent_login_button() throws Throwable 
	{
		String vObjLoginBtn = Constants.ANDROIDFinastraParentOR.getProperty("LoginBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoginBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
		Constants.key.pause(2500);
		LogCapture.info("Android user click on the login button...");
	}

	@Then("^android app should load the finastra parent app Child Requests screen$")
	public void android_app_should_load_the_finastra_parent_app_Child_Requests_screen() throws Throwable 
	{
		boolean vSendButton = false;
		String vObjSendBtnHomePage = Constants.ANDROIDFinastraParentOR.getProperty("SendBtnHomePage");
		String vObjHomePageTitle = Constants.ANDROIDFinastraParentOR.getProperty("HomePageTitle");
		String vObjCreateChildAccScreen = Constants.ANDROIDFinastraParentOR.getProperty("CreateChildAccScreen");
		
		try 
		{				
			vSendButton = Constants.driver.findElement(By.xpath(vObjSendBtnHomePage)).isDisplayed();
			LogCapture.info("Child Requests screen is visible = " + vSendButton);
		} 
		catch (Exception e) 
		{
			LogCapture.info("Child Requests screen NOT visible....");
		}

		if (vSendButton) 
		{
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtnHomePage));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjHomePageTitle));
			LogCapture.info("Child Requests screen is visible ");
		} 
		else 
		{
			try 
			{
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCreateChildAccScreen));
				((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
			} 
			catch (Exception e) 
			{
				e.getMessage();
			}
		}
		LogCapture.info("Android User login successfully and Child Requests screen displayed.........");
		
	}
	
	@When("^android user click on (Profile|Settings|My Cards) button$")
	public void android_user_click_on_Profile_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Profile"))
		{
			String vObjProfileBtn = Constants.ANDROIDFinastraParentOR.getProperty("ProfileBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjProfileBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjProfileBtn));
			LogCapture.info("Android user clicked on Profile button...");
		}
		else if(optionValue.equalsIgnoreCase("Settings"))
		{
			String vObjSettingsBtnMyProfile = Constants.ANDROIDFinastraParentOR.getProperty("SettingsBtnMyProfile");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSettingsBtnMyProfile));
			Assert.assertEquals("PASS", Constants.key.click(vObjSettingsBtnMyProfile));
			LogCapture.info("Android user clicked on Settings button...");
		}
		else if(optionValue.equalsIgnoreCase("My Cards"))
		{
			String vObjMyCardsBtnMyProfile = Constants.ANDROIDFinastraParentOR.getProperty("MyCardsBtnMyProfile");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMyCardsBtnMyProfile));
			Assert.assertEquals("PASS", Constants.key.click(vObjMyCardsBtnMyProfile));
			LogCapture.info("Android user clicked on My Cards button...");
		}
	}
	
	@Then("^android user land on (My Profile|Change Password) screen$")
	public void android_user_land_on_My_Profile_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("My Profile"))
		{
			String vObjMyProfileScreen = Constants.ANDROIDFinastraParentOR.getProperty("MyProfileScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMyProfileScreen));
			LogCapture.info("Android user land on My Profile screen...");
		}
		else if(optionValue.equalsIgnoreCase("Change Password"))
		{
			String vObjChangePasswordScreen = Constants.ANDROIDFinastraParentOR.getProperty("ChangePasswordScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChangePasswordScreen));
			LogCapture.info("Android user land on Change Password screen...");
		}
	}
	
	@When("^android user click on Change Password option on settings screen$")
	public void android_user_click_on_Change_Password_option_on_settings_screen() throws Throwable 
	{
		String vObjChangePasswordOptn = Constants.ANDROIDFinastraParentOR.getProperty("ChangePasswordOptn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChangePasswordOptn));
		Assert.assertEquals("PASS", Constants.key.click(vObjChangePasswordOptn));
		LogCapture.info("Android user clicked on Change Password option...");
	}
	
	@When("^android user enters the Old Password \"([^\"]*)\"$")
	public void android_user_enters_the_Old_Password(String oldPass) throws Throwable 
	{
		String vObjOldPassInput = Constants.ANDROIDFinastraParentOR.getProperty("OldPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOldPassInput));
		
		String vOldPass = Constants.ANDROIDTestData.getProperty(oldPass);
		
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjOldPassInput, vOldPass));
		LogCapture.info("Android user entered old password successfully..."+vOldPass);
	}
	
	@When("^android user enters the New Password \"([^\"]*)\" and Confirm Password \"([^\"]*)\"$")
	public void android_user_enters_the_New_Password_and_Confirm_Password(String newPass, String confPass) throws Throwable 
	{
		String vObjNewPassInput = Constants.ANDROIDFinastraParentOR.getProperty("NewPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNewPassInput));
		
		String vNewPass = Constants.ANDROIDTestData.getProperty(newPass);
		
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjNewPassInput, vNewPass));
		LogCapture.info("Android user entered new password successfully..."+vNewPass);
		
		String vObjConfirmPassInput = Constants.ANDROIDFinastraParentOR.getProperty("ConfirmPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirmPassInput));
		
		String vConfPass = Constants.ANDROIDTestData.getProperty(newPass);
		
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjConfirmPassInput, vConfPass));
		LogCapture.info("Android user entered confirm password successfully..."+vConfPass);		
	}
	
	@When("^android user click on Update button on Change Password screen$")
	public void android_user_click_on_Update_button_on_Change_Password_screen() throws Throwable 
	{
		String vObjUpdateBtnCP = Constants.ANDROIDFinastraParentOR.getProperty("UpdateBtnCP");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdateBtnCP));
		Assert.assertEquals("PASS", Constants.key.click(vObjUpdateBtnCP));
		LogCapture.info("Android user clicked on Update button...");
	}
	
	@Then("^android user land on Password Updated successfully screen$")
	public void android_user_land_on_Password_Updated_successfully_screen() throws Throwable 
	{
		String vObjPasswordUpdatedScreen = Constants.ANDROIDFinastraParentOR.getProperty("PasswordUpdatedScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPasswordUpdatedScreen));
		String vText = Constants.key.readText(vObjPasswordUpdatedScreen);
		System.out.println(vText);
		LogCapture.info("Android user is on Password Updated screen...");
	}
	
	@When("^android user click on OK button on Password Updated screen$")
	public void android_user_click_on_OK_button_on_Password_Updated_screen() throws Throwable 
	{
		String vObjOkBtnCP = Constants.ANDROIDFinastraParentOR.getProperty("OkBtnCP");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkBtnCP));
		Assert.assertEquals("PASS", Constants.key.click(vObjOkBtnCP));
		LogCapture.info("Android user clicked on OK button...");
	}
	
	@Then("^android user should navigate to Enter Password screen$")
	public void android_user_should_navigate_to_Enter_Password_screen() throws Throwable 
	{
		String vObjEnterPassScreen = Constants.ANDROIDFinastraParentOR.getProperty("EnterPassScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEnterPassScreen));
		LogCapture.info("Android user is on Enter Password screen...");
	}
	
	@When("^android user click on Reset Password link text$")
	public void android_user_click_on_Reset_Password_link_text() throws Throwable 
	{
		String vObjResetPassLinkTxt = Constants.ANDROIDFinastraParentOR.getProperty("ResetPassLinkTxt");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetPassLinkTxt));
		Assert.assertEquals("PASS", Constants.key.click(vObjResetPassLinkTxt));
		LogCapture.info("Android user clicked on Reset Password link text...");
	}

	@When("^android user enters the email address for reset password \"([^\"]*)\"$")
	public void android_user_enters_the_email_address_for_reset_password(String email) throws Throwable 
	{
		String vObjEmailInputResetPass = Constants.ANDROIDFinastraParentOR.getProperty("EmailInputResetPass");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailInputResetPass));
		
		String vEmail =  Constants.ANDROIDTestData.getProperty(email);
		
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInputResetPass, vEmail));
		LogCapture.info("Android user entered email address successfully..."+vEmail);
	}
	
	@When("^android user click on Send button on reset password screen$")
	public void android_user_click_on_Send_button_on_reset_password_screen() throws Throwable 
	{
		String vObjSendBtnResetPass = Constants.ANDROIDFinastraParentOR.getProperty("SendBtnResetPass");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtnResetPass));
		Assert.assertEquals("PASS", Constants.key.click(vObjSendBtnResetPass));
		LogCapture.info("Android user clicked on Send button...");
	}
	
	@When("^android user enter the password to reset \"([^\"]*)\"$")
	public void android_user_enter_the_password_to_reset(String pass) throws Throwable 
	{
		String vObjPassInputResetPass = Constants.ANDROIDFinastraParentOR.getProperty("PassInputResetPass");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassInputResetPass));
		
		String vPass = Constants.ANDROIDTestData.getProperty(pass);
		
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassInputResetPass, vPass));
		LogCapture.info("Android user entered password successfully..."+vPass);
	}
	
	@Then("^android user land on Password Reset successfully screen$")
	public void android_user_land_on_Password_Reset_successfully_screen() throws Throwable 
	{
		String vObjPasswordResetScreen = Constants.ANDROIDFinastraParentOR.getProperty("PasswordResetScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPasswordResetScreen));
		
		String vTxt = Constants.key.readText(vObjPasswordResetScreen);
		System.out.println(vTxt);
		LogCapture.info("Android user land on Password Changed screen...");
	}
	
	@When("^android user click on Finish button on Password Changed screen$")
	public void android_user_click_on_Finish_button_on_Password_Changed_screen() throws Throwable 
	{
		String vObjFinishBtnPassReset = Constants.ANDROIDFinastraParentOR.getProperty("FinishBtnPassReset");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFinishBtnPassReset));
		Assert.assertEquals("PASS", Constants.key.click(vObjFinishBtnPassReset));
		LogCapture.info("Android user clicked on Finish button...");
	}
	
	@Then("^android user land on My Cards screen$")
	public void android_user_land_on_My_Cards_screen() throws Throwable 
	{
		boolean vAddACard = false;
		String vObjAddACard = Constants.ANDROIDFinastraParentOR.getProperty("AddACard");
		String vObjAgoraCardsPage = Constants.ANDROIDFinastraParentOR.getProperty("AgoraCardsPage");
		String vObjAddCardPageTitle = Constants.ANDROIDFinastraParentOR.getProperty("AddCardPageTitle");
		
		try 
		{
			vAddACard = Constants.driver.findElement(By.xpath(vObjAddACard)).isDisplayed();
			LogCapture.info("External card screen is visible = " + vAddACard);
		} 
		catch (Exception e) 
		{
			LogCapture.info("External card screen NOT visible....");
		}

		if (vAddACard) 
		{
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddACard));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAgoraCardsPage));
			LogCapture.info("External card screen is visible ");
		} 
		else 
		{
			try 
			{
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCardPageTitle));
				((PressesKey) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
			} 
			catch (Exception e) 
			{
				e.getMessage();
			}
		}
		LogCapture.info("Android user is on External Cards screen...");
	}
	
	@When("^android user click on (Add A Card|Add new card|Remove this card) button$")
	public void android_user_click_on_Add_A_Card_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Add A Card"))
		{
			String vObjAddACard = Constants.ANDROIDFinastraParentOR.getProperty("AddACard");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddACard));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddACard));
			LogCapture.info("Android user clicked on Add A Card button...");
		}
		else if(optionValue.equalsIgnoreCase("Add new card"))
		{
			String vObjAddCardBtn = Constants.ANDROIDFinastraParentOR.getProperty("AddCardBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCardBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddCardBtn));
			LogCapture.info("Android user clicked on Add button...");
		}
		else if(optionValue.equalsIgnoreCase("Remove this card"))
		{
			String vObjRemoveCardBtn = Constants.ANDROIDFinastraParentOR.getProperty("RemoveCardBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRemoveCardBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjRemoveCardBtn));
			LogCapture.info("Android user clicked on Remove this card button...");
		}
	}
	
	@Then("^android user land on (Add Card|card added|Cancellation|Card Deleted) screen$")
	public void android_user_land_on_Add_Card_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Add Card"))
		{
			String vObjAddCardPageTitle = Constants.ANDROIDFinastraParentOR.getProperty("AddCardPageTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCardPageTitle));
			LogCapture.info("Android user land on Add Card screen...");
		}
		else if(optionValue.equalsIgnoreCase("card added"))
		{
			String vObjCardAddedScreen = Constants.ANDROIDFinastraParentOR.getProperty("CardAddedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardAddedScreen));
			String vCardAddedTxt = Constants.key.readText(vObjCardAddedScreen);
			System.out.println(vCardAddedTxt);
			Assert.assertEquals("PASS", Constants.key.click(vObjCardAddedScreen));
			LogCapture.info("Android user land card added screen...");
		}
		else if(optionValue.equalsIgnoreCase("Cancellation"))
		{
			String vObjCancellationScreen = Constants.ANDROIDFinastraParentOR.getProperty("CancellationScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCancellationScreen));
			LogCapture.info("Android user land on Cancellation screen...");
		}
		else if(optionValue.equalsIgnoreCase("Card Deleted"))
		{
			String vObjCardDeletedScreen = Constants.ANDROIDFinastraParentOR.getProperty("CardDeletedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardDeletedScreen));
			String vCardDeletedTxt = Constants.key.readText(vObjCardDeletedScreen);
			System.out.println(vCardDeletedTxt);
			Assert.assertEquals("PASS", Constants.key.click(vObjCardDeletedScreen));
			LogCapture.info("Android user land on Card Deleted screen...");
		}
	}
	
	@When("^android user enters the external card number \"([^\"]*)\"$")
	public void android_user_enters_the_external_card_number(String cardNo) throws Throwable 
	{
		String vObjCardNoInput = Constants.ANDROIDFinastraParentOR.getProperty("CardNoInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNoInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNoInput, cardNo));
		LogCapture.info("Android user entered Card Number successfully..."+cardNo);
	}

	@When("^android user enters the external card expiry date \"([^\"]*)\"$")
	public void android_user_enters_the_external_card_expiry_date(String expDate) throws Throwable 
	{
		String vObjExpiryDateInput = Constants.ANDROIDFinastraParentOR.getProperty("ExpiryDateInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpiryDateInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpiryDateInput, expDate));
		LogCapture.info("Android user entered Expiry Date successfully..."+expDate);
	}

	@When("^android user enters the external card code \"([^\"]*)\"$")
	public void android_user_enters_the_external_card_code(String cvv) throws Throwable 
	{
		String vObjSecurityCodeInput = Constants.ANDROIDFinastraParentOR.getProperty("SecurityCodeInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSecurityCodeInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSecurityCodeInput, cvv));
		LogCapture.info("Android user entered Code successfully..."+cvv);
	}

	@When("^android user enters the external card name \"([^\"]*)\"$")
	public void android_user_enters_the_external_card_name(String cardName) throws Throwable 
	{
		String vObjNameOfTheCardInput = Constants.ANDROIDFinastraParentOR.getProperty("NameOfTheCardInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNameOfTheCardInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjNameOfTheCardInput, cardName));
		LogCapture.info("Android user entered Card Name successfully..."+cardName);
	}
	
	@Then("^android user verify the newly added card should be displayed on cards screen \"([^\"]*)\"$")
	public void android_user_verify_the_newly_added_card_should_be_displayed_on_cards_screen(String data) throws Throwable 
	{
		try
		{
			String vObjCardList = Constants.ANDROIDFinastraParentOR.getProperty("CardList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardList));
		
			int SizeOfCardList = Constants.key.getElementList(vObjCardList).size();
			//System.out.println(SizeOfCardList);
			List<MobileElement> lists = Constants.key.getElementList(vObjCardList);
			for(int i=0 ; i<SizeOfCardList ; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if(val.equalsIgnoreCase(data))
				{
					Assert.assertEquals(val, data);
					//Assert.assertEquals("PASS", Constants.key.VerifyText(val, data));
					break;
				}
			}
			LogCapture.info("Android user verified newly added card is displayed...");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@When("^android user select the external card \"([^\"]*)\"$")
	public void android_user_select_the_external_card(String cardName) throws Throwable 
	{
		try
		{
			String vObjCardList = Constants.ANDROIDFinastraParentOR.getProperty("CardList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardList));
			
			List<MobileElement> list = Constants.key.getElementList(vObjCardList);
			//System.out.println(list.size());
			
			String vObjCardRadioBtnList = Constants.ANDROIDFinastraParentOR.getProperty("CardRadioBtnList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardRadioBtnList));
			
			List<MobileElement> list1 = Constants.key.getElementList(vObjCardRadioBtnList);
			//System.out.println(list.size());
			
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
			LogCapture.info("Android user selected the specified card");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^android user click on Confirm button on cancellation screen$")
	public void android_user_click_on_Confirm_button_on_cancellation_screen() throws Throwable 
	{
		String vObjConfirmDltCardBtn = Constants.ANDROIDFinastraParentOR.getProperty("ConfirmDltCardBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirmDltCardBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjConfirmDltCardBtn));
		LogCapture.info("Android user clicked on Confirm button");
	}
	
	@When("^android user click on Plus icon$")
	public void android_user_click_on_Plus_icon() throws Throwable 
	{
		String vObjPlusIcon = Constants.ANDROIDFinastraParentOR.getProperty("PlusIcon");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPlusIcon));
		Assert.assertEquals("PASS", Constants.key.click(vObjPlusIcon));
		LogCapture.info("Android user clicked on Plus icon...");
	}
	
	@When("^android user click on (Pockets|Create Pocket) option$")
	public void android_user_click_on_Pockets_option(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Pockets"))
		{
			String vObjPocketsOptn = Constants.ANDROIDFinastraParentOR.getProperty("PocketsOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketsOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjPocketsOptn));
			LogCapture.info("Android user clicked on Pockets option...");
		}
		else if(optionValue.equalsIgnoreCase("Create Pocket"))
		{
			String vObjCreatePocketPlusIconBtn = Constants.ANDROIDFinastraParentOR.getProperty("CreatePocketPlusIconBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCreatePocketPlusIconBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCreatePocketPlusIconBtn));
			LogCapture.info("Android user clicked on Create Pocket option...");
		}
	}
	
	@Then("^android user land on Pockets screen$")
	public void android_user_land_on_Pockets_screen() throws Throwable 
	{
		String vObjPocketsScreen = Constants.ANDROIDFinastraParentOR.getProperty("PocketsScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketsScreen));
		LogCapture.info("Android user land on Pockets screen...");
	}
	
	@When("^android user enters the pocket name \"([^\"]*)\"$")
	public void android_user_enters_the_pocket_name(String pocketName) throws Throwable 
	{
		String vObjPocketNameInput = Constants.ANDROIDFinastraParentOR.getProperty("PocketNameInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketNameInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPocketNameInput, pocketName));
		LogCapture.info("Android user entered pocket name successfully..."+pocketName);
	}
	
	@When("^android user click on AGREE CREATE POCKET button$")
	public void android_user_click_on_AGREE_CREATE_POCKET_button() throws Throwable 
	{
		String vObjAGREECREATEPOCKETBtn = Constants.ANDROIDFinastraParentOR.getProperty("AGREECREATEPOCKETBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAGREECREATEPOCKETBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjAGREECREATEPOCKETBtn));
		LogCapture.info("Android user click on AGREE & CREATE POCKET button...");
	}
	
	@Then("^android user land on Pocket Created screen in Finastra parent app$")
	public void android_user_land_on_Pocket_Created_screen_in_Finastra_parent_app() throws Throwable 
	{
		String vObjPocketCreatedScreen = Constants.ANDROIDFinastraParentOR.getProperty("PocketCreatedScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketCreatedScreen));
		String vTxtPocketCreated = Constants.key.readText(vObjPocketCreatedScreen);
		System.out.println(vTxtPocketCreated);
		Assert.assertEquals("PASS", Constants.key.click(vObjPocketCreatedScreen));
		LogCapture.info("Android user land on Pocket Created screen...");
	}
	
	@When("^android user selecting the child \"([^\"]*)\"$")
	public void android_user_selecting_the_child(String data) throws Throwable 
	{
		String vFnameChild = Constants.ANDROIDTestData.getProperty(data);
		try
		{
			String vObjSelectChild = Constants.ANDROIDFinastraParentOR.getProperty("SelectChild");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectChild));
			Assert.assertEquals("PASS", Constants.key.click(vObjSelectChild));
		
			String vObjSelectChildList = Constants.ANDROIDFinastraParentOR.getProperty("SelectChildList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectChildList));
		
			int SelectChildListSize = Constants.key.getElementList(vObjSelectChildList).size();
			//System.out.println(SelectChildListSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjSelectChildList);
			for(int i=0 ; i<SelectChildListSize ; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if(val.equalsIgnoreCase(vFnameChild))
				{
					lists.get(i).click();
					break;
				}	
			}
			LogCapture.info("Android user selected the specified child..."+vFnameChild);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	@Then("^android user verify newly added pocket should be displayed on the Pockets screen \"([^\"]*)\"$")
	public void android_user_verify_newly_added_pocket_should_be_displayed_on_the_Pockets_screen(String data) throws Throwable 
	{
		try
		{
			String vObjPocketsList = Constants.ANDROIDFinastraParentOR.getProperty("PocketsList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPocketsList));
		
			int SizeOfPocketsList = Constants.key.getElementList(vObjPocketsList).size();
			//System.out.println(SizeOfPocketsList);
			List<MobileElement> lists = Constants.key.getElementList(vObjPocketsList);
			for(int i=0 ; i<SizeOfPocketsList ; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if(val.equalsIgnoreCase(data))
				{
					Assert.assertEquals("PASS", Constants.key.VerifyText(val, data));
					break;
				}
			}
			LogCapture.info("Android user verified newly added pocket..."); 
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^android user click on (Child List|One Time|Continue|Recurrent|Bi-Weekly) button$")
	public void android_user_click_on_Child_List_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Child List"))
		{
			String vObjChildListBtn = Constants.ANDROIDFinastraParentOR.getProperty("ChildListBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildListBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjChildListBtn));
			LogCapture.info("Android user clicked on Child List button...");
		}
		else if(optionValue.equalsIgnoreCase("One Time"))
		{
			String vObjOneTimeBtn = Constants.ANDROIDFinastraParentOR.getProperty("OneTimeBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOneTimeBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjOneTimeBtn));
			LogCapture.info("Android user clicked on One Time button...");
		}
		else if(optionValue.equalsIgnoreCase("Continue"))
		{
			String vObjContinueBtn = Constants.ANDROIDFinastraParentOR.getProperty("ContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtn));
			LogCapture.info("Android user clicked on Continue button...");
		}
		else if(optionValue.equalsIgnoreCase("Recurrent"))
		{
			String vObjRecurrentBtn = Constants.ANDROIDFinastraParentOR.getProperty("RecurrentBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecurrentBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjRecurrentBtn));
			LogCapture.info("Android user clicked on Recurrent button...");
		}
		else if(optionValue.equalsIgnoreCase("Bi-Weekly"))
		{
			String vObjBiWeeklyBtn = Constants.ANDROIDFinastraParentOR.getProperty("BiWeeklyBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBiWeeklyBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjBiWeeklyBtn));
			LogCapture.info("Android user clicked on Bi-Weekly button...");
		}
	}
	
	@Then("^android user land on (Child List|send money|List of My Accounts|Money SENT) screen$")
	public void android_user_land_on_Child_List_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Child List"))
		{
			String vObjChildListScreen = Constants.ANDROIDFinastraParentOR.getProperty("ChildListScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildListScreen));
			LogCapture.info("Android user land on Child List screen...");
		}
		else if(optionValue.equalsIgnoreCase("send money"))
		{
			String vObjOneTimeBtn = Constants.ANDROIDFinastraParentOR.getProperty("OneTimeBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOneTimeBtn));
			LogCapture.info("Android user land on send money screen...");
		}
		else if(optionValue.equalsIgnoreCase("List of My Accounts"))
		{
			String vObjListOfMyAccountsScreen = Constants.ANDROIDFinastraParentOR.getProperty("ListOfMyAccountsScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjListOfMyAccountsScreen));
			LogCapture.info("Android user land on List of My Accounts screen...");
		}
		else if(optionValue.equalsIgnoreCase("Money SENT"))
		{
			String vObjMoneySentScreen = Constants.ANDROIDFinastraParentOR.getProperty("MoneySentScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMoneySentScreen));
			String vSENTTxt = Constants.key.readText(vObjMoneySentScreen);
			System.out.println(vSENTTxt);
			Assert.assertEquals("PASS", Constants.key.click(vObjMoneySentScreen));
			LogCapture.info("Android user land on Money SENT screen...");
		}
	}
	
	@When("^android user enters the reason \"([^\"]*)\"$")
	public void android_user_enters_the_reason(String reason) throws Throwable 
	{
		String vObjReasonInput = Constants.ANDROIDFinastraParentOR.getProperty("ReasonInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReasonInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjReasonInput, reason));
		LogCapture.info("Android user entered reason successfully..."+reason);
	}
	
	@When("^android user enters the amount \"([^\"]*)\"$")
	public void android_user_enters_the_amount(String data) throws Throwable 
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
				String vObjOne = Constants.ANDROIDFinastraParentOR.getProperty("One");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
				Assert.assertEquals("PASS", Constants.key.click(vObjOne));
				break;
			case "2":
				System.out.println("2");
				String vObjTwo = Constants.ANDROIDFinastraParentOR.getProperty("Two");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
				Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
				break;
			case "3":
				System.out.println("3");
				String vObjThree = Constants.ANDROIDFinastraParentOR.getProperty("Three");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
				Assert.assertEquals("PASS", Constants.key.click(vObjThree));
				break;
			case "4":
				System.out.println("4");
				String vObjFour = Constants.ANDROIDFinastraParentOR.getProperty("Four");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
				Assert.assertEquals("PASS", Constants.key.click(vObjFour));
				break;
			case "5":
				System.out.println("5");
				String vObjFive = Constants.ANDROIDFinastraParentOR.getProperty("Five");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
				Assert.assertEquals("PASS", Constants.key.click(vObjFive));
				break;
			case "6":
				System.out.println("6");
				String vObjSix = Constants.ANDROIDFinastraParentOR.getProperty("Six");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
				Assert.assertEquals("PASS", Constants.key.click(vObjSix));
				break;
			case "7":
				System.out.println("7");
				String vObjSeven = Constants.ANDROIDFinastraParentOR.getProperty("Seven");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
				Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
				break;
			case "8":
				System.out.println("8");
				String vObjEight = Constants.ANDROIDFinastraParentOR.getProperty("Eight");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
				Assert.assertEquals("PASS", Constants.key.click(vObjEight));
				break;
			case "9":
				System.out.println("9");
				String vObjNine = Constants.ANDROIDFinastraParentOR.getProperty("Nine");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
				Assert.assertEquals("PASS", Constants.key.click(vObjNine));
				break;
			case "0":
				System.out.println("0");
				String vObjZero = Constants.ANDROIDFinastraParentOR.getProperty("Zero");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
				Assert.assertEquals("PASS", Constants.key.click(vObjZero));
				break;
			case ".":
				System.out.println(".");
				String vObjDot = Constants.ANDROIDFinastraParentOR.getProperty("Dot");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDot));
				Assert.assertEquals("PASS", Constants.key.click(vObjDot));
			default:
				System.out.println("Not a number");
			}
		}

		LogCapture.info("Amount entered successfully........." + data);
	}
	
	@When("^android user select the child base on firstname \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void android_user_select_the_child_base_on_firstname_and_email(String name, String email) throws Throwable 
	{
		String vFname = Constants.ANDROIDTestData.getProperty(name);
		String vEmail = Constants.ANDROIDTestData.getProperty(email);
		try
		{
			String vObjChildListScreen = Constants.ANDROIDFinastraParentOR.getProperty("ChildListScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildListScreen));

			String vObjChildList = Constants.ANDROIDFinastraParentOR.getProperty("ChildList");
			
			int childSize = Constants.key.getElementList(vObjChildList).size();
			//System.out.println(childSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjChildList);
			for (int i = 0; i < childSize; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if (val.equalsIgnoreCase(vFname))
				{
					String vObjSendBtnList = Constants.ANDROIDFinastraParentOR.getProperty("SendBtnList");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtnList));
					
					String vObjChildEmailList = Constants.ANDROIDFinastraParentOR.getProperty("ChildEmailList");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildEmailList));
					
					int emailList = Constants.key.getElementList(vObjChildEmailList).size();
					//System.out.println(emailList);

					List<MobileElement> lists2 = Constants.key.getElementList(vObjSendBtnList);
					//System.out.println(lists2.get(0).getText());
					List<MobileElement> lists1 = Constants.key.getElementList(vObjChildEmailList);
					for (i = 0; i < emailList; i++) 
					{
						String val1 = lists1.get(i).getText();
						//System.out.println(val1);
						if (val1.equalsIgnoreCase(vEmail))
						{
							lists2.get(i).click();
							break;
						}
					}
				}
			}
			LogCapture.info("Android user clicked on send button of specified child firstname is..."+vFname+ "email is "+vEmail);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@When("^android user click on (Add Card|Debit Card) option$")
	public void android_user_click_on_Add_Card_option(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Add Card"))
		{
			// Swipe logic needs to be implement
			String vObjMyAccountOptn = Constants.ANDROIDFinastraParentOR.getProperty("MyAccountOptn");
			try
			{
				int vXCord = 159;
				int vYCord = 950;
				Assert.assertEquals("PASS", Constants.key.androidSwipe(vObjMyAccountOptn, vXCord, vYCord));
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			String vObjAddCardNew = Constants.ANDROIDFinastraParentOR.getProperty("AddCardNew");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCardNew));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddCardNew));
			LogCapture.info("Android user click on Add Card option...");
		}
		else if(optionValue.equalsIgnoreCase("Debit Card"))
		{
			String vObjDebitCardOptn = Constants.ANDROIDFinastraParentOR.getProperty("DebitCardOptn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardOptn));
			Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardOptn));
			LogCapture.info("Android user clicked on Debit Card option...");
		}
	}
	
	@When("^android user select the pocket \"([^\"]*)\"$")
	public void android_user_select_the_pocket(String pocket) throws Throwable 
	{
		try
		{
			String vObjSelectPocket = Constants.ANDROIDFinastraParentOR.getProperty("SelectPocket");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectPocket));
			Assert.assertEquals("PASS", Constants.key.click(vObjSelectPocket));
	
			String vObjSelectPocketList = Constants.ANDROIDFinastraParentOR.getProperty("SelectPocketList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectPocketList));
		
			int SelectPocketListSize = Constants.key.getElementList(vObjSelectPocketList).size();
			//System.out.println(SelectPocketListSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjSelectPocketList);
			for(int i=0 ; i<SelectPocketListSize ; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if(val.equalsIgnoreCase(pocket))
				{
					lists.get(i).click();
					break;
				}	
			}
			LogCapture.info("Android user selected the pocket..."+pocket);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^android select the newly added card$")
	public void android_select_the_newly_added_card() throws Throwable 
	{
		String vObjSelectNewlyCreatedCard = Constants.ANDROIDFinastraParentOR.getProperty("SelectNewlyCreatedCard");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectNewlyCreatedCard));
		Assert.assertEquals("PASS", Constants.key.click(vObjSelectNewlyCreatedCard));
		LogCapture.info("Android user selected newly created card...");
	}
	
	@When("^android user click on Pay button on (card|Security code) screen$")
	public void android_user_click_on_Pay_button_on_card_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("card"))
		{
			String vObjPayBtnOnCardScreen = Constants.ANDROIDFinastraParentOR.getProperty("PayBtnOnCardScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPayBtnOnCardScreen));
			Assert.assertEquals("PASS", Constants.key.click(vObjPayBtnOnCardScreen));
			LogCapture.info("Android user clicked on Pay button...");
		}
		else if(optionValue.equalsIgnoreCase("Security code"))
		{
			String vObjPayBtnOnSecCodeScreen = Constants.ANDROIDFinastraParentOR.getProperty("PayBtnOnSecCodeScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPayBtnOnSecCodeScreen));
			Assert.assertEquals("PASS", Constants.key.click(vObjPayBtnOnSecCodeScreen));
			LogCapture.info("Android user clicked on Pay button...");
		}
	}
	
	@When("^android user enters the card security code \"([^\"]*)\"$")
	public void android_user_enters_the_card_security_code(String data) throws Throwable 
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
				String vObjOne = Constants.ANDROIDFinastraParentOR.getProperty("One");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
				Assert.assertEquals("PASS", Constants.key.click(vObjOne));
				break;
			case "2":
				System.out.println("2");
				String vObjTwo = Constants.ANDROIDFinastraParentOR.getProperty("Two");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
				Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
				break;
			case "3":
				System.out.println("3");
				String vObjThree = Constants.ANDROIDFinastraParentOR.getProperty("Three");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
				Assert.assertEquals("PASS", Constants.key.click(vObjThree));
				break;
			case "4":
				System.out.println("4");
				String vObjFour = Constants.ANDROIDFinastraParentOR.getProperty("Four");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
				Assert.assertEquals("PASS", Constants.key.click(vObjFour));
				break;
			case "5":
				System.out.println("5");
				String vObjFive = Constants.ANDROIDFinastraParentOR.getProperty("Five");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
				Assert.assertEquals("PASS", Constants.key.click(vObjFive));
				break;
			case "6":
				System.out.println("6");
				String vObjSix = Constants.ANDROIDFinastraParentOR.getProperty("Six");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
				Assert.assertEquals("PASS", Constants.key.click(vObjSix));
				break;
			case "7":
				System.out.println("7");
				String vObjSeven = Constants.ANDROIDFinastraParentOR.getProperty("Seven");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
				Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
				break;
			case "8":
				System.out.println("8");
				String vObjEight = Constants.ANDROIDFinastraParentOR.getProperty("Eight");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
				Assert.assertEquals("PASS", Constants.key.click(vObjEight));
				break;
			case "9":
				System.out.println("9");
				String vObjNine = Constants.ANDROIDFinastraParentOR.getProperty("Nine");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
				Assert.assertEquals("PASS", Constants.key.click(vObjNine));
				break;
			case "0":
				System.out.println("0");
				String vObjZero = Constants.ANDROIDFinastraParentOR.getProperty("Zero");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
				Assert.assertEquals("PASS", Constants.key.click(vObjZero));
				break;
			case ".":
				System.out.println(".");
				String vObjDot = Constants.ANDROIDFinastraParentOR.getProperty("Dot");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDot));
				Assert.assertEquals("PASS", Constants.key.click(vObjDot));
			default:
				System.out.println("Not a number");
			}
		}
		LogCapture.info("Security code entered successfully........." + data);
	}
	
	@When("^android user click on SEND button on Child Requests screen$")
	public void android_user_click_on_SEND_button_on_Child_Requests_screen() throws Throwable 
	{
		String vObjSendBtnHomePage = Constants.ANDROIDFinastraParentOR.getProperty("SendBtnHomePage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendBtnHomePage));
		Assert.assertEquals("PASS", Constants.key.click(vObjSendBtnHomePage));
		LogCapture.info("Android user clicked on SEND button...");
	}
	
	@When("^android user click on Submit button on select pocket screen$")
	public void android_user_click_on_Submit_button_on_select_pocket_screen() throws Throwable 
	{
		String vObjSubmitBtnSelPocketScreen = Constants.ANDROIDFinastraParentOR.getProperty("SubmitBtnSelPocketScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSubmitBtnSelPocketScreen));
		Assert.assertEquals("PASS", Constants.key.click(vObjSubmitBtnSelPocketScreen));
		LogCapture.info("Android user clicked on Submit button...");
	}
	
	@When("^android user select the Start Date \"([^\"]*)\"$")
	public void android_user_select_the_Start_Date(String startDate) throws Throwable 
	{
		String vObjStartDateBtn = Constants.ANDROIDFinastraParentOR.getProperty("StartDateBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStartDateBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjStartDateBtn));
		
		String vObjDateList = Constants.ANDROIDFinastraParentOR.getProperty("DateList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDateList));
		
		int StartEndDateListSize = Constants.key.getElementList(vObjDateList).size();
		//System.out.println(StartEndDateListSize);
		
		List<MobileElement> list = Constants.key.getElementList(vObjDateList);
			for(int i=0 ; i<StartEndDateListSize ; i++)
			{
				String val = list.get(i).getText();
				//System.out.println(val);
				if(val.equalsIgnoreCase(startDate))
				{
					list.get(i).click();
					break;
				}
			}

		String vObjOkBtnDate = Constants.ANDROIDFinastraParentOR.getProperty("OkBtnDate");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkBtnDate));
		Assert.assertEquals("PASS", Constants.key.click(vObjOkBtnDate));
		LogCapture.info("Android user selected start date...");
	}

	@When("^android user select the End Date \"([^\"]*)\"$")
	public void android_user_select_the_End_Date(String endDate) throws Throwable 
	{
		String vObjEndDateBtn = Constants.ANDROIDFinastraParentOR.getProperty("EndDateBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEndDateBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjEndDateBtn));
		
		String vObjDateList = Constants.ANDROIDFinastraParentOR.getProperty("DateList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDateList));
		
		int StartEndDateListSize = Constants.key.getElementList(vObjDateList).size();
		//System.out.println(StartEndDateListSize);
		
		List<MobileElement> list = Constants.key.getElementList(vObjDateList);
			for(int i=0 ; i<StartEndDateListSize ; i++)
			{
				String val = list.get(i).getText();
				//System.out.println(val);
				if(val.equalsIgnoreCase(endDate))
				{
					list.get(i).click();
					break;
				}
			}

		String vObjOkBtnDate = Constants.ANDROIDFinastraParentOR.getProperty("OkBtnDate");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkBtnDate));
		Assert.assertEquals("PASS", Constants.key.click(vObjOkBtnDate));
		LogCapture.info("Android user selected start date...");
	}
	
	@When("^android user selecting the added child base on \"([^\"]*)\" and \"([^\"]*)\"$")
	public void android_user_selecting_the_added_child_base_on_and(String name, String email) throws Throwable 
	{
		String vFnameChild = Constants.ANDROIDTestData.getProperty(name);
		String vChildEmail = Constants.ANDROIDTestData.getProperty(email);
		try
		{
			String vObjChildList = Constants.ANDROIDFinastraParentOR.getProperty("ChildList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildList));
			int childSize = Constants.key.getElementList(vObjChildList).size();
			//System.out.println(childSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjChildList);
			for (int i = 0; i < childSize; i++) 
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if (val.equalsIgnoreCase(vFnameChild)) 
				{
					String vObjChildEmailList = Constants.ANDROIDFinastraParentOR.getProperty("ChildEmailList");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildEmailList));
					int emailList = Constants.key.getElementList(vObjChildEmailList).size();
					//System.out.println(emailList);
					
					List<MobileElement> lists1 = Constants.key.getElementList(vObjChildEmailList);
				
					for (i = 0; i < emailList; i++) 
					{
						String val1 = lists1.get(i).getText();
						// System.out.println(val1);
						if (val1.equalsIgnoreCase(vChildEmail)) 
						{
							lists1.get(i).click();
							break;
						}
					}
				}
			}
			LogCapture.info("Android user selected the specific child...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@When("^android user click on Card Settings on Child Account Details screen$")
	public void android_user_click_on_Card_Settings_on_Child_Account_Details_screen() throws Throwable 
	{
		String vObjCardSettingsOptn = Constants.ANDROIDFinastraParentOR.getProperty("CardSettingsOptn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardSettingsOptn));
		Assert.assertEquals("PASS", Constants.key.click(vObjCardSettingsOptn));
		LogCapture.info("Android user clicked on Card Settings option...");
	}
	
	@Then("^android user land on child Card Settings screen$")
	public void android_user_land_on_child_Card_Settings_screen() throws Throwable 
	{
		String vObjCardSettingsScreen = Constants.ANDROIDFinastraParentOR.getProperty("CardSettingsScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardSettingsScreen));
		LogCapture.info("Android user land on Card Settings screen...");
	}
	
	@Then("^android user verify card is displayed$")
	public void android_user_verify_card_is_displayed() throws Throwable 
	{
		String vObjCardDisplyedLogo = Constants.ANDROIDFinastraParentOR.getProperty("CardDisplyedLogo");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardDisplyedLogo));
		LogCapture.info("Android user verified teh card...");
	}
	
	@When("^android user click on (Create Child Account|validate) button$")
	public void android_user_click_on_Create_Child_Account_button(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Create Child Account"))
		{
			String vObjCreateChildAccBtn = Constants.ANDROIDFinastraParentOR.getProperty("CreateChildAccBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCreateChildAccBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCreateChildAccBtn));
			LogCapture.info("Android user clicked on Create Child Account button...");
		}
		else if(optionValue.equalsIgnoreCase("validate"))
		{
			String vObjValidateChildBtn = Constants.ANDROIDFinastraParentOR.getProperty("ValidateChildBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjValidateChildBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjValidateChildBtn));
			LogCapture.info("Android user clicked on Validate button...");
		}
	}
	
	@Then("^android user land on (Create Child Account|Child Account Created) screen$")
	public void android_user_land_on_Create_Child_Account_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Create Child Account"))
		{
			String vObjCreateChildAccScreen = Constants.ANDROIDFinastraParentOR.getProperty("CreateChildAccScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCreateChildAccScreen));
			LogCapture.info("Android user land on Create Child Account screen...");
		}
		else if(optionValue.equalsIgnoreCase("Child Account Created"))
		{
			String vObjChildCreatedScreen = Constants.ANDROIDFinastraParentOR.getProperty("ChildCreatedScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildCreatedScreen));
			
			String vCCreatedTxt = Constants.key.readText(vObjChildCreatedScreen);
			System.out.println(vCCreatedTxt);
			Assert.assertEquals("PASS", Constants.key.click(vObjChildCreatedScreen));
			LogCapture.info("Android user land Child Account Created screen...");
		}
	}
	
	@When("^android user enters the valid (firstname|lastname|cell phone|email|DOB|password|confirm password) \"([^\"]*)\"$")
	public void android_user_enters_the_valid_firstname(String optionValue , String data) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("firstname"))
		{
			String vObjFirstNameInput = Constants.ANDROIDFinastraParentOR.getProperty("FirstNameInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFirstNameInput));
			
			String vFname = data + Constants.key.nameGenerate(2);
			
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameInput, vFname));
			LogCapture.info("Android user entered firstname successfully..."+vFname);
		}
		else if(optionValue.equalsIgnoreCase("lastname"))
		{
			String vObjLastNameInput = Constants.ANDROIDFinastraParentOR.getProperty("LastNameInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLastNameInput));
			
			String vLastName = data + Constants.key.nameGenerate(2);
			
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameInput, vLastName));
			LogCapture.info("Android user entered lastname successfully..."+vLastName);
		}
		else if(optionValue.equalsIgnoreCase("cell phone"))
		{
			String vObjCellPhoneInput = Constants.ANDROIDFinastraParentOR.getProperty("CellPhoneInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCellPhoneInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCellPhoneInput, data));
			LogCapture.info("Android user entered cell phone number successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("email"))
		{
			String vObjNewChildEmailInput = Constants.ANDROIDFinastraParentOR.getProperty("NewChildEmailInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNewChildEmailInput));
			
			String vEmailChild = Constants.key.generateEmail(4, data);
			
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjNewChildEmailInput, vEmailChild));
			LogCapture.info("Android user entered child email address successfully..."+vEmailChild);
		}
		else if(optionValue.equalsIgnoreCase("DOB"))
		{
			String vObjDOBChildInput = Constants.ANDROIDFinastraParentOR.getProperty("DOBChildInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDOBChildInput));
			Constants.Data = data.split("/");
			String vObjMonth = Constants.Data[0].toString();
			String vObjDay = Constants.Data[1].toString();
			String vObjYear = Constants.Data[2].toString();
			String data1 = vObjMonth + vObjDay + vObjYear;
			data = data1;
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBChildInput, data));
			LogCapture.info("Date of birth entered successfully........." + data);
		}
		else if(optionValue.equalsIgnoreCase("password"))
		{
			String vObjNewChildPassInput = Constants.ANDROIDFinastraParentOR.getProperty("NewChildPassInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNewChildPassInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjNewChildPassInput, data));
			LogCapture.info("Android user entered password successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("confirm password"))
		{
			String vObjNewChildConfPassInput = Constants.ANDROIDFinastraParentOR.getProperty("NewChildConfPassInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNewChildConfPassInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjNewChildConfPassInput, data));
			LogCapture.info("Android user entered confirm password successfully..."+data);
		}
	}
	
	@When("^android user selects the gender \"([^\"]*)\"$")
	public void android_user_selects_the_gender(String cgender) throws Throwable 
	{
		if (cgender.equalsIgnoreCase("Male")) 
		{
			String vObjChildGenderMail = Constants.ANDROIDFinastraParentOR.getProperty("ChildGenderMail");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildGenderMail));
			Assert.assertEquals("PASS", Constants.key.click(vObjChildGenderMail));
			LogCapture.info("User selected as " + cgender + " gender");
		} 
		else if(cgender.equalsIgnoreCase("Female"))
		{
			String vObjChildGenderFemale = Constants.ANDROIDFinastraParentOR.getProperty("ChildGenderFemale");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChildGenderFemale));
			Assert.assertEquals("PASS", Constants.key.click(vObjChildGenderFemale));
			LogCapture.info("User selected as " + cgender + " gender");
		}
	}
	
}
