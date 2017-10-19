<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.util.HcmsConnectionFactory" %>
<%ResultSet resultset =null;%>

<html>
<head>
<title> Schedule Appointment </title>
<sx:head />
<style>
h22 {
	font-family: TimesNewRoman,Times New Roman,Times,Baskerville,Georgia,serif;
	font-size: 24px;
	font-style: italic;
	font-variant: normal;
	font-weight: 500;
	line-height: 26.4px;
} </style>
</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >  Schedule Appointment  <s:property value="usertype" />    </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="ScheAppt.action" method="post">
   
 <%

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try
    {
   	 System.out.println(" IN  JDBC connection");
      connection = HcmsConnectionFactory.getConnection();
      if (connection == null) {
    	  System.out.println(" Error in getting DB Connection ");
       // throw new HcmsException("Error in getting DB connection .");
  
      }
      System.out.println(" connection obtained");
      statement = connection.prepareStatement("select concat(specialization , '#', registered_id) from doctor");
      resultset =statement.executeQuery() ;
      System.out.println(" query ran connection obtained");

%>   
    
<center>
<br> <br>
       <h22>  <s:text  name = "Choose Speciality "/><br> </h22> 
       <br>
         <select list="Speciality2" name="Speciality2" label="label.speciality">
        <%  while(resultset.next()){
        	System.out.println(" resultset.getString(1)" + resultset.getString(1));
         	%>
      <option><%= resultset.getString(1) %></option>
        <% } %>
        </select>
        
        <br> <br>
</center>

<%
//**Should I input the codes here?**
	
		 System.out.println(" connection obtained 2222");
statement.close();
System.out.println(" connection obtained 4444");
if (resultSet != null) {
	resultSet.close();
}
System.out.println(" connection obtained 3333");
        }
        catch(Exception e)
        {
             out.println("wrong entry hhh");
        }
    finally {
    	if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
    }
    
%>   
    
    <br> <br>
    
    
         <s:hidden  value="%{appdate}" name="appdate" />
       <s:hidden  value="%{regid}" name="regid" />
       <s:hidden  value="%{usertype}" name="usertype" />
       <s:hidden  value="%{Speciality2}" name="Speciality2" />
       
     <sx:datetimepicker name="appdate" key="label.dateofappt"  
                    displayFormat="dd-MMM-yyyy" />  
        <s:textfield name="ssn" key="label.ssn" size="20" />              
      <!--   <s:textfield name="regid" key="label.regid" size="50" /> --> 
        
          <td height="39" align="center" colspan="2">       
      <input name="button" value="OK" type="submit" ONCLICK="button1()"> </td>
    </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>


