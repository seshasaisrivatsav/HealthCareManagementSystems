<h1>HealthCareManagementSystems</h1>

<p>The project aims to build a Database System with web interface for Doctors, Patients and Pharmacy.
The aim of the project is to provide online features for an effective Health Care Management System.
The HCMS (Health Care Management Systems) helps bring Doctors, Patients and Pharmacists to a single system. 
The patients can schedule/cancel appointment(s) online, locate nearest pharmacies, check medicine availability at  pharmacy and also rate doctors. 
A Doctor can view his appointments and add prescription/reports for a patient online. A patient can view his prescription/reports online.
A pharmacy can update its inventory accordingly for the patient.</p>

<p><a href="https://docs.google.com/presentation/d/1NMdTmYszutj3tyaBNjqWXGNSmOg9LlBn1OjsXQzAEt4/edit?usp=sharing">Slides</a></p>

<p>The project is built using Java, mySQL </p>

<h1>Working of the project </h1>
<p>This is a mySQL backed <a href ="https://struts.apache.org/">struts 2</a> based frame work</p>
<ul>
   <li>WEB-INF has <a href="https://github.com/seshasaisrivatsav/HealthCareManagementSystems/blob/master/WebContent/WEB-INF/web.xml">web.xml</a> which loads the Login page</li>
   <li>login.jsp has a POST call which calls the login.action located in <a href="https://github.com/seshasaisrivatsav/HealthCareManagementSystems/blob/master/src/com/actions/LoginAction.java">com.actions.login</a> </li>
   <li>Login Action calls the <a href="https://github.com/seshasaisrivatsav/HealthCareManagementSystems/blob/master/src/com/service/LoginService.java">LoginService</a> which has the methods .All the services are in "/src/com/service" </li>
   <li>Database connection happens in LoginService where connection.prepareStatement(hasSQLQueries) in.</li>
   <li><a href = "https://github.com/seshasaisrivatsav/HealthCareManagementSystems/blob/master/Resources/db.properties">db properties</a> has database connection information </li>
   <li> <a href="https://github.com/seshasaisrivatsav/HealthCareManagementSystems/blob/master/Resources/struts.xml">struts.xml</a></li>
</ul>
