angular.module('trainingsModule').controller('trainingsController',['$scope','$location',function($scope,$location){
    $scope.logout=function(){
        $location.url('/');
    }
    $scope.goToTrainings=function(){
        $location.url('/trainings');
    }
}]);