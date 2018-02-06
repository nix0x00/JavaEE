<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 28/05/2017
  Time: 2:13 AM
  To change this template use File | Settings | File Templates.
--%>
    
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../../style/style.css"/>
        <link rel="stylesheet" type="text/css" href="../../style/common.css"/>
            
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
            <div class="w3-sidebar w3-card">
                <a href="./ReportOne" class="w3-bar-item w3-button">Report 1</a>
                <a href="./ReportTwo" class="w3-bar-item w3-button">Report 2</a>
                <a href="./ReportThree" class="w3-bar-item w3-button">Report 3</a>
                <a href="./ReportFour" class="w3-bar-item w3-button">Report 4</a>
                <a href="./ReportFive" class="w3-bar-item w3-button">Report 5</a>
            </div>
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