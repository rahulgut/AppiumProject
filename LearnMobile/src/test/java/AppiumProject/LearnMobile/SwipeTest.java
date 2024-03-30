package AppiumProject.LearnMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeTest extends AndroidBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void swipeGesture() {
		
		// Appium configuration will be called automatically because BaseTest class has been inherited. BaseTest class has appium configuration and tear down method
		
		// Click on "Views"
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// Click on "Gallery"
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Gallery']")).click();
		
		// Click on "1. Photos"
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		//Grab element for 1st image
		WebElement firstImage= driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		// Validate focusable attribute for 1st image
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
		
		swipeAction(firstImage, "left");
		
		// Validate focusable attribute for 1st image
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
				
	}

}
