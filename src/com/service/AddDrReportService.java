package com.service;

import com.util.HcmsConnectionFactory;
import com.util.HcmsException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class AddDrReportService extends ActionSupport implements SessionAware {

	public boolean addDrReport(String enterreport,
			                   String reportdate, String bplevel, 
			                   String patientheight, String patientweight,
			                   String patientcomment, String patientssn)
			throws Exception {
		boolean validation = false;
		System.out.println(" IN AddDrReportService Before JDBC connection 111");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = HcmsConnectionFactory.getConnection();
			if (connection == null) {
				addActionError("AddDrReportService Error in getting DB Connection");
				System.out.println("AddDrReportService Error in getting DB Connection ");
				return false;
				// throw new HcmsException("Error in getting DB connection .");
			}
			System.out.println(" AddDrReportService connection obtained");

			statement = connection
					.prepareStatement(" insert into report  (report_content, date, bloodpressure, heightincm, weightinlb, comments, appointment) "
							+ "values (?,  ?,  ?,   ?,  ?,  ?,  (select A.appointment_id from prescription P , Appointment A "
							+ "                                   where P.appointment = A.appointment_id and A.date = ? "
							+ "                                     and A.patient = (select patient_id from patient where ssn = ? ) limit 1)) ");
			statement.setString(1, enterreport);
			statement.setString(2, reportdate);
			statement.setString(3, bplevel);
			statement.setString(4, patientheight);
			statement.setString(5, patientweight);
			statement.setString(6, patientcomment);
			statement.setString(7, reportdate);
			statement.setString(8, patientssn);
			
		 

			statement.executeUpdate();
			statement.close();

		} catch (SQLException sqe) {
			System.out.println("AddDrReportService Error in Data Base Connection line  "+ sqe);
			addActionError("AddDrReportService Error in getting DB Connection"+ sqe);
			System.out.println(" AddDrReportService Error in getting DB Connection ");
			return false;
			// throw new HcmsException("Error in Data Base Connection.", sqe);
		} catch (Exception exception) {
			System.out.println("AddDrReportService Error in Data Base Connection Exception");
			addActionError("AddDrReportService Error in getting DB Connection");
			System.out.println("AddDrReportService Error in getting DB Connection ");
			return false;
			// throw exception;
		} finally {
			System.out.println("AddDrReportService  Data Base Connection FINALLY");
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
		}
		return true;
	}
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
 

}
