package com.service;
import com.forms.DrApptDetailForm;
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
public class DrApptDetailService extends ActionSupport implements SessionAware {
	public String getAppdate() {
	return appdate;
}
public void setAppdate(String appdate) {
	this.appdate = appdate;
}
public String getRegid() {
	return regid;
}
public void setRegid(String regid) {
	this.regid = regid;
}


	private String appdate;
	private String regid;
	
	   ArrayList<DrApptDetailForm> list=new ArrayList<DrApptDetailForm>();  
	   
	   public ArrayList<DrApptDetailForm> getList() {  
	       return list;  
	   }  
	   public void setList(ArrayList<DrApptDetailForm> list) {  
	       this.list = list;  
	   }  
public String execute() 
  {
   boolean validation = false;
   int err=0;
   String dobFormatted;
   
   if ( this.appdate == null) {
	   setAppdate("");
   }
   if ( this.regid == null) {
	   setRegid("");
   }
   if ( this.appdate == null || this.appdate.replaceAll(" ", "").equalsIgnoreCase("")
		   || this.appdate.replaceAll(",","").replaceAll(" ", "").length() == 0) {
	   setAppdate("");
   	dobFormatted = "";
   } else {
   	dobFormatted = this.appdate.replaceAll(",","").replaceAll(" ", "").substring(0,10);
   }
   
   
   System.out.println(" IN DrApptDetails Before JDBC connection 111");
 //   DrApptDetailForm drapptdetailform = new DrApptDetailForm();
    Connection connection = null;
   PreparedStatement statement = null;
   ResultSet resultSet = null;
   int abc =  567 ;
   System.out.println(" DrApptDetails connection obtained" + appdate+ "-" + regid + "-");
  System.out.println(" DrApptDetails connection obtained 222-"+abc );
   try
   {
	   if (this.appdate.equalsIgnoreCase("") || this.appdate == null
			   || this.appdate.replaceAll(",","").replaceAll(" ", "").length() == 0) {
 		  System.out.println("Appt Date is blank  ");
 		  addActionError("Appt Date is blank");
 		  err =1;
  	  }
 	  if (this.regid.equalsIgnoreCase("") || this.regid == null
 			 || this.regid.replaceAll(",","").replaceAll(" ", "").length() == 0) {
 		  System.out.println("Registration Id is blank  ");
 		  addActionError("Registration Id is blank");
 		  err=1;
 	  }
       if (err > 0 ) {
     	  return "error";
       }
  	 System.out.println(" IN DrApptDetails Before JDBC connection");
     connection = HcmsConnectionFactory.getConnection();
     if (connection == null) {
    	 addActionError("Error in getting DB Connection DrApptDetails");
  	      System.out.println(" Error in getting DB Connection DrApptDetails");
  	    return "error";
       //throw new HcmsException("Error in getting DB connection .");
 
     }
     System.out.println(" DrApptDetails connection obtained 222" + appdate + regid.replaceAll(",","").replaceAll(" ", "")
    		 + " date " + dobFormatted);
     
     
     statement = connection.prepareStatement("  select A.date, P.name "
     		+ "                                   from  Appointment A, person P , Patient PT, Doctor D "
     		+ "                                  where A.patient = PT.patient_id and  A.doctor = D.doctor_id "
     		+ "                                    and  p.ssn = pt.ssn"
        	+ "                                    and a.date = ? "
     		+ "                                    and  A.doctor = (select doctor_id "
     		+ "                                                       from doctor "
     		+ "                                                      where registered_id =  ? ) ");
//     System.out.println( " SELECT  usertype from HCMS_USERS WHERE USR_ID = ? AND USR_PWD = ?" + loginId + " " + password);
      statement.setString(1, dobFormatted);
       statement.setInt(2, Integer.parseInt(regid.replaceAll(",","").replaceAll(" ", "")));
   
     System.out.println(" DrApptDetails connection obtained "  );
     resultSet = statement.executeQuery();
     while(resultSet.next()){  
    	 System.out.println(" Appt Date " + resultSet.getString("DATE") + " Name " + resultSet.getString("NAME"));
    	
    	 DrApptDetailForm a = new DrApptDetailForm();  
    	 a.setAppdate(resultSet.getString(1));
    	 a.setName(resultSet.getString(2));
         System.out.println(" Appt Date " + resultSet.getString("DATE") + " Name " + resultSet.getString("NAME"));
         list.add(a); 
       }
     statement.close();
     resultSet.close();
  
        
    }
   catch (SQLException sqe)
   {
       System.out.println( " Error in Data Base Connection line DrApptDetails" + sqe);
       validation = false;
    // throw new HcmsException("Error in Data Base Connection DrApptDetails.", sqe);
   }
   catch (Exception exception)
   {
	   System.out.println( " Error in Data Base Connection Exception DrApptDetails" );
	   validation = false;
    // throw exception;
   }
//   finally
//   {
//	   System.out.println( " Data Base Connection FINALLY DrApptDetails" );
//     if (resultSet != null) {
//       resultSet.close();
//     }
//     if (statement != null) {
//       statement.close();
//     }
     validation = true;
//   }
 //  return validation;
   return "success";
 }

@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
}

//simple validation
public void validate(){
//	if(username.equalsIgnoreCase("") ){
		System.out.println(" Validate Adduser");
		 System.out.println(" DrApptDetails connection obtained  app" + appdate  );
		 System.out.println(" DrApptDetails connection obtained regid" + regid  );
	
	//}
}

}
