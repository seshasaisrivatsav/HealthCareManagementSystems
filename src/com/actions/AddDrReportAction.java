package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;  

import com.opensymphony.xwork2.ActionSupport;
import com.service.AddDrReportService;
import com.service.AddPrescriptionService;

import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddDrReportAction extends ActionSupport  {
 
	public String getEnterreport() {
		return enterreport;
	}
	public void setEnterreport(String enterreport) {
		this.enterreport = enterreport;
	}
	public String getReportdate() {
		return reportdate;
	}
	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}
	public String getBplevel() {
		return bplevel;
	}
	public void setBplevel(String bplevel) {
		this.bplevel = bplevel;
	}
	public String getPatientheight() {
		return patientheight;
	}
	public void setPatientheight(String patientheight) {
		this.patientheight = patientheight;
	}
	public String getPatientweight() {
		return patientweight;
	}
	public void setPatientweight(String patientweight) {
		this.patientweight = patientweight;
	}
	public String getPatientcomment() {
		return patientcomment;
	}
	public void setPatientcomment(String patientcomment) {
		this.patientcomment = patientcomment;
	}
	public String getPatientssn() {
		return patientssn;
	}
	public void setPatientssn(String patientssn) {
		this.patientssn = patientssn;
	}
	private String enterreport;
	private String reportdate;
	private String bplevel;
	private String patientheight;
	private String patientweight;
	private String patientcomment;
	private String patientssn;
	
	   public String execute() {
	    	int err=0;
	    	 System.out.println(" AddDrReportAction 111" );
	    	 AddDrReportService addDrReportService = new AddDrReportService();
	    System.out.println(" AddDrReportAction 222" );
//	    RegisterAction adduserForm = new RegisterAction();

	    String dobFormatted;
		   
	    if ( this.enterreport == null) {
	    	setEnterreport("");
	    }
	    if ( this.patientssn == null) {
	    	setPatientssn("");
	    }
	    if ( this.reportdate == null || this.reportdate.equalsIgnoreCase("")) {
	    	setReportdate("");
	    	dobFormatted = "";
	    } else {
	    	dobFormatted = this.reportdate.substring(0,10);
	    }
	    if ( this.bplevel == null) {
	    	setBplevel("");
	    }
	    if ( this.patientheight == null) {
	    	setPatientheight("");
	    }
	    if ( this.patientweight == null) {
	    	setPatientweight("");
	    }
	    if ( this.patientcomment == null) {
	    	setPatientcomment("");
	    }
	    if ( this.patientssn == null) {
	    	setPatientssn("");
	    }    
	    try
	          {
   	             if (this.patientweight.equalsIgnoreCase("") || this.patientweight == null
   	            		 || this.patientweight.replaceAll(",","").replaceAll(" ", "").length() ==0 ) {
		                System.out.println("Patient Weight is blank  ");
		                addActionError("Patient Weight  is blank");
		                err=1;
	             }
   	             if (this.patientcomment.equalsIgnoreCase("") || this.patientcomment == null 
   	            		|| this.patientcomment.replaceAll(",","").replaceAll(" ", "").length() ==0 ) {
		                System.out.println("Patient Comment is blank  ");
		                addActionError("Patient Comment  is blank");
		                err=1;
	             }   	             
	    	     if (this.patientheight.equalsIgnoreCase("") || this.patientheight == null 
	    	    		 || this.patientheight.replaceAll(",","").replaceAll(" ", "").length() ==0) {
        		      System.out.println("Patient Height is blank  ");
        		      addActionError("Patient Height  is blank");
        		      err=1;
         	     }
	        	  if (this.enterreport.equalsIgnoreCase("") || this.enterreport == null
	        			  || this.enterreport.replaceAll(",","").replaceAll(" ", "").length() ==0) {
	        		  System.out.println("Report Name is blank  ");
	        		  addActionError("Report Name is blank");
	        		  err=1;
	          	  }
	        	  if (this.reportdate.equalsIgnoreCase("") || this.reportdate == null
	        			  || this.reportdate.replaceAll(",","").replaceAll(" ", "").length() ==0) {
	        		  System.out.println("Report Date is blank  ");
	        		  addActionError("Report Date is blank");
	        		  err=1;
	         	  }
	        	  if (this.patientssn.equalsIgnoreCase("") || this.patientssn == null
	        			  || this.patientssn.replaceAll(",","").replaceAll(" ", "").length() ==0) {
	        		  System.out.println("Patient SSN is blank  ");
	        		  addActionError("Patient SSN  is blank");
	        		  err=1;
	         	  }
	        	  if (this.bplevel.equalsIgnoreCase("") || this.bplevel == null
	        			  || this.bplevel.replaceAll(",","").replaceAll(" ", "").length() ==0) {
	        		  System.out.println("BP Level is blank  ");
	        		  addActionError("BP Level is blank");
	        		  err=1;
	         	  }
	        	  
	        	  if (addDrReportService.addDrReport(this.enterreport.replaceAll(",","").replaceAll(" ", "") ,
	        			          dobFormatted,  this.bplevel.replaceAll(",","").replaceAll(" ", "") , 
	        			          this.patientheight.replaceAll(",","").replaceAll(" ", ""),  this.patientweight.replaceAll(",","").replaceAll(" ", ""),
	        			          this.patientcomment.replaceAll(",","").replaceAll(" ", "") , 
	        			          this.patientssn.replaceAll(",","").replaceAll(" ", "")  ) == false )
	              {
	        		  System.out.println("Error in Adding Dr report ");
	        		  addActionError("Error in Adding Dr report");
	        		   return "error";
	                }
	               return "success";
	              
	          }
	          catch (Exception e)
	          {
	          	return "error";
	          }
	          
	        }
	    
	    String usertype = "Doctor";
	 	
	 	public String getUsertype() {
	 		return usertype;
	 	}
	 	public void setUsertype(String usertype) {
	 		this.usertype = "Doctor";
	 	}
		
		//simple validation
			public void validate(){
		}
}
