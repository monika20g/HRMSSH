package com.qa.orangehrm.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider
{
	Properties pro;
	public ConfigProvider()
	{ 
		pro=new Properties();
		try {
			
				pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/com/qa/orangehrm/config/config.properties")));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	public String getValue(String Key)
	{
		return pro.getProperty(Key);
		
	}
	
	
	//MYSQL DATABASE DETAILS

	public static String mysqldriver="com.mysql.cj.jdbc.Driver";

	public static String mysqluserName = "root";

	public static String mysqlpassword = "root";

	public static String mysqlurl = "jdbc:mysql://localhost:3306/10dec2019?useTimezone=true&serverTimezone=UTC";

	}


