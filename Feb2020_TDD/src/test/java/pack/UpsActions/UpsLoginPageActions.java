package pack.UpsActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pack.UpsPages.UpsLoginPageElements;

public class UpsLoginPageActions {

	UpsLoginPageElements loginPageElements;

	public UpsLoginPageActions(WebDriver driver) {
		this.loginPageElements = new UpsLoginPageElements();
		PageFactory.initElements(driver, loginPageElements);
	}

	public void inputUserID(String str) {
		loginPageElements.userId.sendKeys(str);
	}

	public void inputPassword(String str) {
		loginPageElements.password.sendKeys(str);
	}

	public void submit() {
		loginPageElements.submitBtn.click();
	}

	public String errorMsg() {
		return loginPageElements.errorMsg.getText();
	}

	public String loginButtonText() {

		return loginPageElements.submitBtn.getText();
	}

}
