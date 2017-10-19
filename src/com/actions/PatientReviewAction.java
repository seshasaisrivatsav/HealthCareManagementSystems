
package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;  

import com.opensymphony.xwork2.ActionSupport;
import com.service.AddDrReportService;
import com.service.AddPrescriptionService;
import com.service.PatientReviewService;

import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class PatientReviewAction extends ActionSupport  {
 
	 
	private String review;
	private String patientssn;
	private String regid;
	
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getPatientssn() {
		return patientssn;
	}
	public void setPatientssn(String patientssn) {
		this.patientssn = patientssn;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	
	   public String execute() {
	    	int err=0;
	    	 System.out.println(" AddDrReportAction 111" );
	    	 PatientReviewService patientReviewService = new PatientReviewService();
	
	    	 System.out.println(" AddDrReportAction 222" );
 
       if ( this.review == null) {
    	   setReview("");
	    }
	    if ( this.patientssn == null) {
	    	setPatientssn("");
	    }
	    if ( this.regid == null) {
	    	setRegid("");
	    }      
	    try
	          {
   	             if (this.review.equalsIgnoreCase("") || this.review == null
   	            		|| this.review.replaceAll(",","").replaceAll(" ", "").length() == 0) {
		                System.out.println("Patient Weight is blank  ");
		                addActionError("Patient Weight  is blank");
		                err=1;
	             }
   	             if (this.patientssn.equalsIgnoreCase("") || this.patientssn == null
   	            		|| this.patientssn.replaceAll(",","").replaceAll(" ", "").length() == 0) {
		                System.out.println("Patient Comment is blank  ");
		                addActionError("Patient Comment  is blank");
		                err=1;
	             }   	             
	    	     if (this.regid.equalsIgnoreCase("") || this.regid == null
	    	    		 || this.regid.replaceAll(",","").replaceAll(" ", "").length() == 0) {
        		      System.out.println("Patient Height is blank  ");
        		      addActionError("Patient Height  is blank");
        		      err=1;
         	     }
	    	     if (err == 1) {
                	 return "error";
                 }
	        	  if (patientReviewService.addPatientReview(
	        			   this.review.replaceAll(",","").replaceAll(" ", ""), 
	        			   this.patientssn.replaceAll(",","").replaceAll(" ", "") , 
	        			   this.regid.replaceAll(",","").replaceAll(" ", "") )  == false )
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
