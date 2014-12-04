'use strict';

var lloydsHomeApp = angular.module('lloydsHomeApp', ['ngRoute', 'lloydsHomeControllers', 'uiGmapgoogle-maps']);

lloydsHomeApp.config(['$routeProvider', '$provide',
    function ($routeProvider) {
        $routeProvider.
            when('/properties', {
                templateUrl: 'property-listings.html',
                controller: 'PropertyListingsController'
            }).
            when('/property/:listing_id', {
                templateUrl: 'property-details.html',
                controller: 'PropertyDetailsController'
            }).
            otherwise({
                redirectTo: '/properties'
            });
    }
]);

lloydsHomeApp.config(function(uiGmapGoogleMapApiProvider) {
    uiGmapGoogleMapApiProvider.configure({
        key: 'AIzaSyAiic1aOhd6zx-0gYDZF5MIqmPW0xxiPLs',
        v: '3.17'
    });
});
