angular.module('createModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/create', {
        templateUrl: 'res/create/create.html',
        controller: 'createController'
    });
});