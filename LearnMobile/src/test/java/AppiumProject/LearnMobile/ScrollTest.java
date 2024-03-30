package AppiumProject.LearnMobile;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollTest extends AndroidBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void scrollGesture() {
		
		// Appium configuration will be called automatically because BaseTest class has been inherited. BaseTest class has appium configuration and tear down method
		
		// Click on "Views"
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// Scroll down to view "WebView"
		
		// When you exactly know where to scroll, by providing web element
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		// When you want to scroll based on the coordinates. We can scroll to the end of the page by putting do while condition
		// Calling scrollToEndAction() method
		scrollToEndAction();
		
	}

}
