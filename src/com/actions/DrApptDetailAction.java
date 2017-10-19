package com.actions;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;  

import com.forms.DrApptDetailForm;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DrApptDetailService;

import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DrApptDetailAction extends ActionSupport implements SessionAware{

	   public String execute() {
		   int err=0;
		   System.out.println("DrApptDetailAction");
		//   DrApptDetailForm a = new DrApptDetailForm();
		   DrApptDetailService drApptDetailService = new DrApptDetailService();  
		   if ( this.appdate == null) {
			   setAppdate("");
		    }
		   if ( this.regid == null) {
			   setRegid("");
		    }
		   
	          try
	          {
	        	
	        	  if (this.appdate.equalsIgnoreCase("") || this.appdate == null
	        			 || this.appdate.replaceAll(",","").replaceAll(" ", "").length() == 0 ) {
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
                  System.out.println(" ApptDate " + appdate + " registration " + regid + " formatted date " + appdate.substring(0,10));
 	        	  if (drApptDetailService.execute() == "false" )
	              {
	        		  System.out.println("Error in getting the query DrApptDetailAction  ");
	        		  addActionError("Error in getting the query for appt details");
	        		   return "error";
	                
	                }
	               return "success";
	              
	          }
	          catch (Exception e)
	          {
	          	return "error";
	          }
	          		   
    }
	   ArrayList<DrApptDetailForm> list=new ArrayList<DrApptDetailForm>();  
	   
	   public ArrayList<DrApptDetailForm> getList() {  
	       return list;  
	   }  
	   public void setList(ArrayList<DrApptDetailForm> list) {  
	       this.list = list;  
	   }  
	   
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
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
