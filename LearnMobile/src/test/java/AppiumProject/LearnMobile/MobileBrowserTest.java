package AppiumProject.LearnMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileBrowserTest extends MobileBrowserBaseTest {
	
	// To execute it as a TestNG test
	@Test
	public void browserTest() throws InterruptedException {
		
		//Elements can be located by - xpath, ID, classname, accessibilityId, androidUIAutomator
		
		// Calling configureAppium() method in BaseTest class
		//configureAppium();
		
		// Appium configuration will be called automatically because MobileBrowserBaseTest class has been inherited. MobileBrowserBaseTest class has appium configuration and tear down methods, which gets gets called because of @BeforeClass and @AfterClass TestNG annotations.
		
		// Working on mobile browser is same as working on web browser. So, we will be using Selenium for the same
		driver.get("https://www.google.com/");
		
		// Changing language from German to English
		driver.findElement(By.xpath("//android.view.View[@resource-id=\"vc3jof\"]")).click();
		
		driver.findElement(By.xpath("(//android.view.MenuItem[@text=\"‪English (United Kingdom)‬\"])[1]")).click();
		
		// Click on 'Read more'
		driver.findElement(By.xpath("//android.widget.Button[@text=\"Read more\"]")).click();
		
		// Accepting cookies by click 'Accept all'
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"L2AGLb\"]")).click();
		
		// Get the title of the page
		System.out.println(driver.getTitle());
	}
}
