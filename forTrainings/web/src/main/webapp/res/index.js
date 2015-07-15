var myMod = angular.module('app',['ngRoute','trainingsModule','loginModule']);

myMod.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);