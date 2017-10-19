/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author sssv
 */
public class HcmsConnectionFactory {
    
  private static Connection connection = null;
  private static String driver = null;
  private static String username = null;
  private static String password = null;
  private static String url = null;
	private static final String DB_BUNDLE_NAME = "db";
	  private static final ResourceBundle DB_RESOURCE_BUNDLE = ResourceBundle.getBundle("db");

  
private static void init()
    throws Exception
  {
	  
	//  Properties prop = new Properties();
	//	InputStream input = null;
		
		  
//		  public static String getDBProperty(String key)
//		  {
//		    return DB_RESOURCE_BUNDLE.getString(key);
//		  }
		
		
	  try {
		  Locale currentLocale;
		   ResourceBundle messages;

		   currentLocale = new Locale("en");

		//   input = new FileInputStream("C:\\eclipse\\workspace\\Health\\HCMS_App\\Resources\\db.properties");

			// load a properties file
		//	prop.load(input);
System.out.println(" DB_RESOURCE_BUNDLE.getString(key) " + DB_RESOURCE_BUNDLE.getString("jdbc.driver"));
System.out.println(" DB_RESOURCE_BUNDLE.getString(key) " + DB_RESOURCE_BUNDLE.getString("jdbc.url"));
System.out.println(" DB_RESOURCE_BUNDLE.getString(key) " + DB_RESOURCE_BUNDLE.getString("jdbc.username"));
System.out.println(" DB_RESOURCE_BUNDLE.getString(key) " + DB_RESOURCE_BUNDLE.getString("jdbc.password"));
			// get the property value and print it out
//     driver =  prop.getProperty("jdbc.driver");
//     url = prop.getProperty("jdbc.url");
//     username = prop.getProperty("jdbc.username");
//     password = prop.getProperty("jdbc.password");
driver = DB_RESOURCE_BUNDLE.getString("jdbc.driver");
url = DB_RESOURCE_BUNDLE.getString("jdbc.url");
username = DB_RESOURCE_BUNDLE.getString("jdbc.username");
password = DB_RESOURCE_BUNDLE.getString("jdbc.password");
    
//    driver = "com.mysql.jdbc.Driver";
 //   url = "jdbc:mysql://localhost:3306/hcms";
//    private static final String DB_USER = "username";
//    private static final String DB_PASSWORD = "password";
		} catch (Exception e) {
			System.out.println("Error retrieving properties file: " + e);
		}
  }
  
  public static synchronized Connection getConnection()
    throws Exception
  {
    if ((connection == null) || (connection.isClosed())) {
      try
      {
    	  System.out.println(" In Connection Factory " + driver + " url " + url);
        init();
        System.out.println(" In Connection Factory " + driver + " url " + url);
//        Class.forName(driver);
        try 
        {
                Class.forName(driver);
        } 
        catch (ClassNotFoundException e) 
        {
                System.err.println("Exception : Add MySQL JDBC Driver in your classpath ");
                System.err.println(e.getMessage());
                throw e;
        }
        connection = DriverManager.getConnection(url, username, password);
      }
      catch (MissingResourceException mex)
      {
        throw mex;
      }
      catch (ClassNotFoundException cnf)
      {
        throw cnf;
      }
      catch (SQLException sqe)
      {
        throw sqe;
      }
      catch (Exception ex)
      {
        throw ex;
      }
    }
    return connection;
  }
  
  public static synchronized void close(Connection con)
    throws Exception
  {
    if (con != null) {
      try
      {
        con.close();
      }
      catch (SQLException sqe)
      {
        throw sqe;
      }
      catch (Exception ex)
      {
        throw ex;
      }
    }
  }
}

