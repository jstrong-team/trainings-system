angular.module('app').controller('navigationController',['$scope','$location','doSearchService','doLogoutService',  function($scope, $location, doSearchService,doLogoutService) {

    $scope.searchExpression='';

    $scope.searchResponse=null;

    $scope.navigation ={url: '/res/navigation/navigation.html'};

    $scope.doSearch=function(){
        doSearchService($scope.searchExpression).then(function (data, status, headers, config) {
            $scope.searchResponse=data.data;
            //console.log(data.data);
        }, function (error) {
            console.log(error);
        });
    };

    $scope.createLog=function(){
        console.log($scope.searchExpression);
        console.log($scope.searchResponse);
    };

    $scope.logout=function(){
        localStorage.clear();
        doLogoutService().then(function (data) {
            console.log(data);
            $location.url('/ui');
        }, function (error) {
            console.log(error);
        });
    };
    $scope.goToTrainings=function(){
        $location.url('/ui/trainings');
    };


}]);