<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 26/05/2017
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./style/style.css"/>
    <link rel="stylesheet" type="text/css" href="./style/common.css"/>

    <script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="./js/jquery.cycle2.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AVCB - APU Veterinary Clinic and Boarding System</title>
</head>
<body>
<nav>
    <div>
        <a class="link pink" href="./index.jsp">AVCB</a>
        <!--<a class="link mix-yellow" href="https://meta.nix-dev.org">Community</a>-->
        <a class="link purple" href="./services.jsp#service">Services</a>
        <a class="link mix-pink" href="./faq.jsp#faq">FAQ</a>
        <a class="link maroon selected" href="./about.jsp#aboutUs">About</a>
        <a class="link gray" href="./index.jsp#contactUs">Contact</a>
        <a class="link blue" href="./auth/index.jsp">Login</a>
    </div>
</nav>
<div class="content" id="header">
    <a name="top"> <div class="cycle-slideshow">
        <br/><br/><br/>
        <span class="cycle-prev">&#9001;</span>
        <span class="cycle-next">&#9002;</span>
        <span class="cycle-pager"></span>
        <img src="./images/image1.jpg" alt="image 1">
        <img src="./images/image2.jpg" alt="image 2">
        <img src="./images/image3.png" alt="image 3">
    </div></a>
</div>
<div class="content" id="about">
    <a name="aboutUs">
        <strong><p>About Us</p></strong><br /><br />
        <p>Since 1982 the Veterinary Clinic has offered quality pet care services in Kuala Lumpur.  We have a wonderful mix of caregivers whose time with the clinic ranges from just a few years to over 20 years!  Although our interests are quite varied - quilting, photography, golfing, cars, and outdoor adventures - we're all united in our love of animals and our desire to help care for your pet! We offer a wide range of services including preventative care, surgery, dental care, x-rays, ultrasound and in house bloodwork.</p>
        <br /><br />
        <p>We developed our new name by selecting the words that tell the stories of our former namesakes, while also describing who we are and what we do. “Humane” describes our continued Open Door policy and our desire to restore all animals to full health, while “Animal Rescue” details our goal of helping all animals in need, both domestic and wild. Our new logo reflects the animals we serve: one tail represents wildlife and the other tail represents domestic animals.</p>
        <br /><br />
        <p>We strive to provide all aspects of care to abandoned, neglected, and injured animals; reunite lost pets with their caregivers or seek new families for them; educate the community on humane care and interactions with all animals with the goal of reducing pet overpopulation and negative relationships with native wildlife; reinforce a standard of living for animals and prevent cruelty; and provide assistance and medical care to injured, orphaned, or ill native Pennsylvania wildlife with a goal of returning them to their natural habitat.</p>
        <br /><br />
        <p>Call us today to schedule an appointment!</p>
    </a>
</div>
<div class="footer">
    <footer>
        <p id="footHeader">Copyright &copy; AVCB. All Rights Reserved. Veterinary Clinic and Boarding System by APU.</p>
        <a href="./tos/tos.jsp"><p>Terms of Services</p></a>

        <div id="alignFooter">
            <a href="https://facebook.com"><img src="./images/fb.png" title="AVCB on Facebook"/></a>
            <a href="https://twitter.com"><img src="./images/twitter.png" title="AVCB on Twitter"/></a>
        </div>
        <br/>
        <a href="./tos/policy.jsp"><p>Privacy Policy</p></a>
        <br/>
        <a href="./about.jsp#header"><p>Top Page</p></a>
    </footer>
</div>
</body>
</html>