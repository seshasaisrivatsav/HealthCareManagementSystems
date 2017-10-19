<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title>Patient Report</title>
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
  <h2 style="display:inline;" >    Patient Report    </h2>
</div>
 
    <s:form  method="post">
      <tbody>
     <table style="width:100%">
  <tr>
    <th>Patient</th>
    <th>Report</th>
    <th>Date</th>
    <th>BloodPressure</th>
    <th>Height(CM)</th>
    <th>Weight(LB)</th>
    <th>Comments</th>
  </tr>
   <s:iterator  value="list">
       <td><s:property value="name"/></td>
       <td><s:property value="report"/></td>
       <td><s:property value="date"/></td> 
       <td><s:property value="bloodpressure"/></td> 
         <td><s:property value="heightincm"/></td> 
          <td><s:property value="weightinlb"/></td> 
            <td><s:property value="comments"/></td> 
          </fieldset>
   </s:iterator>
   </table>
     </tbody>

</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>




