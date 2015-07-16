var moduleApp = angular.module('app', ['ngRoute', 'calendarModule', 'loginModule']);

moduleApp.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);