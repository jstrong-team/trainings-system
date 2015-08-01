angular.module('trainingPageModule').controller('absentReasonModalCtrl', ['$scope', '$modalInstance',function($scope, $modalInstance){

    $scope.reason = '';

    $scope.accept=function(){
        $modalInstance.close($scope.reason);
    };

}]);
