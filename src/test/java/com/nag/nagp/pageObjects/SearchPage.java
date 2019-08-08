package com.nag.nagp.pageObjects;

import org.openqa.selenium.By;

public interface SearchPage {
	
	By searchItemGrid=By.xpath("//div[@class='a-section a-spacing-top-medium s-visual-card-navigation-desktop']");
	String searchedText="(//span[@class='rush-component']//span[contains(text(),'searchedText')])[1]";
	By sortedBy=By.xpath("//span[@data-action='a-dropdown-button']");	
	By amazonLogo=By.xpath("//a[@class='nav-logo-link']");
	
	
}
