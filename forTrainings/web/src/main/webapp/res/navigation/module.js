angular.module('navigationModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/create', {
        templateUrl: 'res/create/create.html',
        controller: 'navigationController'
    });
}).run(function($rootScope, $location) {
    $rootScope.location = $location;
});;