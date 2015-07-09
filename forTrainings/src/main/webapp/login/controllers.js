angular.module('loginModule').controller('loginController', ['$scope', 'loginService',
    function($scope, loginservice) {
    $scope.credetionals = {login: '', password: ''};


    $scope.login = function() {
        console.log($scope.credetionals);
        loginservice.a($scope.credetionals).then(function(response){
            console.log(response);

        }, function(error){
            console.error(error);
            console.error('smth');
        });


    }
}]);