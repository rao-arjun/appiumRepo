package appiumautomation.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import appiumautomation.pages.AppLandingPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBaseClass {
	private AndroidDriver<MobileElement> driver;
	private final String appiumServerURL = "http://127.0.0.1:4723/wd/hub";
	private final String platformName = "Android";
	private final String appLocation = "src//test//resources//FasTip.apk";
	private final String deviceName = "emulator-5554";
	private final String automationName= "UiAutomator2";
	private final String platformVersion= "8.0";

	protected AppLandingPage appLandingPage;
	
	@BeforeClass
	public void launchApp(){	
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		dc.setCapability(MobileCapabilityType.APP, appLocation);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL(appiumServerURL), dc);
			this.appLandingPage = new AppLandingPage(driver);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}
}
