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
public class AdduserService extends ActionSupport implements SessionAware {
	

 public boolean createUser(String ssn, String name, String dob, String username, String password,
		                   String gender, String address, String regid, String speciality,
		                   String usertype, String telephone)
   throws Exception
 {
   boolean validation = false;
   System.out.println(" IN createUser Before JDBC connection 111");
   Connection connection = null;
   PreparedStatement statement = null;
   ResultSet resultSet = null;
   try
   {
  	 System.out.println(" IN createUser Before JDBC connection");
     connection = HcmsConnectionFactory.getConnection();
     if (connection == null) {
    	 addActionError("Error in getting DB Connection");
  	      System.out.println(" Error in getting DB Connection ");
  	      return false;
       //throw new HcmsException("Error in getting DB connection .");
 
     }
     System.out.println(" createUser connection obtained");
     
     // Check if the username already exists , if exists then fail
     
     statement = connection.prepareStatement("SELECT usertype  from HCMS_USERS WHERE username = ? ");
//     System.out.println( " SELECT  usertype from HCMS_USERS WHERE USR_ID = ? AND USR_PWD = ?" + loginId + " " + password);
     statement.setString(1, username);
   
     resultSet = statement.executeQuery();
     if (resultSet.next()) {
    	 System.out.println(" Username already exists");
    	 addActionError("Username already exists");
         statement.close();
         resultSet.close();
    	 return  false ;
       //  throw new HcmsException("Username already exists");
       // validation = false;
     }
     statement.close();
     resultSet.close();
  
     statement = connection.prepareStatement("insert into HCMS_Users (username, password, usertype ) values  (? ,?, ? )");
     statement.setString(1, username);
     statement.setString(2, password);
     statement.setString(3, usertype);
     
     statement.executeUpdate();
     statement.close();
     
     if ((usertype.equalsIgnoreCase("Doctor")) ||
           (usertype.equalsIgnoreCase("Patient"))){
          statement = connection.prepareStatement("insert into person (ssn, name , dob, username, gender, address)"
          		+ "     values  (? ,?, ? ,?, ?, ? )");
          statement.setString(1, ssn);
          statement.setString(2, name);
          statement.setString(3, dob);
          statement.setString(4, username);
          statement.setString(5, gender);
          statement.setString(6, address);
          
          statement.executeUpdate();
          statement.close();
     }
     if  (usertype.equalsIgnoreCase("Doctor")){
     
    	 statement = connection.prepareStatement("insert into doctor (ssn, registered_id, specialization)  "
    	 		+ " values ( ? , ? , ? ) ");
   	 
    	 statement.setString(1, ssn);
         statement.setString(2, regid);
         statement.setString(3, speciality);
         statement.executeUpdate();
         statement.close();
     }
     if  (usertype.equalsIgnoreCase("Patient")){
         
    	 statement = connection.prepareStatement("insert into patient (ssn)  "
    	 		+ " values ( ? ) ");
   	 
    	 statement.setString(1, ssn);
    	 statement.executeUpdate();
         statement.close();
     }
   if  (usertype.equalsIgnoreCase("Pharmacy")){
	   System.out.println( " Creating Pharmacy record" );
	   statement = connection.prepareStatement(" insert into pharmacy (name, username, address, telephone)  "
    	 		+ " values (?,?, ? ,?) " );
 
	   statement.setString(1, name);
	   statement.setString(2, username);
	   statement.setString(3, address);
	   statement.setString(4, telephone);
	   statement.executeUpdate();
	   statement.close();
     }
     
      
    }
   catch (SQLException sqe)
   {
       System.out.println( " Error in Data Base Connection line 82" + sqe);
     throw new HcmsException("Error in Data Base Connection.", sqe);
   }
   catch (Exception exception)
   {
	   System.out.println( " Error in Data Base Connection Exception" );
     throw exception;
   }
   finally
   {
	   System.out.println( " Error in Data Base Connection FINALLY" );
     if (resultSet != null) {
       resultSet.close();
     }
     if (statement != null) {
       statement.close();
     }
   }
   return true;
 }

@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
}

//simple validation
public void validate(){
//	if(username.equalsIgnoreCase("") ){
		System.out.println(" Validate Adduser");

	//}
}

}
