package pack.UpsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pack.UpsActions.UpsShippingPageActions;
import pack.UpsDriver.UPSDriver;

public class PriUpsShippingTest extends UPSDriver {
	
	WebDriver driver = getChromeDriver();
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
		shippingActions.inputName("Prioti Taher");
		shippingActions.inputContactName("Pri");
		shippingActions.inputAddress1("630 old country rd");
		shippingActions.inputCity("Garden City");
		shippingActions.inputZipcode("11530");
		shippingActions.inputState("New York");
		shippingActions.inputEmail("tprioti@aol.com");
		shippingActions.inputPhone("(347) 000-1234");
		shippingActions.inputExtension("1234");
		shippingActions.inputCheckbox();
		shippingActions.inputContinueButton();
		
		String expectedSummaryName="Prioti Taher";
		String actualSummaryName=shippingActions.getSummaryName();
		
		Assert.assertEquals(actualSummaryName, expectedSummaryName);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {

		driver.quit();

	

}
}
