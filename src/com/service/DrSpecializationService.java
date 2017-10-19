package com.service;

import com.util.HcmsConnectionFactory;
import com.util.HcmsException;
import com.forms.DrApptDetailForm;
import com.forms.DrScheduleForm;

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
public class DrSpecializationService extends ActionSupport implements SessionAware {

	

		private String speciality;
		
		private String Speciality2;
	 
		public String getSpeciality2() {
			return Speciality2;
		}
		public void setSpeciality2(String speciality2) {
			Speciality2 = speciality2;
		}
		public String getSpeciality() {
			return speciality;
		}
		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}

		ArrayList<DrScheduleForm> list=new ArrayList<DrScheduleForm>();  
		   
		   public ArrayList<DrScheduleForm> getList() {  
		       return list;  
		   }  
		   public void setList(ArrayList<DrScheduleForm> list) {  
		       this.list = list;  
		   }  
	public String execute() 
	  {
	   boolean validation = false;
	   int err=0;
	   String dobFormatted;
	   
	   System.out.println("speciality is blank Speciality2  " +Speciality2 );
	   if ( this.speciality == null) {
		   setSpeciality("");
	   }
       if ( this.speciality == null || this.speciality.replaceAll(" ", "").equalsIgnoreCase("")
			   || this.speciality.replaceAll(",","").replaceAll(" ", "").length() == 0) {
    	   setSpeciality("");
		   }
	   
 	    Connection connection = null;
	   PreparedStatement statement = null;
	   ResultSet resultSet = null;
 
	   try
	   {
		   if (this.Speciality2.equalsIgnoreCase("") || this.Speciality2 == null
				   || this.Speciality2.replaceAll(",","").replaceAll(" ", "").length() == 0) {
	 		  System.out.println("speciality is blank  ");
	 		  addActionError("speciality is blank");
	 		  err =1;
	  	  }
	
	       if (err > 0 ) {
	     	  return "error";
	       }
	  	 System.out.println(" IN DrSpecializationService Before JDBC connection");
	     connection = HcmsConnectionFactory.getConnection();
	     if (connection == null) {
	    	 addActionError("Error in getting DB Connection DrSpecializationService");
	  	      System.out.println(" Error in getting DB Connection DrSpecializationService");
	  	    return "error";
	       //throw new HcmsException("Error in getting DB connection .");
 
	     }
	     
	     statement = connection.prepareStatement("  select D.registered_id, P.name, D.specialization from doctor D, person P  "
	     		+ "                               where D.ssn = P.ssn  and D.specialization = ? ");
//	     System.out.println( " SELECT  usertype from HCMS_USERS WHERE USR_ID = ? AND USR_PWD = ?" + loginId + " " + password);
	       statement.setString(1,  Speciality2.replaceAll(",","").replaceAll(" ", ""));
	   
 	     resultSet = statement.executeQuery();
	     while(resultSet.next()){  
 	    	 DrScheduleForm a = new DrScheduleForm();  
	    	     a.setRegid(resultSet.getString(1));
	    	     a.setName(resultSet.getString(2));
	    	     a.setSpecialization(resultSet.getString(3));
 	         list.add(a); 
	       }
	     statement.close();
	     resultSet.close();
	    }
	   catch (SQLException sqe)
	   {
	       System.out.println( " Error in Data Base Connection line DrSpecializationService" + sqe);
	       validation = false;
	    // throw new HcmsException("Error in Data Base Connection DrApptDetails.", sqe);
	   }
	   catch (Exception exception)
	   {
		   System.out.println( " Error in Data Base Connection Exception DrSpecializationService" );
		   validation = false;
	    // throw exception;
	   }
	//   finally
	//   {
//		   System.out.println( " Data Base Connection FINALLY DrApptDetails" );
//	     if (resultSet != null) {
//	       resultSet.close();
//	     }
//	     if (statement != null) {
//	       statement.close();
//	     }
	     validation = true;
	//   }
	 //  return validation;
	   return "success";
	 }
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
 

}
