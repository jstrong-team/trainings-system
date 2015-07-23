angular.module('navigationModule').controller('navigationController',['$rootScope','$scope','$location','doSearchService','doLogoutService',  function($rootScope, $scope, $location, doSearchService,doLogoutService) {

    $scope.searchExpression = '';

    $rootScope.rootExpr='';

    $scope.location=$location;

    $scope.searchResponse = null;

    $scope.navigation = {url: '/res/navigation/navigation.html'};

    $scope.doSearch = function() {
        $rootScope.rootExpr=$scope.searchExpression;
        console.log($scope.searchExpression);
        doSearchService($scope.searchExpression).then(function (data, status, headers, config) {
            $scope.searchResponse=data.data;
            console.log($scope.searchExpression);
            //console.log(data.data);
        }, function (error) {
            console.log(error);
        });
    };

    $scope.logout = function() {
        localStorage.clear();
        doLogoutService().then(function (data) {
            console.log(data);
            $location.url('/ui');
        }, function (error) {
            console.log(error);
        });
    };

    $scope.goToTrainings = function() {
        $location.url('/ui/trainings');
    };

    $scope.createTraining = function() {
        $location.url('/ui/create');
    };

    $scope.goToNews = function() {
        $location.url('/ui/news');
    };

    $scope.createLog=function (){
        console.log($location.path());
    };
}]);