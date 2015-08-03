var adminNewsModule = angular.module('adminNewsModule', ['ui.bootstrap']);

adminNewsModule.config(function ($routeProvider) {
    $routeProvider.when('/ui/news', {
        templateUrl: 'res/news/adminNews/adminNews.html',
        controller: 'newsController'
    });
});