package appiumautomation.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.*;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class FunctionalTests extends TestBaseClass{
	
	@Test(priority=1)
	public void verifySuccessfullLaunchOfApp(){
		//Scenario to verify the landing page of the app
		
	}
	
	@Test(priority=2,dependsOnMethods="verifySuccessfullLaunchOfApp")
	public void updateTipFromSettings(){
		
	}
	
	@Test(priority=3,dependsOnMethods="verifySuccessfullLaunchOfApp")
	public void tipCalculation() {
		//Verify the calculation of Tip
	}
}
