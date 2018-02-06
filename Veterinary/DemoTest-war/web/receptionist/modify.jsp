<%-- 
    Document   : modify
    Created on : Jun 8, 2017, 1:21:45 PM
    Author     : abspk
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../style/style.css"/>
        <link rel="stylesheet" type="text/css" href="../style/common.css"/>
        <link rel="stylesheet" type="text/css" href="../style/jquery.datetimepicker.min.css" />
            
            
        <script src="../js/jquery.js"></script>
        <script src="../js/jquery.datetimepicker.js"></script>
        <script src="../js/jquery.datetimepicker.min.js"></script>
        <script src="../js/func.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AVCB - APU Veterinary Clinic and Boarding System</title>
    </head>
    <body>
        <nav>
            <div>
                <a class="link pink" href="./index.jsp">AVCB</a>
                <!--<a class="link mix-yellow" href="https://meta.nix-dev.org">Community</a>-->
                <a class="link purple selected" href="../Appointment">Appointments</a>
                <a class="link mix-pink" href="../auth/register.jsp">Register User</a>
                <a class="link maroon" href="./boarding/create-boarding.jsp">Boarding Service</a>
                <a class="link blue" href="../Logout">Logout</a>
            </div>
        </nav>
            
            
        <div class="content" id="services">
            <br /><br /><br /><br />
            <p>Request an Appointment</p>
            <br />
            <form name="modifyAppointment" class="input-style" action="./ModifyAppointment" method="post">
                <c:forEach items="${appoint}" var="object">
                    
                    <c:set var="app" value="${object.appointmentDate}" scope="session" ></c:set>
                    <input type="hidden" name="pk" value="${object.id}" />
                    <input type="text" id="name" name="name" placeholder="Customer Name e.g John Doe" value="${object.custName}" /><br />
                    <input type="hidden" id="email" name="email" placeholder="Email address e.g somename@example.com" value="${object.custEmail}" /><br />
                    <input type="tel" id="telephone" name="telephone" placeholder="e.g 0173787324" value="${object.tel}" /><br />
                    <input type="text" placeholder="Pet Name" name="petName" id="petName" value="${object.petName}" /><br />
                    <input type="text" placeholder="Pet Type" name="petType" id="petType" value="${object.type}" /><br />
                    <input type="hidden" name="petID" id="petID" value="${object.pet.id}" />
                    <select id="reason" name="reason" title="Choose a service">
                        <option value="${object.service}">${object.service}</option>
                        <option value="surgery">Surgery</option>
                        <option value="bath">Full Bath</option>
                        <option value="cut">Full Cut</option>
                        <option value="exam">Sick Pet Exam</option>
                        <option value="visit">New Patient Visit</option>
                        <option value="annual">Annual Wellness Exam</option>
                        <option value="vaccination">Vaccination</option>
                        <option value="other">Others</option>
                    </select><br />
                    <select name="vet" title="Choose a Vet">
                        <option value="choose">${object.vet.firstName}&nbsp; ${object.vet.lastName}</option>
                        <c:forEach items="${vetList}" var="vetDetail" >
                            <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp;${vetDetail.lastName} &nbsp; : &nbsp; ${vetDetail.speciality} & ${vetDetail.secondSpeciality}</option>
                        </c:forEach>
                    </select>
                    <br />
                    <input type="text" name="date" id="datetimepicker" placeholder="Choose a date.." value="${object.appointmentDate}">
                    <br />
                    <input type="submit" value="Submit" />
                </c:forEach>
            </form>
        </div>
        <div class="footer">
            <footer>
                <p id="footHeader">Copyright &copy; AVCB. All Rights Reserved. Veterinary Clinic and Boarding System by APU.</p>
                <a href="../tos/tos.jsp"><p>Terms of Services</p></a>
                    
                <div id="alignFooter">
                    <a href="https://facebook.com"><img src="../images/fb.png" title="AVCB on Facebook"/></a>
                    <a href="https://twitter.com"><img src="../images/twitter.png" title="AVCB on Twitter"/></a>
                </div>
                <br/>
                <a href="../tos/policy.jsp"><p>Privacy Policy</p></a>
                <br/>
                <a href="../about.jsp#header"><p>Top Page</p></a>
            </footer>
        </div>
    </body>
</html>