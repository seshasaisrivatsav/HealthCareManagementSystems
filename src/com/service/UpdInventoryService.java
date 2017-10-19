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

public class UpdInventoryService extends ActionSupport implements SessionAware{
 
 public boolean update( String pharmacyName,  String telephone, String medicineName, int countN)
			throws Exception {
		boolean validation = false;
		System.out.println(" IN UpdInventoryService Before JDBC connection 111");
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
			System.out.println(" createUser connection obtained");

			// Check if the username already exists , if exists then fail



			statement = connection
					.prepareStatement("  update MedicineInventory set count = ? "
							+ "           where pharmacy = (select pharmacy_id from pharmacy  "
							+ "                              where name = ?  and telephone = ?   ) "
							+ "               and medicine = (select medicine_id from medicine"
							+ "                                where name = ? )");
			statement.setInt(1, countN);
			statement.setString(2, pharmacyName);
			statement.setString(3, telephone);
			statement.setString(4, medicineName);

			statement.executeUpdate();
			statement.close();

		} catch (SQLException sqe) {
			System.out.println(" Error in Data Base Connection line  " + sqe);
			addActionError("Error in getting DB Connection" + sqe);
			System.out.println(" Error in getting DB Connection ");
			return false;
			//throw new HcmsException("Error in Data Base Connection.", sqe);
		} catch (Exception exception) {
			System.out.println(" Error in Data Base Connection Exception");
			addActionError("Error in getting DB Connection");
			System.out.println(" Error in getting DB Connection ");
			return false;
			//throw exception;
		} finally {
			System.out.println(" Error in Data Base Connection FINALLY");
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
