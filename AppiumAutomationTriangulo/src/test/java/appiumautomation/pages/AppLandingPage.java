package appiumautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppLandingPage {
	private AndroidDriver<MobileElement> driver;
	
	private By fastipLog = By.id("android:id/action_bar_title");
	private By billAmountTextBox = By.id("org.traeg.fastip:id/billAmtEditText");
	private By calculateTipButton = By.id("org.traeg.fastip:id/calcTipButton");
	
	private By tipPercentage = By.id("org.traeg.fastip:id/tipPctTextView");
	private By tipAmount = By.id("org.traeg.fastip:id/tipAmtTextView");
	private By totalAmount = By.id("org.traeg.fastip:id/totalAmtTextView");
	private By settingsButton = By.id("org.traeg.fastip:id/menu_settings");
	
	public AppLandingPage(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	public String fastipLogoText(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fastipLog)));
		return driver.findElement(fastipLog).getText();
	}
	public TipsSettingPage goToTipsSettingsPage(){
		driver.findElement(settingsButton).click();
		return new TipsSettingPage(driver);
	}
	
	public String getTipPercentage(){
		return driver.findElement(tipPercentage).getText();
	}
	
	public String getTipAmount(){
		return driver.findElement(tipAmount).getText();
	}
	
	public String getTipTotalAmount(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(totalAmount)));
		return driver.findElement(totalAmount).getText();
	}
	
	public void calculateBillAmountWithTip(double billAmount){
		driver.findElement(billAmountTextBox).clear();
		driver.findElement(billAmountTextBox).sendKeys(Double.toString(billAmount));
		driver.findElement(calculateTipButton).click();
	}
}
