/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.actions;

 import com.forms.LoginForm;
import com.service.LoginService;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;  
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author sssv
 */
public class LoginAction extends ActionSupport implements SessionAware {
    private String username;
    private String password;
    SessionMap<String,String> sessionmap;  
    private String usertype;
    private String name;
 
    public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String execute() {
 	   System.out.println(" LOGIN FROM LOGICACTION" + this.username);
 	   System.out.println(" PASSWORD is " + this.password);
    
 	   if ( this.username.equalsIgnoreCase("") || this.password.equalsIgnoreCase("") ) {
 		  addActionError("Invalid Username/Password");
 		   return "error";
 	   }
 	  LoginService loginService = new LoginService();
//        if (this.username.equals("admin")
//                && this.password.equals("admin123")) {
//            return "success";
//        } else {
//            addActionError(getText("error.login"));
//            return "error";
//        }
//        
        try
        {
        	String str  = loginService.validateUser(
        			 this.username.replaceAll(",","").replaceAll(" ", "") , 
        			 this.password.replaceAll(",","").replaceAll(" ", "") );
        	if (str.equalsIgnoreCase("false")) {
        		return "error";
        	} else
            {
        		
        		String[] tokens = str.split(",");
        		int tokenCount = tokens.length;
        		for (int j = 0; j < tokenCount; j++) {
        			if (j==0) {
        				usertype = tokens[j];
        			} else {
        				name = tokens[j];
        			}
        			
        			System.out.println("Split Output: "+ tokens[j]);
        		}
        	  System.out.println(" usename LoginAction is " +  str + " usertype " + usertype + " name " + name);
             return "success";
            }
    		 
        	// usertype
    		
          
        }
        catch (Exception e)
        {
        	System.out.println(" Exception Caught in LoginAction " + this.usertype);
        	return "error";
        }
        
      }

 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }


	@Override
	public void setSession(Map map) {  
	    sessionmap=(SessionMap)map;  
	    sessionmap.put("login","true");  
	}  
	  
	public String logout(){  
	    sessionmap.invalidate();  
	    return "success";  
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}  
	
	//simple validation
//	public void validate(){
// 		if(username.equalsIgnoreCase("")  || password.equalsIgnoreCase("")){
//			System.out.println("LOginAction action Validate Adduser");
//	      addActionError("error.logn");
//		 }
//	}
}

