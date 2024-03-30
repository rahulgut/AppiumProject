package AppiumProject.LearnMobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IosSwipeTest extends IosBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void iosSwipeGesture() {
		
		// Calling configureAppium() method in BaseTest class
		//configureAppium();
		
		// Appium configuration will be called automatically because IosBaseTest class has been inherited. IosBaseTest class has iOS appium configuration and tear down methods, which gets gets called because of @BeforeClass and @AfterClass TestNG annotations.
		
		// Element locators in IOS - xpath, id, accessibiliyId, classname, iOSClassChain, iOSNsPredicateString
		
		// Instead of using the apps we have in resources for testing, we will invoke inbuilt iOS Photos app using bundleId
		// To invoke any app in iOS for testing, either we need to provide app or bundleId
		
//		// Create map object params
//		Map<String,String> params= new HashMap<>();
//		
//		// Add param to the object. Providing bundleId for Photos app
//		params.put("bundleId", "com.apple.mobileslideshow");
//		
//		// Call executeScript() method by providing what needs to be performed and params as arguments. It will launch Photos app
//		driver.executeScript("mobile: launchApp", params);
		
		// Calling launchInbuiltApp() in IosBaseTest class to launch Photos app
		launchInbuiltApp();
		
		// Get the list of photos
		List<WebElement> allPhotos= driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		
		System.out.println(allPhotos.size());
		
		// Validate count of photos
		Assert.assertEquals(allPhotos.size(), 6);
		
		// Click on 1st photo
		driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
		
		// Perform swipe on photos until you reach last photo
		
		// Create map object paramObj
//		Map<String,Object> paramObj= new HashMap<String,Object>();
//		
//		// Add params to the object
//		paramObj.put("direction", "left");
//		
//		// Let's perform swipes equal to the count of photos
//		for(int i=0;i<allPhotos.size();i++) {
//			
//			// Print each photo name/ timestamp on console
//			System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
//			
//			// Call executeScript() method by providing what needs to be performed and params as arguments
//			driver.executeScript("mobile: swipe", paramObj);
//		}
		
		// Calling swipeAction() in IosBaseTest class to swipe photos in Photos app til the last photo
		swipeAction(allPhotos, "left");
		
		
		// Cleanup script to go back to the default screen for Photos app, by clicking back button on top left
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'All Photos'`]")).click();
		
		// Instead we can use navigate().back() as well
		//driver.navigate().back();
	}
}
