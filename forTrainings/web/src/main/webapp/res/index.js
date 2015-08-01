var moduleApp = angular.module('app', ['ngRoute', 'ui.bootstrap', 'calendarModule', 'loginModule',
    'navigationModule', 'createModule', 'trainingPageModule', 'creationResponseModule',
    'ui.bootstrap.datetimepicker', 'trainingPageTrainerModule', 'adminNewsModule', 'trainingEditModule',
    'ngLoadingSpinner', 'trainingPageAdminModule', 'reportsModule','printPageModule']);

moduleApp.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode(true);
}]);