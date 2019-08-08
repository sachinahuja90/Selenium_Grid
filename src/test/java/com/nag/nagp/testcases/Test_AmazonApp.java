package com.nag.nagp.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nag.nagp.customException.ElementNotClickable;
import com.nag.nagp.customException.ElementNotFound;
import com.nag.nagp.pageObjects.AmazonCreateAccountPage;
import com.nag.nagp.pageObjects.AmazonHomePage;
import com.nag.nagp.pageObjects.AmazonSignInPage;
import com.nag.nagp.pageObjects.SearchPage;
import com.nag.nagp.testcasebase.TestCasesBase;

public class Test_AmazonApp extends TestCasesBase {
	
	@Test(description="Validate Amazon Application Home page",groups= {"Home"})
	public void Test_Validate_HomePage() throws ElementNotFound, ElementNotClickable {		
		assertTrue(keywords.verifyElementPresence("amazonPay", AmazonHomePage.amazonPay));
		assertTrue(keywords.verifyElementPresence("amazonPay", AmazonHomePage.signButton));
		assertTrue(keywords.verifyElementPresence("amazonPay", AmazonHomePage.yourAmazon));		
	}
	
	
	@Test(description="Validate Login Page Amazon Application",groups= {"Login"})
	public void Test_Validate_ClickSignIn() throws ElementNotFound, ElementNotClickable {
		assertTrue(keywords.verifyElementPresence("amazonPay", AmazonHomePage.signButton));
		keywords.click("signButton", AmazonHomePage.signButton);
		keywords.waitForWindowToLoad();
		assertTrue(keywords.verifyPageTitle("Amazon Sign In"));
		assertTrue(keywords.verifyElementPresence("mobileEmailTxtBox", AmazonSignInPage.mobileEmailTxtBox));
		assertTrue(keywords.verifyElementPresence("continueButton", AmazonSignInPage.continueButton));
		assertTrue(keywords.verifyElementPresence("createAccountButton", AmazonSignInPage.createAccountButton));
		assertTrue(keywords.verifyElementPresence("needHelpLink", AmazonSignInPage.needHelpLink));		
	}
	
	@Test(description="Validate Create Account Amazon Application",groups= {"SignUp"})
	public void Test_Validate_AmazonSignUp() throws ElementNotFound, ElementNotClickable {
		assertTrue(keywords.verifyElementPresence("signButton", AmazonHomePage.signButton));
		keywords.click("signButton", AmazonHomePage.signButton);
		keywords.waitForWindowToLoad();
		assertTrue(keywords.verifyElementPresence("createAccountButton", AmazonSignInPage.createAccountButton));
		keywords.click("createAccountButton", AmazonSignInPage.createAccountButton);
		keywords.waitForWindowToLoad();
		
		assertTrue(keywords.verifyElementPresence("yourNameTxtbox", AmazonCreateAccountPage.yourNameTxtbox));
		assertTrue(keywords.verifyElementPresence("mobileTxtbox", AmazonCreateAccountPage.mobileTxtbox));
		assertTrue(keywords.verifyElementPresence("emailTxtbox", AmazonCreateAccountPage.emailTxtbox));
		assertTrue(keywords.verifyElementPresence("passwordTxtbox", AmazonCreateAccountPage.passwordTxtbox));
		assertTrue(keywords.verifyElementPresence("continueButton", AmazonCreateAccountPage.continueButton));			
	}
	
	@Test(description="Validate Search keyword",groups= {"Search"})
	public void Test_Validate_AmazonSearch() throws ElementNotFound, ElementNotClickable {
		String searchedText=TestCasesBase.testDataMap.get("Search");
		assertTrue(keywords.verifyElementPresence("signButton", AmazonHomePage.signButton));
		keywords.typeText("searchBox", AmazonHomePage.searchBox, searchedText);
		keywords.pressEnterKey("searchBox", AmazonHomePage.searchBox);
		keywords.waitForWindowToLoad();
		By xp=By.xpath(SearchPage.searchedText.replaceAll("searchedText", searchedText));
		assertTrue(keywords.verifyElementPresence("searchedText", xp));
	}
	
	@Test(description="Validate Click Amazon Logo",groups= {"Search"})
	public void Test_Validate_Click_AmazonLogo() throws ElementNotFound, ElementNotClickable {
		String searchedText=TestCasesBase.testDataMap.get("searchedText");
		assertTrue(keywords.verifyElementPresence("signButton", AmazonHomePage.signButton));
		keywords.typeText("searchBox", AmazonHomePage.searchBox, searchedText);
		keywords.pressEnterKey("searchBox", AmazonHomePage.searchBox);
		keywords.waitForWindowToLoad();
		By xp=By.xpath(SearchPage.searchedText.replaceAll("searchedText", searchedText));
		assertTrue(keywords.verifyElementPresence("searchedText", xp));
		keywords.click("amazonLogo", SearchPage.amazonLogo);
		keywords.waitForWindowToLoad();
		assertTrue(keywords.verifyPageTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
	}
}
