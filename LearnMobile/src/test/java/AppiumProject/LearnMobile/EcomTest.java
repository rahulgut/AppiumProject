package AppiumProject.LearnMobile;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EcomTest extends AndroidBaseTest{
	
	// To execute it as a TestNG test
	@Test
	public void fillForm() throws InterruptedException {
		
		// Click on static dropdown to select the country
		driver.findElement(By.id("android:id/text1")).click();
		
		// Click on option 'Angola', which is in the view
		driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']")).click();
		
		// Scroll down to view an option 'India' in the countries list
		
		// When you exactly know where to scroll, by providing web element
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		
		// Click on option 'India', which is now in the view after scrolling
		//driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		
		// Click on 'Lets Shop' button which will validate the form
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Grabbing toast message
		String toastMsg= driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		
		// Validating toast message
		Assert.assertEquals(toastMsg, "Please enter your name");
		
		// Enter name in the name field
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Chameli");
		
		// To hide the keyboard, in order to proceed with elements below.
		//driver.hideKeyboard();
		
		// Select radio button female
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		// Click on 'Lets Shop' button which will validate and submit the form
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Add 2nd product to cart
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
		
		
		// Scroll down to view product 'Jordan 6 Rings' in the products list
		String addProduct= "Jordan 6 Rings";
		
		// When you exactly know until where to scroll, by providing web element name
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		// Get products count from the list
		int productCount= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		// Iterate through the list to find product 'Jordan 6 Rings'
		for(int i=0;i<productCount;i++) {
			String productName= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productName.equalsIgnoreCase(addProduct)) {
				// Add to cart
				driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).get(i).click();
				//driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		// Click on Cart icon to go to the cart page
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		// Applying explicit wait for the cart page to load. Not required on this machine, but issue may occur because of slowness
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		// Waiting until 5 seconds for the 'Cart' title to appear
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		// Validate if cart page has product 'Jordan 6 Rings'
		int productCountCartPage= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		// Iterate through the list to find product 'Jordan 6 Rings'
		for(int i=0;i<productCountCartPage;i++) {
			String productNameCartPage= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productNameCartPage.equalsIgnoreCase(addProduct)) {
				// Validate with assertion
				Assert.assertEquals(productNameCartPage, addProduct);
			}
		}
		
		// Calculate total price of products in the cart
		double totalPrice=0;
		for(int i=0;i<productCountCartPage;i++) {
			String productPriceString= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			
			// Calling function formatAmount() in BaseTest class
			double productPrice = formatAmount(productPriceString);
			//double productPrice = Double.parseDouble(productPriceString.substring(1).trim());
			totalPrice= totalPrice + productPrice;
		}
		
		String totalAmountString= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		// Calling function formatAmount() in BaseTest class
		double totalAmount = formatAmount(totalAmountString);
		//double totalAmount = Double.parseDouble(totalAmountString.substring(1).trim());
		
		// Validate total of products in the cart
		Assert.assertEquals(totalPrice, totalAmount);
		
		// Click on checkbox before proceeding
		driver.findElement(By.className("android.widget.CheckBox")).click();
		
		// Long press on terms and conditions to open it
		//WebElement termEle= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		
		// Calling longPressAction() reusable method in BaseTest class
		longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		
		// Validate alert title
		String alertTitle= driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "Terms Of Conditions");
		
		// Validate alert message body
		String alertBody= driver.findElement(By.id("android:id/message")).getText();
		Assert.assertEquals(alertBody, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
		
		// Close the terms and conditions alert dialog 
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		
		// Click on button will open browser webpage to complete the purchase. It's a Hybrid app, which means it has both native and web view.
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		// Applying sleep for browser web page to render
		Thread.sleep(3000);
		// driver doesn't have knowledge of handling browser. We need to provide driver with the context of web page.
		
		// Grab all context names that developer has given in the app
		Set<String> contexts= driver.getContextHandles();
		
		// Printing all contect names in console, in order to find context name for handling web view
		for(String contextName: contexts) {
			System.out.println(contextName); // It will return 2 contexts: NATIVE_APP and WEBVIEW_com.androidsample.generalstore
		}
		
		// Changing language from German to English
		driver.findElement(By.xpath("//android.view.View[@resource-id=\"vc3jof\"]")).click();
		
		driver.findElement(By.xpath("(//android.view.MenuItem[@text=\"‪English (United Kingdom)‬\"])[1]")).click();
		
		// Click on 'Read more'
		//driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"KByQx\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text=\"Read more\"]")).click();
		
		// Accepting cookies by click 'Accept all'
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"L2AGLb\"]")).click();
		
		// Switch to web view context, in order to handle browser page in mobile app
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		// On mobile browser, we can work just like Selenium, as we do for web browser. Infact, we can inspect elements from web browser itself. Mobile browser is no different
		driver.findElement(By.cssSelector("textarea[name=\"q\"]")).sendKeys("rahul dhawan");
		
		// Click enter
		driver.findElement(By.cssSelector("textarea[name=\"q\"]")).sendKeys(Keys.ENTER);
		
		// Click back button to go back to Native app
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		// Switch to native app context, in order to handle native app
		driver.context("NATIVE_APP");
	}

}
