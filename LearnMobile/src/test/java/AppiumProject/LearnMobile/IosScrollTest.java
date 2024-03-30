package AppiumProject.LearnMobile;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IosScrollTest extends IosBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void iosScrollGesture() {
		
		// Calling configureAppium() method in BaseTest class
		//configureAppium();
		
		// Appium configuration will be called automatically because IosBaseTest class has been inherited. IosBaseTest class has iOS appium configuration and tear down methods, which gets gets called because of @BeforeClass and @AfterClass TestNG annotations.
		
		// Element locators in IOS - xpath, id, accessibiliyId, classname, iOSClassChain, iOSNsPredicateString
		
		// Scroll until element 'Web View' is found
		
		// Locate an element until when scroll needs to be performed
		WebElement ele= driver.findElement(AppiumBy.accessibilityId("Web View"));
		
		// Create map object params
//		Map<String,Object> params= new HashMap<>();
//		
//		// Add params to the object
//		params.put("element", ((RemoteWebElement)ele).getId());
//		params.put("direction", "down");
//		
//		// Call executeScript() method by providing what needs to be performed and params as arguments
//		driver.executeScript("mobile: scroll", params);
		
		// calling scrollToElement() method in IosBaseTest class and passing WebElement as an argument
		scrollToElement(ele);
		
		// Click on 'Web View'
		driver.findElement(AppiumBy.accessibilityId("Web View")).click();
		
		// Click back button on top left to go back to main screen
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
		
		// Click on 'Picker View'
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Picker View'`]")).click();
		
		// Pick values in picker view. It can be done by just providing the value you want to select in picker
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("105");
		
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("55");
		
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("170");
		
		String bluePickerValStr= driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText();
		// Validate the value in third picker, Blue color component value
		Assert.assertEquals(bluePickerValStr, "170");
	}
}
