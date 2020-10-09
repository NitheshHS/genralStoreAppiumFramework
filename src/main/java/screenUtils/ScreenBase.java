package screenUtils;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.PointOption.*;


public class ScreenBase {
	
	AndroidDriver<AndroidElement> driver;
	
	public ScreenBase(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public void hideKeyBoard() {
		driver.hideKeyboard();
	}
	
	public String getToastMessage() {
		return driver.findElement(By.xpath("//android.widget.Toast")).getText();
	}
	
	public AndroidElement ScrollUsingAndroidUiAutomator(String elementName) {
	return driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollTextIntoView(\""+elementName+"\")"));
	}
	
	public AndroidElement scrollUsingTouchAction(AndroidElement element,int noSwipe) {
		int startX=(int)driver.manage().window().getSize().width/2;
		int startY=(int)driver.manage().window().getSize().height-10;
		int endY=10;
		int swipe=0;
		while(swipe<noSwipe) {
			try {
				element.isDisplayed();
			}
			catch (Exception e) {
				new TouchAction<>(driver).longPress(PointOption.point(startX, startY))
				.moveTo(point(startX, endY)).release().perform();
			}
		}
		return element;
	}

}
