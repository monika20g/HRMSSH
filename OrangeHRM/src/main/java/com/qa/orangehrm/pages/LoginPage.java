package com.qa.orangehrm.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.orangehrm.util.Utility;



public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	
	
	//page factory - OR
	By user= By.id("txtUsername");


	//@FindBy(id="txtUsername") 
	//WebElement user;
	By password=By.id("txtPassword");
	//@FindBy(name="txtPassword")
	//WebElement pass;
	By loginButton=By.xpath("//input[@value='LOGIN']");
	/*@FindBy(xpath="//input[@value='LOGIN']") 
	WebElement loginButton;*/
	By  adminButton= By.xpath("//*[text()='Admin']");
	
	public void verifyUrlBeforeLogin()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login Page does not contain login url");	
	}
	
	
	public void verifyUrlAfterLogin()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard does not contain dashboard keyword");	
	}
	

	public void typeUserName()
	{
		Utility.waitForWebElement(driver, user).sendKeys("Admin");
		//user.sendKeys("Admin");
	}
	
	public void typePassword()
	{
		Utility.waitForWebElement(driver,password).sendKeys("admin123");
		//pass.sendKeys("admin123");
	}
	
	public void clickOnLoginButton()
	{
		Utility.waitForWebElement(driver,loginButton).click();
		//loginButton.click();
	}
	
	//Actions
	public  DashboardPage loginToApplication(String userName,String passWord)
	{
		/*user.sendKeys(userName);
		pass.sendKeys(passWord);
		loginButton.click();*/
		//return new  HomePage();
		Utility.waitForWebElement(driver,user).sendKeys(userName);
		Utility.waitForWebElement(driver,password).sendKeys(passWord);
		Utility.waitForWebElement(driver,loginButton).click();
		
		return new DashboardPage();
		
	}
	
	/*public AdminPage clickOnAdminButton(WebDriver driver,By adminButton)
	{
		Utility.waitForWebElement(driver,adminButton).click();
		//AdminButton.click();
		return new AdminPage();
		
	}*/
	
	

}

