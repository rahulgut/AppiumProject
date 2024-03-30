package AppiumProject.LearnMobile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBrowserBaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		// Appium server start
		service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
		//service.start();
				
		// Desired capabilities for Android driver
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("RahulPixel");
		
		options.setChromedriverExecutable("/Users/rahul/AppiumLearning/ChromeDriver/chromedriver103");
		
		//options.setCapability("browserName", "Chrome");
		
		// Getting below error and unable to launch mobile chrome browser
		
		//org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: An unknown server-side error occurred while processing the command. Original error: An unknown server-side error occurred while processing the command. Original error: unknown error: Failed to start com.android.chrome on device emulator-5554: Starting: Intent { dat=data: cmp=com.android.chrome/com.google.android.apps.chrome.Main }
		//Error type 3
		//Error: Activity class {com.android.chrome/com.google.android.apps.chrome.Main} does not exist.
		
		// Workaround is to use below 2 capabilities, appPackage and appActivity. Also, comment out capability browserName
		options.setCapability("appPackage", "com.android.chrome");
		options.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		// To grant permission for notifications, accept all cookies etc.
		options.setCapability("autoGrantPermissions", true);
		
				
		//Android Driver
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		//Applying implicit wait Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	
	@AfterClass
	public void tearDown() {
		//Close Android driver
		//driver.quit();
				
		//Stop Server
		//service.stop();
	}

}
