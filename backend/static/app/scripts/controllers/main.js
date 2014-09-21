'use strict';

/**
 * @ngdoc function
 * @name webApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webApp
 */
var app =angular.module('beer', ['ngRoute']); //'list'

app.factory('mapData', function(){
	return {rad:1, wasted:true, classy:false};
});



app.controller('MainCtrl', function($scope, $route, $routeParams, $location, mapData) {
  	$scope.map = mapData;
     $scope.$route = $route;
     $scope.$location = $location;
     $scope.$routeParams = $routeParams; 

});




  app.controller('MapCtrl', function($scope, $http, mapData){
  	$scope.map = mapData;
  	var coords = {"lat":45.50000, "longit":'-73.5667'};
  	function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.watchPosition(showPosition);
    } else {
        console.log( "Geolocation is not supported by this browser.");
    }
}
function showPosition(position) {
	if(position.coords.latitude)
    coords.lat=position.coords.latitude;
	if(position.coords.longitude)
    coords.longit = position.coords.longitude;
}
	getLocation()

    var init = function(){




function initialize() {
    
    var mapOptions = {
          zoom: 8,
          center: new google.maps.LatLng(coords.lat, coords.longit),
          mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById('map_canvas'),
            mapOptions);
  }


    

window.google = window.google || {};
google.maps = google.maps || {};
(function() {
  
 function getScript(src) {
        // replace document.write by these lines would solve the problem,
        // Failed to execute 'write' on 'Document': It isn't possible to write into a document from an        asynchronously-loaded external script unless it is explicitly opened.
        var element = document.createElement("script");
        element.src = src;
        document.body.appendChild(element);

       // document.write('<' + 'script src="' + src + '"' +
       //             ' type="text/javascript"><' + '/script>');
  }
  
  var modules = google.maps.modules = {};
  google.maps.__gjsload__ = function(name, text) {
    modules[name] = text;
  };
  
  google.maps.Load = function(apiLoad) {
    delete google.maps.Load;
    apiLoad([0.009999999776482582,[[["https://mts0.googleapis.com/vt?lyrs=m@274000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.googleapis.com/vt?lyrs=m@274000000\u0026src=api\u0026hl=en-US\u0026"],null,null,null,null,"m@274000000",["https://mts0.google.com/vt?lyrs=m@274000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.google.com/vt?lyrs=m@274000000\u0026src=api\u0026hl=en-US\u0026"]],[["https://khms0.googleapis.com/kh?v=158\u0026hl=en-US\u0026","https://khms1.googleapis.com/kh?v=158\u0026hl=en-US\u0026"],null,null,null,1,"158",["https://khms0.google.com/kh?v=158\u0026hl=en-US\u0026","https://khms1.google.com/kh?v=158\u0026hl=en-US\u0026"]],[["https://mts0.googleapis.com/vt?lyrs=h@274000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.googleapis.com/vt?lyrs=h@274000000\u0026src=api\u0026hl=en-US\u0026"],null,null,null,null,"h@274000000",["https://mts0.google.com/vt?lyrs=h@274000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.google.com/vt?lyrs=h@274000000\u0026src=api\u0026hl=en-US\u0026"]],[["https://mts0.googleapis.com/vt?lyrs=t@132,r@274000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.googleapis.com/vt?lyrs=t@132,r@274000000\u0026src=api\u0026hl=en-US\u0026"],null,null,null,null,"t@132,r@274000000",["https://mts0.google.com/vt?lyrs=t@132,r@274000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.google.com/vt?lyrs=t@132,r@274000000\u0026src=api\u0026hl=en-US\u0026"]],null,null,[["https://cbks0.googleapis.com/cbk?","https://cbks1.googleapis.com/cbk?"]],[["https://khms0.googleapis.com/kh?v=84\u0026hl=en-US\u0026","https://khms1.googleapis.com/kh?v=84\u0026hl=en-US\u0026"],null,null,null,null,"84",["https://khms0.google.com/kh?v=84\u0026hl=en-US\u0026","https://khms1.google.com/kh?v=84\u0026hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt?hl=en-US\u0026","https://mts1.googleapis.com/mapslt?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt/ft?hl=en-US\u0026","https://mts1.googleapis.com/mapslt/ft?hl=en-US\u0026"]],[["https://mts0.googleapis.com/vt?hl=en-US\u0026","https://mts1.googleapis.com/vt?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt/loom?hl=en-US\u0026","https://mts1.googleapis.com/mapslt/loom?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt?hl=en-US\u0026","https://mts1.googleapis.com/mapslt?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt/ft?hl=en-US\u0026","https://mts1.googleapis.com/mapslt/ft?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt/loom?hl=en-US\u0026","https://mts1.googleapis.com/mapslt/loom?hl=en-US\u0026"]]],["en-US","US",null,0,null,null,"https://maps.gstatic.com/mapfiles/","https://csi.gstatic.com","https://maps.googleapis.com","https://maps.googleapis.com",null,"https://maps.google.com"],["https://maps.gstatic.com/maps-api-v3/api/js/18/4","3.18.4"],[1146657126],1,null,null,null,null,null,"",null,null,1,"https://khms.googleapis.com/mz?v=158\u0026",null,"https://earthbuilder.googleapis.com","https://earthbuilder.googleapis.com",null,"https://mts.googleapis.com/vt/icon",[["https://mts0.googleapis.com/vt","https://mts1.googleapis.com/vt"],["https://mts0.googleapis.com/vt","https://mts1.googleapis.com/vt"],[null,[[0,"m",274000000]],[null,"en-US","US",null,18,null,null,null,null,null,null,[[47],[37,[["smartmaps"]]]]],0],[null,[[0,"m",274000000]],[null,"en-US","US",null,18,null,null,null,null,null,null,[[47],[37,[["smartmaps"]]]]],3],[null,[[0,"m",274000000]],[null,"en-US","US",null,18,null,null,null,null,null,null,[[50],[37,[["smartmaps"]]]]],0],[null,[[0,"m",274000000]],[null,"en-US","US",null,18,null,null,null,null,null,null,[[50],[37,[["smartmaps"]]]]],3],[null,[[4,"t",132],[0,"r",132000000]],[null,"en-US","US",null,18,null,null,null,null,null,null,[[63],[37,[["smartmaps"]]]]],0],[null,[[4,"t",132],[0,"r",132000000]],[null,"en-US","US",null,18,null,null,null,null,null,null,[[63],[37,[["smartmaps"]]]]],3],[null,null,[null,"en-US","US",null,18],0],[null,null,[null,"en-US","US",null,18],3],[null,null,[null,"en-US","US",null,18],6],[null,null,[null,"en-US","US",null,18],0],["https://mts0.google.com/vt","https://mts1.google.com/vt"],"/maps/vt",274000000,132],2,500,["https://geo0.ggpht.com/cbk","https://www.gstatic.com/landmark/tour","https://www.gstatic.com/landmark/config","/maps/preview/reveal?authuser=0","/maps/preview/log204","/gen204?tbm=map","https://static.panoramio.com.storage.googleapis.com/photos/"],["https://www.google.com/maps/api/js/master?pb=!1m2!1u18!2s4!2sen-US!3sUS!4s18/4","https://www.google.com/maps/api/js/widget?pb=!1m2!1u18!2s4"],1,0], loadScriptTime);
  initialize()

  };
  var loadScriptTime = (new Date).getTime();
  getScript("https://maps.gstatic.com/maps-api-v3/api/js/18/4/main.js");
})();


$http({method: 'GET', url: '/deps?lat='+coords.lat+'&long='+coords.longit+'&rad='+mapData.rad}).
	success(function(data, status, headers, config) {
		console.log(data);
    // this callback will be called asynchronously
    // when the response is available
  });
}  
init();
  });

  app.config( function($routeProvider, $locationProvider) {
  $routeProvider
   .when('/map', {
    templateUrl: 'views/map.html',
    controller: 'MapCtrl'

  })
  .when('/list', {
    templateUrl: 'views/list.html',
    // controller: 'ListController'
  })
  .when('/' , {
  	templateUrl: 'views/main.html',
  	controller: 'MainCtrl'
  })
});


















