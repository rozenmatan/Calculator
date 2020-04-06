package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	private AppiumDriver<MobileElement> driver;
	private TouchAction action;
	
	public BasePage(AppiumDriver<MobileElement> driver) {
		
		this.driver = driver;
		action = new TouchAction(driver);
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	public void tap(MobileElement el) {
		
		action.tap(PointOption.point(el.getLocation().x,el.getLocation().y)).perform();
	}
	public void tap(int x, int y) {
		
		action.tap(PointOption.point(x,y)).perform();
	}
	
	public void swipeByCoordinate(int fromX,int fromY,int toX,int toY) {
		action.press(PointOption.point(fromX,fromY)).moveTo(PointOption.point(toX,toY)).release().perform();
	}
}
