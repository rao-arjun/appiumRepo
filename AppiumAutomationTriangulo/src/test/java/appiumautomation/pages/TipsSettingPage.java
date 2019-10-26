package appiumautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TipsSettingPage {

	private AndroidDriver<MobileElement> driver;
	
	private By settingsSection = By.id("android:id/action_bar_title");
	private By setTipPercentageTextBox = By.id("org.traeg.fastip:id/tipPercentageEditText");
	private By submitTipSettingsButton = By.id("org.traeg.fastip:id/saveSettingsButton");
	
	public TipsSettingPage(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;	
	}
	
	public String headerOfPage (){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(settingsSection)));
		return driver.findElement(settingsSection).getText();
	}
	
	public AppLandingPage updateTipPercentage(String tipPercentage){
		driver.findElement(setTipPercentageTextBox).clear();
		driver.findElement(setTipPercentageTextBox).sendKeys(tipPercentage);
		driver.findElement(submitTipSettingsButton).click();
		return new AppLandingPage(driver);
	}
}
