/*package com.qa.orangehrm.util;


//	https://www.phptravels.net/thflights/checkoutwe are on right page means ------we are on Checkout Page

	//	BELOW IS MY CODE:
		
		import java.io.File;
		import java.io.IOException;
		import java.util.Date;
		import java.util.Iterator;
		import java.util.List;
		import java.util.concurrent.TimeUnit;

		import org.apache.commons.io.FileUtils;
		import org.openqa.selenium.By;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
		//import org.openqa.selenium.chrome.ChromeDriver;

		public class extra {
			 static WebDriver driver;	
			public static void main(String[] args) throws IOException, InterruptedException {
				
			System.setProperty("webdriver.chrome.driver", "/Users/monika/Downloads/chromedriver 2");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://www.phptravels.net/index.php"); 
			
			//Title should contains Travel
					String title=driver.getTitle();
					System.out.println(title);
					if(title.contains("Travel"))
					{
						System.out.println("Title contain Travel");
					}
					else
					{
						System.out.println("Title does not contain Travel");
					}
			
			// Click on MyAccount > Click on Login
			driver.findElement(By.xpath("(//a[@id='dropdownCurrency'])[2]")).click();
			driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab show']/div/div/a[1]")).click();	
			
			//Url should contains login
			String LoginPg=driver.getCurrentUrl();
		    System.out.println(LoginPg); 
		    if(LoginPg.contains("login"))
			{
				System.out.println("Title contain login");
				System.out.println("We are on a Login Page");
			}
			else
			{
				System.out.println("Title does not contain login");
			}

		    
		   // capture screenshot before login
		    screenShot();
		    System.out.println("We took our first  screen shot.");
		    
			"Enter below credentials 
		    user@phptravels.com
		    Password demouser"
		   
			  driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("user@phptravels.com");  
		      driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("demouser");
		      driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		      
		     // capture screenshot after login
		      screenShot();
		      System.out.println("we took second  screen shot dont forget to see it in screenshort folder");
		    //  Thread.sleep(2000);
		     // Click on Flight Tab
		      
		      driver.findElement(By.xpath("//div[@id='mobileMenuMain']/nav/ul/li[3]")).click();
		    //  title should contains flights
		      
		     String FlightTabTitle= driver.getCurrentUrl();
		     if(FlightTabTitle.contains("flights")) 
		     { System.out.println("we clicked on flight tab");}
		     else
		    	 {System.out.println("we didnt clicked on flight tab");}
		      //Click on one way Check box
		      //Its already clicked by Default
		      
		      //Click and Type Bang in from input box 
		     
		      driver.findElement(By.xpath("//div[@id='s2id_location_from']")).click();     
		      driver.findElement(By.xpath("(//div[@class='select2-search'])[4]/input")).sendKeys("Bang");
		       Thread.sleep(2000);
		      
		      List<WebElement> FromDropDown= driver.findElements(By.xpath("//div[@id='select2-drop']/ul/li"));
		      for (WebElement ele :FromDropDown)
		      {
		    	  String eleF;
		      eleF=ele.getText();
		      System.out.println(eleF);
		        if(eleF.equalsIgnoreCase("Bangalore (BLR)"))
		        {
		        	ele.click();
		        	System.out.println("We clicked on Bangalore");
		        	break;
		        }
		      }
		      
		      //Type Del in from input box 
		      //Select Delhi from input box
		      driver.findElement(By.xpath("//div[@id='s2id_location_to']")).click();
		      driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Del");
		      Thread.sleep(2000);
		      List<WebElement> ToDropDown= driver.findElements(By.xpath("//div[@id='select2-drop']/ul/li"));
		      for (WebElement ele :ToDropDown)
		      {
		    	  String eleF;
		      eleF=ele.getText();
		   	  System.out.println(eleF);
		        if(eleF.equalsIgnoreCase("Delhi (DEL)"))
		        {
		        	ele.click();
		        	System.out.println("we clicked on Delhi");
		        	break;
		        }
		      }
		      
		      
		      
		      
		      //Date need to be selected
		     // String date="2019-12-24";
		      driver.findElement(By.xpath("//input[@id='FlightsDateStart']")).click();

		      List<WebElement>allDates=driver.findElements(By.xpath("//div[@id='datepickers-container']/div[7]/div/div/div[2]/div"));
		      Iterator<WebElement>dates=allDates.iterator();		
			while(dates.hasNext())
			{  
				WebElement Fdate=dates.next();
				//System.out.println("Dates are :"+Fdate.getText());
				if(Fdate.getText().equalsIgnoreCase("24"))
				{
					
					
					Fdate.click();
					System.out.println("found 24th and clicked!!!!!!!!!!!!!");
					break;
				}
			}

			  // Select adult value  2, infant 2
		    
		    driver.findElement(By.xpath("(//span[@class='input-group-btn-vertical'])[3]/button[1]")).click();
		    driver.findElement(By.xpath("(//span[@class='input-group-btn-vertical'])[3]/button[1]")).click();
		   driver.findElement(By.xpath("(//span[@class='input-group-btn-vertical'])[5]/button[1]")).click();
		   driver.findElement(By.xpath("(//span[@class='input-group-btn-vertical'])[5]/button[1]")).click();
			
		   //Click on Search button
		    driver.findElement(By.xpath("(//div[@class='form-inner']/div/div/button)[2]")).click();
			
		    String FlightsResultsPg=driver.getTitle();
		    System.out.println("We are on Flight Result  Page!!!!! ----------- "+FlightsResultsPg);
		 
		    //Print all flight prices displayed on first page
		  	List<WebElement>Pricelist=driver.findElements(By.xpath("//div[@class='row']/form/div[2]/div/div/p[1]"));
		  	for(WebElement ele :Pricelist)
		  	{
		  		System.out.println(ele.getText());
		  		
		  	}
		  //Click on Book Now- First Flight
		  	driver.findElement(By.xpath("(//div[@class='row']/form/div[2]/div/button)[1]")).click();
		  	
		  	//URL contain checkout
		  	String checkOutPage=driver.getCurrentUrl();
		  	System.out.println(checkOutPage);
		  	if(checkOutPage.contains("checkout"))
		  	{
		  		System.out.println("we are on right page means ------we are on Checkout Page");
		  		
		  	}
		  	else
		  	{
		  		System.out.println("Tada!!!!!!!!!!!");
		  	}
		    

		 
			}
			public static void screenShot() throws IOException {
				Date d=new Date();
				String fileName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
				System.out.println(fileName);
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    //The below method will save the screen shot in d drive with name "screenshot.png"
			       FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/screenshot/"+fileName));
			}
		}
*/