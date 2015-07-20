angular.module('trainingPageModule').controller('trainingPageController',['$scope','getTrainingInfo', function($scope,getTrainingInfo) {

    $scope.temp1='directive context';
    getTrainingInfo().then(function(data, status, headers, config) {
        //console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa33");
        //console.log(data.data[0]);
        $scope.training=data.data[0];
    });

}]);