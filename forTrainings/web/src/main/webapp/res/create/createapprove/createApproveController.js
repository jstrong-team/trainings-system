angular.module('createApproveModule').controller('createApproveController', ['$scope', '$routeParams', 'getApproveData', 'parseService', 'approveService', '$location',
    function ($scope, $routeParams, getApproveData, parseService, approveService, $location) {

        getApproveData().then(function (data, status, headers, config) {
            $scope.editInfo=data.data;
            $scope.editInfo.time = [];
            $scope.editInfo.dateTime = [];
            $scope.editInfo.year = [];
            for (var j = 0; j < $scope.editInfo.meets.length; j++) {
                $scope.editInfo.time.push(moment($scope.editInfo.meets[j].date).format('HH:mm'));
                $scope.editInfo.dateTime.push(moment($scope.editInfo.meets[j].date).format('DD MMMM'));
                $scope.editInfo.year.push(moment($scope.editInfo.meets[j].date).format('YYYY'));
            }
        }, function (error) {
            console.error(error);
        });

        $scope.approve = function () {
            approveService.approveCreate($routeParams.trainingId);
        };

        $scope.dismiss = function () {
            approveService.dismiss($routeParams.trainingId);
        };

        $scope.showInput = 'TRAINING_PAGE_SHOW';

        $scope.isCollapsed = true;

        $scope.changeCollapse = function () {
            if ($scope.isCollapsed) {
                $scope.showInput = 'TRAINING_PAGE_HIDE';
            } else {
                $scope.showInput = 'TRAINING_PAGE_SHOW';
            }
            $scope.isCollapsed = !$scope.isCollapsed;
        };


    }]);
