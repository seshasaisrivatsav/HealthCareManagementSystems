<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title> Add Presciption</title>
<sx:head />
</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >  Add Prescription   <s:property value="usertype" />    </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="AddPrescription.action" method="post">
     
         <s:textfield name="medicineName" key="label.medicineName" size="50" />
         <sx:datetimepicker name="prescriptionDate" key="label.prescriptionDate"  
                       displayFormat="dd-MMM-yyyy" />
          <s:textfield name="patientssn" key="label.patientssn" size="50" />
           <s:textfield name="dosage" key="label.dosage" size="50" />  
          <s:textfield name="regid" key="label.regid" size="50" />
          
          <td height="39" align="center" colspan="2">       
      <input name="button" value="Add" type="submit" ONCLICK="button1()"> </td>
    </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>

