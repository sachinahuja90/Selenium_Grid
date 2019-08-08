package com.nag.nagp.pageObjects;

import org.openqa.selenium.By;

public interface AmazonCreateAccountPage {
	
	By yourNameTxtbox=By.id("ap_customer_name");
	By mobileTxtbox=By.id("ap_phone_number");
	By emailTxtbox=By.name("secondaryLoginClaim");
	By passwordTxtbox=By.id("ap_password");
	By continueButton=By.xpath("//input[@id='continue' and @type='submit']");
}
