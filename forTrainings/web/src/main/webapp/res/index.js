var moduleApp = angular.module('app', ['ui.bootstrap','ngRoute', 'calendarModule', 'loginModule','trainingPageModule']);

moduleApp.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);