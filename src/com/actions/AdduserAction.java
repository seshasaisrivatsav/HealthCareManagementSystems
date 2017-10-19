package com.actions;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.service.AdduserService;
import com.forms.AdduserForm;
import com.actions.RegisterAction;

public class AdduserAction extends ActionSupport  {

    public String execute() {
    	 System.out.println(" AdduserAction 111" );
   	AdduserService adduserService = new AdduserService();
    System.out.println(" AdduserAction 222" + this.usertype);
//    RegisterAction adduserForm = new RegisterAction();

    String dobFormatted;
	   
    if ( this.ssn == null) {
    	setSsn("");
    }
    if ( this.name == null) {
    	setName("");
    }
    if ( this.dob == null || this.dob.equalsIgnoreCase("")) {
    	setDob("");
    	dobFormatted = "";
    } else {
    	dobFormatted = this.dob.substring(0,10);
    }
    if ( this.username == null) {
    	setUsername("");
    }
    if ( this.password == null) {
    	setPassword("");
    }
    if ( this.gender == null) {
    	setGender("");
    }
    if ( this.address == null) {
    	setAddress("");
    }
    if ( this.regid == null) {
    	setRegid("");
    }
    if ( this.speciality == null) {
    	setSpeciality("");
    }
    if ( this.telephone == null) {
    	setTelephone("");
    }
    
	   System.out.println(" AdduserAction usertype" + this.usertype + this.username
			   + this.ssn + this.name + dobFormatted + "  "+this.password + this.gender
			   + this.address + this.speciality + this.regid);
    
          try
          {
        	  if (this.username.equalsIgnoreCase("") || this.username == null) {
        		  System.out.println("Username is blank  ");
        		  addActionError("Username is blank");
        		   return "error";
        	  }
        	  if (this.password.equalsIgnoreCase("") || this.password == null) {
        		  System.out.println("Password is blank  ");
        		  addActionError("Password is blank");
        		   return "error";
        	  }
        	  if (this.name.equalsIgnoreCase("") || this.name == null) {
        		  System.out.println("Name is blank  ");
        		  addActionError("Name is blank");
        		   return "error";
        	  }
        	  if (adduserService.createUser( this.ssn.replaceAll(",","").replaceAll(" ", "") , 
        			  this.name.replaceAll(",","").replaceAll(" ", "") , dobFormatted, 
        			  this.username.replaceAll(",","").replaceAll(" ", ""), 
        			  this.password.replaceAll(",","").replaceAll(" ", "") , 
        			  this.gender.replaceAll(",","").replaceAll(" ", "") , 
        			  this.address.replaceAll(",","").replaceAll(" ", ""), 
        			  this.regid.replaceAll(",","").replaceAll(" ", "") , 
        			  this.speciality.replaceAll(",","").replaceAll(" ", ""), 
        			  this.usertype.replaceAll(",","").replaceAll(" ", ""), 
        			  this.telephone.replaceAll(",","").replaceAll(" ", "") ) == false )
              {
        		  System.out.println("Username already exists  ");
        		  addActionError("Username already exists");
        		   return "error";
                
                }
               return "success";
              
          }
          catch (Exception e)
          {
          	return "error";
          }
        }
    
	private String ssn;
	private String name;
	private String dob;
	private String username;
	private String password;
	private String gender;
	private String address;
	private String regid;
	private String speciality;
	private String usertype;
	private String telephone;
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	//simple validation
		public void validate(){
			if(getUsername().equalsIgnoreCase("") ){
				System.out.println(" Validate");
			}
		}
}
