<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<html>
<head>
<title> HCMS Application </title>
<sx:head />
</head>

<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >   Update Inventory  </h2>
</div>
 <s:actionerror />

  <tbody>
    <s:form action="UpdateInventory.action" method="post">
<s:hidden  value="%{usertype}" name="usertype" />
          <s:textfield name="countN" key="label.count" size="20" />
           <s:textfield name="pharmacyName" key="label.pharmacyname" size="20" />  
            <s:textfield name="telephoneNo" key="label.phone" size="20" />
          <s:textfield name="medicineName" key="label.medicineName" size="120" />
            
      <td height="39" align="center" colspan="2">
      <input name="button" value="Update" type="submit" ONCLICK="button1()"> </td>
 
   </tbody>
</s:form>

<a class="button" href="javascript:history.back()">Back</a>
</body>
 
</html>