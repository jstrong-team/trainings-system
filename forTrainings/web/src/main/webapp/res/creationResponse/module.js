var creationResponseModule =  angular.module('creationResponseModule', []);

creationResponseModule.config(function($routeProvider) {
    $routeProvider.when('/ui/creation_response', {
        templateUrl: 'res/creationResponse/success.html'
    });
});

creationResponseModule.config(function($routeProvider) {
    $routeProvider.when('/ui/creation_response_external', {
        templateUrl: 'res/creationResponse/successExternal.html'
    });
});