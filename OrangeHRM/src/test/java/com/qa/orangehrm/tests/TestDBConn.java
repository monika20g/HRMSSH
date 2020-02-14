package com.qa.orangehrm.tests;



import java.sql.SQLException;
import java.util.List;

import com.qa.orangehrm.util.DbManager;

public class TestDBConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id = 2"));
        List<String>query=DbManager.getMysqlQuery("select  tutorial_author from selenium where tutorial_title = 'testing'");
    for(int i=0;i<query.size();i++)
    {
    	System.out.println(query.get(i));
    }
	}

}
