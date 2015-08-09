(function () {
    var services = [
        '$scope',
        '$q',
        '$location',
        'getTrainingInfo',
        'getSubscribersService',
        'getFeedbacksService',
        'editTrainingService',
        'openModalService',
        '$route',
        'subscribeService',
        '$modal',
        '$http',
        'absentService',
        'deleteTrainingService'
    ];
    var controller = function ($scope,
                               $q,
                               $location,
                               getTrainingInfo,
                               getSubscribersService,
                               getFeedbacksService,
                               editTrainingService,
                               openModalService,
                               $route,
                               subscribeService,
                               $modal,
                               $http,
                               absentService,
                               deleteTrainingService) {

        $scope.isCollapsed = {
            dates: true,
            subscribers: false,
            addSubscriber: true
        };

        $scope.show = {
            subscribers: 'TRAINING_PAGE_HIDE',
            dates: 'TRAINING_PAGE_SHOW',
            addSubscriber: 'TRAINING_PAGE_HIDE'
        };

        $scope.changeCollapse = {
            dates: function () {
                $scope.isCollapsed.dates = !$scope.isCollapsed.dates;
                if ($scope.isCollapsed.dates) {
                    $scope.show.dates = 'TRAINING_PAGE_SHOW';
                } else {
                    $scope.show.dates = 'TRAINING_PAGE_HIDE';
                }
            },
            subscribers: function () {
                $scope.isCollapsed.subscribers = !$scope.isCollapsed.subscribers;
                if ($scope.isCollapsed.subscribers) {
                    $scope.show.subscribers = 'TRAINING_PAGE_SHOW';
                } else {
                    $scope.show.subscribers = 'TRAINING_PAGE_HIDE';
                }
            },
            addSubscriber: function () {
                $scope.isCollapsed.addSubscriber = !$scope.isCollapsed.addSubscriber;
                if ($scope.isCollapsed.addSubscriber) {
                    $scope.show.addSubscriber = 'TRAINING_PAGE_SHOW';
                } else {
                    $scope.show.addSubscriber = 'TRAINING_PAGE_HIDE';
                }
            }
        };

        $scope.editTraining = function () {
            $location.url('/ui/trainingPage/edit/' + $scope.training.id);
        };

        $scope.subscribe = function () {
            //subscribeService($scope.training,$scope.subscribers);
            subscribeService.subscribe($scope.training.id, $scope.feedback).then(function () {
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    $scope.training.isSubscribe = true;
                    absentService.prepare($scope.subscribers, $scope.training);
                }, function (error) {
                    console.error(error);
                });

            }, function (error) {
                console.error(error);
            });
        };

        $scope.foreignUser = {
            name: null,
            mail: null,
            phone: null
        };

        $scope.addForeignUser = function () {
            console.log($scope.foreignUser);
            $http.post('rest/storagetraining//addExternalUser?trainingId=' + $scope.training.id, $scope.foreignUser).then(function () {
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    absentService.prepare($scope.subscribers, $scope.training);
                    $scope.training.isSubscribe = false;
                    $scope.foreignUser.name=null;
                    $scope.foreignUser.mail=null;
                    $scope.foreignUser.phone=null;
                }, function (error) {
                    console.log(error);
                });
            },function(error){
                console.error(error);
            });
        };

        $scope.acceptAttendanceChanges = function () {
            absentService.sendAttendance($scope.training.id);
        };

        $scope.removeTraining = function () {
            deleteTrainingService($scope.training.id);
        };

        $scope.openModal = function () {
            openModalService($scope.feedback, $scope.training.id);
        };

        $scope.unsubscribe = function () {
            subscribeService.unsubscribe($scope.training.id).then(function () {
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    absentService.prepare($scope.subscribers, $scope.training);
                    $scope.training.isSubscribe = false;
                }, function (error) {
                    console.log(error);
                });
            }, function (error) {
                console.error(error);
            });
        };

        $scope.trainerFeedback = {
            employeeId: null,
            presence: null,
            attitude: null,
            communication: null,
            question: null,
            interest: null,
            result: null,
            level: null,
            rating: null,
            other: null
        };

        $scope.openTrainerModal = function () {
            var modalInstance = $modal.open({
                animation: true,
                templateUrl: '/res/trainingpage/trainer/userRevieModal.html',
                controller: 'userRevieModalController',
                resolve: {
                    feedbacks: function () {
                        return {
                            feedback: $scope.trainerFeedback,
                            trainingId: $scope.training.id,
                            subscribers: $scope.subscribers
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

        getTrainingInfo().then(function (data, status, headers, config) {
            var dfd = $q.defer();
            $scope.training = data.data;
            $scope.training.time = [];
            $scope.training.dateTime = [];
            $scope.training.year = [];
            $scope.training.tableDate = [];
            for (var j = 0; j < $scope.training.meets.length; j++) {
                $scope.training.time.push(moment($scope.training.meets[j].date).format('HH:mm'));
                $scope.training.dateTime.push(moment($scope.training.meets[j].date).format('DD MMMM'));
                $scope.training.tableDate.push(moment($scope.training.meets[j].date).format('DD.MM'));
                $scope.training.year.push(moment($scope.training.meets[j].date).format('YYYY'));
            }
            dfd.resolve($scope.training.id);
            return dfd.promise;

        },function(error){
            console.log(error);
        }).then(function (id) {
            getSubscribersService(id).then(function (data, status, headers, config) {
                $scope.subscribers = data.data;
                absentService.prepare($scope.subscribers, $scope.training);
            }, function (error) {
                console.error(error);
            });
            getFeedbacksService(id).then(function (data, status, headers, config) {
                $scope.feedbacks = data.data;
            }, function (error) {
                console.error(error);
            });
        });

    };

    controller.$inject = services;

    angular.module('trainingPageAdminModule').controller('trainingPageAdminController', controller);
})();



