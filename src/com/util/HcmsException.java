/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

/**
 *
 * @author sssv
 */

public class HcmsException
  extends Exception{
     private static final long serialVersionUID = 8381378820856305263L;
     
       public HcmsException(String string, String string2) {}
  
  public HcmsException(String message)
  {
    super(message);
  }
  
  public HcmsException(Throwable throwable)
  {
    super(throwable);
  }
  
  public HcmsException(String message, Throwable throwable)
  {
    super(message, throwable);
  }
}





 
  

