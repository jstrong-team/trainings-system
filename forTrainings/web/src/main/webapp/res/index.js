var moduleApp = angular.module('app', ['ngRoute','ui.bootstrap', 'calendarModule', 'loginModule',
    'navigationModule', 'createModule', 'trainingPageModule', 'creationResponseModule', 'ui.bootstrap.datetimepicker']);

moduleApp.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);

//moduleApp.controller('appController',['$scope','$rootscope',function($scope,$rootscope){
//    $rootscope.showNavbarHat=true;
//    $scope.showNavbarHat=false;
//}]);
