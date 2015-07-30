angular.module('app').controller('indexController', ['$scope', '$location', function ($scope, $location) {
    $scope.location = $location;
    $scope.navigation = {url: '/res/navigation/navigation.html'};

}]);