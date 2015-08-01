var loginModule = angular.module('loginModule',[]);

loginModule.config(function($routeProvider) {
    $routeProvider.when('/ui/', {
            templateUrl : '/res/login/login.html',
            controller: 'loginController'
        }).when('/ui/404',{
        templateUrl : '/res/errorpages/404.html'
        }).otherwise({
        redirectTo: '/ui/404'
    });
});

loginModule.run(function($rootScope, $location) {
    $rootScope.location = $location;
});