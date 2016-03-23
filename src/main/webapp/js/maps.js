var distanceF;
var initialLocation;

function init() {
    //set options for map
    var mapDiv = document.getElementById("myMap");
    var options = {
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        zoom: 11
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
            //http://" + arr[2] + "/WHAM/datasource/37.3394444/-121.8938889/10
            var api_url = "http://" + arr[2] + "/WHAM/datasource/" + position.coords.latitude + "/" + position.coords.longitude + "/10";
            console.log(api_url);
            
            $.get({ url: api_url }, function (data) {
                var loc = data;
                console.log("success " + data[0]);

            loc = [{ "eventName": "Boston Calling - May 27, 28, 29, 2016", "eventDesc": "Boston Calling Music Festival is a three-day, multi-stage festival featuring some of the biggest and best acts in live music. It is held on Boston City Hall Plaza, May 27, 28, & 29, 2016. The event will be one big party with easy access to all performance areas, incredible beer, wine, food offerings, and more suprises to be announced. All ages are welcome and children under 10 are free. For more information, please consult bostoncalling.com. \n  \nFriday performances by Sia, Sufjan Stevens, and Lisa Hannigan & Aaron Dessner. Weekend performances by Disclosure, Robyn, ODESZA, HAIM, Miike Snow, Janelle Monáe, City and Colour, Courtney Barnett, Elle King, The Front Bottoms, BØRNS, Charles Bradley and His Extraordinaires,The Vaccines, Vince Staples, Battles, Unknown Mortal Orchestra, Christine and The Queens, Lizzo, Palehound, and Michael Christmas. \n  \n  \nFRIDAY \nBox Office Opens: 5pm Gates Open: 6pm Music Ends: 11:00pm \nSATURDAY/SUNDAY \nBox Office Opens: 11am Gates Open: 12pm Music Ends: 11:00pm \n  \nTicketing Policies \n- Once you purchase, you will receive an order confirmation email from Eventbrite on behalf of Boston Calling. \n- IMPORTANT: If you do not see your order confirmation in your inbox, make sure to check your junk/spam folder. If you still do not see your order confirmation, click here to access the Eventbrite help center. \n- Your actual ticket will be available to download in your Eventbrite account on or around April 15, 2016.  You will be notified via the email address used at check-out when they are available.   \n- Tickets are non-refundable and non-transferable.  \n- If you are having any other technical ticketing-related issues with your order, click here to contact Eventbrite. For general festival info, click here. \n  \nFAQs \nWhat happens if it rains? \nBoston Calling is a rain or shine event. \n  \nHow do I get to City Hall Plaza? \nMain Entrance is location on Congress Street and we recommend taking the T to the Haymarket or State Street stations. We strongly encourage you to take public transportation. \n  \nWhen is the performance schedule released? \nThe performance schedule will be released a few weeks prior to the festival. If you want to be notified right away once the schedule is released, be sure to sign up for our mailing list or download our app. Artist lineup subject to change. \n  \nIs the Festival accessible to people with disabilities?  \nThe entire plaza has various ramps accessing the multiple levels. ADA accessible restrooms are also available. ASL interpreters are only available upon request. \n  \nAre there ATMs available if I run low on cash? \nMany ATMs will be located around the festival grounds. \n  \nWhat will be available in the food/beer areas? \nDelicious food from Tasty Burger and many more. Beer and wine will be available to those who are 21+. Please make sure to bring proper ID and grab a wrist band from the ID Check tent by the main entrance. \n  \nWhat about vegetarian items? \nMany food vendors will feature a vegetarian option. \n  \nWhere can I contact the organizer with any questions? \nPlease email info@bostoncalling.com.   ", "eventLocation": "1 City Hall Square null Boston MA 02203 US", "phoneNumber": null, "emailId": null, "startDate": 1464307200000, "endDate": 1464577200000, "startDateAndTime": null, "endDateAndTime": null, "startTime": null, "endTime": 1464577200000, "latitude": 42.360331, "longitude": -71.057996, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1442871105000, "lastUpdateTime": 1458756243000, "officialEvent": false }, { "eventName": "Stony Creek Debut Party! Barrel-Aged Cinnamon Chocolate Porter; Black Wheat Wine & More", "eventDesc": "Join us at Sunset Tap and Grill on Thursday 3/24 to celebrate the debut of Stony Creek Brewery in Massachusetts! With 8 great beers on taps that have never been sold in MA before you won'y want to miss this party!  \n\nSip on the Chahklit Baltic Porter - a tribute to Jamaican Chahklit tea - this beer is brewed with almonds, earthy Ceylon Cinnamon and cacao nibs and then aged in Caribbean rum barrels. \n\n\nThe Reposado Negro is a Black Wheat Wine that has been aged in Tequila barrels. Roasted malt \"charred\" flavors mix beautifully with a sweetness from the tequila barrels. At 9.5% this one is boozy! \n\n\nSun Juice is a tasty Belgian Summer Ale that's brewed with wheat and Saison yeast. It's also got a bit of orange peel, grapefruit peel, coriander and chamomile, reminding you that summer is coming!\n\n\nThe Stony Joe is a unique blend of styles. A golden mocha stout, it is Brewed like a milk stout but instead of dark malts they use English barley giving it a golden color. Throw in some cocoa nibs and roasted coffee and you have yourself a fantastic brew! \n\nWith so many awesome beers to try you're gonna want to get their early (and maybe get a flight or two). So RSVP and we'll see you there!  \n \nSun Juice \nSaison - 5.3%\nSun Juice is a refreshing Belgian Summer Ale brewed with wheat. Saison yeast produces a silky body while orange peel, grapefruit peel, corriander , and chamomile impart a spicy and fruity complexity. It's summertime, grab youirself some Sun Juice. \nChahklit Baltic Porter \nBaltic Porter - 8.5%\nGrandma Clara makes Chahklit Tea for her family. She uses hand ground cacao pods, cinnamon leaf, almond, milk, and maybe the occasionaL splash of rum...for your health. This is our tribute to her Jamaican tradition. Chahklit is a Baltic Porter brewed with almonds and earthy Ceylon Cinnamon. Cacao Nibs impart rich chocolate depth. IT ages in Caribbean Rum Barrels to lend oak complexity and subtle Rum nuance. Sip it slowly and be transported back to Grandma Clara's kitchen. \nReposado Negro \nAmerican Barleywine - 9.2%\nReposado Tequila is known for its oak aged, smooth complexity. This is our interpretation of the fine Mexican spirit. Reposado Negro is A Black Wheat Wine aged in Tequila Barrels. A marriage of sweet alcohol warmth, smooth bready texture, and roasted malt \"charred\" flavors, this jet black brew will have you swearing you are sipping a top shelf tequila. \nBig Cranky Double IPA \nImperial IPA - 9.5%\nA Bold West Coast Double IPA, this is the crankiest of our IPAs. 7 different hops contribute complex and juicy hop character. Its dry finish allows the hops to stand out. At 9.5% ABV and 95 IBUs, while remarkably cranky, this beer is extraordinarily drinkable. \nPetite Cranky \nIndia Pale Ale (IPA)\nThis is an anniversary beer by stony creek. A session IPA with Saison yeast! \nStony Joe \nStout - 5.5%\nStony Joe is a Golden Mocha Stout. It is designed like a traditional Milk Stout but without using the typical roasted dark malts. Instead we use a boat load of rich, decadent golden colored English barley, flaked barley, flaked oats, and flaked wheat to give it lush body and smooth sweetness. We then ferment it on Cocoa Nibs and add fresh locally roasted Guatemalan Coffee, directly to the fermenter. The cocoa nibs and coffee add the rich mocha notes and bright roasty/coffee aroma! \nSnow Hole Imperial Red \nImperial IPA - 8.5% 85 IBUs\nA Snowhole is someone who loves a brutal winter. Our Double Red, with its malty notes of caramel and dark sugar, is complemented perfectly by intense citrus and spicy hops. 6 different hops, 8 hop additions, over 3.5 pounds of hops per barrel, 8.5% ABV and 85 IBUs make for a winter brew that can stand up to any storm. \nBlack Water Pils \nPilsner\nThis is a brand new Black Pilsner from Stoney Creek!  ", "eventLocation": "130 Brighton Avenue null Allston MA 02134 US", "phoneNumber": null, "emailId": null, "startDate": 1458777600000, "endDate": 1458871200000, "startDateAndTime": null, "endDateAndTime": null, "startTime": null, "endTime": 1458871200000, "latitude": 42.352712, "longitude": -71.13158399999998, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1457397027000, "lastUpdateTime": 1458666653000, "officialEvent": false }, { "eventName": "Game of Thrones Beer Release! Seven Kingdoms Hoppy Wheat & More!", "eventDesc": "A new game of thrones beer release by ommegang. Prizes and great beer - more details to come!  \nBeer List:  \nSeven Kingdoms - GoT Hoppy Wheat Beer\nRosetta Kriek\nGlimmerglass Spring Saison\nShadow Brewer Imperial Stout\nHoublon Chouffe Belgian-Style Scotch Ale", "eventLocation": "239 Holland Street null Somerville MA 02144 US", "phoneNumber": null, "emailId": null, "startDate": 1459296000000, "endDate": 1459389600000, "startDateAndTime": null, "endDateAndTime": null, "startTime": null, "endTime": 1459389600000, "latitude": 42.402786, "longitude": -71.12675999999999, "filePath": null, "organiserName": null, "organiserDesc": null, "creationTime": 1458585314000, "lastUpdateTime": 1458585503000, "officialEvent": false }];

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
