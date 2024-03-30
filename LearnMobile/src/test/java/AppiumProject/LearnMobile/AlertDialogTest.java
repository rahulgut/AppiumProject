package AppiumProject.LearnMobile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AlertDialogTest extends AndroidBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void alertDialogHandling() throws InterruptedException {
		
		// Click on "App"
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]")).click();
		
		// Click on "Alert Dialogs"
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		// Click on "OK Cancel dialog with a long message"
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
		
		// Validate if alert dialog title
		String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "Header title");
		
		// Click 'Cancel' on alert
		driver.findElement(By.id("android:id/button2")).click();
		
		// Click 'Single choice list'
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
				
		// Select Satellite radio button
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Satellite\"]")).click();
				
		// Click OK on alert 'Single choice list'
		driver.findElement(By.id("android:id/button1")).click();
		
		// Click on 'Text Entry dialog'
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Text Entry dialog\"]")).click();
		
		// Enter name in text field
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Rahul");
		
		// Enter password in text field
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Pass@123");
		
		// Click OK 'Text Entry dialog'
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		
		// Click on 'OK Cancel dialog with traditional theme'
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
		
		// Click OK on 'OK Cancel dialog with traditional theme'
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		
		// Click on 'List dialog'
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		
		// Validate count of dialog list items and print them
		List<WebElement> dialogListItems= driver.findElements(By.className("android.widget.TextView"));
		
		System.out.println("Size of List: "+dialogListItems.size());
		Assert.assertEquals(dialogListItems.size(), 5);
		
		for(WebElement ele :dialogListItems) {
		    System.out.println(ele.getText());
		}
		
		// Click on 'Command two' list
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Command two\"]")).click();
		
		// Validate message
		String alertMsg= driver.findElement(By.id("android:id/message")).getText();
		Assert.assertEquals(alertMsg, "You selected: 1 , Command two");
		
		
		// Accepting alert using Selenium alert 
		//Alert alert= driver.switchTo().alert();
		//alert.accept();
		
		
	}

}
