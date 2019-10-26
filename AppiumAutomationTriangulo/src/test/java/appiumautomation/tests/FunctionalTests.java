package appiumautomation.tests;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appiumautomation.pages.TipsSettingPage;


public class FunctionalTests extends TestBaseClass{
	
	private TipsSettingPage tipsSettingPage;
	
	@Test(priority=1)
	public void verifySuccessfullLaunchOfApp(){
		//Scenario to verify the landing page of the app
		assertEquals(appLandingPage.fastipLogoText(),"FasTip");		
	}
	
	@Test(priority=2, dependsOnMethods="verifySuccessfullLaunchOfApp")
	public void verifyNavigationToTipSettingsPage(){
		//Scenario checks successful navigation to the Tip Settings page of the app
		tipsSettingPage = appLandingPage.goToTipsSettingsPage();
		assertEquals(tipsSettingPage.headerOfPage(),"Settings");
	}
	
	@Test(priority=3,dependsOnMethods="verifyNavigationToTipSettingsPage",dataProvider="testDataForTipPercentageUpdate")
	public void updateTipFromSettings(double tipPercentage){
		//Scenario to update the tip and validate whether updated in the main page
		tipsSettingPage.updateTipPercentage(Double.toString(tipPercentage));
		assertTrue(appLandingPage.getTipPercentage().contains(Double.toString(tipPercentage)));		
	}
	
	@Test(priority=4,dependsOnMethods="verifySuccessfullLaunchOfApp",dataProvider="testDataForBillAmountCalculation")
	public void tipCalculationForBillAmount(double billAmount, String expectedTotalAmount) {
		//Scenario to Verify the calculation of Total Amount based on tip percentage configured before hand 20 percent
		appLandingPage.calculateBillAmountWithTip(billAmount);
		assertEquals(appLandingPage.getTipTotalAmount(),expectedTotalAmount);
	}
	
	@DataProvider
	public Object[] testDataForTipPercentageUpdate(){
		Object[] data = {10.0, 15.5, 20};
		return data;
	}
	
/*	@DataProvider
	public Object[][] testDataForBillAmountCalculation(){
		Object [][] data = 
				{
					{100, "$120.00"},
					{50.00,"$60.00"},
					{25.5, "$30.60"}
				};
		return data;
	}
*/
	
	 @DataProvider
	 public Object[][] testDataForBillAmountCalculation() {
	    return new Object[][] {
	      new Object[] { 100, "$120.00" },
	      new Object[] { 50.00,"$60.00" },
	      new Object[] { 25.5, "$30.60" },
	    };
	  }
}
