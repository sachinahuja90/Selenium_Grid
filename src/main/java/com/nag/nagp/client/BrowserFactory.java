package com.nag.nagp.client;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	private static BrowserFactory instance = null;

	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	public RemoteWebDriver getDriver() {
		return driver.get();
	}

	public final void launchBrowser(String browser) throws MalformedURLException {
		try {
		driver.set(new RemoteWebDriver(new URL("http://192.168.0.107:4444/wd/hub"), getBrowserCapabilities(browser)));
		}
		catch (Exception e) {
	e.printStackTrace();
		}
	}

	private static DesiredCapabilities getBrowserCapabilities(String browserType) {
		if (browserType.equalsIgnoreCase("firefox"))
			return DesiredCapabilities.firefox();
		else if (browserType.equalsIgnoreCase("chrome"))
			return DesiredCapabilities.chrome();
		else if (browserType.equalsIgnoreCase("IE"))
			return DesiredCapabilities.internetExplorer();
		else {
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			return DesiredCapabilities.firefox();
		}
	}

	private void setChromeDriver() throws Exception {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("credentials_enable_service", false);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--no-sandbox", "--disable-extensions", "--start-maximized", "--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe");
		driver.set(new ChromeDriver(options));
	}

	private void setFireFoxDriver() throws Exception {

		FirefoxOptions options = new FirefoxOptions();

		options.addPreference("dom.webnotifications.enabled", false);
//		options.addPreference("webdriver_assume_untrusted_issuer", true);

		// Start Mozilla assuming the Untrusted certificates accepting
//		options.addPreference("setAssumeUntrustedCertificateIssuer", true);
//		options.addPreference("security.enterprise_roots.enabled", true);

		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\main\\drivers\\geckodriver.exe");
		driver.set(new FirefoxDriver(options));
	}

	public WebDriver getDriver1() {
		return driver.get();
	}

	public void quitDriver() {
		driver.get().quit();
	}

}
