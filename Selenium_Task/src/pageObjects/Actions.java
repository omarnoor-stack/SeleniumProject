package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import support.Constants;
import support.reportClass;

public class Actions extends reportClass implements Constants {
	
	public void maximaizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void openWebsite() {
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void typeProductNameInSearchInputField(String productName) {
		driver.findElement(By.id("search")).sendKeys(productName + Keys.ENTER);
	}
	
	public void clickOnRandomProduct() {
		List<WebElement> allProducts= driver.findElements(By.cssSelector("div.product-item-info"));
	    int allList= allProducts.size();
	    Random random= new Random();
	    int RandomProduct= random.nextInt(allList);
	    allProducts.get(RandomProduct).click();
	}
	
	public void selectProductSize() {
		List<WebElement> sizes = driver.findElements(By.cssSelector("div.swatch-attribute.size div.swatch-option"));
		if (sizes.isEmpty()) {
			System.out.println("No size found");
			return;
		}
		Random random = new Random();
		int randomIndex = random.nextInt(sizes.size());
		sizes.get(randomIndex).click();

	}
	
	public void selectProductColor() {
		List<WebElement> colors = driver.findElements(By.cssSelector("div.swatch-attribute.color div.swatch-option"));
		if (colors.isEmpty()) {
			System.out.println("No color found");
			return;
		} 
		Random random = new Random();
		int randomIndex = random.nextInt(colors.size());
		colors.get(randomIndex).click();

	}
	
	public void typeProductQuantityInQuantityInputField(int qty) throws InterruptedException {
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys(Integer.toString(qty) + Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void clickOnAddToCartButton() throws InterruptedException {
		driver.findElement(By.cssSelector("button.tocart")).click();
		Thread.sleep(3000);
	}
	
	public void clickOnShoppingCartIcon() throws InterruptedException{
		driver.findElement(By.cssSelector("a.showcart")).click();
		Thread.sleep(3000);
	}
	
	public void clickOnProceedToCheckoutButton() throws InterruptedException {
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		Thread.sleep(2000);
	}
	
	public String getRandomEmail() {
        String randomString = "abcdefghijklmnopqrs";
        StringBuilder emailAddress = new StringBuilder();
        Random rnd = new Random();
        while (emailAddress.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * randomString.length());
            emailAddress.append(randomString.charAt(index));
        }
        return emailAddress.toString();
      
    }
	
	public void typeEmailAddressInCheckoutPage() throws InterruptedException {
		String randomEmail = getRandomEmail()+"@gmail.com";
		 driver.findElement(By.id("customer-email")).sendKeys(randomEmail + Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void typeFirstNameInCheckoutPage(String firstName) throws InterruptedException {
		 driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(firstName + Keys.ENTER);
		 Thread.sleep(2000);
	}
	
	public void typeLastNameInCheckoutPage(String lastName) throws InterruptedException {
		 driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lastName + Keys.ENTER);
		 Thread.sleep(2000);
	}
	
	public void typeCompanyNameInCheckoutPage(String companyName) throws InterruptedException {
		 driver.findElement(By.cssSelector("input[name='company']")).sendKeys(companyName + Keys.ENTER);
		 Thread.sleep(2000);
	}
	
	public void typeStreetAddressInCheckoutPage(String streetAddress) throws InterruptedException {
		 driver.findElement(By.cssSelector("input[name='street[0]']")).sendKeys(streetAddress + Keys.ENTER);
		 Thread.sleep(2000);
	}
	public void typeCityNameInCheckoutPage(String city) throws InterruptedException {
		 driver.findElement(By.cssSelector("input[name='city']")).sendKeys(city + Keys.ENTER);
		 Thread.sleep(2000);
	}
	
	public void selectProvinceFromProvincesInputFieldInCheckoutPage( ) throws InterruptedException {
		Select province = new Select (driver.findElement(By.name("region_id")));
		province.selectByVisibleText("Alaska");
		Thread.sleep(2000);
	}
	
	public void typePostalCodeInCheckoutPage(String zip) throws InterruptedException {
		 driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys(zip + Keys.ENTER);
		 Thread.sleep(2000);
	}
	
	public void selectCountryFromCountriesInputFieldInCheckoutPage( ) throws InterruptedException {
		Select country = new Select (driver.findElement(By.name("country_id")));
		country.selectByVisibleText("Palestinian Territories");
		Thread.sleep(2000);
	}
	
	public void typePhoneNumberInCheckoutPage(String phoneNumber) throws InterruptedException {
		 driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys(phoneNumber + Keys.ENTER);
		 Thread.sleep(2000);
	}
	
	public void clickOnNextButton() throws InterruptedException {
		driver.findElement(By.cssSelector("button.continue")).click();
		Thread.sleep(5000);
	}
	
	public void clickOnPlaceOrderButton() throws InterruptedException {
		driver.findElement(By.cssSelector("button.checkout")).click();
		Thread.sleep(5000);
	}
	
	public void printOrderNumber() {
		WebElement orderNumber = driver.findElement(By.cssSelector("div.checkout-success"));
		System.out.println(orderNumber.getText());
		//Thread.sleep(5000);
	}

}
