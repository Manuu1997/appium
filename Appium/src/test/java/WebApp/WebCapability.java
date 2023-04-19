package WebApp;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WebApps.WebApplication;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebCapability extends WebApplication
{
AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException
	{
		driver=cap2();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void t1() throws InterruptedException
	{
		driver.get("htpps://www.google.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='c']")).sendKeys("moolyaed");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		List<AndroidElement> links=driver.findElements(By.tagName("a"));
		links.size();
		System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
			Thread.sleep(3000);
			System.out.println(links.get(i).getText());
			Thread.sleep(4000);
			System.out.println(links.get(i).getAttribute("href"));
		}
	
	}
}
