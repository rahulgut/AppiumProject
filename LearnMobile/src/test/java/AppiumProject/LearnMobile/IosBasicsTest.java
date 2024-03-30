package AppiumProject.LearnMobile;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IosBasicsTest extends IosBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void iOSBasics() {
		// Calling configureAppium() method in BaseTest class
		//configureAppium();
		
		// Appium configuration will be called automatically because IosBaseTest class has been inherited. IosBaseTest class has iOS appium configuration and tear down methods, which gets gets called because of @BeforeClass and @AfterClass TestNG annotations.
		
		// Element locators in IOS - xpath, id, accessibiliyId, classname, iOSClassChain, iOSNsPredicateString
		
		// Click on 'Alert Views'
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		// Avoid using xpath in iOS because it is slow. xpath is based on XML and iOS native language is not designed on XML. So, there is lot of work in background for appium to scan and serialize iOS code to support XML and applying xpath to it and then deserialize XML to App source.
		//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
		
		// iOSClassChain is faster than xpath
		
		// Click on 'Text Entry'
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label=='Text Entry'`]")).click();
		
		// Type Hello in text field on alert
		driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTextField\"")).sendKeys("Hello");
		
		// Click OK on alert
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
		
		// Click on 'Confirm / Cancel'
		// We can locate an element using iOSNsPredicateString by aggregating multiple string matches as well
		//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Confirm / Cancel'")).click();
		
		// In iOSNsPredicateString, we can use regular expression BEGINSWITH as well
		//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label BEGINSWITH 'Confirm'")).click();
		
		// In iOSNsPredicateString, we can use regular expression BEGINSWITH along with [c] telling it is case sensitive
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label BEGINSWITH[c] 'Confirm'")).click();

		// In iOSNsPredicateString, similarly we can use regular expression ENDSWITH as well
		//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label ENDSWITH 'Cancel'")).click();
		
		// In iOSNsPredicateString, similarly we can use regular expression ENDSWITH along with [c] telling it is case sensitive
		//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label ENDSWITH[c] 'Cancel'")).click();

		// Locate, grab and print in console text on Action sheet
		String textMsg= driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH 'A message'")).getText();
		System.out.println(textMsg);
		
		// Click 'Confirm' on Action sheet
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Confirm\"`]")).click();
		
	}
}
