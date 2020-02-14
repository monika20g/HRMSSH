package com.qa.orangehrm.tests;
import org.testng.annotations.Test;



import org.openqa.selenium.support.PageFactory;


import com.qa.orangehrm.base.BaseClass;
import com.qa.orangehrm.factories.DataProviderFactory;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.LogoutPage;

public class LoginScenarios extends BaseClass {
	public LoginPage login;
    public LogoutPage logout;
	public  AdminPage adminPage;
	@Test(priority=0)
	public void verifyPage()
	{	//how will you initialize ur page factory?
	   login=PageFactory.initElements(driver,LoginPage.class);
	   logout=PageFactory.initElements(driver,LogoutPage.class);
		//adminPage=PageFactory.initElements(driver,AdminPage.class);
		
		logger=report.createTest("URL validation");
		login.verifyUrlBeforeLogin();			
		logger.info("Validating url");
	}
	
	@Test(priority=1,dependsOnMethods="verifyPage")
	public void loginToApplication()
	{
		//ExcelProvider excel;
		
		//	excel = new ExcelProvider();
		
		logger=report.createTest("Login as admin");
		
	//	login.loginToApplication("Admin","admin123");
		
     login.loginToApplication(DataProviderFactory.getExcel().getCellData("OrangeHRM", 1, 0),
				
				DataProviderFactory.getExcel().getCellData("OrangeHRM", 1, 1));
		
		System.out.println("credential entered!!");
	   
		login.verifyUrlAfterLogin();
		System.out.println("verify");
		
		logger.info("Logged in");
		
	}
	/*@Test(priority=2)
	public void clickOnAdminButton()
	{
	login.clickOnAdminButton(driver);
		
	}*/
	
/*	@Test(priority=2,dependsOnMethods="loginToApplication")
	public void logoutFromApplication() throws InterruptedException
	{
		logger=report.createTest("Logout");
		
		logout.logOutFromApplicationWithAdminRole();
		System.out.println("logged out !!!!");
	    logger.info("Logout done");
		
	}*/

}
