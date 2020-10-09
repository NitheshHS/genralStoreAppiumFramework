package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {
	
	private static String propertyFile="AndroidGeneralStore.properties";
	public AndroidDriver<AndroidElement> driver;
	
	
	public void setUp() throws Throwable {
		if(driver==null) {
			if(propertyFile.startsWith("Android")) {
				driver=FileLib.getAndroidDriver();
			}
			else if(propertyFile.startsWith("IOS")) {
				
			}
		}
	}
	
	@BeforeSuite
	public void configBS() throws Throwable {
		AppiumServer.startAppiumServer().start();
		FileLib.configAndroidcapability(propertyFile);
	}
	@AfterSuite
	public void configAS() {
		AppiumServer.stopAppiumServer();
	}
	
	@BeforeTest
	public void configBT() {
		FileLib.setAndroidcapability();
	}
	
	@AfterTest
	public void configAT() {
		
	}
	@BeforeClass
	public void configBC(){
		
	}
	@BeforeMethod
	public void init() throws Throwable {
		setUp();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public void configAC() {
		
	}

}
