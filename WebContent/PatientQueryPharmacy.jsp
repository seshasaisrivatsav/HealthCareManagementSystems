<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title> Query Pharmacy</title>
<sx:head />
</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >    Query <s:property value="usertype" /> Pharmacy   </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="PtQryPharmacy.action" method="post">
      <s:hidden  value="%{medicineName}" name="medicineName" />
           <s:textfield name="medicineName" key="label.medicineName" size="50" />
              <td height="39" align="center" colspan="2">
      <input name="button" value="Check Availability" type="submit" ONCLICK="button1()"> </td>
    </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>

