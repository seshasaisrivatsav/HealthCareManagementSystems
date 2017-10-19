package com.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorActionForm;

public class DrApptDetailForm {
 
 
	public String getAppdate() {
		return appdate;
	}
	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String appdate;
	private String name;
}
