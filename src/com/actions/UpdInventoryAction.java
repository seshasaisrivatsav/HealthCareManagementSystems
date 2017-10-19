package com.actions;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;  

import com.opensymphony.xwork2.ActionSupport;
import com.service.UpdInventoryService;

import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdInventoryAction extends ActionSupport implements SessionAware{

	   public String execute() {
		   int err =0;
		   System.out.println("UpdInventoryAction");
		   UpdInventoryService updInventoryService = new UpdInventoryService();  
		   if ( this.pharmacyName == null) {
			   setPharmacyName("");
		    }
		   if ( this.telephoneNo == null) {
			   setTelephoneNo("");
		    }
		   if ( this.medicineName == null) {
			   setMedicineName("");
		    }
		   if ( countN < 0) {
			   setCountN(0);
		    }
	          try
	          {
	        	  System.out.println(" pharmacyname " + this.pharmacyName
	        			  + " tele " + this.telephoneNo 
	        			  + " pho" + this.medicineName
	        			  + " countN" + countN );
	        	  if (this.pharmacyName.equalsIgnoreCase("") || this.pharmacyName == null
                        ||this.pharmacyName.replaceAll(",","").replaceAll(" ", "").length() == 0 ) {
	        		  System.out.println("pharmacyName is blank  ");
	        		  addActionError("pharmacyName is blank");
//	        		   return "error";
	        		  err =1;
	        	  }
	        	  if (this.telephoneNo.equalsIgnoreCase("") || this.telephoneNo == null
	        			  ||this.telephoneNo.replaceAll(",","").replaceAll(" ", "").length() == 0 ) {
	        		  System.out.println("telephoneNo is blank  ");
	        		  addActionError("telephoneNo is blank");
	        		  err =1;
//	        		   return "error";
	        	  }
	        	  if (this.medicineName.equalsIgnoreCase("") || this.medicineName == null
	        			  ||this.medicineName.replaceAll(",","").replaceAll(" ", "").length() == 0 ) {
	        		  System.out.println("Medicine Name is blank  ");
	        		  addActionError("Medicine Name is blank");
	        		  err =1;
//	        		   return "error";
	        	  }
	        	  if ( countN < 0 ) {
	        		  System.out.println("Count is less than 0  ");
	        		  addActionError("Count is less than 0");
	        		  err =1;
	        		 //  return "error";
	        	  }
	        	  if (err == 1) {
	                	 return "error";
	                 }
 	        	  if (updInventoryService.update( this.pharmacyName.replaceAll(",","").replaceAll(" ", "") , 
 	        			 this.telephoneNo.replaceAll(",","").replaceAll(" ", "")   ,
 	        			this.medicineName.replaceAll(",","").replaceAll(" ", "") , 
 	        			this.countN  ) == false )
	              {
	        		  System.out.println("Error in updating inventory  ");
	        		  addActionError("Error in updating inventory");
	        		   return "error";
	                
	                }
	               return "success";
	              
	          }
	          catch (Exception e)
	          {
	          	return "error";
	          }
	          		   
    }
	public int getCountN() {
		return countN;
	}

	public void setCountN(int countN) {
		this.countN = countN;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	int countN;
    String pharmacyName;
    String telephoneNo;
    String medicineName;
    String usertype = "Pharmacy";
 	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = "Pharmacy";
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
 

}
