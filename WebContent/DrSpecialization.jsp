<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title>Dr Specialization</title>
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
  <h2 style="display:inline;" >    Dr Specialization  </h2>
</div>
 
    <s:form  method="post">
      <tbody>
     <table style="width:80%">
  <tr>
    <th>Registered Id</th>
    <th>Name</th>
    <th>Specialization</th>
  </tr>
   <s:iterator  value="list">
       <td><s:property value="regid"/></td>
       <td><s:property value="name"/></td>
       <td><s:property value="specialization"/></td>
          </fieldset>
   </s:iterator>
   </table>
     </tbody>
  
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>
