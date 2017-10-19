package com.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.service.PatientApptCancelService;
import com.service.ScheduleAppointmentService;

public class ScheduleAppointmentAction extends ActionSupport implements Preparable {
 
	private String ssn;
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAppdate() {
		return appdate;
	}
	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}
	public String getSpeciality2() {
		return Speciality2;
	}
	public void setSpeciality2(String Speciality2) {
		this.Speciality2 = Speciality2;
	}

	private String appdate;
    private String Speciality2;
    private String regid;	
		
    public String execute() {
    	int err=0;
    	String dobFormatted;
    	 System.out.println(" ScheduleAppointmentAction 111" + appdate + this.usertype);
    	 ScheduleAppointmentService scheduleApptService = new ScheduleAppointmentService();

    	 System.out.println(" ScheduleAppointmentAction 222" );
    	 
    	 if ( this.appdate == null || this.appdate.replaceAll(" ", "").equalsIgnoreCase("")
 	    		|| this.appdate.replaceAll(",","").replaceAll(" ", "").length() == 0) {
    		 setAppdate("");
 	    	dobFormatted = "";
 	    } else {
 	    	dobFormatted = this.appdate.replaceAll(",","").replaceAll(" ", "").substring(0,10);
 	    }

       if ( this.ssn == null) {
    	setSsn("");
       }
       if ( this.Speciality2 == null) {
    	   setSpeciality2("");
        }

 
    try
          {
    	 if ( this.appdate == null || this.appdate.replaceAll(" ", "").equalsIgnoreCase("")
  	    		|| this.appdate.replaceAll(",","").replaceAll(" ", "").length() == 0) {
	                System.out.println("Appt Date is blank  ");
	                addActionError("Appt Date is blank");
	                err=1;
             }
	             if (this.ssn.equalsIgnoreCase("") || this.ssn == null
	     	  			|| this.ssn.replaceAll(",","").replaceAll(" ", "").length() == 0) {
	     	  		  System.out.println("Patient SSN is blank  ");
	     	  		  addActionError("Patient SSN is blank");
	     	  		  err=1;
	     	  	  }
//	             if (this.Speciality2.equalsIgnoreCase("") || this.Speciality2 == null
//		     	  			|| this.Speciality2.replaceAll(",","").replaceAll(" ", "").length() == 0) {
//	            	 System.out.println("Doctor Specialization is blank  ");
//		                addActionError("Dr Specialization is blank");
//		                err=1;
//		     	  	  }
	             	
             if (err == 1) {
            	 return "error";
             }
             String str = this.Speciality2.replaceAll(",","").replaceAll(" ", "");
             String speciality = null;
             // Speciality2 tokenize
             
             String[] tokens = str.split("#");
     		int tokenCount = tokens.length;
     		for (int j = 0; j < tokenCount; j++) {
     			if (j==0) {
     				speciality = tokens[j];
     			} else {
     				regid = tokens[j];
     			}
     			
     			System.out.println("Split Output: "+ tokens[j]);
     		}
             
             System.out.println(" dobFormatted, ssn, regid " + dobFormatted + ssn + regid);
        	  if (scheduleApptService.register(dobFormatted, this.ssn.replaceAll(",","").replaceAll(" ", ""),
        			  this.regid.replaceAll(",","").replaceAll(" ", "")) == false )
              {
        		  System.out.println("Error in ScheduleAppointmentAction ");
        		  addActionError("Error in ScheduleAppointmentAction");
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
     
    
@Override
public void prepare() throws Exception {
	// TODO Auto-generated method stub

}


}
