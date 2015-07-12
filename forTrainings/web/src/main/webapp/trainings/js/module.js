angular.module('trainingsModule',[]).config(function($routeProvider) {
    $routeProvider
        .when('/trainings', {
            templateUrl: 'trainings/employee.html',
            controller: 'trainingsController'
        })
});