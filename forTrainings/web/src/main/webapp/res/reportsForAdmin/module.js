angular.module('reportsModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/admin/reports', {
        templateUrl: 'res/reportsForAdmin/reports.html',
        controller: 'reportsController'
    });
});