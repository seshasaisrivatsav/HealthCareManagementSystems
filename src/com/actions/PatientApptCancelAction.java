
package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;  

import com.opensymphony.xwork2.ActionSupport;
import com.service.PatientApptCancelService;




import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class PatientApptCancelAction extends ActionSupport  {
 	 
	public String getAppdate() {
		return appdate;
	}
	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}
	public String getPatientSSN() {
		return patientSSN;
	}
	public void setPatientSSN(String patientSSN) {
		this.patientSSN = patientSSN;
	}

	private String appdate;
	private String patientSSN;

	   public String execute() {
	    	int err=0;
	    	String dobFormatted;
	    	 System.out.println(" PatientApptCancelAction 111" + appdate);
	    	 PatientApptCancelService patientapptcancelService = new PatientApptCancelService();
	
	    	 System.out.println(" PatientApptCancelAction 222" );
 
       if ( this.appdate == null || this.appdate.equalsIgnoreCase("")
    		   ||this.appdate.replaceAll(",","").replaceAll(" ", "").length() == 0) {
    	   setAppdate("");
       	dobFormatted = "";
       } else {
       	dobFormatted = this.appdate.substring(0,10);
       }
	    if ( this.patientSSN == null
	    		||this.patientSSN.replaceAll(",","").replaceAll(" ", "").length() == 0) {
	    	setPatientSSN("");
	    }

     
	    try
	          {
   	             if (this.appdate.equalsIgnoreCase("") || this.appdate == null
   	            		 ||this.appdate.replaceAll(",","").replaceAll(" ", "").length() == 0) {
		                System.out.println("Appt Date is blank  ");
		                addActionError("Appt Date is blank");
		                err=1;
	             }
   	             if (this.patientSSN.equalsIgnoreCase("") || this.patientSSN == null
   	            		 ||this.patientSSN.replaceAll(",","").replaceAll(" ", "").length() == 0) {
		                System.out.println("Patient SSN is blank  ");
		                addActionError("Patient SSN  is blank");
		                err=1;
	             }   	             
                 if (err == 1) {
                	 return "error";
                 }
	        	  if (patientapptcancelService.cancelAppt(dobFormatted, 
	        			  this.patientSSN.replaceAll(",","").replaceAll(" ", "") ) == false )
	              {
	        		  System.out.println("Error in Adding Review report ");
	        		  addActionError("Error in Adding Review report");
	        		   return "error";
	                }
	               return "success";
	              
	          }
	          catch (Exception e)
	          {
	          	return "error";
	          }
	          
	        }
	    
	    String usertype = "Patient";
	 	
	 	public String getUsertype() {
	 		return usertype;
	 	}
	 	public void setUsertype(String usertype) {
	 		this.usertype = "Patient";
	 	}
		
		//simple validation
			public void validate(){
			
			}
}
