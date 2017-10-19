<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>


<html>
<head>
<title>        HCMS     System      </title>
<sx:head />

<script type="text/javascript">
    
    function onButtonClick(){       
         alert("First Name:Button Clicked ");           
    }

</script>
</head>
<body>
    <s:form action="Home.action" method="post">
<s:actionerror />
<s:hidden  value="%{usertype}" name="usertype" />
<s:hidden  value="%{name}" name="name" />
<div style="text-align:center;">
       <s:if test="%{usertype=='Doctor'}">
             <h2 style="display:inline;" >    Welcome Dr.<s:property value="name" />   </h2>
       </s:if>
       <s:if test="%{usertype=='Pharmacy'}">
             <h2 style="display:inline;" >    Welcome <s:property value="name" />    </h2>
       </s:if>
       <s:if test="%{usertype=='Patient'}">
             <h2 style="display:inline;" >    Welcome Dear <s:property value="name" />    </h2>
       </s:if>

  <span style="float:right; display:block;"><a href="Login.jsp">Logout </a></span>
</div>
  <tbody>
    
  <!--   <sx:tabbedpanel 
        id="tabContainer">
        <sx:div label="Tab 1">
       Local Tab 1 
   </sx:div>
        <sx:div label="Tab 2">
       Local Tab 2 
   </sx:div>
</sx:tabbedpanel> -->
        <s:if test="%{usertype=='Pharmacy'}">
                 <a style="text-align:center;" href="UpdateInventory.jsp"><p>Update your inventory</p></a>
             </s:if>
    
 <s:if test="%{usertype=='Doctor'}">
    <a style="text-align:center;" href="DoctorViewAppointments.jsp"><p>View your appointments</p></a>
    <a  style="text-align:center;" href="AddPrescription.jsp"><p>Add a prescription</p></a>
     <a style="text-align:center;" href="AddReport.jsp"><p>Add a report</p></a>
 </s:if>

 <s:if test="%{usertype=='Patient'}">
     <a style="text-align:center;" href="PatientQueriesReport.jsp"><p>Check reports</p></a>
     <a style="text-align:center;" href="PatientViewAppointment.jsp"><p>View appointment</p></a>
    <!-- <a style="text-align:center;" href="GetDoctorDetails.jsp"><p>Get Doctor Details</p></a>  --> 
     <a style="text-align:center;" href="PatientScheduleApptStep1.jsp"><p>Schedule appointment</p></a>
     <a style="text-align:center;" href="PatientCancelsAppointment.jsp"><p>Cancel appointment</p></a>
     <a style="text-align:center;" href="PatientViewPresc.jsp"><p>View prescription</p></a>
     <a style="text-align:center;" href="PatientQueryPharmacy.jsp"><p>View pharmacy</p></a>
     <a style="text-align:center;" href="PatientReviewsDoc.jsp"><p>Review doctor</p></a>
 </s:if>
    
    <!--  <s:submit type="button" name="label.logout" label="Logout" onclick="onButtonClick();return false;"/>    -->
    <!--   <s:submit type="button" name="logout" label="Logout" onclick="openPage('Login.jsp') " />   -->

  </s:form>
  </tbody>


</body>
</html>