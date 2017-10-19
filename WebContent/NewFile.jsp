<%@ page import="java.sql.*" %>
<%@ page import="com.util.HcmsConnectionFactory" %>
<%ResultSet resultset =null;%>

<HTML>
<HEAD>
    <TITLE>Select element drop down box</TITLE>
</HEAD>

<BODY >

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
    <h1> Drop down box or select element</h1>
        <select>
        <%  while(resultset.next()){
        	System.out.println(" resultset.getString(1)" + resultset.getString(1));
         	%>
            <option><%= resultset.getString(1) %></option>
        <% } %>
        </select>
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


</BODY>
</HTML>