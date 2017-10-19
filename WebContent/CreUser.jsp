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
  <h2 style="display:inline;" >    Welcome <s:property value="usertype" />  Registration Form   </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="AddUser.action" method="post">
 
  <!--    <h2>Howdy, <s:property value="usertype" />...!</h2> -->
  <s:hidden  value="%{usertype}" name="usertype" />
 <!--  required="true"  <s:textfield name="usertype" value="%{usertype}" readonly="true"/>-->
        <s:if test="%{usertype!='Pharmacy'}">
             <s:textfield name="ssn" key="label.ssn" size="20" />
        </s:if>
          <s:textfield name="name" key="label.name" size="20" />
       <s:if test="%{usertype!='Pharmacy'}">
              <sx:datetimepicker name="dob" key="label.dob"  
                    displayFormat="dd-MMM-yyyy" />  
        </s:if>
           <s:textfield name="username" key="label.username" size="20" />  
          <s:password name="password" key="label.password" size="20" />
        <s:if test="%{usertype!='Pharmacy'}">  
          <s:select name="gender" id="fieldTwo" list="{'M','F'}" 
                headerKey="-1" headerValue="Select" value="%{gender}"  key="label.gender"/>
          </s:if>       
          <s:textfield name="address" key="label.address" size="120" />
     
        <s:if test="%{usertype=='Doctor'}">
       <s:textfield name="regid" key="label.regid" size="20" />
          <s:textfield name="speciality" key="label.speciality" size="50" />
           </s:if>
             <s:if test="%{usertype=='Pharmacy'}">
                 <s:textfield name="telephone" key="label.phone" size="20" />
             </s:if>
      <td height="39" align="center" colspan="2">
      <input name="button" value="Submit" type="submit" ONCLICK="button1()"> </td>
 
   </tbody>
</s:form>
   <!--  <a  style="text-align:center;" href="Login.jsp"><p>Login</p></a>  --> 
</body>
</html>



