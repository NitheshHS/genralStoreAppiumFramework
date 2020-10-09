package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.RegistrationScreen;
@Listeners(base.ListenerIMP.class)
public class VerifyToastMSGTest extends BaseTest{
	@Test
	public void verifyToastMessage() {
		RegistrationScreen reg=new RegistrationScreen(driver);
		reg.verifyToast();
	}

}
