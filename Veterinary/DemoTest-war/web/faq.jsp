<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 27/05/2017
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./style/style.css"/>
    <link rel="stylesheet" type="text/css" href="./style/common.css"/>
    <script type="text/javascript" src="./js/func.js"></script>
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
        <a class="link mix-pink selected" href="./faq.jsp#faq">FAQ</a>
        <a class="link maroon" href="./about.jsp#aboutUs">About</a>
        <a class="link gray" href="./contact.jsp#contactUs">Contact</a>
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
<div class="content" id="training">
    <a name="service">
        <p>We're pleased to offer the following services at The Veterinary Clinic.</p><br />

        <strong><p>Appointments</p></strong>
        <p>Our appointment book is computerized which allows us to efficiently make appointments for you and your pet. Our receptionists and team will attempt to accommodate all requests to the best of our ability. Emergencies are accepted anytime our clinic is open. If you feel you have an emergency with your pet, please call us or come to the hospital immediately. If possible it is best to call before coming in so that a staff member can advise you on your particular emergency.</p>
        <br /><br />
        <strong><p>Emergency & Urgent Care</p></strong>
        <p>We have a veterinarian and personnel on duty 7 days a week who are trained and equipped to handle any urgent care your pet has. Usually an emergency team consists of at least one veterinarian and several technicians working together to save a pet's life. Emergencies can be things such as toxin/poison ingestion, hit by car, and seizures. If you ever feel that your pet needs emergency treatment do not hesitate to call or come in immediately. If possible it is best to call before coming in so that a team member can advise you on your particular emergency.
            We are also available for urgent care when the condition is not life-threatening. If you feel your pet needs to be seen before you are able to get an appointment, our veterinarians will work to "squeeze" you in between scheduled appointments. When you arrive, our receptionists will be able to give you an estimate on how long you may have to wait in order to be seen.</p>
        <br /><br />
        <strong><p>Types of Pets Seen</p></strong>
        <p>Because a large number of veterinarians practice at The Veterinary Clinic, we can care for many types of pets:</p>
        <br /><br />
        <p><li><p>Dogs</p></li></p>
        <p><li><p>Cats</p></li></p>
        <p><li><p>Rabbits</p></li></p>
        <p><li><p>Pocket Pets</p></li></p>
        <p><li><p>Reptiles</p></li></p>
        <p><li><p>Birds</p></li></p>
        <br /><br />

        <strong><p>Categories</p></strong>
        <p><li><p>Surgery</p></li></p>
        <p><li><p>Dental</p></li></p>
        <p><li><p>Physical Rehabilitation</p></li></p>
        <p><li><p>Avian/Exotics</p></li></p>
        <p><li><p>Microchipping</p></li></p>
        <p><li><p>Technician Appointments</p></li></p>
        <p><li><p>Pet Boarding</p></li></p>

        <br /><br />
        <strong><p>Discounts</p></strong>
        <p>The Veterinary Clinic offers discounted services to senior citizens and local area rescue groups. Pre-approval is required to qualify for the rescue group discounts, please call us for more information.</p>
        <br /><br />
        <strong><p>Call us for more information.</p></strong>
    </a>
</div>
<div class="content" id="services">
    <a class="links" name="faq">
        <p><strong>FAQ - Frquently Asked Questions</strong></p>
        <br /><br />

        <p><li><p>How long do you keep animals?</p></li></p>
        <p>There is no set time limit. We hold healthy, adoptable animals until we find them homes.</p>
        <br />
        <li><p>Are you funded by the state or other government entity?</p></li>
        <p>No! We are supported by the generous donations of the public. <br />To make a contribution, call 000-111-222</p>
        <br />
        <li><p>How do I know if my pet needs a specialist veterinarian?</p></li>
        <p>First, ask your veterinarian. Any pet that is seriously ill might benefit from this type of care. Animals that have sustained trauma or bite wounds are an obvious example, but a number of other problems are commonly treated.</p>
        <br />
        <li><p>Do you accept donations of opened food?</p></li>
        <p>No. All of our shelter animals are on a strict diet so that we can better monitor any health problems. We do not accept opened food.</p>
        <br />
        <li><p>How long will my cat or dog be pregnant?</p></li>
        <p>Gestation is approximately 63 days. However, in keeping with the mission of APU Veterinary Clinic, we encourage you to have your animals spayed or neutered in order to control the pet population. Please see our <a style="margin-left: 0; color: #FFFFFF" href="./contact.jsp#contactUs">Veterinary Clinic section</a> for details on our many programs to prevent unwanted animals from making their way to our shelter.</p>
        <br />
        <li><p>Do you bill for veterinary services?</p></li>
        <p>Yes. Please speak to our Clinic Manager at <strong>000-111-222</strong> regarding special circumstances for sick animals who need immediate care.</p>
    </a>
</div>
<div class="content" id="contact">
    <p><a name='contactUs'>
        Thanks for contacting APU Veterinary Clinic! While we strive to respond to every inquiry as quickly as possible,
        please allow up to 48 hours to receive a response.<br />
        <br/>If your matter is of an urgent nature, please call us at 000-111-2222.<br/><br />
        <form method="post" action="/Contact">
            <div id="map"></div>

            <script>
                setMap()
            </script>
            <!--<script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBQ6T7h4p1cvqr-IKxcoP_ONmy8SqeTkGA&callback=setMap">
            </script>-->

            <ol><strong>Name<span color="red">*</span></strong><br/>
                <input type="text" name="firstName" placeholder="First name" size="30"/>&nbsp; <input type="text" name="lastName" placeholder="Last name" size="30"/>
            </ol><br />
            <strong>Phone<span color="red">*</span></strong><br />
            <input type="tel" name="tel" placeholder="e.g 0173787324" size="30" />
            <br /><br />
            <strong>Email<span color="red">*</span></strong><br />
            <input type="email" name="email" placeholder="e.g jimmy@example.com" size="30" />
            <br /><br />
            <strong>Message<span color="red">*</span></strong><br />
            <textarea placeholder="Enter your message here.." name="message" tabindex="5" aria-required="true" aria-invalid="false" rows="10" cols="64" maxlength="400"></textarea>
            <br />
            <input type="submit" value="Submit" />
        </form>
    </a></p>
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
        <a href="./index.jsp#top"><p>Top Page</p></a>

    </footer>
</div>
</body>
</html>
