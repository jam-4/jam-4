'use strict';

var lloydsHomeApp = angular.module('lloydsHomeApp', ['ngRoute', 'lloydsHomeControllers']);

lloydsHomeApp.config(['$routeProvider',
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
