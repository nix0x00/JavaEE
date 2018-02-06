<%-- 
    Document   : pet_status
    Created on : Jun 11, 2017, 9:34:01 AM
    Author     : abspk
--%>

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
                <a class="link pink selected" href="../index.jsp">AVCB</a>
                <!--<a class="link mix-yellow" href="https://meta.nix-dev.org">Community</a>-->
                <a class="link mix-pink" href="/Logout">Logout</a>
            </div>
        </nav>
        <div class="content" id="training">
            <br/><br/><br/>
            <form name="UpdateLastFeed" class="input-style" action="./UpdateLastFeed" method="post">
                <c:forEach items="${diagnosis}" var="object">
                    <input type="hidden" name="pk" value="${object.id}" />
                    
                    <p><strong>Update Pet Status & Last Feed</strong></p>
                    <br /> 
                    <p>Pet Name<br /> <input type="text" disabled="true" name="petName" value="${object.pet.name}" /></p>
                    <br />
                    <p>Status<br /> <input type="text" name="status" placeholder="Please enter the pet status" /></p>
                    <br />
                    <p>Last Fed</p> <br />
                    <p><select name="feed">
                        <option value="7 AM">7 AM</option>
                        <option value="12 PM">12 PM</option>
                        <option value="4 PM">4 PM</option>
                        <option value="8 PM">8 PM</option>
                        </select></p>
                    <br />
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