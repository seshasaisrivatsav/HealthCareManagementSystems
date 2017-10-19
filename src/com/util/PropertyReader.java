/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;
import java.util.ResourceBundle;
/**
 *
 * @author sssv
 */
public class PropertyReader {
    
  private static final String DB_BUNDLE_NAME = "db";
  private static final String ARCHIVE_LOCATION_NAME = "archivelocation";
  private static final ResourceBundle DB_RESOURCE_BUNDLE = ResourceBundle.getBundle("db");
  private static final ResourceBundle ARCHIVE_RESOURCE_BUNDLE = ResourceBundle.getBundle("archivelocation");
  
  public static String getDBProperty(String key)
  {
    return DB_RESOURCE_BUNDLE.getString(key);
  }
  
  public static String getArchiveLocationProperty(String key)
  {
    return ARCHIVE_RESOURCE_BUNDLE.getString(key);
  }
    
}
