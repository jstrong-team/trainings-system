angular.module('trainingEditModule', []).config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/ui/trainingPage/edit/:trainingId', {
        templateUrl: 'res/trainingpage/edit/edit.html',
        controller: 'editController'
    });
}]);