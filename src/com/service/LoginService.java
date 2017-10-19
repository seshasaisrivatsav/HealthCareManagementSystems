/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.util.HcmsConnectionFactory;
import com.util.HcmsException;
                                           


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

 import java.io.BufferedReader;            
import java.io.DataInputStream;           
import java.io.FileInputStream;           
import java.io.FileNotFoundException;     
import java.io.IOException;               
import java.io.InputStreamReader;                                           
import java.sql.Connection;                                                 
import java.sql.PreparedStatement;                                          
import java.sql.ResultSet;                                                  
import java.sql.SQLException;                                               
import java.sql.Statement;                                                  
import java.sql.Timestamp;                                                  
import java.text.ParseException;                                            
import java.text.SimpleDateFormat;                                          
import java.util.ArrayList;                                                 
import java.util.Calendar;                                                  
import java.util.Date;                                                      
import java.util.HashMap;                                                   
import java.util.Iterator;                                                  
import java.util.Map;                                                       
import java.util.MissingResourceException;

/**
 *
 * @author sssv
 */
public class LoginService extends ActionSupport implements SessionAware {
    
	private String usertype;
	private String name;
    
public String validateUser(String loginId, String password)
     throws Exception
   {
     boolean validation = false;
     
     Connection connection = null;
     PreparedStatement statement = null;
     ResultSet resultSet = null;
     try
     {
    	 System.out.println(" IN LoginService Before JDBC connection");
       connection = HcmsConnectionFactory.getConnection();
       if (connection == null) {
    	      System.out.println(" Error in getting DB Connection ");
    	      addActionError("Error in getting DB Connection");
    	      return "false";
        // throw new HcmsException("Error in getting DB connection .");
   
       }
       System.out.println(" connection obtained");
       statement = connection.prepareStatement(" SELECT  a.usertype USERTYPE, "
       		+ " case when a.usertype = 'Pharmacy' then "
       		+ "         (select name from pharmacy b "
       		+ "           where b.username =a.username) "
       		+ "     when a.usertype in ('Doctor', 'Patient') then "
       		+ "        (select name from person c "
       		+ "          where c.username = a.username) end as NAME  "
       		+ "  from HCMS_USERS a where a.username = ?  and a.password = ? ");
       System.out.println( " SELECT  usertype from HCMS_USERS WHERE USR_ID = ? AND USR_PWD = ?" + loginId + " " + password);
       statement.setString(1, loginId);
       statement.setString(2, password);
       
       if (loginId.length() == 0 && password.length() == 0 ) {
    	   statement.close();
    	   return "false";
       }
       
       resultSet = statement.executeQuery();
       if (resultSet.next()) {
    	   System.out.println( "usertype  " + resultSet.getString("USERTYPE"));
    	   usertype = resultSet.getString("USERTYPE");
    	   name = resultSet.getString("NAME");
          validation = true;
       }
       if (usertype.equalsIgnoreCase("")) {
    	   addActionError("User does not exist");
    	   return "false";
       }
      
       statement.close();
       resultSet.close();
     }
     catch (SQLException sqe)
     {
         System.out.println( " Error in Data Base Connection line 82" + sqe);
       throw new HcmsException("Error in Data Base Connection.", sqe);
     }
     catch (Exception exception)
     {
       throw exception;
     }
     finally
     {
       if (resultSet != null) {
         resultSet.close();
       }
       if (statement != null) {
         statement.close();
       }
     }
     return usertype.concat(",").concat(name);
   }


@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
   }

//simple validation
public void validate(){
//	if(username.equalsIgnoreCase("") ){
		System.out.println(" in LoginService Validate Adduser");
	//}
}
}



