package com.appium.utility;

import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import  java.util.List;
import java.util.Map;
  
public class Constants {
	public static String JenkinsBrowser = System.getProperty("jenkinsBrowser");
	public static String BrowserStack = System.getProperty("browserStack");
	public static Reusables key;
	public static MobileDriver<MobileElement> driver;
	public static AndroidDriver<MobileElement> androidDriver;
	public static Properties CONFIG;
	public static Properties DBCONFIG;
    public static Properties IOSLoginOR;
    public static Properties IOSLoginOR1;
    public static Properties IOSDashOR;
    public static Properties IOSRecipientOR;
    public static Properties IOSRegstOR;
    public static Properties IOSMyCardOR;
    public static Properties IOSAddWalletOR;
    public static Properties IOSSendMoneyOR;
    public static Properties IOSExtAppData;
    public static Properties IOSTestData;
    public static DesiredCapabilities AndroidDC;
    public static DesiredCapabilities IOSDC;
    public static DesiredCapabilities IOSDC1;
	public static String appiumServerUrl;
	public static String KEYWORD_PASS ="PASS";
    public static String KEYWORD_FAIL ="FAIL";
    public static WebDriverWait wait;
    public static int waitInSeconds;
    public static int modifyWaitInSeconds;
    public static String appActivityName;
    public static String IOSbundleId;
	public static String appPackageName;
	public static String scenarioName;
	public static String custLegalEntity;
	public static int logInFailCount=0;
	public static List<MobileElement>ListOfMobEle; 
	public static String Data[];
	public static Map<String,String> DataMap;
	public static String TempData;
	
	
	public static Properties ANDROIDLoginOR;
	public static Properties ANDROIDLoginTeenOR;
	public static Properties ANDROIDLoginSMBOR;
	public static Properties ANDROIDLoginEmployeeOR;
	public static Properties ANDROIDTestData;
	
	public static Properties ANDROIDMentaOR;
	public static Properties IOSMentaOR;
	
	public static Properties ANDROIDFinastraParentOR;
}
