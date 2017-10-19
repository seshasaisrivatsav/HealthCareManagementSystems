<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<html>
<head>
<title>Register Here</title>
<sx:head />
</head>
<body>
<div style="text-align:center;">
  <h2 style="display:inline;" >   HCMS Application Register Here  </h2>
</div>
 <s:actionerror />
   <s:form action="CreUser.action" method="post">
    <tbody>  
      <s:radio name="usertype" list="#{'Doctor':''} " key="label.doctor"  /><br> 
      <s:radio name="usertype" list="#{'Patient':''} " key="label.patient"  /><br> 
      <s:radio name="usertype" list="#{'Pharmacy':''} " key="label.pharmacy"  /><br> 
 
         &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
      <s:submit style="text-align:center;"  method="submit" key="label.submit" />
      <!-- <td height="39" align="center" colspan="2">
      <input style="text-align:center;" name="button" value="Submit" type="submit" ONCLICK="button1()"> </td>  -->
 </tbody>
</s:form>
      <a  style="text-align:center;" href="Login.jsp"><p>Login</p></a>
</body>
</html>