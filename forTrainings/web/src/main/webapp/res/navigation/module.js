angular.module('navigationModule', []).run(function ($rootScope, $location) {
    $rootScope.location = $location;
});