
package com.qa.orangehrm.base;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.qa.orangehrm.config.ConfigProvider;
import com.qa.orangehrm.factories.BrowserFactory;
import com.qa.orangehrm.factories.DataProviderFactory;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.LogoutPage;
import com.qa.orangehrm.util.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
    public WebDriver driver;
    public static ExtentReports report;
    public ExtentTest logger;
	//public ExtentTest logger;
	@BeforeSuite
   public void setupReport()
    {   System.out.println("Log:INFO- Report is getting setup");
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./Report/"+"ExtentReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		System.out.println("Log:INFO- Report setup is Ready");
    }
	@AfterMethod
	public void tearDownReport(ITestResult result)
	{
		System.out.println("Log:INFO- Test Executed- Tat Status is "+result.getStatus());
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
		try {
			logger.fail("Test Filed "+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to attach screenshot in report  "+e.getMessage());
		}	
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skipped");	
		}
		report.flush();
		
	}
    @BeforeClass
	public void setUp()
    {
    	System.out.println("Log:INFO-Setting up Browser and Application");
  //  	ConfigProvider config=new ConfigProvider();
	driver=BrowserFactory.getApplication(DataProviderFactory.getConfig().getValue("Browser"),DataProviderFactory.getConfig().getValue("StagingURL"));
	System.out.println("Log:INFO- Browser and Application is ready");
	/*login=PageFactory.initElements(driver,LoginPage.class);
	logout=PageFactory.initElements(driver,LogoutPage.class);*/
	}
   @AfterClass
   public void tearDown()
   {System.out.println("Log:INFO- Terminating browser");
 BrowserFactory.closeApplication(driver);
  System.out.println("Log:INFO- Report browser Terminated");
    }

                         }
