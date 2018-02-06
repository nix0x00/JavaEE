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
    <script type="text/javascript" src="../js/func.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AVCB - APU Veterinary Clinic and Boarding System</title>
    
    <% 
        String s = request.getParameter("b");
        String c = request.getParameter("c");
        
        HttpSession sos = request.getSession(false);
        if(sos == null) {
            response.sendError(403);
        }
        if(sos != null) {
            String type = (String) sos.getAttribute("type");
            if(!type.equals("manager")) {
                response.sendError(403);
            //response.sendRedirect("../404.jsp");
            }
        }
    %>
    <script>
        var d = "<%=s%>";
        var y = "<%=c%>";
    </script>
</head>
<body id="background">
<div class="login">
    <form class="input-style" action="/Register" method="post">
        <input type="text" placeholder="First Name" name="firstname" />
        <br />
        <input type="text" placeholder="Last Name" name="lastname" />
        <br />
        <input type="text" placeholder="Email" name="email" />
        <br />
        <select name="vetType" id="VetType">
            <option value="Cats">Cats</option>
            <option value="Rabbit">Rabbits</option>
            <option value="Cats">Snakes</option>
        </select>
        <br />
        <select name="speciality" id="speciality">
            <option value="Dog">Dogs</option>
            <option value="Hamster">Hamster</option>
            <option value="Birds">Birds</option>
        </select>
        <script>
            document.getElementById("VetType").disabled = true;
            document.getElementById("speciality").disabled = true;
        </script>
        <br />
        <input type="password" placeholder="Password" name="password" />
        <br />
        <select onclick="validate()" id="type" name="type">
            <option value="null">Choose an option</option>
            <option value="receptionist">Receptionist</option>
            <option value="manager">Manager</option>
            <option value="staff">Staff</option>
            <option value="vet">Vet</option>
        </select>
        <br />
        <input type="submit" value="Sign Up">
    </form>
    <div class="reg" id="not"></div>
    <script type="text/javascript">
        r(d, y);
    </script>
    <a class="register" href="./login.jsp">Already have an account?</a>
</div>
</body>
</html>
