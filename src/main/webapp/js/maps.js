var distanceF;
var initialLocation;

function init() {
    //set options for map
    var mapDiv = document.getElementById("myMap");
    var options = {
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        zoom: 13
    };

    var map = new google.maps.Map(mapDiv, options);

    // get current location of the user
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pinImage = {
                url: '../images/blue_dot_circle.png'
            };
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
                var loc = data || [];

                // display number of envents
                var div = document.getElementById('total');
                div.innerHTML = div.innerHTML + 'There are total ' + loc.length + ' events happening arround you!!!!!';

                // adding dummy events as official events
                //loc.push({ "eventName": "Dummy event @ MIT3", extLink:"www.abc1.com","eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": null, "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": 1459296000000, "endDateAndTime": null, "startTime": null, "endTime": 1459389600000, "latitude": 42.3601, "longitude": -71.0942, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": true });
                //loc.push({ "eventName": "Dummy event @ some",extLink: null, "eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": "239 Holland Street null Somerville MA 02144 US", "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": 1459296000000, "endDateAndTime": 1459389600000, "startTime": null, "endTime": 1459389600000, "latitude": 42.3351, "longitude": -71.1704, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": true });
                //loc.push({ "eventName": "Dummy event @ MIT",extLink: null, "eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": "MIT", "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": 1459296000000, "endDateAndTime": 1459389600000, "startTime": null, "endTime": 1459389600000, "latitude": 42.3601, "longitude": -71.0942, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": false });
                //loc.push({ "eventName": "Dummy event @ some2",extLink: null, "eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": "239 Holland Street null Somerville MA 02144 US", "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": 1459296000000, "endDateAndTime": 1459389600000, "startTime": null, "endTime": 1459389600000, "latitude": 42.3351, "longitude": -71.1704, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": false });
                //loc.push({ "eventName": "Dummy event @ MIT2", extLink: null,"eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": "MIT", "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": 1459296000000, "endDateAndTime": 1459389600000, "startTime": null, "endTime": 1459389600000, "latitude": 42.3601, "longitude": -71.0942, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": true });
                //loc.push({ "eventName": "Dummy event @ framingham",extLink: null, "eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": "MIT", "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": 1459296000000, "endDateAndTime": 1459389600000, "startTime": null, "endTime": 1459389600000, "latitude": 42.3770, "longitude": -71.1167, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": true });
                //loc.push({ "eventName": "Dummy event @ fram", extLink: "www.abc.com","eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": null, "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": 1459296000000, "endDateAndTime": null, "startTime": null, "endTime": 1459389600000, "latitude": 42.3505, "longitude": -71.1054, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": false });

                // make map responsive
                google.maps.event.addDomListener(window, "resize", function () {
                    var center = map.getCenter();
                    google.maps.event.trigger(map, "resize");
                    map.setCenter(center);
                });

                // image for the marker
                var image = {
                    url: '../images/paw_pin.png'
                };

                // iterate through each event and it to the marker
                for (var i = 0; i < loc.length; i++) {
                    var count = 0;
                    // hold multiple events happening on same location
                    var hold = [];

                    // find multiple events on same location
                    for (var j = 0; j < loc.length; j++) {
                        if (loc[i].latitude === loc[j].latitude && loc[i].longitude === loc[j].longitude) {
                            count++;
                            hold.push(loc[j]);
                        }
                    }
                    var event_type = loc[i].officialEvent;
                    if (count > 1) {
                        var multiimage = new google.maps.MarkerImage("http://maps.google.com/mapfiles/kml/pal4/icon50.png");
                        var marker = new google.maps.Marker({
                            position: new google.maps.LatLng(loc[i].latitude, loc[i].longitude),//locations[i].latlng,
                            icon: multiimage,
                            map: map,
                            title: loc[i].eventName
                        });

                    } else {
                        if (event_type) {
                            var marker = new google.maps.Marker({
                                position: new google.maps.LatLng(loc[i].latitude, loc[i].longitude),//locations[i].latlng,
                                icon: image,
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
                    }

                    var infowindow = new google.maps.InfoWindow();
                    distanceF = (google.maps.geometry.spherical.computeDistanceBetween(initialLocation, new google.maps.LatLng(loc[i].latitude, loc[i].longitude))) / 1609.34;
                    var distance = distanceF.toFixed(1);
                    var start = new Date(loc[i].startDateAndTime);
                    var end = new Date(loc[i].endDateAndTime);
                    function convert(h, ampm) {
                        if (h >= 12) {
                            h = h - 12;
                            ampm = "PM";
                        }
                        return (h + ":00 " + ampm);
                    }
                    var h1 = convert(start.getHours(), "AM");
                    var h2 = convert(end.getHours(), "AM");
                    var startTime = start.getTime();
                    var start_date_time = start.getMonth() + "/" + start.getDate() + "/" + start.getFullYear() + " " + h1;
                    var end_date_time = end.getMonth() + "/" + end.getDate() + "/" + end.getFullYear() + " " + h2;
                    if (count > 1) {
                        var content = "";
                        for (var k = 0; k < hold.length && count > 0; k++) {
                            var start1 = new Date(hold[k].startDateAndTime);
                            var end1 = new Date(hold[k].endDateAndTime);
                            var h11 = convert(start1.getHours(), "AM");
                            var h21 = convert(end1.getHours(), "AM");
                            var start_date_time1 = start1.getMonth() + "/" + start1.getDate() + "/" + start1.getFullYear() + " " + h11;
                            var end_date_time1 = end1.getMonth() + "/" + end1.getDate() + "/" + end1.getFullYear() + " " + h21;
                            if (k % 2 == 0) {
                                content = content + "<div class='sect'>";
                            } else {
                                content = content + "<div class='sect1'>";
                            }
                            content += "<br/>Name: " + hold[k].eventName
                            + "<br/>";
                            if (hold[k].eventLocation != null) {
                                content = content + "Event Location: " + hold[k].eventLocation + "<br/>"
                            }
                            content = content + "Distance: " + distance + " miles" + "<br/>" +
                                "Start Time: " + start_date_time1 + "<br/>";
                            if (hold[k].endDateAndTime != null) {
                                content = content + "End Time: " + end_date_time1 + "<br/>";
                            }
                            if (hold[k].extLink != null) {
                                var anc = "<a href='" + hold[k].extLink + "' target = '_blank'>Click for more details </a>"
                                content = content + anc + "<br/>";
                            }
                            if (hold[k].officialEvent) {
                                content = content + "<img src='../images/paw.jpg' alt='Smiley face' height='25' width='25' title='NEU official event'>";
                            }
                            content = content + "<br/></div>"
                            count--;
                        }
                        content = "<div class=info>" + content + "</div>";
                    }
                    else {
                        var content = "Name: " + loc[i].eventName
                        + "<br/>";
                        if (loc[i].eventLocation != null) {
                            content = content + "Event Location: " + loc[i].eventLocation + "<br/>"
                        }
                        content = content + "Distance: " + distance + " miles" + "<br/>" +
                            "Start Time: " + start_date_time + "<br/>";
                        if (loc[i].endDateAndTime != null) {
                            content = content + "End Time: " + end_date_time + "<br/>";
                        }
                        if (loc[i].extLink != null) {
                            var a = "<a href='" + loc[i].extLink + "' target = '_blank'>Click for more details </a>"
                            content = content + a + "<br/>";
                        }
                        if (event_type)
                            content = content + "<img src='../images/paw.jpg' alt='Smiley face' height='25' width='25' title='NEU official event'>";
                        content = content + "<br/>"
                    }

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
