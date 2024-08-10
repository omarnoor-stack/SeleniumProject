package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import support.Constants;

public class Assertions implements Constants {
	
	public void checkPageTitleIsContain(String result) {
		Assert.assertEquals(driver.findElement(By.className("page-title")).getText(), result);
	}
	
}
