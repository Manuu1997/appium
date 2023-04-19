package WebApps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebApplication 
{
public static AndroidDriver<AndroidElement> cap2() throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Andriod");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C://Users//user//Downloads//chromedriver.exe");
		dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		return driver;
	}
}
