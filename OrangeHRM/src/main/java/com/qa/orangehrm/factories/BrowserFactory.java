package com.qa.orangehrm.factories;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 
{  	public static void closeApplication(WebDriver driver)
	{
		driver.quit();
		System.out.println("LOG: INFO- Session closed");  
	}
public static WebDriver getApplication(String browserName,String appURL)
{
 WebDriver driver=null;	
	if (browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver","/Users/monika/Downloads/chromedriver 2");
		//./src/test/resources/drivers/chromedriver
	//	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"./src/test/resources/drivers/chromedriver");
	
		driver = new ChromeDriver();
	} else if (browserName.equals("firefox")) {
	
		driver = new FirefoxDriver();
	} else if (browserName.equals("safari")) {

	} else {
	System.out.println(browserName + " Browser value is wrong, please pass the correct browser name....");
	}
     
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	return driver;
	

}
	
	
	
	
	
}
