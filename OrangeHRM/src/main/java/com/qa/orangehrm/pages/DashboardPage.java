package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.util.Utility;

public class DashboardPage
{

	WebDriver driver;
	By  adminButton= By.xpath("//*[text()='Admin']");
	By pimButton=By.xpath("//*[text()='PIM']");
	By leaveButton=By.xpath("//*[text()='Leave']");
	By AssignLeaveLink=By.xpath("(//img)[2]");
	//can we initialize the page Objects here instead of DashboardScanario class?
/*	public DashboardPage() {
		PageFactory.initElements(driver, this);
		
	}*/
	/*	public String verifyPage()
	{
		return null;
		
	}
	
	public  AdminPage clickOnAdminPageLink()
	{
		
		return new AdminPage();
		
	}
*/	
	
}
