package pack.UpsDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UPSDriver {

	// private static String OS = System.getProperty("os.name").toLowerCase();

	/*
	 * public WebDriver ChromeDriver() {
	 * 
	 * WebDriver driver = null;
	 * 
	 * if (OS.toLowerCase().contains("win")) {
	 * System.setProperty("webdriver.chrome.driver",
	 * "\\Browsers\\Chrome\\Windows\\chromedriver.exe"); driver = new
	 * ChromeDriver();
	 * 
	 * } else if (OS.toLowerCase().contains("mac")) {
	 * System.setProperty("webdriver.chrome.driver",
	 * "\\Browsers\\Chrome\\Mac\\chromedriver"); driver = new ChromeDriver(); }
	 * return driver; }
	 */

	public WebDriver getChromeDriver() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
