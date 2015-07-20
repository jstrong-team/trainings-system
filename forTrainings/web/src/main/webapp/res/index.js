var moduleApp = angular.module('app', ['ngRoute', 'calendarModule', 'loginModule', 'navigationModule', 'ui.bootstrap.datetimepicker']);

moduleApp.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);