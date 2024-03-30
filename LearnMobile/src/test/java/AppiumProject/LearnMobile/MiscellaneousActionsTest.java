package AppiumProject.LearnMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousActionsTest extends AndroidBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void miscGestures() {
				
		// Appium configuration will be called automatically because BaseTest class has been inherited. BaseTest class has appium configuration and tear down method
				
		//Locating element by accessibilityId
		// Click on 'Preference'
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		// Click on Preference dependencies
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		// Opening internal app page directly. Using app package and app activity
		
		// On terminal run this command to get the app package and activity name, adb shell dumpsys window | grep -E 'mCurrentFocus'
		// We will get this, mCurrentFocus=Window{c498592 u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
		
		// For opening Wifi screen (Preference dependencies page) on the app directly, we have App package: io.appium.android.apis and App Activity: io.appium.android.apis.preference.PreferenceDependencies
		
		// Passing package name and activity name as arguments
		//Activity activityObj = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		
		// driver.startActivity() is deprecated in current version of Appium ^2.0. 
		//Instead use, mobile: startActivity through javascript, as we did for gestures
		//driver.startActivity(activityObj);
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				"intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
		));
				
		// Click on WiFi checkbox
		driver.findElement(By.id("android:id/checkbox")).click();
				
		// Click on WiFi settings
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
				
		// Validate alert pop up title WiFi Settings
		String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		// Copy to clip board
		driver.setClipboardText("Rahul D");
		
		// Android key events
		// Pressing ENTER button on the device keyboard
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		// Paste from Clip board
		// Paste WiFi name in settings from Clip board
		driver.findElement(By.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
		
		// Rotate device to landscape mode
		DeviceRotation landScapeMode = new DeviceRotation(0, 0, 90);
		driver.rotate(landScapeMode);
		
		// Pressing BACK button on the device
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
				
		// Pressing Home button on the device
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}

}
