<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title>Cancel Appointment </title>
<sx:head />
</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >    Cancel Appointment <s:property value="usertype" />   </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="CancelAppt.action" method="post">
     <sx:datetimepicker name="appdate" key="label.dateofappt"  
                    displayFormat="dd-MMM-yyyy" />  
         <s:textfield name="patientSSN" key="label.patientssn" size="50" />
              <td height="39" align="center" colspan="2">
      <input name="button" value="Cancel Appt" type="submit" ONCLICK="button1()"> </td>
    </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>

