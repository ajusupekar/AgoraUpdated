package com.appium.utility;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.stat.descriptive.moment.SemiVariance.Direction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.cucumber.listener.Reporter;
import com.utility.LogCapture;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Reusables {

//public String launchApp() throws Exception {
	public String launchApp(String appVersion) throws Exception {
		try {
			// Writing logs in log file
			LogCapture.info("Application setup started............");
			// Checking platform for setting up desired capabilities
			if (Constants.CONFIG.getProperty("platformNameAndroid").equalsIgnoreCase("Android")) {
				// Reading properties file and setting up desired capabilities
				// for android platform
				Constants.AndroidDC = new DesiredCapabilities();				
				Constants.AndroidDC.setCapability(MobileCapabilityType.DEVICE_NAME,Constants.CONFIG.getProperty("deviceName"));				
				Constants.AndroidDC.setCapability(MobileCapabilityType.UDID, Constants.CONFIG.getProperty("deviceId"));
				Constants.AndroidDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.CONFIG.getProperty("platformVersion"));
				Constants.AndroidDC.setCapability("skipUnlock", "true");
				Constants.AndroidDC.setCapability("appPackage", Constants.CONFIG.getProperty("appPackage"));
				Constants.AndroidDC.setCapability("appActivity", Constants.CONFIG.getProperty("appActivity"));
				Constants.AndroidDC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
				Constants.AndroidDC.setCapability(MobileCapabilityType.NO_RESET, "false");
				Constants.appiumServerUrl = Constants.CONFIG.getProperty("appiumServerUrl");

				// creating android driver instance
				Constants.driver = new AndroidDriver<MobileElement>(new URL(Constants.appiumServerUrl),Constants.AndroidDC);
				// WebdriverWait implementation
				int waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("waitInSeconds"));
				System.out.println(waitInSeconds);
				Constants.wait = new WebDriverWait(Constants.driver, waitInSeconds);
				takeSnapShot();
			}

			else if (Constants.CONFIG.getProperty("platformNameIOS").equalsIgnoreCase("iOS")) {
				// Reading properties file and setting up desired capabilities for iOS platform
				Constants.IOSDC = new DesiredCapabilities();
				Constants.IOSDC.setCapability(MobileCapabilityType.DEVICE_NAME,Constants.CONFIG.getProperty("IOSDeviceName"));
				Constants.IOSDC.setCapability(MobileCapabilityType.UDID, Constants.CONFIG.getProperty("IOSUdId"));
				Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_NAME,Constants.CONFIG.getProperty("platformNameIOS"));
				Constants.IOSDC.setCapability(MobileCapabilityType.NO_RESET, false);
				Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET, false);
				
				// Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET,true);
				Constants.IOSDC.setCapability(MobileCapabilityType.AUTOMATION_NAME,Constants.CONFIG.getProperty("automationName"));
				Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.CONFIG.getProperty("IOSPlatformVersion"));
				Constants.IOSDC.setCapability("useNewWDA", false);
				Constants.IOSDC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
				Constants.IOSDC.setCapability("xcodeOrgId", Constants.CONFIG.getProperty("xcodeOrgId"));
				Constants.IOSDC.setCapability("xcodeSigningId", Constants.CONFIG.getProperty("xcodeSigningId"));
				Constants.IOSDC.setCapability("bundleId", Constants.CONFIG.getProperty("IOSbundleId"));

				Constants.appiumServerUrl = Constants.CONFIG.getProperty("appiumServerUrl");
				Constants.driver = new IOSDriver<MobileElement>(new URL(Constants.appiumServerUrl), Constants.IOSDC);
				// Webdriver wait implementation
				Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
				Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
				takeSnapShot();	
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info("Installation or launching app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;

	}
	
	public String launchAppIOS() throws Exception {
		try {
			// Writing logs in log file
			LogCapture.info("Application setup started............");
			// Checking platform for setting up desired capabilities
			if (Constants.CONFIG.getProperty("platformNameIOS").equalsIgnoreCase("iOS")) {
				// Reading properties file and setting up desired capabilities for iOS platform
				Constants.IOSDC = new DesiredCapabilities();
				Constants.IOSDC.setCapability(MobileCapabilityType.DEVICE_NAME,Constants.CONFIG.getProperty("IOSDeviceName"));
				Constants.IOSDC.setCapability(MobileCapabilityType.UDID, Constants.CONFIG.getProperty("IOSUdId"));
				Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_NAME,Constants.CONFIG.getProperty("platformNameIOS"));
				Constants.IOSDC.setCapability(MobileCapabilityType.NO_RESET, false);
				Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET, false);
				
				// Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET,true);
				Constants.IOSDC.setCapability(MobileCapabilityType.AUTOMATION_NAME,Constants.CONFIG.getProperty("automationName"));
				Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.CONFIG.getProperty("IOSPlatformVersion"));
				Constants.IOSDC.setCapability("useNewWDA", false);
				Constants.IOSDC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
				Constants.IOSDC.setCapability("xcodeOrgId", Constants.CONFIG.getProperty("xcodeOrgId"));
				Constants.IOSDC.setCapability("xcodeSigningId", Constants.CONFIG.getProperty("xcodeSigningId"));
				Constants.IOSDC.setCapability("bundleId", Constants.CONFIG.getProperty("IOSbundleId"));

				Constants.appiumServerUrl = Constants.CONFIG.getProperty("appiumServerUrl");
				Constants.driver = new IOSDriver<MobileElement>(new URL(Constants.appiumServerUrl), Constants.IOSDC);
				// Webdriver wait implementation
				Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
				Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
				takeSnapShot();	
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info("Installation or launching app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;

	}
	
	public String launchAppANDROIDBrowserstack(String bDevice , String bVersion) throws Exception 
	{
		String username = Constants.CONFIG.getProperty("BS_Username");
		String accesskey = Constants.CONFIG.getProperty("BS_AccessToken");
		try 
		{
			// Writing logs in log file
			LogCapture.info("Application setup started on browser stack............");   
			SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String DateTime = formatDateTime.format(new Date());
			SimpleDateFormat formatDayMonth = new SimpleDateFormat("dd MMMM");
			String DayMonth = formatDayMonth.format(new Date());
			SimpleDateFormat formatTimeStamp = new SimpleDateFormat("hh:mm:ss");
			String TimeStamp = formatTimeStamp.format(new Date());
			// Checking platform for setting up desired capabilities
			if (Constants.CONFIG.getProperty("platformNameAndroid").equalsIgnoreCase("Android")) {

			// Reading properties file and setting up desired capabilities for iOS platform
			//String AndroidDeviceName = Constants.CONFIG.getProperty("BS_AndroidDevice");
			// AndroidDeviceVersion = Constants.CONFIG.getProperty("BS_AndroidPlatformVersion");

			LogCapture.info("Opening Menta  Application on "+Constants.CONFIG.getProperty("platformNameAndroid")+" Device "+bDevice+" Version "+bVersion+" ............");
			Constants.AndroidDC = new DesiredCapabilities();
			Constants.AndroidDC.setCapability("device", bDevice);							 
			Constants.AndroidDC.setCapability("os_version",bVersion);
			Constants.AndroidDC.setCapability("project", "Menta Android");
			//Constants.androidDc.setCapability("build", "Android - "+day);
			//Constants.androidDc.setCapability("name", date + " - "+ Constants.TagNames);
			// Constants.IOSDC.setCapability("browserstack.debug", "true");
			//Constants.androidDc.setCapability("build", "Android - "+DayMonth);
			//Constants.androidDc.setCapability("name", TimeStamp + " - "+ Constants.TagNames);
			Constants.AndroidDC.setCapability("build", DateTime);
			Constants.AndroidDC.setCapability("name", "Menta Android");
			//Constants.AndroidDC.setCapability("platformName", Constants.CONFIG.getProperty("platformName"));
			Constants.AndroidDC.setCapability("unicodeKeyboard", true);
			Constants.AndroidDC.setCapability("noReset", true);

			// Browserstack app path
			LogCapture.info("Installing Android Menta Application............");
			
			Constants.AndroidDC.setCapability(MobileCapabilityType.APP,"bs://" + Constants.CONFIG.getProperty("BS_AndroidMentaAppVersion"));
			
			Constants.driver = new AndroidDriver<MobileElement>(
					new URL("https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub"),
					Constants.AndroidDC);
			// Webdriver wait implementation
			Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("waitInSeconds"));
			Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
			takeSnapShot();
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
		LogCapture.info(
				"Installation or launching app process failed...Please check provided configuration details.........!!!!");
		return Constants.KEYWORD_FAIL;
	}
	return Constants.KEYWORD_PASS;
}

	
	
	public String launchAppIOSBrowserstack(String bDevice , String bVersion) throws Exception 
	{
		String username = Constants.CONFIG.getProperty("BS_Username");
		String accesskey = Constants.CONFIG.getProperty("BS_AccessToken");
		try 
		{
			// Writing logs in log file
			LogCapture.info("Application setup started on browser stack............");   
			SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String DateTime = formatDateTime.format(new Date());
			SimpleDateFormat formatDayMonth = new SimpleDateFormat("dd MMMM");
			String DayMonth = formatDayMonth.format(new Date());
			SimpleDateFormat formatTimeStamp = new SimpleDateFormat("hh:mm:ss");
			String TimeStamp = formatTimeStamp.format(new Date());
			// Checking platform for setting up desired capabilities
			if (Constants.CONFIG.getProperty("platformNameIOS").equalsIgnoreCase("iOS")) {

			// Reading properties file and setting up desired capabilities for iOS platform
			//String AndroidDeviceName = Constants.CONFIG.getProperty("BS_AndroidDevice");
			// AndroidDeviceVersion = Constants.CONFIG.getProperty("BS_AndroidPlatformVersion");

			LogCapture.info("Opening Menta  Application on "+Constants.CONFIG.getProperty("platformNameIOS")+" Device "+bDevice+" Version "+bVersion+" ............");
			Constants.IOSDC = new DesiredCapabilities();
			Constants.IOSDC.setCapability("device", bDevice);							 
			Constants.IOSDC.setCapability("os_version",bVersion);
			Constants.IOSDC.setCapability("project", "Menta IOS");
			//Constants.androidDc.setCapability("build", "Android - "+day);
			//Constants.androidDc.setCapability("name", date + " - "+ Constants.TagNames);
			// Constants.IOSDC.setCapability("browserstack.debug", "true");
			//Constants.androidDc.setCapability("build", "Android - "+DayMonth);
			//Constants.androidDc.setCapability("name", TimeStamp + " - "+ Constants.TagNames);
			Constants.IOSDC.setCapability("build", DateTime);
			Constants.IOSDC.setCapability("name", "Menta Android");
			//Constants.AndroidDC.setCapability("platformName", Constants.CONFIG.getProperty("platformName"));
			Constants.IOSDC.setCapability("unicodeKeyboard", true);
			Constants.IOSDC.setCapability("noReset", true);

			// Browserstack app path
			LogCapture.info("Installing IOS Menta Application............");
			
			Constants.IOSDC.setCapability(MobileCapabilityType.APP,"bs://" + Constants.CONFIG.getProperty("BS_IOSMentaAppVersion"));
			
			Constants.driver = new IOSDriver<MobileElement>(
					new URL("https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub"),
					Constants.IOSDC);
			// Webdriver wait implementation
			Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("waitInSeconds"));
			Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
			takeSnapShot();
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
		LogCapture.info(
				"Installation or launching app process failed...Please check provided configuration details.........!!!!");
		return Constants.KEYWORD_FAIL;
	}
	return Constants.KEYWORD_PASS;
}
	
	public String launchAppUsingDeviceId(String device , String appPackage , String appActivity) throws Exception {
		try {
		// Writing logs in log file
		LogCapture.info("Application setup started............");
		// Checking platform for setting up desired capabilities
		if (Constants.CONFIG.getProperty("platformNameAndroid").equalsIgnoreCase("Android")) {
			// Reading properties file and setting up desired capabilities
			// for android platform
			Constants.AndroidDC = new DesiredCapabilities();				
			//Constants.AndroidDC.setCapability(MobileCapabilityType.DEVICE_NAME,Constants.CONFIG.getProperty("deviceName"));				
			Constants.AndroidDC.setCapability(MobileCapabilityType.UDID, device);
			Constants.AndroidDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.CONFIG.getProperty("platformVersion"));
			Constants.AndroidDC.setCapability("skipUnlock", "true");
			Constants.AndroidDC.setCapability("appPackage", appPackage);
			Constants.AndroidDC.setCapability("appActivity", appActivity);
			Constants.AndroidDC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
			Constants.AndroidDC.setCapability(MobileCapabilityType.NO_RESET, "false");
			Constants.appiumServerUrl = Constants.CONFIG.getProperty("appiumServerUrl");

			// creating android driver instance
			Constants.driver = new AndroidDriver<MobileElement>(new URL(Constants.appiumServerUrl),Constants.AndroidDC);
			// WebdriverWait implementation
			int waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("waitInSeconds"));
			System.out.println(waitInSeconds);
			Constants.wait = new WebDriverWait(Constants.driver, waitInSeconds);
			takeSnapShot();
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
		LogCapture.info("Installation or launching app process failed...Please check provided configuration details.........!!!!");
		return Constants.KEYWORD_FAIL;
	}
	return Constants.KEYWORD_PASS;

}


	public String launchAppPackageActivity(String appVersion , String deviceID ,String Package , String Activity) throws Exception 
	{
		try 
		{
			// Writing logs in log file
			LogCapture.info("Application setup started............");
			// Checking platform for setting up desired capabilities
			if (Constants.CONFIG.getProperty("platformNameAndroid").equalsIgnoreCase("Android")) 
			{
				// Reading properties file and setting up desired capabilities
				// for android platform
				Constants.AndroidDC = new DesiredCapabilities();
				Constants.AndroidDC.setCapability(MobileCapabilityType.DEVICE_NAME,Constants.CONFIG.getProperty("deviceName"));
				Constants.AndroidDC.setCapability(MobileCapabilityType.UDID, deviceID);
				Constants.AndroidDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.CONFIG.getProperty("platformVersion"));
				Constants.AndroidDC.setCapability("skipUnlock", "true");
				Constants.AndroidDC.setCapability("appPackage", Package);
				Constants.AndroidDC.setCapability("appActivity", Activity);
				Constants.AndroidDC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
				Constants.AndroidDC.setCapability(MobileCapabilityType.NO_RESET, "false");
				Constants.appiumServerUrl = Constants.CONFIG.getProperty("appiumServerUrl");

				// creating android driver instance
				Constants.driver = new AndroidDriver<MobileElement>(new URL(Constants.appiumServerUrl),Constants.AndroidDC);
				// WebdriverWait implementation
				int waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("waitInSeconds"));
				System.out.println(waitInSeconds);
				Constants.wait = new WebDriverWait(Constants.driver, waitInSeconds);
				takeSnapShot();
			}
		}
	catch (Exception e) 
	{
		System.out.println(e.getMessage());
		LogCapture.info("Installation or launching app process failed...Please check provided configuration details.........!!!!");
		return Constants.KEYWORD_FAIL;
	}
	return Constants.KEYWORD_PASS;
}

	// To launch existing app without resetting data -------> Reset App and
	// No_Reset capabilities not working in IOS physical devices
	public String LaunchExistingIOSApp() {
		try {
			// Reading properties file and setting up desired capabilities
			// for iOS platform
			Constants.IOSDC = new DesiredCapabilities();
			Constants.IOSDC.setCapability(MobileCapabilityType.DEVICE_NAME,Constants.CONFIG.getProperty("IOSDeviceName"));
			Constants.IOSDC.setCapability(MobileCapabilityType.UDID, Constants.CONFIG.getProperty("IOSUdId"));
			Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_NAME,Constants.CONFIG.getProperty("platformNameIOS"));
			Constants.IOSDC.setCapability(MobileCapabilityType.NO_RESET, false);
			//Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET, false);
			//Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET,true);
			Constants.IOSDC.setCapability(MobileCapabilityType.AUTOMATION_NAME,Constants.CONFIG.getProperty("automationName"));
			Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.CONFIG.getProperty("IOSPlatformVersion"));
			Constants.IOSDC.setCapability("useNewWDA", false);
			Constants.IOSDC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
			Constants.IOSDC.setCapability("xcodeOrgId", Constants.CONFIG.getProperty("xcodeOrgId"));
			Constants.IOSDC.setCapability("xcodeSigningId", Constants.CONFIG.getProperty("xcodeSigningId"));
			Constants.IOSDC.setCapability("bundleId", Constants.CONFIG.getProperty("IOSbundleId"));
			Constants.IOSDC.setCapability("unicodeKeyboard", true);
			
			// to create ios driver instance
			Constants.appiumServerUrl = Constants.CONFIG.getProperty("appiumServerUrl");
			Constants.driver = new IOSDriver<MobileElement>(new URL(Constants.appiumServerUrl), Constants.IOSDC);
			// Webdriver wait implementation
			Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
			Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
			takeSnapShot();
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info("launching already instlled app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Method to write input
	public String writeInInput(String objectPath, String data) throws Exception {
		try {
			//Assert.assertEquals(Constants.KEYWORD_PASS, eleLocatedDisplayed(objectPath));
			//Constants.driver.findElement(By.xpath(objectPath)).clear();
			Constants.driver.findElement(By.xpath(objectPath)).sendKeys(data);
			takeSnapShot();
		} catch (Exception e) {
			System.out.println("Unable to write " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}
	
	// Method to clear input data
		public String clearData(String objectPath) throws Exception {
			try {
				Assert.assertEquals(Constants.KEYWORD_PASS, eleLocatedDisplayed(objectPath));
				Constants.driver.findElement(By.xpath(objectPath)).clear();
			} catch (Exception e) {
				//System.out.println("Unable to write " + e.getMessage());
				takeSnapShot();
				return Constants.KEYWORD_FAIL;
			}
			return Constants.KEYWORD_PASS;
		}

	// Method to click on element
	public String click(String objectPath) throws Exception {
		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			//Constants.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectPath)));
			Constants.driver.findElement(By.xpath(objectPath)).click();
			takeSnapShot();
		} catch (Exception e) {
			takeSnapShot();
			System.out.println("Unable to click : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Click method without visibility check
	// Below code commented because for some element visible property is false and enabled property is true
	public String clickWithoutVisibilityChk(String objectPath) throws Exception {
		try {
			//Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			//Constants.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectPath)));
			Constants.driver.findElement(By.xpath(objectPath)).click();
			takeSnapShot();
		} catch (Exception e) {
			takeSnapShot();
			System.out.println("Unable to click : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String jsClick(String objectPath) throws Exception {
		try {
				
			MobileElement ele= Constants.driver.findElement(By.xpath("//*[@label=\"Remove account\"]"));	
			//MobileElement ele= Constants.driver.findElement(By.xpath(objectPath));
			JavascriptExecutor executor = (JavascriptExecutor)Constants.driver;
			executor.executeScript("arguments[0].click();", ele);
			takeSnapShot();
		} catch (Exception e) {
			takeSnapShot();
			System.out.println("Unable to click : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}
	
	// Method to check element located and displayed on device
	public String eleLocatedDisplayed(String objectPath) throws Exception {
		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			Constants.driver.findElement(By.xpath(objectPath)).isDisplayed();
			takeSnapShot();
		} catch (Exception e) {
			System.out.println("Unable to locate : " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Method to take screenshot
	public static void takeSnapShot() throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String dateString = format.format(new Date());
		String vScenarioN = Constants.scenarioName;
		String fileWithPath = System.getProperty("user.dir") + "/Screenshot/" + "_" + vScenarioN + "_" + dateString+ ".png";
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) Constants.driver);
		//Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile = new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		Reporter.addScreenCaptureFromPath(fileWithPath);
	}

	// To read attribute value
	public String getAttributeValue(String objectPath, String attributeName) throws Exception {
		String attributeValue;
		try {
			attributeValue = Constants.driver.findElement(By.xpath(objectPath)).getAttribute(attributeName);
			if(attributeValue.isEmpty()) {
				return Constants.KEYWORD_FAIL;
			}
			return attributeValue;
		} catch (Exception e) {
			//System.out.println("Unable to get attribute value " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}	
	}

	// To read the text of element
	public String readText(String objectPath) throws Exception {
		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			String textValue = Constants.driver.findElement(By.xpath(objectPath)).getText();
			takeSnapShot();
			return textValue;
		} catch (Exception e) {
			System.out.println("Unable to read text " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
	}

	// To Read current activity and package
	public String setCurrentActivityPackage() {
		if (Constants.AndroidDC.getCapability("platformName").toString().equalsIgnoreCase("Android")) {
			try {
				Constants.appActivityName = ((AndroidDriver<MobileElement>) Constants.driver).currentActivity();
				Constants.appPackageName = ((AndroidDriver<MobileElement>) Constants.driver).getCurrentPackage();
				LogCapture.info("Application activity and package name read successfully....");
			} catch (Exception e) {
				LogCapture.info("Error while reading activity and package name....");
				return Constants.KEYWORD_FAIL;
			}
		}
		return Constants.KEYWORD_PASS;
	}

	//To switch on application bundle id/package
	public String switchApp(String packageName) {
		try {
			Constants.driver.activateApp(packageName);
			takeSnapShot();
			LogCapture.info("User switched on application : " + packageName);
		} catch (Exception e) {
			LogCapture.info("Error while switching pakage : " + packageName + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	//Switch wifi and data connection off

	public String setConnectionToOff(String platform) {
		String wifiStatus;
		// String mobileSim;
		// String mobileDataStatus;
		if (platform.equalsIgnoreCase("Android")) {
			AndroidDriver<MobileElement> aDriver = (AndroidDriver<MobileElement>) Constants.driver;
			try {
				aDriver.setConnection(new ConnectionStateBuilder().withDataDisabled().withWiFiDisabled().build());
				LogCapture.info("Switching off the connection: " + aDriver.getConnection());
			} catch (Exception e) {
				LogCapture.info("Connection could not be switch off");
				return Constants.KEYWORD_FAIL;
			}
		}
		else if (platform.equalsIgnoreCase("IOS")) {

			try {
				String iphoneSettingbundleId = Constants.IOSExtAppData.getProperty("iphoneSettingBundleId");
				switchApp(iphoneSettingbundleId);
				wifiStatus = getAttributeValue(Constants.IOSExtAppData.getProperty("WifiSwitch"), "value");
				if (wifiStatus.equalsIgnoreCase("Fail")) {
					Constants.key.click(Constants.IOSExtAppData.getProperty("WifiSettingOpt"));
					wifiStatus = getAttributeValue(Constants.IOSExtAppData.getProperty("WifiSwitch"), "value");
				}
				if (wifiStatus.equalsIgnoreCase("0")) {
					System.out.println("Wifi switch off");
				} else if (wifiStatus.equalsIgnoreCase("1")) {
					click(Constants.IOSExtAppData.getProperty("WifiSwitch"));
				}
				// Constants.driver.resetApp();
				switchApp(Constants.CONFIG.getProperty("IOSbundleId"));
			} catch (Exception e) {
				return Constants.KEYWORD_FAIL;
			}
		}
		
		/*
		 * mobileSim =getAttribute("//XCUIElementTypeCell[@name='Mobile Data']",
		 * "value");
		 * 
		 * if(mobileSim.equalsIgnoreCase("No SIM")){ System.out.
		 * println("SIM Card not inserted...Unable to on mobile data...!!!!"); }
		 * 
		 * else if(mobileSim.equalsIgnoreCase("SIM")){ //Code not implemented
		 * for mobile data connection }
		 */
		
		return Constants.KEYWORD_PASS;

	}

	// To switch on/off wi-fi and mobile data connection

	public String setConnectionToOn(String platform) throws Exception {
		String wifiStatus;
		// String mobileSim;
		// String mobileDataStatus;
		if (platform.equalsIgnoreCase("Android")) {
			AndroidDriver<MobileElement> aDriver = (AndroidDriver<MobileElement>) Constants.driver;
			try {
				aDriver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
				LogCapture.info("Switching on the connection: " + aDriver.getConnection());

			} catch (Exception e) {
				LogCapture.info("Connection could not be switch on");
				return Constants.KEYWORD_FAIL;
			}
		}

		if (platform.equalsIgnoreCase("IOS")) {

			String iphoneSettingbundleId = Constants.IOSExtAppData.getProperty("iphoneSettingBundleId");
			switchApp(iphoneSettingbundleId);
			wifiStatus = getAttributeValue(Constants.IOSExtAppData.getProperty("WifiSwitch"), "value");
			if (wifiStatus.equalsIgnoreCase("Fail")) {
				Constants.key.click(Constants.IOSExtAppData.getProperty("WifiSettingOpt"));
				wifiStatus = getAttributeValue(Constants.IOSExtAppData.getProperty("WifiSwitch"), "value");
			}
			if (wifiStatus.equalsIgnoreCase("0")) {
				Constants.key.click(Constants.IOSExtAppData.getProperty("WifiSwitch"));
				// Swipe("//XCUIElementTypeStaticText[@name='Wi-Fi']", "right",1);
			} else if (wifiStatus.equalsIgnoreCase("1")) {
				System.out.println("Wifi switch on");
				// Swipe("//XCUIElementTypeStaticText[@name='Wi-Fi']", "right",1);
			}
			Constants.driver.resetApp();
			switchApp((Constants.CONFIG.getProperty("bundleId")));
		}
		/*
		 * mobileSim =getAttribute("//XCUIElementTypeCell[@name='Mobile Data']",
		 * "value");
		 * 
		 * if(mobileSim.equalsIgnoreCase("No SIM")){ System.out.
		 * println("SIM Card not inserted...Unable to on mobile data...!!!!"); }
		 * 
		 * else if(mobileSim.equalsIgnoreCase("SIM")){ //Code not implemented
		 * for mobile data connection }
		 */
		return Constants.KEYWORD_PASS;
	}

	// To swipe left/right/up/down
	public String Swipe(String vObjEle, String direction, int count) {

		try {
			for (int i = 0; i < count; i++) {
				JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("direction", direction);
				MobileElement element = Constants.driver.findElement(By.xpath(vObjEle));
				params.put("element", element);
				js.executeScript("mobile: swipe", params);
				//System.out.println("Swipe_" + direction + "_" + (i + 1));
				takeSnapShot();
			}
		} catch (Exception e) {
			System.out.println("Unable to swipe :" + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}
	// To compare two strings
	public String VerifyText(String value1, String value2) throws Exception {
		if (value1 != null && value2 != null) {
			if (value1.trim().equalsIgnoreCase(value2.trim())) {
				//takeSnapShot();
				return Constants.KEYWORD_PASS;
			} else {
				System.out.println("Value1 :" +value1+ " doesnot match with Value2 :"+value2);
				takeSnapShot();
				return Constants.KEYWORD_FAIL;
			}
		} else {
			System.out.println("Unable to compare....");
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
	}

	// To clear input text
	public String clearText(String vObjEle) throws Exception {
		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vObjEle)));
			Constants.driver.findElement(By.xpath(vObjEle)).clear();
		} catch (Exception e) {
			System.out.println("Unable to clear : " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// To close app
	public String closeApp() {
		try {
			Constants.driver.closeApp();
		} catch (Exception e) {
			System.out.println("Unable to close : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// To re-initialize web driver wait
	public String reInitializeWebDriverWait(int data) {
		try {
			
			Constants.wait = new WebDriverWait(Constants.driver, data);
		} catch (Exception e) {
			System.out.println("Unable to re-intialize wait : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public List<MobileElement> getElementList(String vObjEle) {
		List<MobileElement> elementList = Constants.driver.findElements(By.xpath(vObjEle));
		return elementList;	
	}
	
	public String scrollInIOS(String eleText,String direction) throws Exception
	{
	try{
		MobileElement element = (MobileElement)Constants.driver.findElement(By.className("XCUIElementTypeTable"));
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put(eleText, elementID); // Only for ‘scroll in element’
		scrollObject.put("direction", direction);
		((JavascriptExecutor) Constants.driver).executeScript("mobile:scroll", scrollObject);
		return Constants.KEYWORD_PASS;
		}	
		catch (Exception e) {
		System.out.println("Unable to locate : "+e.getMessage());
		takeSnapShot();
		return Constants.KEYWORD_FAIL;
		}
	}
	
	public String getOTP(String object, String data) throws Exception {
		//For connection
		Connection connection = null;
		// For Statement object
		PreparedStatement ps;
		String DB_URL = null;
		// For Database Username
		String DB_USER = null;
		// For Database Password
		String DB_PASSWORD = null;
		String query=null;
		//To store OTP
		String OTP = null;
		if (object.equalsIgnoreCase("SIT")) {
			DB_URL = "jdbc:sqlserver://"+Constants.DBCONFIG.getProperty("SITDB_URL")+":"+Constants.DBCONFIG.getProperty("SITDB_PORT");
			DB_USER = Constants.DBCONFIG.getProperty("SITDB_User");
			DB_PASSWORD = Constants.DBCONFIG.getProperty("SITDB_Password");
			// Statement object to send the SQL statement to the Database
			query = "SELECT TOP  1 Pin FROM [NGOP-SIT].dbo.CustomerPin  where Email =? ORDER by CreatedOn  DESC";
			//"jdbc:sqlserver://172.31.4.93:1433
		}
		else if (object.equalsIgnoreCase("UAT")) {
			DB_URL = "jdbc:sqlserver://"+Constants.DBCONFIG.getProperty("UATDB_URL")+":"+Constants.DBCONFIG.getProperty("UATDB_PORT");
			DB_USER = Constants.DBCONFIG.getProperty("UATDB_User");
			DB_PASSWORD = Constants.DBCONFIG.getProperty("UATDB_Password");
			// Statement object to send the SQL statement to the Database
			query = "SELECT TOP  1 Pin FROM [ngop].dbo.CustomerPin  where Email =? ORDER by CreatedOn  DESC";
		}
		try {
			String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(dbClass).newInstance();
			// Get connection to DB
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ps = connection.prepareStatement(query);
			ps.setNString(1, data);
			ResultSet res = ps.executeQuery();
			// Get the contents of CustomerPin table from DB
			while (res.next()) {
				OTP = res.getString("Pin");
				break;
			  // System.out.println("OTP :" + OTP);
			}
			return OTP;
		} catch (Exception e) {
			System.out.println("Unable to fetch OTP from Database : " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		} finally {
			// Close DB connection
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	
	public String AppBackground(Duration duration) {
		try {
			Constants.driver.runAppInBackground(duration);

		} catch (Exception e) {
			System.out.println("App is not in background : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}
	
	public long pause(long seconds)
	{
		try 
		{
			Thread.sleep(seconds);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return seconds;
	}
	
	public String androidSwipe(String vObjElement , int x , int y) throws Exception
	{
		try
		{
			MobileElement element = Constants.driver.findElement(By.xpath(vObjElement));
			TouchAction action = new TouchAction((MobileDriver<MobileElement>)Constants.driver);
			action.longPress(ElementOption.element(element)).moveTo(ElementOption.point(x,y)).release().perform();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}
	
	public static void quitApp()
	{
		Constants.driver.quit();
	}
	
	public static String getAlphaNumericString(int n) 
	{
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n); // create StringBuffer size of AlphaNumericString
		for (int i = 0; i < n; i++) 
		{
			// generate a random number between 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index)); // add Character one by one in end of sb
		}
		return sb.toString();
	}

	public static String generateEmail(int length, String domain) 
	{
		return getAlphaNumericString(length) + "@" + domain;
	}
	
	public String nameGenerate(int n)
	{
		String randomName = RandomStringUtils.randomAlphabetic(n);
		return randomName;
	}
	
	public String lastDigits(String cardNumber)
	{
		String lastFourDigit = "";
		
		if(cardNumber.length() > 4) 
		{
			lastFourDigit = cardNumber.substring(cardNumber.length() - 4);
		}
		else 
		{
			lastFourDigit = cardNumber;
		}
		return lastFourDigit;
	}
	
	public String scrollToExactElement(String str) throws Exception 
	{
        try {
            Thread.sleep(5000);

            ((AndroidDriver<MobileElement>) Constants.driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
                            + str + "\").instance(0))")
                    .click();
        } 
        catch (Exception e) 
        {
            takeSnapShot();
            return Constants.KEYWORD_FAIL;
        }
        return Constants.KEYWORD_PASS;
    }
	
	public String scrollDownUI(String eleText) throws Exception 
	{
        try 
        {
            Constants.androidDriver = ((AndroidDriver<MobileElement>) Constants.driver);
            Constants.androidDriver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                            + eleText + "\").instance(0))");
        } 
        catch (Exception e) 
        {
            System.out.println("Unable to locate : " + e.getMessage());
            takeSnapShot();
            return Constants.KEYWORD_FAIL;
        }
        return Constants.KEYWORD_PASS;
    }
	
	private void scroll(int startX, int startY, int endX, int endY) 
	{
		new TouchAction((MobileDriver) Constants.driver).press(point(startX, startY))
                .waitAction(waitOptions(ofMillis(1000))).moveTo(point(endX, endY)).release().perform();
    }
	
	public String swipeHorizontal(int startPercentage, int finalPercentage, int anchorPercentage) 
	{
        try 
        {
            Dimension size = Constants.driver.manage().window().getSize();
            int anchor = (size.height * anchorPercentage) / 100;
            int startPoint = (size.width * startPercentage) / 100;
            int endPoint = (size.width * finalPercentage) / 100;
            scroll(startPoint, anchor, endPoint, anchor);
            LogCapture.info("Able to swap Horizonatlly....");
        } 
        catch (Exception e) 
        {
            LogCapture.info("Unable to swipe horizontally");
            return Constants.KEYWORD_FAIL;
        }
        return Constants.KEYWORD_PASS;
    }
	
	public String swipeVertical(int startPercentage, int finalPercentage, int anchorPercentage) 
	{
        try 
        {
            Dimension size = Constants.driver.manage().window().getSize();
            int anchor = (size.width * anchorPercentage) / 100;
            int startPoint = (size.height * startPercentage) / 100;
            int endPoint = (size.height * finalPercentage) / 100;
            scroll(anchor, startPoint, anchor, endPoint);
        } 
        catch (Exception e) 
        {
            LogCapture.info("Unable to swipe verticallys");
            return Constants.KEYWORD_FAIL;
        }
        return Constants.KEYWORD_PASS;
    }
	
	

	
}
	

