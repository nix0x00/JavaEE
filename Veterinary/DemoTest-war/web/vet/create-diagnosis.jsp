<%-- 
    Document   : create-diagnosis
    Created on : Jun 11, 2017, 12:10:37 AM
    Author     : abspk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../style/style.css"/>
        <link rel="stylesheet" type="text/css" href="../style/common.css"/>
        
        <script src="../js/func.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AVCB - APU Veterinary Clinic and Boarding System</title>
    </head>
    <body>
        <nav>
            <div>
                <a class="link pink" href="./index.jsp">AVCB</a>
                <a class="link blue" href="../Logout">Logout</a>
            </div>
        </nav>
        
        <div class="content" id="training">
            <br/><br/><br/>
            <form name="CreateDiagnosis" class="input-style" action="./CreateDiagnosis" method="post">
                <c:forEach items="${app}" var="object">
                    <input type="hidden" name="pk" value="${object.id}" />
                        
                    <p><strong>Enter Diagnosis</strong></p>
                    <br /> 
                    <p>Status<br /> <input type="text" name="status" placeholder="Please enter the pet status" /></p>
                    <br />
                    <p>Pet Name<br /> <input type="text" disabled="true" name="petName" value="${object.pet.name}" /></p>
                    <br />
                    <p>Pet Type<br /> <input type="text" name="petType" value="${object.pet.type}" disabled="true" /></p>
                    <br />
                    <p>Customer Name<br /> <input type="text" disabled="true" name="custName" value="${object.customer.name}" /></p>
                    <br />
                    <input type="hidden" name="appoint" value="${object.id}" />
                    <input type="hidden" name="petID" value="${object.pet.id}" />
                    <input type="hidden" name="custID" value="${object.customer.email}" />
                    <br />
                    <p><input type="submit" value="Submit" /></p>
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