//   jQuery(function($) {
//     // Asynchronously Load the map API 
//     var script = document.createElement('script');
//     script.src = "http://maps.googleapis.com/maps/api/js?sensor=false&callback=initialize";
//     document.body.appendChild(script);
// });

// function initialize() {
//     var map;
//     var bounds = new google.maps.LatLngBounds();
//     var mapOptions = {
//         mapTypeId: 'roadmap'
//     };
                    
//     // Display a map on the page
//     map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
//     map.setTilt(45);
        
//     // Multiple Markers
//     var markers = [
//         ['London Eye, London', 51.503454,-0.119562],
//         ['Palace of Westminster, London', 51.499633,-0.124755]
//     ];
                        
//     // Info Window Content
//     var infoWindowContent = [
//         ['<div class="info_content">' +
//         '<h3>London Eye</h3>' +
//         '<p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p>' +        '</div>'],
//         ['<div class="info_content">' +
//         '<h3>Palace of Westminster</h3>' +
//         '<p>The Palace of Westminster is the meeting place of the House of Commons and the House of Lords, the two houses of the Parliament of the United Kingdom. Commonly known as the Houses of Parliament after its tenants.</p>' +
//         '</div>']
//     ];
        
//     // Display multiple markers on a map
//     var infoWindow = new google.maps.InfoWindow(), marker, i;
    
//     // Loop through our array of markers & place each one on the map  
//     for( i = 0; i < markers.length; i++ ) {
//         var position = new google.maps.LatLng(markers[i][1], markers[i][2]);
//         bounds.extend(position);
//         marker = new google.maps.Marker({
//             position: position,
//             map: map,
//             title: markers[i][0]
//         });
        
//         // Allow each marker to have an info window    
//         google.maps.event.addListener(marker, 'click', (function(marker, i) {
//             return function() {
//                 infoWindow.setContent(infoWindowContent[i][0]);
//                 infoWindow.open(map, marker);
//             }
//         })(marker, i));

//         // Automatically center the map fitting all markers on the screen
//         map.fitBounds(bounds);
//     }

//     // Override our map zoom level once our fitBounds function runs (Make sure it only runs once)
//     var boundsListener = google.maps.event.addListener((map), 'bounds_changed', function(event) {
//         this.setZoom(14);
//         google.maps.event.removeListener(boundsListener);
//     });
// }





