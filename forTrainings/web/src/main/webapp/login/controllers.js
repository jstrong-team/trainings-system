angular.module('loginModule').controller('logintController',['$scope','loginService','$location',function($scope,loginService,$location){
    $scope.credationals={login:null, password:null}
    $scope.error;
    $scope.submit= function(){
        //console.log($scope.credationals);
        loginService.serv($scope.credationals).then(function(response){
            console.log(response);
            $location.url('/trainings');
        }, function(error){
            console.error(error);
            $scope.error="Wrong login or password";
            $scope.credationals={login:null, password:null};
        });
    }

}]);