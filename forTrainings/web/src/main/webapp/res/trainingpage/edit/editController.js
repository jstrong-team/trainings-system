angular.module('trainingEditModule').controller('editController', ['$scope', '$http', 'getTrainingInfo', function ($scope, $http, getTrainingInfo) {
    getTrainingInfo().then(function(data, status, headers, config){
        console.log('succes');
        console.log(data);
        $scope.editInfo=data.data;
    },function(error){
        console.error(error);
    });
}]);
