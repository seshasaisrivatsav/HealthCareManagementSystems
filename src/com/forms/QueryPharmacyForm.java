package com.forms;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorActionForm;
public class QueryPharmacyForm {

	private String phName;
	public String getPhName() {
		return phName;
	}
	public void setPhName(String phName) {
		this.phName = phName;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getMedCount() {
		return medCount;
	}
	public void setMedCount(String medCount) {
		this.medCount = medCount;
	}
	public String getDrugComp() {
		return drugComp;
	}
	public void setDrugComp(String drugComp) {
		this.drugComp = drugComp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String medName;
	private String medCount;
	private String drugComp;
	private String address;
	private String telephone;
 
}
