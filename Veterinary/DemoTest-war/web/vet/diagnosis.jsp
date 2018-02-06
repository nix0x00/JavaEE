<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../style/style.css"/>
        <link rel="stylesheet" type="text/css" href="../style/common.css"/>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AVCB - APU Veterinary Clinic and Boarding System</title>
    </head>
    <body>
        <nav>
            <div>
                <a class="link pink" href="./index.jsp">AVCB</a>
                <!--<a class="link mix-yellow" href="https://meta.nix-dev.org">Community</a>-->
                <a class="link purple" href="./view-appointment.jsp">View Appointments</a>
                <a class="link mix-pink selected" href="./SearchAP">Pet Diagnosis</a>
                <a class="link mix-pink" href="./report.jsp">Report</a>
                <a class="link blue" href="../Logout">Logout</a>
            </div>
        </nav>
        
        <div class="content" id="training">
            <br/><br/><br/>
            <form action="./LoadDiagnosis" method="post">
                <table style="width:100%">
                    <tr>
                        <th>Date</th>
                        <th>Customer Email</th>
                        <th>Customer Name</th>
                        <th>Pet Name</th>
                        <th>Service</th>
                    </tr>
                    <c:forEach items="${appointment}" var="list">
                        <c:if test="${list != null}">
                            <tr>
                                
                            <div>
                                <td><label><input type="radio" id='regular' value="${list.appointmentDate}" name="appointmentDate">${list.appointmentDate}</label></td>
                                <td><label>${list.custEmail}</label></td>
                                <td><label>${list.custName}</label></td>
                                <td><label>${list.petName}</label></td>
                                <td><label>${list.service}</label></td>
                            </div>
                            <input type="hidden" name="pk" id="pk" value="${list.id}"/>
                            <input type="hidden" name="diagnosis" value="diagnosis" />
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
                <input type="submit" value="Submit" />
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