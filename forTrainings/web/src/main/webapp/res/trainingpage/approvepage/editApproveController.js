angular.module('approvePageModule').controller('editApproveController', ['$scope', '$routeParams', 'getApproveData','parseService', function ($scope, $routeParams, getApproveData,parseService) {

    getApproveData().then(function (data, status, headers, config) {
        $scope.editInfo = data.data;
        $scope.editInfo.oldTime=[];
        $scope.editInfo.oldDateTime=[];
        $scope.editInfo.newTime=[];
        $scope.editInfo.newDateTime=[];
        $scope.editInfo.name=parseService.parse($scope.editInfo.name);
        $scope.editInfo.annotation=parseService.parse($scope.editInfo.annotation);
        $scope.editInfo.description=parseService.parse($scope.editInfo.description);
        $scope.editInfo.target=parseService.parse($scope.editInfo.target);
        $scope.editInfo.place=parseService.parse($scope.editInfo.place);
        console.log($scope.editInfo.annotation);
        for(var j=0;j<$scope.editInfo.oldDates.length;j++) {
            $scope.editInfo.oldTime.push(moment($scope.editInfo.oldDates[j]).format('HH:mm'));
            $scope.editInfo.oldDateTime.push(moment($scope.editInfo.oldDates[j]).format('DD MMMM'));
        }
        for(var j=0;j<$scope.editInfo.newDates.length;j++) {
            $scope.editInfo.newTime.push(moment($scope.editInfo.newDates[j]).format('HH:mm'));
            $scope.editInfo.newDateTime.push(moment($scope.editInfo.newDates[j]).format('DD MMMM'));
        }
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
