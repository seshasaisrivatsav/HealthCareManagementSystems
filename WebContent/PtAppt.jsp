<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title>Patient Appointment</title>
<head />
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}

</style>

<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >    Patient Appointment    </h2>
</div>
 
    <s:form  method="post">
      <tbody>
     <table style="width:80%">
  <tr>
    <th>Doctor name</th>
    <th>Appointment Date</th>
  </tr>
   <s:iterator  value="list">
       <td><s:property value="AppointmentDate"/></td>
       <td><s:property value="drName"/></td>
          </fieldset>
   </s:iterator>
   </table>
     </tbody>

</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>




