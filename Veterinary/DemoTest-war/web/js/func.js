/**
 * Created by abspk on 27/05/2017.
 */
function setMap() {
    var coord = {lat: 3.0483271, lng: 101.6906169};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: coord
    });
    var marker = new google.maps.Marker({
        position: coord,
        map: map
    });
}

function validate() {
    var t = document.getElementById("type");
    var selectedType = t.options[t.selectedIndex].value;
    if(selectedType == "vet") {
        alert("Vet Type input enabled..")
        document.getElementById("VetType").disabled = false;
        document.getElementById("speciality").disabled = false;
    } else {
        document.getElementById("VetType").disabled = true;
    }
}

$(document).ready(function () {
    $(function () {
        //jQuery('#datetimepicker').datetimepicker();
        $('#datetimepicker').datetimepicker();
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker2').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker3').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker4').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker5').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker6').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker7').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker8').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

function getText() {
    return "Sorry wrong username/password.";
}

function getWarn() {
    return "Please choose an option";
}

function r(d, y) {
    if(d === "true") {
        document.getElementById("not").innerText = getText();
    }
    if(y === "true") {
        document.getElementById("not").innerText = getWarn();
    }
}

function redirection(url) {
    var seconds = 5;
    var interval = setInterval(function() {
        document.getElementById('count').innerHTML = --seconds;
        
        if(seconds <= 0) {
            window.location.replace(url);
            clearInterval(interval);
        }
    }, 1000);
}

function editAppointment() {
    alert( $('input[type="radio"]:checked').val() );
    window.location.replace("./EditAppointment");
}