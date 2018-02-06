<%-- 
    Document   : success
    Created on : Jun 2, 2017, 9:47:38 PM
    Author     : abspk
--%>
<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 02/06/2017
  Time: 3:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../style/style.css"/>
        <link rel="stylesheet" type="text/css" href="../style/common.css"/>
        
        <script type="text/javascript" src="../js/func.js"></script>
        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="../js/jquery.cycle2.min.js"></script>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AVCB - APU Veterinary Clinic and Boarding System</title>
        
        <%
            String url = request.getParameter("url");
        %>
        <script type="text/javascript">
            var uri = "<%=url%>";
        </script>
    </head>
    <body>
        <nav>
            <div>
                <a class="link pink selected" href="../index.jsp">AVCB</a>
                <!--<a class="link mix-yellow" href="https://meta.nix-dev.org">Community</a>-->
                <a class="link purple" href="../services.jsp#service">Services</a>
                <a class="link mix-pink" href="../faq.jsp#faq">FAQ</a>
                <a class="link maroon" href="../about.jsp#aboutUs">About</a>
                <a class="link gray" href="../contact.jsp#contactUs">Contact</a>
                <a class="link blue" href="../auth/index.jsp">Login</a>
            </div>
        </nav>
        <div class="content" id="header">
            <div class="logout">
                <Strong>You have been Registered successfully!</Strong>
                
                <div id="logout">
                    <div id="count"></div>
                </div>
                
                <script type="text/javascript">     
                    redirection(uri);
                </script>
            </div>
        </div>
        
        <div class="footer">
            <footer>
                <p id="footHeader">Copyright &copy; AVCB. All Rights Reserved. Veterinary Clinic and Boarding System by APU.</p>
                <a href="./tos/tos.jsp"><p>Terms of Services</p></a>
                
                <div id="alignFooter">
                    <a href="https://facebook.com"><img src="../images/fb.png" title="AVCB on Facebook"/></a>
                    <a href="https://twitter.com"><img src="../images/twitter.png" title="AVCB on Twitter"/></a>
                </div>
                <br/>
                <a href="./tos/policy.jsp"><p>Privacy Policy</p></a>
                <br/>
                <a href="./about.jsp#header"><p>Top Page</p></a>
            </footer>
        </div>
    </body>
</html>
