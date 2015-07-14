angular.module('trainingsModule').controller('trainingsController',['$scope','$location','getTrainingsService',function($scope,$location,getTrainingsService){
    $scope.logout=function(){
        //$location.url('/');
        getTrainingsService().then(function(response){
            console.log(response.data);
        }, function(error){
            console.error(error);
        });
        //trainings();
    }
    $scope.goToTrainings=function(){
        $location.url('/trainings');
    }
}]);