<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<title> Doctor Details </title>
<sx:head />

</head>
<body>
 <div style="text-align:center;">
  <h2 style="display:inline;" >  Doctor Details  <s:property value="usertype" />    </h2>
</div>
 <s:actionerror />
  <tbody>
    <s:form action="DrDetails.action" method="post">
  <br>
  <br>

<label for="speciality">Choose Doctor Speciality :</label>
	 <select list="Speciality2" name="Speciality2" label="label.speciality">
	 <option  disabled selected></option>
 <option value="Allergist">Allergist or Immunologist</option>
<option value="Anesthesiologist">Anesthesiologist</option>
<option value="Cardiologist">Cardiologist</option>
<option value="Dermatologist">Dermatologist</option>
<option value="Gastroenterologist">Gastroenterologist</option>
<option value="Hematologist">Hematologist/Oncologist</option>
<option value="InternalMedicine">Internal Medicine Physician</option>
<option value="Nephrologist">Nephrologist</option>
<option value="Neurologist">Neurologist</option>
<option value="Neurosurgeon">Neurosurgeon</option>
<option value="Obstetrician">Obstetrician</option>
<option value="Gynecologist">Gynecologist</option>
<option value="Nurse">Nurse</option>
<option value="OccupationalMedicine">OccupationalMedicine Physician</option>
<option value="Ophthalmologist">Ophthalmologist</option>
<option value="OralSurgeon">Oral and Maxillofacial Surgeon</option>
<option value="OrthopaedicSurgeon">Orthopaedic Surgeon</option>
<option value="Otolaryngologist">Otolaryngologist (Head and Neck Surgeon)</option>
<option value="Pathologist">Pathologist</option>
<option value="Pediatrician">Pediatrician</option>
<option value="PlasticSurgeon">Plastic Surgeon</option>
<option value="Podiatrist">Podiatrist</option>
   </select> 
 
        <s:hidden  value="%{appdate}" name="appdate" />
       <s:hidden  value="%{regid}" name="regid" />
       <s:hidden  value="%{usertype}" name="usertype" />
       <s:hidden  value="%{Speciality2}" name="Speciality2" />

    <!--       <s:textfield name="speciality" key="label.speciality" size="50" />  -->  
     <br>
     <br> <br>
             <td height="39" align="center" colspan="4">       
        <br>     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     
        <input name="button" value="OK" type="submit" ONCLICK="button1()"> </td>
            </tbody>
</s:form>
  
<a class="button" href="javascript:history.back()">Back</a>
</body>
</html>


