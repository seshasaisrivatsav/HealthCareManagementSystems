package com.forms;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorActionForm;
public class PtAppointmentForm {
	
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	
	public String getDrName() {
		return drName;
	}
	public void setDrName(String drName) {
		this.drName = drName;
	}

	private String AppointmentDate;
	private String drName;


}
