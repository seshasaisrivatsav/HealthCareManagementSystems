package com.actions;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.service.LoginService;
public class RegisterAction extends ActionSupport  {
    private String usertype;

    public String execute() {
  	   System.out.println(" RegisterAction usertype" + this.usertype);
       
//  	  LoginService loginService = new LoginService();
//         if (this.username.equals("admin")
//                 && this.password.equals("admin123")) {
//             return "success";
//         } else {
//             addActionError(getText("error.login"));
//             return "error";
//         }
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
 
	public String getUsertype() {
	    System.out.println("RegisterAction getUsertype" + usertype);
		return usertype;
	}

	public void setUsertype(String usertype) {
		 System.out.println("setUsertype " + usertype);
		this.usertype = usertype;
	}
   
}
