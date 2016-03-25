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

                // adding dummy events as official events
                loc.push({ "eventName": "Dummy event @ framingham", "eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": "239 Holland Street null Somerville MA 02144 US", "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": null, "endDateAndTime": null, "startTime": null, "endTime": 1459389600000, "latitude": 42.3351, "longitude": -71.1704, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": true });
                loc.push({ "eventName": "Dummy event @ framingham", "eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": "MIT", "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": null, "endDateAndTime": null, "startTime": null, "endTime": 1459389600000, "latitude": 42.3601, "longitude": -71.0942, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": true });

                // make map responsive
            google.maps.event.addDomListener(window, "resize", function () {
                var center = map.getCenter();
                google.maps.event.trigger(map, "resize");
                map.setCenter(center);
            });

            // image for the marker
            var image = {
                url: '../images/paw_pin.png',
                //size: new google.maps.Size(30, 35),
            };
        
            // iterate through each event and it to the marker
            for (var i = 0; i < loc.length; i++) {
                var event_type = loc[i].officialEvent;
                if (event_type) {
                    var marker = new google.maps.Marker({
                        position: new google.maps.LatLng(loc[i].latitude, loc[i].longitude),//locations[i].latlng,
                        icon: image,
                        animation: google.maps.Animation.BOUNCE,
                        map: map,
                        title: loc[i].eventName
                    });
                } else {
                    var marker = new google.maps.Marker({
                        position: new google.maps.LatLng(loc[i].latitude, loc[i].longitude),//locations[i].latlng,
                        map: map,
                        title: loc[i].eventName
                    });
                }                

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
                if (event_type) {
                    var content = "Name: " + loc[i].eventName
                    + "<br/>" + "Event Location: " + loc[i].eventLocation
                    + "<br/>" + "Latitude: " + loc[i].latitude + "<br/>" + "Longitude: " + loc[i].longitude + "<br/>" +
                    "Distance: " + distance + " miles" + "<br/>" + "Start Time: " + start_date_time + "<br/>"
                    + "End Time: " + end_date_time + "<br/><br/><img src='../images/paw.jpg' alt='Smiley face' height='25' width='25' title='NEU official event'>";
                }
                else
                    var content = "Name: " + loc[i].eventName
                    + "<br/>" + "Event Location: " + loc[i].eventLocation
                    + "<br/>" + "Latitude: " + loc[i].latitude + "<br/>" + "Longitude: " + loc[i].longitude + "<br/>" +
                    "Distance: " + distance + " miles" + "<br/>" + "Start Time: " + start_date_time + "<br/>"
                    + "End Time: " + end_date_time;

                var currentInfoWindow = null;
                google.maps.event.addListener(marker, 'click', (function (marker, content, infowindow) {
                    return function () {
                        infowindow.setContent(content);
                        if (currentInfoWindow != null) {
                            currentInfoWindow.close();
                        }
                        infowindow.open(map, marker);
                        currentInfoWindow = infowindow;
                    };
                })(marker, content, infowindow));
            } // end of for loop
           });// end of api call
        });// end of navigator
    } 
}
window.onload = init;
