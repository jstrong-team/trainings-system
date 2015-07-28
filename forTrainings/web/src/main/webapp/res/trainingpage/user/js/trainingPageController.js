angular.module('trainingPageModule').controller('trainingPageController', ['$scope', 'getTrainingInfo', '$http', '$modal', '$routeParams','getSubscribersService', function ($scope, getTrainingInfo, $http, $modal, $routeParams,getSubscribersService) {

    $scope.isCollapsed = false;

    $scope.feedback = {
        understand: null,
        interested: null,
        continueWithThisTrainer: null,
        smthNew: null,
        recommend: null,
        rate: null,
        other: null
    };

    $scope.openModal = function () {

        var modalInstance = $modal.open({
            animation: true,
            templateUrl: '/res/trainingpage/user/feedbackModal.html',
            controller: 'ModalInstanceCtrl',
            size: 'lg',
            resolve: {
                feedbacks: function () {
                    return {
                        feedback: $scope.feedback,
                        trainingId: $scope.training.id
                    };
                }
            }
        });

        modalInstance.result.then(function (response) {
            console.log(response);
        }, function (error) {
            console.log(error);
        });
    };

    $scope.subscribe = function () {
        $http.post('/rest/storagetraining/addsubscriber?id='+ $scope.training.id, $scope.feedback).then(function (response) {
            console.log(response);
        }, function (error) {
            console.log(error);
        });
    };

    getTrainingInfo().then(function (data, status, headers, config) {
        console.log('0000000000000000000');
        console.log(data.data);
        $scope.training=data.data;
        $scope.training.time=[];
        $scope.training.dateTime=[];
        $scope.training.year=[];
        for(var j=0;j<$scope.training.dates.length;j++) {
            $scope.training.time.push(moment($scope.training.dates[j]).format('HH:mm'));
            $scope.training.dateTime.push(moment($scope.training.dates[j]).format('DD MMMM'));
            $scope.training.year.push(moment($scope.training.dates[j]).format('YYYY'));
        }
        //$scope.subscribers = [];
        getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
            $scope.subscribers=data.data;
        }, function (error) {
            console.log(error);
        });
        //getSubscribers
    });
}]);
