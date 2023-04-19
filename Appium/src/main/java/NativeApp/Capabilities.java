package NativeApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;

public class Capabilities {
public static AndroidDriver<AndroidElement> cap() throws MalformedURLException {
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Manu");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Andriod");
	//dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
	//default automation name for mobile is Appium and it work for both andriod and ios
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.andriod.apis");
	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.andriod.apis.ApisDemos");
	AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0.4723/wd/hub"),dc);
	return driver;
}
}
