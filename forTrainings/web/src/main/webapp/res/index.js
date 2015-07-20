var moduleApp = angular.module('app', ['ngRoute','ui.bootstrap', 'calendarModule', 'loginModule', 'navigationModule','trainingPageModule', 'ui.bootstrap.datetimepicker']);

moduleApp.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);