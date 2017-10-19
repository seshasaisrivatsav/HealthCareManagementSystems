<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title> Query Pharmacy</title>
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
  <h2 style="display:inline;" >    Query Pharmacy    </h2>
</div>
 
    <s:form  method="post">
      <tbody>
     <table style="width:100%">
  <tr>
    <th>Pharmacy Name</th>
    <th>Medicine Name</th>
     <th>Medicine count</th>
      <th>Drug Component</th>
       <th>Address</th>
        <th>Telephone</th>
  </tr>
   <s:iterator  value="list">
       <td><s:property value="phName"/></td>
       <td><s:property value="medName"/></td>
       <td><s:property value="medCount"/></td>
       <td><s:property value="drugComp"/></td>
       <td><s:property value="address"/></td>
       <td><s:property value="telephone"/></td>
          </fieldset>
   </s:iterator>
   </table>
     </tbody>
 
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>
