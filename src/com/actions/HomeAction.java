package com.actions;

import com.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	
	   public String execute() {
	 	   System.out.println(" HomeAction"  );
//	 	  LoginService loginService = new LoginService();
//	        if (this.username.equals("admin")
//	                && this.password.equals("admin123")) {
//	            return "success";
//	        } else {
//	            addActionError(getText("error.login"));
//	            return "error";
//	        }
//	        
	        try
	        {
	              return "success";
	    
	        }
	        catch (Exception e)
	        {
	        	return "error";
	        }
	        
	      }

}
