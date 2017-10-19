<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title> Review Doctor</title>
<sx:head />
</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >  Review Doctor  <s:property value="usertype" />    </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="ReviewDoctor.action" method="post">
     
         <s:textfield name="review" key="label.review" size="100" />
        <s:textfield name="patientssn" key="label.patientssn" size="25" />
         <s:textfield name="regid" key="label.drregid" size="25" />     
               
       
          <td height="39" align="center" colspan="2">       
      <input name="button" value="Submit Review" type="submit" ONCLICK="button1()"> </td>
    </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>


