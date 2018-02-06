<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 28/05/2017
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../style/common.css"/>
    <link rel="stylesheet" type="text/css" href="../style/style.css"/>

    <script src="../js/func.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AVCB - APU Veterinary Clinic and Boarding System</title>
    <% 
        String s = request.getParameter("b");
        String c = request.getParameter("c");
    %>
    <script>
        var d = "<%=s%>";
        var y = "<%=c%>";
    </script>
</head>
<body id="background">
<div class="login">
    <form class="input-style" action="/Login" method="post">
        <strong>Log Into AVCB</strong>
        <br /><br />
        <input type="text" placeholder="Username" name="username" />
        <br />
        <input type="password" placeholder="Password" name="password" />
        <br />
        <select name="type">
            <option value="null">Choose an option</option>
            <option value="receptionist">Receptionist</option>
            <option value="manager">Manager</option>
            <option value="staff">Staff</option>
            <option value="vet">Vet</option>
        </select>
        <br />
        <input type="submit" value="Submit">
    </form>
    
    <div class="reg" id="not"></div>
    <script type="text/javascript">
        r(d, y);
    </script>
    <a class="register" href="./register.jsp">Not Registered?</a>
</div>
</body>
</html>