angular.module('trainingEditModule').controller('editController', ['$scope', '$routeParams', 'getTrainingInfo','editService', function ($scope, $routeParams, getTrainingInfo,editService) {

    getTrainingInfo().then(function (data, status, headers, config) {
        $scope.editInfo = data.data;
    }, function (error) {
        console.error(error);
    });

    $scope.addDate = function (index) {
        $scope.editInfo.dates.splice(index,0,'');
    };

    $scope.removeDate = function (index) {
        $scope.editInfo.dates.splice(index,1);
        //console.log(index);
    };

    $scope.showInput='Show';

    $scope.isCollapsed = true;

    $scope.changeCollapse=function(collapsed){
        $scope.isCollapsed = !$scope.isCollapsed;
        if(collapsed){
            $scope.showInput='Hide';
        }else{
            $scope.showInput='Show';
        }
    };

    $scope.datesChange = function (index, value) {
        $scope.editInfo.dates[index] = value;
    };

    $scope.applyCahnges = function () {
        editService($routeParams.trainingId ,$scope.editInfo);
    };

}]);
