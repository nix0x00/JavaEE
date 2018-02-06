<%-- 
    Document   : report_five
    Created on : Jun 16, 2017, 3:18:34 PM
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
        <script src="../../js/fusioncharts.js"></script>
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
        
        <div class="content" id="chart" style="padding-top: 44px"></div>
        <br />
        
        <%
            double appoint = 0;
            double board = 0;
        %>
        <%@page import="fusioncharts.FusionCharts" %>
        
        <c:forEach items="${appointment}" var="list">
            
            <c:if test="${list != null}">
                <c:set var="ap" value="${list.price}"></c:set>
                <% appoint = (Double)pageContext.getAttribute("ap"); %>
            </c:if>
        </c:forEach>
                
                    
        <c:forEach items="${boarding}" var="list">
            <c:if test="${list != null}">
                <c:set var="bo" value="${list.price}"></c:set>
                <% board = (Double)pageContext.getAttribute("bo"); %>
            </c:if>
        </c:forEach>
        <%
            FusionCharts columnChart= new FusionCharts(
            "column2d",// chartType
                        "chart1",// chartId
                        "600","400",// chartWidth, chartHeight
                        "chart",// chartContainer
                        "json",// dataFormat
                        "{   "
                                + "\"chart\": "
                                + "{  \"caption\": \"Asia Pacific University\","
                                + "                   \"subCaption\": \"Veterinary & Boarding Service\","
                                + "                   \"xAxisName\": \"APUVCBS\","
                                + "                   \"yAxisName\": \"Revenues (In USD)\", "
                                + "                  \"numberPrefix\": \"$\", "
                                + "                  \"paletteColors\": \"#0075c2\", "
                                + "                  \"bgColor\": \"#ffffff\", "
                                + "                  \"borderAlpha\": \"20\", "
                                + "                  \"canvasBorderAlpha\": \"0\",  "
                                + "                 \"usePlotGradientColor\": \"0\",  "
                                + "                 \"plotBorderAlpha\": \"10\","
                                + "                   \"placeValuesInside\": \"1\","
                                + "                   \"rotatevalues\": \"1\","
                                + "                   \"valueFontColor\": \"#ffffff\", "
                                + "                  \"showXAxisLine\": \"1\", "
                                + "                  \"xAxisLineColor\": \"#999999\", "
                                + "                  \"divlineColor\": \"#999999\", "
                                + "                  \"divLineIsDashed\": \"1\", "
                                + "                  \"showAlternateHGridColor\": \"0\","
                                + "                   \"subcaptionFontSize\": \"14\", "
                                + "                  \"subcaptionFontBold\": \"0\" "
                                + "              }, "
                                + "              \"data\": ["
                                + "{             "
                                + "      \"label\": \"Appointment\", "
                                + "                  \"value\": \"" + appoint + "\" "
                                + "              },"
                                + " {  "
                                + "                 \"label\": \"Boarding\", "
                                + "                  \"value\": \"" + board + "\"  "
                                + "             },"
                                
                                + "]      "
                                + "     }"
                    );
           
            %>          
            <%=columnChart.render()%>


        
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