package tests;

import java.net.MalformedURLException; 
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeSuite
	public void setup() throws MalformedURLException {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		   capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		   capabilities.setCapability("deviceName", "localhost:5555");
		   capabilities.setCapability("appPackage", "com.google.android.calculator");
		   capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
		   capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		   capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		   driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}
	@AfterSuite
	public void quit() {
		driver.quit();
	}
	

}
