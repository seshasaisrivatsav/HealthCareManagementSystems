package com.service;

import com.util.HcmsConnectionFactory;
import com.util.HcmsException;

import com.forms.QueryPharmacyForm;

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

public class QueryPharmacyService extends ActionSupport implements SessionAware {

	private String medicineName;
	
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	ArrayList<QueryPharmacyForm> list=new ArrayList<QueryPharmacyForm>();  
	   
	   public ArrayList<QueryPharmacyForm> getList() {  
	       return list;  
	   }  
	   public void setList(ArrayList<QueryPharmacyForm> list) {  
	       this.list = list;  
	   }  
 
	   public String execute() 
	   {
	    boolean validation = false;
	    int err=0;
	    String dobFormatted;
	    
	    if ( this.medicineName == null) {
	    	setMedicineName("");
	    }
	   
	     Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	     
	     try
	    {
	 	   if (this.medicineName.replaceAll(",","").replaceAll(" ", "") =="" || this.medicineName == null
	 			   || this.medicineName.replaceAll(",","").replaceAll(" ", "").length() == 0) {
	  		  System.out.println("Medicine Name blank  ");
	  		  addActionError("Medicine Name blank");
	  		  err =1;
	   	  }
	  	    if (err > 0 ) {
	      	  return "error";
	        }
	   	 System.out.println(" IN QueryPharmacyService Before JDBC connection length" + this.medicineName.replaceAll(",","").replaceAll(" ", "").length());
	      connection = HcmsConnectionFactory.getConnection();
	      if (connection == null) {
	     	 addActionError("Error in getting DB Connection QueryPharmacyService");
	   	      System.out.println(" Error in getting DB Connection QueryPharmacyService");
	   	    return "error";
	        //throw new HcmsException("Error in getting DB connection .");
	  
	      }
	      
	      
	      statement = connection.prepareStatement("  select P.name, M.name, MI.count , M.drugcomponent, P.address, P.telephone "
	      		+ "                                    from MedicineInventory MI, Medicine M , pharmacy P  "
	      		+ "                                    where MI.pharmacy = P.pharmacy_id "
	      		+ "    and  MI.medicine = M.medicine_id and  M.name = ? ");
//	      System.out.println( " SELECT  usertype from HCMS_USERS WHERE USR_ID = ? AND USR_PWD = ?" + loginId + " " + password);
	         statement.setString(1,  medicineName.replaceAll(",","").replaceAll(" ", ""));
	    
	      System.out.println(" QueryPharmacyService connection obtained "  );
	      resultSet = statement.executeQuery();
	      while(resultSet.next()){  
	     	
	    	  QueryPharmacyForm a = new QueryPharmacyForm();  
	     	      a.setPhName(resultSet.getString(1));
	     	     a.setMedName(resultSet.getString(2));
	     	      a.setMedCount(resultSet.getString(3));
	     	      a.setDrugComp (resultSet.getString(4));
	     	      a.setAddress(resultSet.getString(5));
	     	     a.setTelephone(resultSet.getString(6));
	     	     
	                 list.add(a); 
	        }
	      statement.close();
	      resultSet.close();
	   
	         
	     }
	    catch (SQLException sqe)
	    {
	        System.out.println( " Error in Data Base Connection line QueryPharmacyService" + sqe);
	        validation = false;
	     // throw new HcmsException("Error in Data Base Connection DrApptDetails.", sqe);
	    }
	    catch (Exception exception)
	    {
	 	   System.out.println( " Error in Data Base Connection Exception QueryPharmacyService" );
	 	   validation = false;
	     // throw exception;
	    }
	 //   finally
	 //   {
//	 	   System.out.println( " Data Base Connection FINALLY DrApptDetails" );
//	      if (resultSet != null) {
//	        resultSet.close();
//	      }
//	      if (statement != null) {
//	        statement.close();
//	      }
	      validation = true;
	 //   }
	  //  return validation;
	    return "success";
	  }	
	

}
