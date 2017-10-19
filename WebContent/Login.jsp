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
  <h2 style="display:inline;" >   HCMS Application  </h2>
</div>


<s:form action="login.action" method="post">
    <s:textfield name="username" key="label.username" size="20" />
    <s:password name="password" key="label.password" size="20" />
 <s:actionerror />
    <s:submit method="login" key="label.login" align="center" />
</s:form>
<s:form action="Register.action" method="post">
	 <tr>
   <td colspan="2"> Not Yet Registered!! <input name="button" value="Register" type="submit" ONCLICK="button1()">  
     </tr>
</s:form>
</body>
</html>