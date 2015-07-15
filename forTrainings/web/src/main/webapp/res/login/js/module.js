angular.module('loginModule',[]).config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'res/login/login.html',
            controller: 'logintController'
        })
});