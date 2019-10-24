package appiumautomation.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.*;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class FunctionalTests {
	private AndroidDriver driver;
	
	@BeforeTest
	public void setupDriver() throws MalformedURLException{
		String appiumServerURL = "http://127.0.0.1:4723/wd/hub";		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		dc.setCapability(MobileCapabilityType.APP, "src/test/resources/TrianguloApp.apk");
		//dc.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		driver = new AndroidDriver(new URL(appiumServerURL), dc);
	}
	
	@Test
	public void firstTest() throws InterruptedException {
	driver.findElement(By.id("Login Screen")).click();
	}
}
