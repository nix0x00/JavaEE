<%-- 
    Document   : edit-boarding
    Created on : Jun 10, 2017, 8:36:39 AM
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
                <a class="link pink" href="../index.jsp">AVCB</a>
                <a class="link blue" href="../../Logout">Logout</a>
            </div>
        </nav>
        
        <div class="content" id="training">
            <br/><br/><br/>
            <form action="EditBoarding" method="post">
                <table style="width:100%">
                    <tr>
                        <th>Customer Name</th>
                        <th>Customer Email</th>
                        <th>Duration</th>
                        <th>Price</th>
                    </tr>
                    <c:forEach items="${boarding}" var="list">
                        <c:if test="${list != null}">
                            <tr>
                                
                            <div>
                                <td><label><input type="radio" id='regular' value="${list.id}" name="id">${list.cust.name}</label></td>
                                <td><label>${list.cust.email}</label></td>
                                <td><label>${list.duration} days</label></td>
                                <td><label>${list.price}</label></td>
                            </div>
                            <input type="hidden" name="pk" id="pk" value="${list.id}"/>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
                <br />
                <input type="submit" value="Submit" />
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
