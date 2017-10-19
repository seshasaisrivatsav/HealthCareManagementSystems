
package com.forms;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorActionForm;
public class PtReportForm {
	
	private String name;
	private String report;
	private String date;
	private String bloodpressure;
	private String heightincm;
	private String weightinlb;
	private String comments;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBloodpressure() {
		return bloodpressure;
	}
	public void setBloodpressure(String bloodpressure) {
		this.bloodpressure = bloodpressure;
	}
	public String getHeightincm() {
		return heightincm;
	}
	public void setHeightincm(String heightincm) {
		this.heightincm = heightincm;
	}
	public String getWeightinlb() {
		return weightinlb;
	}
	public void setWeightinlb(String weightinlb) {
		this.weightinlb = weightinlb;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}



}
