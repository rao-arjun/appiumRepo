package appiumautomation.tests;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appiumautomation.pages.TipsSettingPage;


public class FunctionalTests extends TestBaseClass{
	
	private static TipsSettingPage tipsSettingPage;
	
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
	
	@Test(dependsOnMethods="verifyNavigationToTipSettingsPage")
	public void setTipPercentageInSettingsPage(){
		//Scenario to update the tip to 20 percent and validate whether updated in the main page
		tipsSettingPage.updateTipPercentage(Double.toString(20));
		assertTrue(appLandingPage.getTipPercentage().contains(Double.toString(20)));		
	}
	
	@Test(dependsOnMethods="setTipPercentageInSettingsPage",dataProvider="testDataForBillAmountCalculation")
	public void totalBillAmountWithTip(double billAmount, String expectedTotalAmount) {
		//Scenario to Verify the calculation of Total Amount based on tip percentage configured before hand to 20 percent
		appLandingPage.calculateBillAmountWithTip(billAmount);
		assertEquals(appLandingPage.getTipTotalAmount(),expectedTotalAmount);
	}
	
	 @DataProvider
	 public Object[][] testDataForBillAmountCalculation() {
	    return new Object[][] {
	      new Object[] { 100, "$120.00" },
	      new Object[] { 50.00,"$60.00" },
	      new Object[] { 25.5, "$30.60" },
	    };
	  }
}
