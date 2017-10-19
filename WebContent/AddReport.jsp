<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title> Add Report</title>
<sx:head />
</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >  Add Report   <s:property value="usertype" />    </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="AddDrReport.action" method="post">
     
         <s:textfield name="enterreport" key="label.enterreport" size="50" />
         <sx:datetimepicker name="reportdate" key="label.reportdate"  
                       displayFormat="dd-MMM-yyyy" />
          <s:textfield name="bplevel" key="label.bplevel" size="50" />     
          <s:textfield name="patientheight" key="label.patientheight" size="50" />   
          <s:textfield name="patientweight" key="label.patientweight" size="50" />    
          <s:textfield name="patientcomment" key="label.patientcomment" size="50" />      
          <s:textfield name="patientssn" key="label.patientssn" size="50" />
             
       
          <td height="39" align="center" colspan="2">       
      <input name="button" value="Add Report" type="submit" ONCLICK="button1()"> </td>
    </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>

