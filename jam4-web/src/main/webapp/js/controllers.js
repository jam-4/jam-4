'use strict';

var lloydsHomeControllers = angular.module('lloydsHomeControllers', []);

lloydsHomeControllers.controller('PropertyListingsController', [
        '$scope',
        '$http',
        function ($scope, $http) {
            $http.get('api/property/area/Surrey+KT16').success(function (data) {
                $scope.properties = data;
            });
        }]
);

lloydsHomeControllers.controller('PropertyDetailsController', [
        '$scope',
        '$routeParams',
        '$http',
        function ($scope, $routeParams, $http) {
            $http.get('api/property/' + $routeParams.listing_id).success(function (data) {
                $scope.property_details = data.listing[0];
            });
        }]
);
