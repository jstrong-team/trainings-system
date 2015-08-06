(function () {
    var services = [
        '$scope',
        '$location',
        'getTrainingInfo',
        'getSubscribersService',
        'getFeedbacksService',
        'attendanceSendService',
        '$modal',
        'absentOutputService'
    ];
    var controller = function ($scope,
                               $location,
                               getTrainingInfo,
                               getSubscribersService,
                               getFeedbacksService,
                               attendanceSendService,
                               $modal,
                               absentOutputService) {

        $scope.isCollapsed = {
            dates: true,
            subscribers: false
        };

        $scope.show = {
            subscribers: 'Hide',
            dates: 'Show'
        };

        $scope.acceptAttendanceChanges = function () {
            attendanceSendService($scope.training.id);
        };

        $scope.changeCollapse = {
            dates: function () {
                $scope.isCollapsed.dates = !$scope.isCollapsed.dates;
                if ($scope.isCollapsed.dates) {
                    $scope.show.dates = 'Show';
                } else {
                    $scope.show.dates = 'Hide';
                }
            },
            subscribers: function () {
                $scope.isCollapsed.subscribers = !$scope.isCollapsed.subscribers;
                if ($scope.isCollapsed.subscribers) {
                    $scope.show.subscribers = 'Show';
                } else {
                    $scope.show.subscribers = 'Hide';
                }
            }
        };

        $scope.trainerFeedback = {
            employeeId:null,
            presence:null,
            attitude:null,
            communication:null,
            question:null,
            interest:null,
            result:null,
            level:null,
            rating:null,
            other:null
        };

        $scope.openModal = function () {
            var modalInstance = $modal.open({
                animation: true,
                templateUrl: '/res/trainingpage/trainer/userRevieModal.html',
                controller: 'userRevieModalController',
                resolve: {
                    feedbacks: function () {
                        return {
                            feedback: $scope.trainerFeedback,
                            trainingId: $scope.training.id,
                            subscribers:$scope.subscribers
                        };
                    }
                }
            });
            modalInstance.result.then(function (response) {
                console.log(response);
            }, function (error) {
                console.error(error);
            });

        };

        $scope.editTraining = function () {
            $location.url('/ui/trainingPage/edit/' + $scope.training.id);
        };

        getTrainingInfo().then(function (data, status, headers, config) {
            $scope.training = data.data;
            $scope.training.time = [];
            $scope.training.dateTime = [];
            $scope.training.year = [];
            for (var j = 0; j < $scope.training.meets.length; j++) {
                $scope.training.time.push(moment($scope.training.meets[j].date).format('HH:mm'));
                $scope.training.dateTime.push(moment($scope.training.meets[j].date).format('DD MMMM'));
                $scope.training.year.push(moment($scope.training.meets[j].date).format('YYYY'));
            }
            getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                $scope.subscribers = data.data;
                absentOutputService.prepare($scope.subscribers, $scope.training);
            }, function (error) {
                console.error(error);
            });
            getFeedbacksService($scope.training.id).then(function (data, status, headers, config) {
                $scope.feedbacks = data.data;
            }, function (error) {
                console.error(error);
            });
        });

    };
    controller.$injet = services;
    angular.module('trainingPageTrainerModule').controller('trainingPageTrainerController', controller);
})();




