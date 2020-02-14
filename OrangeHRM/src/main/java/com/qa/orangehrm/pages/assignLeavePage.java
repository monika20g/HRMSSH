package com.qa.orangehrm.pages;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.util.Utility;
public class assignLeavePage
{
WebDriver driver;
	
	public assignLeavePage(WebDriver ldriver)
	{
		this.driver=ldriver;	
	}
	
//PageFactory
By EmployeeName=By.xpath("//input[@id='assignleave_txtEmployee_empName']");
By AssignLeaveBttn=By.xpath("(//img)[2]");
By leaveTypeList=By.xpath("//select[@id='assignleave_txtLeaveType']/option");
By FromCalenderImage =By.xpath("(//img[@class='ui-datepicker-trigger'])[1]");
By FromDate=By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a");
By ToCalenderImage =By.xpath("(//img[@class='ui-datepicker-trigger'])[2]");
By ToDate=By.xpath("(//img[@class='ui-datepicker-trigger'])[2]");
By Assignbtn=By.xpath("//input[@id='assignBtn']");



public void assignLeavePage()	
{Utility.waitForWebElement(driver, AssignLeaveBttn).click();;

     Utility.waitForWebElement(driver,EmployeeName).sendKeys("Jasmine Morgan");;
	 List<WebElement>allValues=Utility.waitForMultipleWebElement(driver, leaveTypeList); 
	 Utility.selectValueFromCalender(allValues, "Paternity US");
	 Utility.waitForWebElement(driver,FromCalenderImage).click();
	
	 List<WebElement>allValues1=Utility.waitForMultipleWebElement(driver, FromDate); 
	 Utility.selectValueFromCalender(allValues1, "25");
	 Utility.waitForWebElement(driver,ToCalenderImage).click();
		
	
	 List<WebElement>allValues2=Utility.waitForMultipleWebElement(driver,ToDate); 
	 Utility.selectValueFromCalender(allValues2, "28");
	 Utility.waitForWebElement(driver,Assignbtn).click();
  
   
}

}
