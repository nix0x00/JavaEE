<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 28/05/2017
  Time: 2:13 AM
  To change this template use File | Settings | File Templates.
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
                <a class="link pink" href="../index.jsp">AVCB</a>
                <!--<a class="link mix-yellow" href="https://meta.nix-dev.org">Community</a>-->
                <a class="link purple" href="../services.jsp#service">Services</a>
                <a class="link mix-pink" href="../auth/register.jsp">Register User</a>
                <a class="link maroon selected" href="./create-rota.jsp">Create Rota</a>
                <a class="link gray" href="./report/reports.jsp">Reports</a>
                <a class="link blue" href="../Logout">Logout</a>
            </div>
        </nav>
            
        <div class="content" id="rotaHeight">
            
            <div id="rota">
                <form action="CreateRota" method="post">
                    <p>Monday</p>
                    <div>
                        <select name="monday" title="Speciality > Rabbit & Dog">
                            <option value="null">Speciality > Rabbit & Dog</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Rabbit' || vetDetail.speciality == 'Dog' || vetDetail.secondSpeciality == 'Rabbit' || vetDetail.secondSpeciality == 'Dog'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                                
                        </select>
                        &nbsp;<select name="monday2" title="Speciality > Cats & Hamster">
                            <option value="null">Speciality > Cats & Hamster</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Cat' || vetDetail.speciality == 'Hamster' || vetDetail.secondSpeciality == 'Cat' || vetDetail.secondSpeciality == 'Hamster'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<select name="monday3" title="Speciality > Birds & Snakes">
                            <option value="null">Speciality > Birds & Snakes</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Birds' || vetDetail.secondSpeciality == 'Birds' || vetDetail.speciality == 'Snakes' || vetDetail.secondSpeciality == 'Snakes'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<input type="text" name="mondayDate" id="datetimepicker2" placeholder="Select date.." >
                    </div>
                    <p>Tuesday</p>
                    <div>
                        <select name="tuesday" title="Speciality > Rabbit & Dog">
                            <option value="null">Speciality > Rabbit & Dog</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Rabbit' || vetDetail.speciality == 'Dog' || vetDetail.secondSpeciality == 'Rabbit' || vetDetail.secondSpeciality == 'Dog'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                                
                        </select>
                        &nbsp;<select name="tuesday2" title="Speciality > Cats & Hamster">
                            <option value="null">Speciality > Cats & Hamster</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Cat' || vetDetail.speciality == 'Hamster' || vetDetail.secondSpeciality == 'Cat' || vetDetail.secondSpeciality == 'Hamster'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<select name="tuesday3" title="Speciality > Birds & Snakes">
                            <option value="null">Speciality > Birds & Snakes</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Birds' || vetDetail.secondSpeciality == 'Birds' || vetDetail.speciality == 'Snakes' || vetDetail.secondSpeciality == 'Snakes'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<input type="text" name="tuesdayDate" id="datetimepicker3" placeholder="Select date.." >
                    </div>
                    <p>Wednesday</p>
                    <div>
                        <select name="wednesday" title="Speciality > Rabbit & Dog">
                            <option value="null">Speciality > Rabbit & Dog</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Rabbit' || vetDetail.speciality == 'Dog' || vetDetail.secondSpeciality == 'Rabbit' || vetDetail.secondSpeciality == 'Dog'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                                
                        </select>
                        &nbsp;<select name="wednesday2" title="Speciality > Cats & Hamster">
                            <option value="null">Speciality > Cats & Hamster</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Cat' || vetDetail.speciality == 'Hamster' || vetDetail.secondSpeciality == 'Cat' || vetDetail.secondSpeciality == 'Hamster'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<select name="wednesday3" title="Speciality > Birds & Snakes">
                            <option value="null">Speciality > Birds & Snakes</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Birds' || vetDetail.secondSpeciality == 'Birds' || vetDetail.speciality == 'Snakes' || vetDetail.secondSpeciality == 'Snakes'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<input type="text" name="wedDate" id="datetimepicker8" placeholder="Select date.." >
                    </div>
                    <p>Thursday</p>
                    <div>
                        <select name="thursday" title="Speciality > Rabbit & Dog">
                            <option value="null">Speciality > Rabbit & Dog</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Rabbit' || vetDetail.speciality == 'Dog' || vetDetail.secondSpeciality == 'Rabbit' || vetDetail.secondSpeciality == 'Dog'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                                
                        </select>
                        &nbsp;<select name="thursday2" title="Speciality > Cats & Hamster">
                            <option value="null">Speciality > Cats & Hamster</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Cat' || vetDetail.speciality == 'Hamster' || vetDetail.secondSpeciality == 'Cat' || vetDetail.secondSpeciality == 'Hamster'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<select name="thursday3" title="Speciality > Birds & Snakes">
                            <option value="null">Speciality > Birds & Snakes</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Birds' || vetDetail.secondSpeciality == 'Birds' || vetDetail.speciality == 'Snakes' || vetDetail.secondSpeciality == 'Snakes'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<input type="text" name="thursDate" id="datetimepicker4" placeholder="Select date.." >
                    </div>
                    <p>Friday</p>
                    <div>
                        <select name="friday" title="Speciality > Rabbit & Dog">
                            <option value="null">Speciality > Rabbit & Dog</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Rabbit' || vetDetail.speciality == 'Dog' || vetDetail.secondSpeciality == 'Rabbit' || vetDetail.secondSpeciality == 'Dog'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                                
                        </select>
                        &nbsp;<select name="friday2" title="Speciality > Cats & Hamster">
                            <option value="null">Speciality > Cats & Hamster</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Cat' || vetDetail.speciality == 'Hamster' || vetDetail.secondSpeciality == 'Cat' || vetDetail.secondSpeciality == 'Hamster'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<select name="friday3" title="Speciality > Birds & Snakes">
                            <option value="null">Speciality > Birds & Snakes</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Birds' || vetDetail.secondSpeciality == 'Birds' || vetDetail.speciality == 'Snakes' || vetDetail.secondSpeciality == 'Snakes'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<input type="text" name="friDate" id="datetimepicker5" placeholder="Select date.." >
                    </div>
                    <p>Saturday</p>
                    <div>
                        <select name="saturday" title="Speciality > Rabbit & Dog">
                            <option value="null">Speciality > Rabbit & Dog</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Rabbit' || vetDetail.speciality == 'Dog' || vetDetail.secondSpeciality == 'Rabbit' || vetDetail.secondSpeciality == 'Dog'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                                
                        </select>
                        &nbsp;<select name="saturday2" title="Speciality > Cats & Hamster">
                            <option value="null">Speciality > Cats & Hamster</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Cat' || vetDetail.speciality == 'Hamster' || vetDetail.secondSpeciality == 'Cat' || vetDetail.secondSpeciality == 'Hamster'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<select name="saturday3" title="Speciality > Birds & Snakes">
                            <option value="null">Speciality > Birds & Snakes</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Birds' || vetDetail.secondSpeciality == 'Birds' || vetDetail.speciality == 'Snakes' || vetDetail.secondSpeciality == 'Snakes'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<input type="text" name="satDate" id="datetimepicker6" placeholder="Select date.." >
                    </div>
                    <p>Sunday</p>
                    <div>
                        <select name="sunday" title="Speciality > Rabbit & Dog">
                            <option value="null">Speciality > Rabbit & Dog</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Rabbit' || vetDetail.speciality == 'Dog' || vetDetail.secondSpeciality == 'Rabbit' || vetDetail.secondSpeciality == 'Dog'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                                
                        </select>
                        &nbsp;<select name="sunday2" title="Speciality > Cats & Hamster">
                            <option value="null">Speciality > Cats & Hamster</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Cat' || vetDetail.speciality == 'Hamster' || vetDetail.secondSpeciality == 'Cat' || vetDetail.secondSpeciality == 'Hamster'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<select name="sunday3" title="Speciality > Birds & Snakes">
                            <option value="null">Speciality > Birds & Snakes</option>
                            <c:forEach items="${vetList}" var="vetDetail">
                                <c:if test="${vetDetail.speciality == 'Birds' || vetDetail.secondSpeciality == 'Birds' || vetDetail.speciality == 'Snakes' || vetDetail.secondSpeciality == 'Snakes'}">
                                    <option value="${vetDetail.email}">${vetDetail.firstName}&nbsp; ${vetDetail.lastName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        &nbsp;<input type="text" name="sunDate" id="datetimepicker7" placeholder="Select date.." >
                    </div>
                    <br />
                    <input type="submit" value="Submit" />
                </form>
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