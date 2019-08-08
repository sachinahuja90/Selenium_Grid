package com.nag.nagp.pageObjects;

import org.openqa.selenium.By;

public interface AmazonHomePage {
	
	By searchBox=By.id("twotabsearchtextbox");
	By signButton=By.xpath("//a[@id='nav-link-accountList']");
	By yourAmazon=By.id("nav-your-amazon");
	By todayDeal=By.xpath("//a[text()='Today's Deals']");
	By amazonPay=By.xpath("//a[text()='Amazon Pay']");

	//div[@class='a-section a-spacing-top-medium s-visual-card-navigation-desktop']
}
