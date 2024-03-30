package AppiumProject.LearnMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPress extends AndroidBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void longPressGesture() throws InterruptedException {
		
		// Appium configuration will be called automatically because BaseTest class has been inherited. BaseTest class has appium configuration and tear down method
		
		// Click on "Views"
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// Click on "Expandable Lists"
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		
		// Click on "1. Custom Adapter"
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		// Long click or Long press on "People Names"
		// Locate element
		WebElement elem = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		// Calling longPressAction() method
		longPressAction(elem);
		
		// Applying sleep to see the long click execution happening
		Thread.sleep(2000);
		
		// Get text of Sample menu option that appeared on long press
		String menuText= driver.findElement(By.id("android:id/title")).getText();
		
		// Validate text of Sample menu
		Assert.assertEquals(menuText, "Sample menu");
		
		// Validate if Sample menu option is displayed
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
	}

}
