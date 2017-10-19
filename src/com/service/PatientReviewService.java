
package com.service;

import com.util.HcmsConnectionFactory;
import com.util.HcmsException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.forms.PtAppointmentForm;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import java.io.BufferedReader;            
import java.io.DataInputStream;           
import java.io.FileInputStream;           
import java.io.FileNotFoundException;     
import java.io.IOException;               
import java.io.InputStreamReader;                                           
import java.sql.Connection;                                                 
import java.sql.PreparedStatement;                                          
import java.sql.ResultSet;                                                  
import java.sql.SQLException;                                               
import java.sql.Statement;                                                  
import java.sql.Timestamp;                                                  
import java.text.ParseException;                                            
import java.text.SimpleDateFormat;                                          
import java.util.ArrayList;                                                 
import java.util.Calendar;                                                  
import java.util.Date;                                                      
import java.util.HashMap;                                                   
import java.util.Iterator;                                                  
import java.util.Map;                                                       
import java.util.MissingResourceException;

public class PatientReviewService extends ActionSupport implements SessionAware {

 
	public boolean addPatientReview(String review,
			                   String patientssn, String regid )
			throws Exception {
		boolean validation = false;
		System.out.println(" IN PatientReviewService Before JDBC connection 111");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = HcmsConnectionFactory.getConnection();
			if (connection == null) {
				addActionError("PatientReviewService Error in getting DB Connection");
				System.out.println("PatientReviewService Error in getting DB Connection ");
				return false;
				// throw new HcmsException("Error in getting DB connection .");
			}
			System.out.println(" PatientReviewService connection obtained");

			statement = connection.prepareStatement("  insert into review  (review_text, patient, doctor ) "
					+ "      values (? , (select patient_id from patient where ssn =  ? ),"
					+ "       (select doctor_id from doctor where registered_id = ? ))  ");
			statement.setString(1, review);
			statement.setString(2, patientssn);
			statement.setString(3, regid);
		
			statement.executeUpdate();
			statement.close();

		} catch (SQLException sqe) {
			System.out.println("PatientReviewService Error in Data Base Connection line  "+ sqe);
			addActionError("PatientReviewService Error in getting DB Connection"+ sqe);
			System.out.println(" PatientReviewService Error in getting DB Connection ");
			return false;
			// throw new HcmsException("Error in Data Base Connection.", sqe);
		} catch (Exception exception) {
			System.out.println("PatientReviewService Error in Data Base Connection Exception");
			addActionError("PatientReviewService Error in getting DB Connection");
			System.out.println("PatientReviewService Error in getting DB Connection ");
			return false;
			// throw exception;
		} finally {
			System.out.println("PatientReviewService  Data Base Connection FINALLY");
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
		}
		return true;
	}
	 ArrayList<PtAppointmentForm> list=new ArrayList<PtAppointmentForm>();  
	   
	   public ArrayList<PtAppointmentForm> getList() {  
	       return list;  
	   }  
	   public void setList(ArrayList<PtAppointmentForm> list) {  
	       this.list = list;  
	   }  
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
 

}
