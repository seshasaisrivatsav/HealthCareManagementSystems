package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;  

import com.opensymphony.xwork2.ActionSupport;
import com.service.AddPrescriptionService;

import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddPrescriptionAction extends ActionSupport  {
	
	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(String prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public String getPatientssn() {
		return patientssn;
	}

	public void setPatientssn(String patientssn) {
		this.patientssn = patientssn;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	private String medicineName;
	private String prescriptionDate;
	private String patientssn;
	private String dosage;
	private String regid;
	
    public String execute() {
    	int err=0;
    	 System.out.println(" AddPrescriptionAction 111" );
    	 AddPrescriptionService addPresService = new AddPrescriptionService();
    System.out.println(" AddPrescriptionService 222" );
//    RegisterAction adduserForm = new RegisterAction();

    String dobFormatted;
    
	   
    if ( this.medicineName == null) {
    	setMedicineName("");
    }
    if ( this.patientssn == null) {
    	setPatientssn("");
    }
    if ( this.prescriptionDate == null || this.prescriptionDate.equalsIgnoreCase("")
    		|| this.prescriptionDate.replaceAll(",","").replaceAll(" ", "").length() == 0) {
    	setPrescriptionDate("");
    	dobFormatted = "";
    } else {
    	dobFormatted = this.prescriptionDate.substring(0,10);
    }
    if ( this.dosage == null) {
    	setDosage("");
    }
           try
          {
        	  if (this.medicineName.equalsIgnoreCase("") || this.medicineName == null 
        			  || this.medicineName.replaceAll(",","").replaceAll(" ", "").length() == 0) {
        		  System.out.println("Medicine Name is blank  ");
        		  addActionError("Medicine Name is blank");
        		  err=1;
          	  }
        	  if (this.prescriptionDate.equalsIgnoreCase("") || this.prescriptionDate == null
        			  || this.prescriptionDate.replaceAll(",","").replaceAll(" ", "").length() == 0) {
        		  System.out.println("Password is blank  ");
        		  addActionError("Password is blank");
        		  err=1;
         	  }
        	  if (this.patientssn.equalsIgnoreCase("") || this.patientssn == null
        			  || this.patientssn.replaceAll(",","").replaceAll(" ", "").length() == 0) {
        		  System.out.println("Patient SSN is blank  ");
        		  addActionError("Patient SSN  is blank");
        		  err=1;
         	  }
        	  if (this.dosage.equalsIgnoreCase("") || this.dosage == null
        			  || this.dosage.replaceAll(",","").replaceAll(" ", "").length() == 0) {
        		  System.out.println("Dosage is blank  ");
        		  addActionError("Dosage is blank");
        		  err=1;
         	  }
        	  if (addPresService.addPrescription(this.medicineName.replaceAll(",","").replaceAll(" ", "") , dobFormatted, 
        			  this.patientssn.replaceAll(",","").replaceAll(" ", ""),  
        			  this.dosage.replaceAll(",","").replaceAll(" ", ""), 
        			  this.regid.replaceAll(",","").replaceAll(" ", "") ) == false )
              {
        		  System.out.println("Error in Adding Prescription ");
        		  addActionError("Error in Adding Prescription");
        		   return "error";
                }
               return "success";
              
          }
          catch (Exception e)
          {
          	return "error";
          }
          
        }
    
    
    public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
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
