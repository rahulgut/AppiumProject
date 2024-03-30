package AppiumProject.LearnMobile;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;




public class AppiumBasics extends AndroidBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void wifiSettingName() throws MalformedURLException {
		
		//Elements can be located by - xpath, ID, classname, accessibilityId, androidUIAutomator
		
		// Calling configureAppium() method in BaseTest class
		//configureAppium();
		
		// Appium configuration will be called automatically because BaseTest class has been inherited. BaseTest class has appium configuration and tear down method
		
		//Locating element by accessibilityId
		// Click on 'Preference'
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		// Click on Preference dependencies
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		// Click on WiFi checkbox
		driver.findElement(By.id("android:id/checkbox")).click();
		
		// Click on WiFi settings
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		// Validate alert pop up title WiFi Settings
		String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		// Type WiFi name in settings
		driver.findElement(By.className("android.widget.EditText")).sendKeys("RahulFi");
		
		// Click OK on WiFi settings
		//driver.findElement(By.id("android:id/button1")).click();
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		
		
		// Calling tearDown() method in BaseTest class
		//tearDown();
		
	}

}
