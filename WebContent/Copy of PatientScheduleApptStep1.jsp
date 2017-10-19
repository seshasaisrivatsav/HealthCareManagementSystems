<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title> Schedule Appointment </title>
<sx:head />
</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >  Schedule Appointment  <s:property value="usertype" />    </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="ScheAppt.action" method="post">
    
         <s:hidden  value="%{appdate}" name="appdate" />
       <s:hidden  value="%{regid}" name="regid" />
       <s:hidden  value="%{usertype}" name="usertype" />
     <sx:datetimepicker name="appdate" key="label.dateofappt"  
                    displayFormat="dd-MMM-yyyy" />  
        <s:textfield name="ssn" key="label.ssn" size="20" />              
         <s:textfield name="regid" key="label.regid" size="50" />
        
          <td height="39" align="center" colspan="2">       
      <input name="button" value="OK" type="submit" ONCLICK="button1()"> </td>
    </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>


