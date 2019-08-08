package com.nag.nagp.pageObjects;

import org.openqa.selenium.By;

public interface AmazonSignInPage {
	
	By mobileEmailTxtBox=By.id("ap_email");
	By continueButton=By.id("continue");
	By needHelpLink=By.xpath("//span[contains(text(),'Need help?')]");
	By createAccountButton=By.id("createAccountSubmit");


}
