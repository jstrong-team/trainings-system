angular.module('approvePageModule').controller('editApproveController', ['$scope', '$routeParams', 'getApproveData', function ($scope, $routeParams, getApproveData) {

    getApproveData().then(function (data, status, headers, config) {
        $scope.editInfo = data.data;
    }, function (error) {
        console.error(error);
    });



    $scope.showInput='Show';

    $scope.isCollapsed = true;

    $scope.changeCollapse=function(){
        if($scope.isCollapsed){
            $scope.showInput='Hide';
        }else{
            $scope.showInput='Show';
        }
        $scope.isCollapsed = !$scope.isCollapsed;
    };



}]);
