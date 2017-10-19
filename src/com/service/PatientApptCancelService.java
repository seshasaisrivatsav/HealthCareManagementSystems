
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

public class PatientApptCancelService extends ActionSupport implements SessionAware {

 
	public boolean cancelAppt(String appdate,
			                   String patientSSN  )
			throws Exception {
		boolean validation = false;
		System.out.println(" IN PatientApptCancelService Before JDBC connection 111");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = HcmsConnectionFactory.getConnection();
			if (connection == null) {
				addActionError("PatientApptCancelService Error in getting DB Connection");
				System.out.println("PatientApptCancelService Error in getting DB Connection ");
				return false;
				// throw new HcmsException("Error in getting DB connection .");
			}
			System.out.println(" PatientApptCancelService connection obtained");

			statement = connection.prepareStatement("   delete from appointment  where  date =  ?  "
					+ "                                    and patient in (select patient_id "
					+ "                                          from patient where ssn = ? )  ");
			statement.setString(1, appdate);
			statement.setString(2, patientSSN);
		
			statement.executeUpdate();
			statement.close();

		} catch (SQLException sqe) {
			System.out.println("PatientApptCancelService Error in Data Base Connection line  "+ sqe);
			addActionError("PatientApptCancelService Error in getting DB Connection"+ sqe);
			System.out.println(" PatientApptCancelService Error in getting DB Connection ");
			return false;
			// throw new HcmsException("Error in Data Base Connection.", sqe);
		} catch (Exception exception) {
			System.out.println("PatientApptCancelService Error in Data Base Connection Exception");
			addActionError("PatientApptCancelService Error in getting DB Connection");
			System.out.println("PatientApptCancelService Error in getting DB Connection ");
			return false;
			// throw exception;
		} finally {
			System.out.println("PatientApptCancelService  Data Base Connection FINALLY");
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
