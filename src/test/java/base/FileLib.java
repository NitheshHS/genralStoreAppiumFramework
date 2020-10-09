package base;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class FileLib {

	private static String PLATFORM_NAME;
	private static String AUTOMATION_NAME;
	private static String APP_PACKAGE;
	private static String APP_ACTIVITY;
	private static int IMPLICIT_WAIT;
	private static int EXPLICIT_WAIT;
	private static String APP_PATH;

	private static AndroidDriver<AndroidElement> driver;
	private static DesiredCapabilities cap=new DesiredCapabilities();
	private static Properties prop=new Properties();
	
	public static void configAndroidcapability(String AndroidPropertiesFile) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\Properties\\"+AndroidPropertiesFile);
		
		prop.load(fis);
		PLATFORM_NAME=prop.getProperty("platformName");
		AUTOMATION_NAME=prop.getProperty("automationName");
		APP_PACKAGE=prop.getProperty("appPackage");
		APP_ACTIVITY=prop.getProperty("appActivity");
		IMPLICIT_WAIT=Integer.parseInt(prop.getProperty("implicitTimeout"));
		EXPLICIT_WAIT=Integer.parseInt(prop.getProperty("ExplicitTimeout"));
		APP_PATH=prop.getProperty("app");
	}

	public static DesiredCapabilities setAndroidcapability() {
		String app = System.getProperty("user.dir")+"\\Apps\\"+APP_PATH;
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		cap.setCapability(MobileCapabilityType.APP, app);
		
		return cap;
		

	}
	public static void setIosCapability() {

	}
	public static AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException{
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}
	public static IOSDriver<IOSElement> getIOSDrive(){
		return null;
		
	}

}
