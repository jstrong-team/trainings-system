angular.module('trainingsModule').controller('trainingsController',['$scope','$location',function($scope,$location){
    $scope.logout=function(){
        $location.url('/');
    }
}]);