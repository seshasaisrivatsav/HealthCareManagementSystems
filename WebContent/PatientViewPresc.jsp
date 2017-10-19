<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title>View Prescription</title>
<sx:head />
</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >    View <s:property value="usertype" /> Prescription  </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="viewPrescri.action" method="post">
      <s:hidden  value="%{AppointmentDate}" name="AppointmentDate" />
       <s:hidden  value="%{PatientSSN}" name="PatientSSN" />
     <sx:datetimepicker name="AppointmentDate" key="label.reportdate"  
                    displayFormat="dd-MMM-yyyy" />  
         <s:textfield name="PatientSSN" key="label.patientssn" size="50" />
              <td height="39" align="center" colspan="2">
      <input name="button" value="View" type="submit" ONCLICK="button1()"> </td>
    </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>

