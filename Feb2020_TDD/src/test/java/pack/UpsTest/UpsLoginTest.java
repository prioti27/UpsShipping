package pack.UpsTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pack.UpsActions.UpsLoginPageActions;
import pack.UpsDriver.UPSDriver;

public class UpsLoginTest extends UPSDriver {

	WebDriver driver;
	UpsLoginPageActions loginActions;

	@BeforeMethod(alwaysRun = true)
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			this.driver = getChromeDriver();
			this.loginActions = new UpsLoginPageActions(this.driver);

		} else if (browser.equalsIgnoreCase("Firefox")) {
			this.driver = getFirefoxDriver();
			this.loginActions = new UpsLoginPageActions(this.driver);
		}

		final String URL = "https://www.ups.com/lasso/login?";

		driver.get(URL);
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"__tealiumImplicitmodal\"]/div/button")).click();

	}

	@Test(priority = 3,groups={"regressionTest"})
	public void verifyLoginErrorMsg() {

		loginActions.inputUserID("user");
		loginActions.inputPassword("pass");
		loginActions.submit();

		String errorText = loginActions.errorMsg();

		boolean bool;

		if (errorText.isEmpty()) {
			bool = false;
		} else {
			bool = true;
		}

		System.out.println("verifyLoginErrorMsg() executed");
		Assert.assertEquals(bool, true);

	}

	@Test(priority = 2,groups={"sanityTest"})
	public void verifyLoginButtonText() {

		String actualText = loginActions.loginButtonText();
		System.out.println("Actual login button text: " + actualText);
		String expectedText = "Sign In";
		System.out.println("verifyLoginButtonText() executed");
		Assert.assertEquals(actualText, expectedText);

	}

	@Test(priority = 1,groups={"sanityTest"})
	public void verifyUpsLoginPageTitle() {
		String expectedTitle = "Login | UPS - United States";
		String actualTitle = driver.getTitle();
		System.out.println("verifyUpsLoginPageTitle() executed");
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {

		driver.quit();

	}
}
