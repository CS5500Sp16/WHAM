
var locations = [];
var distance;
var initialLocation;
locations.push({ name: "Northeastern University", latlng: new google.maps.LatLng(42.340075, -71.0895367) });
locations.push({ name: "Brighton", latlng: new google.maps.LatLng(42.3463503, -71.1626756) });
locations.push({ name: "Framingham", latlng: new google.maps.LatLng(42.279286, -71.4161565) });
locations.push({ name: "Waltham", latlng: new google.maps.LatLng(42.3764852, -71.235611300000002) });
function init() {
    var mapDiv = document.getElementById("myMap");

    var options = {
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        zoom: 11
    };

    var map = new google.maps.Map(mapDiv, options);

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pinImage = new google.maps.MarkerImage("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|FFFF00");
            initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            map.setCenter(initialLocation);
            //locations.push({ name: "Current Location", latlng: initialLocation });
            var marker = new google.maps.Marker({
                position: map.getCenter(),
                icon: pinImage,
                title: "You are here",
                map: map
            });
        });
    }
    var bounds = new google.maps.LatLngBounds();
    google.maps.event.addDomListener(window, "resize", function () {
        var center = map.getCenter();
        google.maps.event.trigger(map, "resize");
        map.setCenter(center);
    });

    for (var i = 0; i < locations.length; i++) {
        var marker = new google.maps.Marker({
            position: locations[i].latlng,
            map: map,
            title: locations[i].name
        });

        //bounds.extend(locations[i].latlng);

        var infowindow = new google.maps.InfoWindow();


        //distance = google.maps.geometry.spherical.computeDistanceBetween(, locations[i].latlng);

        var content = "Name: " + locations[i].name + "<br/>" + "Latitude: " + locations[i].latlng.lat() + "<br/>" + "Longitude: " + locations[i].latlng.lng();
        google.maps.event.addListener(marker, 'click', (function (marker, content, infowindow) {
            return function () {
                infowindow.setContent(content);
                infowindow.open(map, marker);
            };
        })(marker, content, infowindow));
    }
    //map.fitBounds(bounds);
}
window.onload = init;
