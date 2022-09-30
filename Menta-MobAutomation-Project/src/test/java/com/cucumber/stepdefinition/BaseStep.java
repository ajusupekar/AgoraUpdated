package com.cucumber.stepdefinition;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import com.appium.utility.Constants;
import com.appium.utility.Reusables;
import com.utility.LogCapture;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseStep {

	@Before
	public void intialization(Scenario scenario) {

		try {
			// To initialize scenario name for screenshot
			Constants.scenarioName = scenario.getName();

			// Creating object ReusableFunction class
			Constants.key = new Reusables();
			Constants.DataMap = new HashMap();
			// Config properties
			System.out.println(System.getProperty("user.dir"));
			FileInputStream fs;

			fs = new FileInputStream(System.getProperty("user.dir") + "/src/Config/config.properties");
			Constants.CONFIG = new Properties();
			Constants.CONFIG.load(fs);

			// DB config properties
			fs = new FileInputStream(System.getProperty("user.dir") + "/src/Config/dbconfig.properties");
			Constants.DBCONFIG = new Properties();
			Constants.DBCONFIG.load(fs);
	
			//Loading ANDROIDMentaOR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/AGORAANDROID/ANDROIDMentaOR.properties");
			Constants.ANDROIDMentaOR = new Properties();
			Constants.ANDROIDMentaOR.load(fs);
			
			//Loading ANDROIDFinastraParentOR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/AGORAANDROID/ANDROIDFinastraParentOR.properties");
			Constants.ANDROIDFinastraParentOR = new Properties();
			Constants.ANDROIDFinastraParentOR.load(fs);
			
			
			// Loading Menta ANDROIDTestData
			fs = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ANDROIDTestData.properties");
			Constants.ANDROIDTestData = new Properties();
			Constants.ANDROIDTestData.load(fs);
			
			//Loading IOSMentaOR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/IOSMenta/IOSMentaOR.properties");
			Constants.IOSMentaOR = new Properties();
			Constants.IOSMentaOR.load(fs);
			
			// Loading Menta IOSTestData
			fs = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/IOSTestData.properties");
			Constants.IOSTestData = new Properties();
			Constants.IOSTestData.load(fs);
			
			// Writing log in log4j-test-automation.log file
			LogCapture.startLog("-------------------------Test Case Validation Started-------------------------");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to run base step : " + e.getMessage());
		}
	}

	@After
	public static void finish() {
		LogCapture.endLog("-------------------------Test Case Validation Ended--------------------");
		// To close all driver session
		//Constants.driver.quit();
		if(!(Constants.driver==null))
		{
			System.out.println("Mobile Script Executed...");
			Constants.driver.quit();
		}
		else 
		{
			System.out.println("Rest Assured Script Executed...");
		}
	}

	// public static void writeExtentReport() {
	// Reporter.loadXMLConfig(new
	// File("/Users/automation/Desktop/AppiumWorkSpace/IOS-Mobile/extent-config.xml"));
	// }

	// public static void writeExtentReport() {
	// Reporter.loadXMLConfig(new File(Constants.key.getReportConfigPath()));
	//
	// }

}
