/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

 import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorActionForm;

/**
 *
 * @author sssv
 */
public class RegisterForm  extends ValidatorActionForm
 {
    private String usertype;
   
   public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


   
   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
   {
     ActionErrors errors = new ActionErrors();
     System.out.println(" In RegisterForm class");
     if ((getUsertype() == null) || (getUsertype().length() < 1)) {
       errors.add("loginid", new ActionMessage("error.loginid.required"));
     }
     return errors;
   }
}


 
 
