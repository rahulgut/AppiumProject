package AppiumProject.LearnMobile;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IosLongPressTest extends IosBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void iOSLongPressGesture() {
		// Calling configureAppium() method in BaseTest class
		//configureAppium();
		
		// Appium configuration will be called automatically because IosBaseTest class has been inherited. IosBaseTest class has iOS appium configuration and tear down methods, which gets gets called because of @BeforeClass and @AfterClass TestNG annotations.
		
		// Element locators in IOS - xpath, id, accessibiliyId, classname, iOSClassChain, iOSNsPredicateString
		
		// Click on 'Steppers'
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Steppers'")).click();
		
		// Long press on custom + icon
		
		// Locate an element where long press needs to be performed
		WebElement ele= driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
		
//		// Create map object params
//		Map<String,Object> params= new HashMap<>();
//		
//		// Add params to the object
//		params.put("element", ((RemoteWebElement) ele).getId());
//		params.put("duration", 5);
//		
//		// Call executeScript() method by providing what needs to be performed and params as arguments
//		driver.executeScript("mobile: touchAndHold", params);
		
		// Calling function longPressAction() in IosBaseTest class and passing WebElement as an argument
		longPressAction(ele);
	}
}
