angular.module('approvePageModule').controller('editApproveController', ['$scope', '$routeParams', 'getApproveData', function ($scope, $routeParams, getApproveData) {

    getApproveData().then(function (data, status, headers, config) {
        $scope.editInfo = data.data;
    }, function (error) {
        console.error(error);
    });

    $scope.addDate = function (index) {
        $scope.editInfo.meets.splice(index,0,{date:'',id:null});
    };

    $scope.removeDate = function (index) {
        $scope.editInfo.meets.splice(index,1);
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



}]);
