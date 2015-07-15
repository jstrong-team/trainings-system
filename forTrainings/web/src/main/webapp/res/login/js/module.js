angular.module('loginModule',[]).config(function($routeProvider) {
    $routeProvider
        .when('/ui/', {
            templateUrl : 'res/login/login.html',
            controller: 'logintController'
        })
});