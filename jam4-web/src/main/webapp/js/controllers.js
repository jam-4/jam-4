var lloydsHomeControllers = angular.module('lloydsHomeControllers', []);

lloydsHomeControllers.controller('PropertyListingsController', [
        '$scope',
        '$http',
        function ($scope, $http) {
            $http.get('http://localhost:8082/jam4-web/api/property/area/Tower%20Hill').success(function(data) {
                $scope.properties = data;
            });
        }]
);

lloydsHomeControllers.controller('PropertyDetailsController', [
        '$scope',
        '$routeParams',
        '$http',
        function ($scope, $routeParams, $http) {
            $http.get('http://localhost:8082/jam4-web/api/property/' + $routeParams.listing_id).success(function(data) {
                $scope.property_details = data.listing[0];
            });
        }]
);
