angular.module('creationResponseModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/creation_response', {
        templateUrl: 'res/creationResponse/success.html'
    });
});