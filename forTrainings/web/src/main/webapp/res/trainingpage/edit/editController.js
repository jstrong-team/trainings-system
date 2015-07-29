angular.module('trainingEditModule').controller('editController', ['$scope', '$http', 'getTrainingInfo', function ($scope, $http, getTrainingInfo) {
    getTrainingInfo().then(function (data, status, headers, config) {
        $scope.editInfo = data.data;
    }, function (error) {
        console.error(error);
    });

    $scope.isCollapsed = true;

    $scope.addDate = function (index) {
        $scope.editInfo.dates.splice(index,0,'');
    };

    $scope.removeDate = function (index) {
        $scope.editInfo.dates.splice(index,1);
        console.log(index);
    };

    $scope.datesChange = function (index, value) {
        $scope.editInfo.dates[index] = value;
    };

    $scope.applyCahnges = function () {
        console.log($scope.editInfo);
    };




}]);
