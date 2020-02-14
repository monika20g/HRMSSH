package com.qa.orangehrm.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.util.Utility;
//this is page for logout
//this is page for logout
public class LogoutPage {
	
	WebDriver driver;
	
	public LogoutPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	By adminText=By.xpath("//a[text()='Welcome Admin']");
	
	By logoutText=By.xpath("//a[text()='Logout']");
	
	
	public void logOutFromApplicationWithAdminRole() {
		
		/*driver.findElement(adminText).click();
		driver.findElement(logoutText).click();*/
		
		Utility.waitForWebElement(driver,adminText).click();
		Utility.waitForWebElement(driver,logoutText).click();
	
		
		
	}

}
