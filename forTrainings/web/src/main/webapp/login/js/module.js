angular.module('loginModule',[]).config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'login/login.html',
            controller: 'logintController'
        })
});