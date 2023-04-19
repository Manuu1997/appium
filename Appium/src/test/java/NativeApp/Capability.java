package NativeApp;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
//for tap options
import static io.appium.java_client.touch.TapOptions.tapOptions;
//for element option
import static io.appium.java_client.touch.offset.ElementOption.element;
//for longpress
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//for time
import static java.time.Duration.ofSeconds;

import java.awt.event.KeyEvent;

public class Capability extends Capabilities
{
	AndroidDriver<AndroidElement>	driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException
	{
		driver=cap();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test(enabled=false)
	public void perferences() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("3.Preference Dependencies"));
		driver.findElement(By.id("andriod:id/checkbox")).click();
		//driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
		//when you are using andriod ui automator to identify any element using an attribute,then
		//you have to use ui selector method for selecting the attribute
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(By.id("andriod:id/edit")).sendKeys("Manasa");
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
@Test(enabled=false)
public void notifications()
{
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.openNotifications();
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Appium Settings\")")).click();
	
}

@Test(enabled=false)
public void views() throws InterruptedException
{
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	//driver.findElement(MobileBy.AccessibilityId("Views")).click();
	//if you want to scroll then u need 3things
	//UIAutomator,UISelector,UIScrollable
	Thread.sleep(5000);
	driver.findElementByAndroidUIAutomator("new Uiscrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
	AndroidElement clickabale1=driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
	Dimension print = clickabale1.getSize();
	System.out.println(print);
}

@Test(enabled = true)
public void tapandlongpress()
{
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	AndroidElement ele=driver.findElement(MobileBy.AccessibilityId("Expandable Lists"));
	TouchAction ta=new TouchAction(driver);
	ta.tap(tapOptions().withElement(element(ele))).perform();
	driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
	AndroidElement ele1 = driver.findElementByAndroidUIAutomator("text(\"Fish Names\"");
	ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).release().perform();
	String sample =driver.findElementByClassName("android.widget.TextView").get(0).getText;
	System.out.println(sample);
	String action =driver.findElementByClassName("android.widget.TextView").get(0).getText;
	System.out.println(action);
}

@Test
public void Swipe()
{
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
	driver.findElement(By.xpath("//andriod.widget.TextView[@context-desc=\"2.Inline\"]")).click();
	TouchAction ta=new TouchAction(driver);
	AndroidElement ele1=driver.findElement((MobileBy.AccessibilityId("12"));
	AndroidElement ele2=driver.findElement(MobileBy.AccessibilityId("5"));
	ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(2))).moveTo(element(ele2)).release().perform();
	}

@Test
public void draganddrop() throws InterruptedException
{
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	driver.findElement(MobileBy.AccessibilityId("Drag and drop")).click();
	TouchAction ta=new TouchAction(driver);
	AndroidElement fcircle=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	AndroidElement scircle=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
	Thread.sleep(3000);
	ta.longPress(longPressOptions().withElement(element(fcircle)).withDuration(ofSeconds(3))).moveTo(element(scircle)).release().perform();
			}
@Test
public void msg() throws InterruptedException
{
	driver.findElementByAndroidUIAutomator("text(\"OS\")").click();
	driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
	driver.findElements(By.className("andriod.widget.TableRow")).get(0).click();;
	driver.findElement(MobileBy.AccessibilityId("io.appium.android.apis:id/sms_recipient")).sendKeys("6505551212");
	driver.findElement(MobileBy.AccessibilityId("io.appium.android.apis:id/sms_content")).sendKeys("hiiii");
	driver.findElement(MobileBy.AccessibilityId("Send")).click();
	Thread.sleep(7000);
	driver.activateApp("com.google.andriod.apps.messasging");
	String element=driver.findElement(MobileBy.id("")).getText();
	System.out.println(element);
	}
}
