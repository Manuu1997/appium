package HybridApp;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import io.appium.java_client.MobileBy;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.android.nativekey.AndroidKey;
	import io.appium.java_client.android.nativekey.KeyEvent;
	import io.appium.java_client.remote.AndroidMobileCapabilityType;
	import io.appium.java_client.remote.AutomationName;
	import io.appium.java_client.remote.MobileCapabilityType;

	public class GeneralStores {
	 AndroidDriver<AndroidElement> driver;
	
	 @BeforeTest
	public void bt() throws MalformedURLException {
    DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Manu");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
    dc.setCapability(MobileCapabilityType. AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.androidsample.generalstore");
	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.androidsample.generalstore.SplashActivity");
	driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);

	}

 @Test
	public void homepage() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	Thread.sleep(3000);
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("nikhil");
	driver.hideKeyboard();
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).click();
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(3000);
	//driver.pressKey(new KeyEvent(AndroidKey.BACK));
	//Thread.sleep(3000);
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))").click();
	//Thread.sleep(3000);
	//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(1).click();
	//Thread.sleep(3000);
	//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	String product1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
	Thread.sleep(3000);
	String product2 =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
	Thread.sleep(3000);
	//String product3=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(2).getText();
	System.out.println(product1);
	Thread.sleep(3000);
	System.out.println(product2);
	Thread.sleep(3000);
	//System.out.println(product3);
	//Thread.sleep(3000);
	String totalprice=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	System.out.println(totalprice);
	Thread.sleep(3000);
	product1 = product1.substring(1);
	Thread.sleep(3000);
	product2 = product2.substring(2);
	Thread.sleep(3000);
	//product3 = product3.substring(3);
	//Thread.sleep(3000);
	totalprice = totalprice.substring(1);
	Thread.sleep(3000);
	Double firstproduct = Double.parseDouble(product1);
	Thread.sleep(3000);
	Double secondproduct = Double.parseDouble(product2);
	Thread.sleep(3000);
    // Double thirdproduct = Double.parseDouble(product3);
	Double total = Double.parseDouble(totalprice);
	Double sum =firstproduct + secondproduct;
	if(total.equals(sum))
	{
	System.out.println("cost matching");
}
	else
	{
	System.out.println("cost will not match");
}
	driver.findElement(By.xpath("//*[@class='android.widget.CheckBox']")).click();
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
	  
	    }
	    
	}

}
	