package AppiumProject.LearnMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.Test;



public class MobBrowserRSAApp extends MobileBrowserBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void rSAAppDemoTest() throws InterruptedException {
		//Elements can be located by - xpath, ID, classname, accessibilityId, androidUIAutomator
		
		// Calling configureAppium() method in BaseTest class
		//configureAppium();
		
		// Appium configuration will be called automatically because MobileBrowserBaseTest class has been inherited. MobileBrowserBaseTest class has appium configuration and tear down methods, which gets gets called because of @BeforeClass and @AfterClass TestNG annotations.
		
		// Working on mobile browser is same as working on web browser. So, we will be using Selenium for the same
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		//driver.findElement(By.className("driver.getTitle()")).click();
		//driver.findElement(By.xpath("//span[@class=\"navbar-toggler-icon\"]")).click();
		//driver.findElement(By.className("navbar-toggler-icon")).click();
		
		// To Scroll
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
		
		
	}
}
