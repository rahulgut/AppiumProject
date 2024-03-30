package AppiumProject.LearnMobile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		// Appium server start
		service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
		//service.start();
				
		// Creating object for Android driver UiAutomator2Options
		UiAutomator2Options options = new UiAutomator2Options();
		
		// Desired capabilities for Android driver UiAutomator2Options
		options.setDeviceName("RahulPixel");
		
		options.setChromedriverExecutable("/Users/rahul/AppiumLearning/ChromeDriver/chromedriver103");
		
		//options.setChromedriverExecutable("/usr/local/lib/node_modules/appium-chromedriver");
		
		
		//options.setApp("/Users/rahul/AppiumLearning/LearnMobile/src/test/java/resources/ApiDemos-debug.apk");
		options.setApp("/Users/rahul/AppiumLearning/LearnMobile/src/test/java/resources/General-Store.apk");
				
		//Android Driver
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		//Applying implicit wait Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	public void longPressAction(WebElement ele) {
		//Long click
//		driver.executeScript("mobile: longClickGesture", 
//				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), 
//						"duration",2000));
		
		// We can cast this driver with JavascriptExecutor. However, it works without it as well.
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), 
						"duration",2000));
	}
	
	public void scrollToEndAction() {
		// When you want to scroll based on the coordinates. We can scroll to the end of the page by putting do while condition
		boolean canScrollMore;
		
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement firstImage, String dir) {
		// Perform slide gesture
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) firstImage).getId(),
				"direction", dir,
				"percent", 0.75
		));
	}
	
	public void dragDropAction(WebElement dragElement, int xCord, int yCord) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) dragElement).getId(),
			    "endX", xCord,
			    "endY", yCord
		));
	}
	
	public double formatAmount(String priceStr) {
		return Double.parseDouble(priceStr.substring(1).trim());
	}
	
	@AfterClass
	public void tearDown() {
		//Close Android driver
		//driver.quit();
				
		//Stop Server
		//service.stop();
	}

}
