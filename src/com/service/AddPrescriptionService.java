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

public class AddPrescriptionService extends ActionSupport implements SessionAware {

	
	 public boolean addPrescription( String medicineName,  String prescriptionDate, 
			                         String patientssn, String dosage, String regid)
				throws Exception {
			boolean validation = false;
			System.out.println(" IN AddPrescriptionService Before JDBC connection 111");
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
			 	connection = HcmsConnectionFactory.getConnection();
				if (connection == null) {
					addActionError("Error in getting DB Connection");
					System.out.println(" Error in getting DB Connection ");
					return false;
					// throw new HcmsException("Error in getting DB connection .");
				}
				System.out.println(" AddPrescriptionService connection obtained");

				statement = connection
						.prepareStatement("  insert into prescription (appointment) "
								+ "             select appointment_id from appointment A where date = ?    "
								+ "               and A.patient = (select patient_id from patient where ssn = ? )  "
								+ "               and A.doctor = (select doctor_id from doctor where registered_id =  ? )  ");
				
				statement.setString(1, prescriptionDate);
				statement.setString(2, patientssn);
				statement.setString(3, regid);

				statement.executeUpdate();
				statement.close();			
				
				
				
				statement = connection
						.prepareStatement(" insert into medicinename (medname, prescription, dosage) "
								+ " values ( ? ,   (select P.prescription_id from prescription P , Appointment A "
								+ "                  where P.appointment = A.appointment_id and A.date =  ?  "
								+ "                    and A.patient = (select patient_id from patient where ssn = ? ) ) , ? )   ");
				statement.setString(1, medicineName);
				statement.setString(2, prescriptionDate);
				statement.setString(3, patientssn);
				statement.setString(4, dosage);

				statement.executeUpdate();
				statement.close();
				

			} catch (SQLException sqe) {
				System.out.println("AddPrescriptionService Error in Data Base Connection line  " + sqe);
				addActionError("AddPrescriptionService Error in getting DB Connection" + sqe);
				System.out.println(" AddPrescriptionService Error in getting DB Connection ");
				return false;
				//throw new HcmsException("Error in Data Base Connection.", sqe);
			} catch (Exception exception) {
				System.out.println("AddPrescriptionService Error in Data Base Connection Exception");
				addActionError("AddPrescriptionService Error in getting DB Connection");
				System.out.println("AddPrescriptionService Error in getting DB Connection ");
				return false;
				//throw exception;
			} finally {
				System.out.println("AddPrescriptionService  Data Base Connection FINALLY");
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
