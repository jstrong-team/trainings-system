var loginModule = angular.module('loginModule',[]);

loginModule.config(function($routeProvider) {
    $routeProvider.when('/ui/', {
            templateUrl : '/res/login/login.html',
            controller: 'loginController'
        });
});

loginModule.run(function($rootScope, $location) {
    $rootScope.location = $location;
});