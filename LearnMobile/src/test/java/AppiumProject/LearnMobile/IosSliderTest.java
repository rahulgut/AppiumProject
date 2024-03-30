package AppiumProject.LearnMobile;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IosSliderTest extends IosBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void iosSlider() {
		// Calling configureAppium() method in BaseTest class
		//configureAppium();
		
		// Appium configuration will be called automatically because IosBaseTest class has been inherited. IosBaseTest class has iOS appium configuration and tear down methods, which gets gets called because of @BeforeClass and @AfterClass TestNG annotations.
		
		// Element locators in IOS - xpath, id, accessibiliyId, classname, iOSClassChain, iOSNsPredicateString
		
		// Grab element for Slider
		WebElement sliderEle= driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem'`]"));
		
		sliderEle.sendKeys("0%");
		System.out.println(sliderEle.getAttribute("value"));
		Assert.assertEquals(sliderEle.getAttribute("value"), "0%");
		
		sliderEle.sendKeys("1%");
		System.out.println(sliderEle.getAttribute("value"));
		Assert.assertEquals(sliderEle.getAttribute("value"), "100%");
	}
}
