angular.module('loginModule').controller('logintController',['$scope','loginService',function($scope,loginService){
    $scope.credationals={login:null, password:null};
    $scope.submit= function(){
        console.log($scope.credationals);
        loginService.serv(credationals).then(function(response){
            console.log(response);
        }, function(error){
            console.log(error);
        });
    }

}]);