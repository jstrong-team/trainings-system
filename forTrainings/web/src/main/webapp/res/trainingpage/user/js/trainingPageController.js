angular.module('trainingPageModule').controller('trainingPageController', ['$scope', 'getTrainingInfo', '$http', '$modal', '$routeParams', function ($scope, getTrainingInfo, $http, $modal, $routeParams) {

    $scope.training = {
        name: 'JAVA SUPER DUPER TRAINING',
        annotation: '$apply() is used to execute an expression in angular from outside of the angular framework. ' +
        '(For example from browser DOM events, setTimeout, XHR or third party libraries). Because we are calling ' +
        'into the angular framework we need to perform proper scope life cycle of exception handling, executing watches.',
        description: '$apply() is used to execute an expression in angular from ',
        target: 'kids, bamby,white panda,black panda, anton grigoriev',
        paid: true,
        max_participants: 10,
        date: ['2015-06-04 12:00:00'],
        place: '243',
        internal: true,
        id: 2
    };

    $scope.paticipants = [{name: 'fedia', lastname: 'petrov'}];

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
        console.log("----------------------------");
        console.log($routeParams.trainingId);
        //console.log(data);
        //$scope.training=data.data[0];
        //$scope.trainingDate=new Date(data.data[0].date);
    });
}]);
