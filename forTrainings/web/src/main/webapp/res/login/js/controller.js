angular.module('loginModule').controller('loginController', ['$scope', 'loginService', '$location', function ($scope, loginService, $location) {
    $scope.credationals = {login: null, password: null, rememberMe: true};
    $scope.submit = function () {
        loginService.serv($scope.credationals).then(function (response) {
            console.log(response);
            localStorage.setItem('id', response.data.id);
            localStorage.setItem('name', response.data.name);
            $location.url('/ui/trainings');
        }, function (error) {
            console.error(error);
            $scope.error = 'LOGIN_PASSWORD_WRONG';
            $scope.credationals = {login: null, password: null};
        });
    };

}]);