<%-- 
    Document   : create-boarding
    Created on : Jun 10, 2017, 8:36:58 AM
    Author     : abspk
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../../style/style.css"/>
        <link rel="stylesheet" type="text/css" href="../../style/common.css"/>
        <link rel="stylesheet" type="text/css" href="../../style/jquery.datetimepicker.min.css" />
        
        
        <script src="../../js/jquery.js"></script>
        <script src="../../js/jquery.datetimepicker.js"></script>
        <script src="../../js/jquery.datetimepicker.min.js"></script>
        <script src="../../js/func.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AVCB - APU Veterinary Clinic and Boarding System</title>
    </head>
    <body>
        <nav>
            <div>
                <a class="link pink" href="../index.jsp">AVCB</a>
                <a class="link blue" href="../../Logout">Logout</a>
            </div>
        </nav>
        
        
        <div class="content" id="services">
            <br /><br /><br /><br />
            <p>Request an Appointment</p>
            <br />
            <form name="createBoarding" class="input-style" action="./BoardingC" method="post">
                Duration: &nbsp;<p><select name="duration" title="Choose duration">
                        <option value="choose">Choose duration</option>
                        <option value ="1">One day</option>
                        <option value ="2">Two days</option>
                        <option value ="3">Three days</option>
                        <option value ="4">Four days</option>
                        <option value ="5">Five days</option>
                    </select><br />
                    <select name="customer" title="Choose a Customer">
                        <option value="choose">Choose a Customer</option>
                        <c:forEach items="${custList}" var="custDetail" >
                            <option value="${custDetail.email}">${custDetail.name} &nbsp; : &nbsp; ${custDetail.email}</option>
                        </c:forEach>
                    </select>
                    <br />
                    <input type="submit" value="Submit" /></p>
            </form>
        </div>
        <div class="footer">
            <footer>
                <p id="footHeader">Copyright &copy; AVCB. All Rights Reserved. Veterinary Clinic and Boarding System by APU.</p>
                <a href="../../tos/tos.jsp"><p>Terms of Services</p></a>
                
                <div id="alignFooter">
                    <a href="https://facebook.com"><img src="../../images/fb.png" title="AVCB on Facebook"/></a>
                    <a href="https://twitter.com"><img src="../../images/twitter.png" title="AVCB on Twitter"/></a>
                </div>
                <br/>
                <a href="../../tos/policy.jsp"><p>Privacy Policy</p></a>
                <br/>
                <a href="../../about.jsp#header"><p>Top Page</p></a>
            </footer>
        </div>
    </body>
</html>
