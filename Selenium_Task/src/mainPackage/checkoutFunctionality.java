package mainPackage;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Actions;
import pageObjects.Assertions;
import support.reportClass;

@Listeners
public class checkoutFunctionality extends reportClass {
	
	Actions action = new Actions();
	Assertions assertion = new Assertions();
	String productName = "Shirt";
	int qty = 2;
	String firstName = "Amani";
	String lastName = "Zaqzouq";
	String companyName = "PRCS";
	String streetAddress = "Al Quds";
	String city = "Ramallah";
	String zip = "P615";
	String phoneNumber = "0595693682";
	String result = "Thank you";
	
	
	
@BeforeSuite
	public void myBeforeTest() {
		action.maximaizeWindow();
		action.openWebsite();	
	}

@Test(description = "Check Checkout Functionality")
public void checkoutFunctionality() throws InterruptedException {
	action.typeProductNameInSearchInputField(productName);
	action.clickOnRandomProduct();
	action.selectProductSize();
	action.selectProductColor();
	action.typeProductQuantityInQuantityInputField(qty);
	action.clickOnAddToCartButton();
	action.clickOnShoppingCartIcon();
	action.clickOnProceedToCheckoutButton();
	action.typeEmailAddressInCheckoutPage();
	action.typeFirstNameInCheckoutPage(firstName);
	action.typeLastNameInCheckoutPage(lastName);
	action.typeCompanyNameInCheckoutPage(companyName);
	action.typeStreetAddressInCheckoutPage(streetAddress);
	action.typeCityNameInCheckoutPage(city);
	action.selectProvinceFromProvincesInputFieldInCheckoutPage();
	action.typePostalCodeInCheckoutPage(zip);
	action.selectCountryFromCountriesInputFieldInCheckoutPage();
	action.typePhoneNumberInCheckoutPage(phoneNumber);
	action.clickOnNextButton();
	action.clickOnPlaceOrderButton();
	action.printOrderNumber();
	assertion.checkPageTitleIsContain(result);
	

	
}

@AfterSuite
public void myAfterTest() {
	action.closeBrowser();
}
	
	

}
