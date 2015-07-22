angular.module('newsModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/news', {
        templateUrl: 'res/news/news.html',
        controller: 'newsController'
    });
});