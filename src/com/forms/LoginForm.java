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
public class LoginForm  extends ValidatorActionForm
 {
   private String loginid;
   private String password;
   
   public String getLoginid()
   {
     return this.loginid;
   }
   
   public void setLoginid(String loginid)
   {
     this.loginid = loginid;
   }
   
   public String getPassword()
   {
     return this.password;
   }
   
   public void setPassword(String password)
   {
     this.password = password;
   }
   
   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
   {
     ActionErrors errors = new ActionErrors();
     System.out.println(" In LoginForm class");
     if ((getLoginid() == null) || (getLoginid().length() < 1)) {
       errors.add("loginid", new ActionMessage("error.loginid.required"));
     } else if ((getPassword() == null) || (getPassword().length() < 1)) {
       errors.add("password", new ActionMessage("error.password.required"));
     }
     return errors;
   }
}


 
 
