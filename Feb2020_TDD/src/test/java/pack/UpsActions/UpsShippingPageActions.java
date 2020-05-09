package pack.UpsActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pack.UpsPages.UpsShippingPageElements;

public class UpsShippingPageActions {

	WebDriver driver;
	UpsShippingPageElements pageElements; // previous class object decleration
	// constructor

	public UpsShippingPageActions(WebDriver driver) {
		this.driver = driver;
		this.pageElements = new UpsShippingPageElements();// object creation
		PageFactory.initElements(driver, pageElements);
	}

	public void inputCountryName(String str) {
		pageElements.country.sendKeys(str);
	}

	public void inputName(String str) {
		pageElements.name.sendKeys(str);
	}

	public void inputContactName(String str) {
		pageElements.contactName.sendKeys(str);
	}

	public void inputAddress1(String str) {
		pageElements.address1.sendKeys(str);
	}

	public void inputAddress2(String str) {
		pageElements.address2.sendKeys(str);
	}

	public void inputAddress3(String str) {
		pageElements.address3.sendKeys(str);
	}

	public void inputCity(String str) {
		pageElements.city.sendKeys(str);
	}

	public void inputZipcode(String str) {
		pageElements.zipcode.sendKeys(str);
	}

	public void inputState(String str) {
		pageElements.state.sendKeys(str);
	}

	public void inputEmail(String str) {
		pageElements.email.sendKeys(str);
	}

	public void inputPhone(String str) {
		pageElements.phone.sendKeys(str);
	}

	public void inputExtension(String str) {
		pageElements.extension.sendKeys(str);
	}

	public void inputCheckbox() {
		pageElements.checkbox.click();
	}

	public void inputContinueButton() {
		pageElements.continueButton.click();
	}

	public String getSummaryName() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(pageElements.summaryName));

		return pageElements.summaryName.getText();
	}

}
