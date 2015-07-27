var moduleApp = angular.module('app', ['ngRoute','ui.bootstrap', 'calendarModule', 'loginModule',
    'navigationModule', 'createModule', 'trainingPageModule', 'creationResponseModule',
    'ui.bootstrap.datetimepicker','trainingPageTrainerModule', 'newsModule','trainingEditModule']);

moduleApp.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);