package pack.UpsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsShippingPageElements {
	// country
		@FindBy(xpath = "//*[@id='origincountry']")
		public WebElement country;
		// name
		@FindBy(xpath = "//*[@id='originname']")
		public WebElement name;
		// contactName
		@FindBy(xpath = "//*[@id='origincontactName']")
		public WebElement contactName;
		// address1
		@FindBy(xpath = "//*[@id='originaddress1']")
		public WebElement address1;
		// address2
		@FindBy(xpath = "//*[@id='originaddress2']")
		public WebElement address2;
		// address3
		@FindBy(xpath = "//*[@id='originaddress3']")
		public WebElement address3;
		// city
		@FindBy(xpath = "//*[@id='origincity']")
		public WebElement city;
		// zipCode
		@FindBy(xpath = "//*[@id='originpostal']")
		public WebElement zipcode;
		//state
		@FindBy(xpath="//*[@id='originstate']")
		public WebElement state;
		//email
		@FindBy(xpath="//*[@id='originemail']")
		public WebElement email;
		//phone
		@FindBy(xpath="//*[@id='originphone']")
		public WebElement phone;
		//extension
		@FindBy(xpath="//*[@id='originextension']")
		public WebElement extension;
		//checkBox
		@FindBy(css="#ups-main > div.ups-form_wrap.ups-wrap.ups-application_wrapper.ups-app_nbs > app > ng-component > div > div > div > div > ng-component > section > origin > agent > section > div:nth-child(2) > common-checkbox > div > div > label")
		public WebElement checkbox;
		//continueButton
		@FindBy(xpath="//*[@id='nbsBackForwardNavigationContinueButton']")
		public WebElement continueButton;
		//summaryName
		@FindBy(xpath="//*[@id='originnbsAgentSummaryName']")
		public WebElement summaryName;
		
		
}
