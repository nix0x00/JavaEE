<%-- 
    Document   : report_three
    Created on : Jun 14, 2017, 1:44:47 PM
    Author     : abspk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../../style/style.css"/>
        <link rel="stylesheet" type="text/css" href="../../style/common.css"/>
        
        <script src="../../js/func.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AVCB - APU Veterinary Clinic and Boarding System</title>
    </head>
    <body>
        <nav>
            <div>
                <a class="link pink selected" href="../index.jsp">AVCB</a>
                <!--<a class="link mix-yellow" href="https://meta.nix-dev.org">Community</a>-->
                <a class="link purple" href="../../services.jsp#service">Services</a>
                <a class="link mix-pink" href="../../auth/register.jsp">Register User</a>
                <a class="link maroon" href="../Rota">Create Rota</a>
                <a class="link gray" href="./reports.jsp">Reports</a>
            </div>
        </nav>
        
        <div class="content" id="training">
            <br/><br/><br/>
            
            <c:forEach items="${appointment}" var="list">
                <c:if test="${list != null}">
                    <p>Total patients visited so far: <strong>${list.tel}</strong></p>
                    <p>Total money made so far: <strong>${list.price}</strong></p>
                </c:if>
            </c:forEach>
            <br />
            
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
