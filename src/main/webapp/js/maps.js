var distanceF;
var initialLocation;

function init() {
    //set options for map
    var mapDiv = document.getElementById("myMap");
    var options = {
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        zoom: 12
    };

    var map = new google.maps.Map(mapDiv, options);

    // get current location of the user
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pinImage = new google.maps.MarkerImage("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|FFFF00");
            initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            map.setCenter(initialLocation);
            // set marker for user's current location
            var marker = new google.maps.Marker({
                position: map.getCenter(),
                icon: pinImage,
                title: "You are here",
                map: map
            });

            // get host name and port number of current host to create the api url
            var url = window.location.href;
            var arr = url.split("/");
            var api_url = "http://" + arr[2] + "/WHAM/datasource/" + position.coords.latitude + "/" + position.coords.longitude + "/10";
            
            // api call
            $.get({ url: api_url }, function (data) {
                var loc = data;

            // make map responsive
            google.maps.event.addDomListener(window, "resize", function () {
                var center = map.getCenter();
                google.maps.event.trigger(map, "resize");
                map.setCenter(center);
            });

            // iterate through each event and it to the marker
            for (var i = 0; i < loc.length; i++) {
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(loc[i].latitude, loc[i].longitude),//locations[i].latlng, 
                    map: map,
                    title: loc[i].eventName
                });

                var infowindow = new google.maps.InfoWindow();
                distanceF = (google.maps.geometry.spherical.computeDistanceBetween(initialLocation, new google.maps.LatLng(loc[i].latitude, loc[i].longitude))) / 1609.34;
                var distance = distanceF.toFixed(1);
                var start = new Date(loc[i].startDate);
                var end = new Date(loc[i].endDate);
                var startDate = start.getDate();
                var endDate = end.getDate();
                var startMonth = start.getMonth();
                var endMonth = end.getMonth();
                var startYear = start.getFullYear();
                var endYear = end.getFullYear();
                var startTime = start.getTime();
                var start_date_time = startMonth + "/" + startDate + "/" + startYear + " " + start.toTimeString();
                var end_date_time = endMonth + "/" + endDate + "/" + endYear + " " + end.toTimeString();
                var content = "Name: " + loc[i].eventName
                    + "<br/>" + "Event Location: " + loc[i].eventLocation
                    + "<br/>" + "Latitude: " + loc[i].latitude + "<br/>" + "Longitude: " + loc[i].longitude + "<br/>" +
                    "Distance: " + distance + " miles" + "<br/>" + "Start Time: " + start_date_time + "<br/>"
                    + "End Time: " + end_date_time;

                google.maps.event.addListener(marker, 'click', (function (marker, content, infowindow) {
                    return function () {
                        infowindow.setContent(content);
                        infowindow.open(map, marker);
                    };
                })(marker, content, infowindow));
            } // end of for loop
        });
        });// end of navigator
    } 
}
window.onload = init;
