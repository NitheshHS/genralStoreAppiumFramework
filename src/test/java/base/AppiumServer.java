package base;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
	static AppiumDriverLocalService service;
	public static  AppiumDriverLocalService startAppiumServer() {
		service=AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				);
		return service;
	}
	
	public static void stopAppiumServer() {
		service.stop();
	}

}
