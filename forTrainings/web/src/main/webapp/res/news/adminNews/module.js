angular.module('adminNewsModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/news', {
        templateUrl: 'res/news/adminNews/adminNews.html',
        controller: 'newsController'
    });
});