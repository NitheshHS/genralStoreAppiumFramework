package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import screenUtils.ScreenBase;

public class RegistrationScreen extends ScreenBase{

	public RegistrationScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private AndroidElement countrySpinner;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private AndroidElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private AndroidElement maleRadioButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private AndroidElement femaleRadioButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private AndroidElement letsGoButton;

	public AndroidElement getCountrySpinner() {
		return countrySpinner;
	}

	public AndroidElement getNameField() {
		return nameField;
	}

	public AndroidElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public AndroidElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public AndroidElement getLetsGoButton() {
		return letsGoButton;
	}
	
	public void register(String countryName,String yourName) {
		countrySpinner.click();
		ScrollUsingAndroidUiAutomator(countryName).click();
		nameField.sendKeys(yourName);
		hideKeyBoard();
		femaleRadioButton.click();
		letsGoButton.click();
	}
	
	public void verifyToast() {
		letsGoButton.click();
		getToastMessage();
	}
	

}
