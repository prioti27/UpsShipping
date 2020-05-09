package pack.UpsTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pack.UpsActions.UpsShippingPageActions;
import pack.UpsDriver.UPSDriver;

public class UpsShippingTest extends UPSDriver {

	WebDriver driver;
	UpsShippingPageActions shippingActions;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {

		this.driver = getChromeDriver();
		this.shippingActions = new UpsShippingPageActions(this.driver);
		final String URL = "https://www.ups.com/ship/guided/origin?";

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"__tealiumImplicitmodal\"]/div/button")).click();
	}

	@Test(groups={"regressionTest"})
	public void verifyShippingFromTest() {
		shippingActions.inputCountryName("United States");
		shippingActions.inputName("Silvi yeasmin");
		shippingActions.inputContactName("SY");
		shippingActions.inputAddress1("463 E 9th street");
		shippingActions.inputAddress2("same");
		shippingActions.inputAddress3("same");
		shippingActions.inputCity("Brooklyn");
		shippingActions.inputZipcode("11218");
		shippingActions.inputState("New York");
		shippingActions.inputEmail("silvi.yasmin@yahoo.com");
		shippingActions.inputPhone("7037894281");
		shippingActions.inputExtension("9866");
		shippingActions.inputCheckbox();
		shippingActions.inputContinueButton();
		
		String expectedSummaryName="Silvi yeasmin";
		String actualSummaryName=shippingActions.getSummaryName();
		
		Assert.assertEquals(actualSummaryName, expectedSummaryName);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {

		driver.quit();

	}
}
