package AppiumProject.LearnMobile;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragDropTest extends AndroidBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void dragDropGesture() {
		
		// Click on "Views"
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// Click on "Drag and Drop"
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		// WebElement that needs to be dragged
		WebElement dragEle= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		
		// Perform drag and drop
		dragDropAction(dragEle, 631, 619);
		
		// Validate dropped result text
		String resultText= driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(resultText, "Dropped!");
	}

}
