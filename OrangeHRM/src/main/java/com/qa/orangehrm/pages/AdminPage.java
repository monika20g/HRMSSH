package com.qa.orangehrm.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.util.Utility;

public class AdminPage {
	WebDriver driver;
	
	public AdminPage(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	
By adminTab=By.xpath("//a[@id='menu_admin_viewAdminModule']");
By addButton=By.id("btnAdd");	
By empName=By.xpath("//input[@id='systemUser_employeeName_empName']");
By userName=By.xpath("//input[@id='systemUser_userName']");
By saveButton=By.xpath("//input[@id='btnSave']");
By UserRoleList=By.xpath("//select[@id='systemUser_userType']/option");

public void selectContactsByName(String name)
{   Utility.waitForWebElement(driver, adminTab).click();
	By clickOnCheckbox=By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/input");
   // By clickOnCheckbox=By.xpath("//a//parent::td//preceding-sibling::td/input");
    /*List<WebElement>allValuesFromList=Utility.waitForMultipleWebElement(driver,  clickOnCheckbox); 
    
    Utility.selectValueFromCalender(allValuesFromList, "name");	*/
	//Utility.waitForWebElement(driver, adminTab).click();
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/input")).click();
}

public void createUser()	
{
Utility.waitForWebElement(driver, adminTab).click();
Utility.waitForWebElement(driver, addButton).click();;

	 List<WebElement>allValues=Utility.waitForMultipleWebElement(driver, UserRoleList); 
	 Utility.selectValueFromCalender(allValues, "Admin");
	   
	Utility.waitForWebElement(driver, empName).sendKeys("Jasmine Morgan");;
	Utility.waitForWebElement(driver,  userName).sendKeys("Dinesh_05");;

	Utility.waitForWebElement(driver, saveButton).click();;
   
}
}