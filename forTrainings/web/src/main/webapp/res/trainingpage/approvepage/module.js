angular.module('approvePageModule',[]).config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/ui/trainingPage/approve/:trainingID', {
        templateUrl: 'res/trainingpage/approvepage/editApprove.html',
        controller: 'editApproveController'
    });
}]);