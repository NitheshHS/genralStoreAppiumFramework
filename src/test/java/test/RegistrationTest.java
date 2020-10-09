package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.RegistrationScreen;

public class RegistrationTest extends BaseTest {
	
	@Test
	public void registrationTest() {
		RegistrationScreen reg=new RegistrationScreen(driver);
		reg.register("India", "Alexa");
	}

}
