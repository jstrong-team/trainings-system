(function () {
    var services = [
        '$scope',
        'getTrainingInfo',
        '$http',
        '$modal',
        '$routeParams',
        'getSubscribersService',
        '$route',
        'unsubscribeService',
        'openModalService',
        'subscribeService',
        'absentOutputService'
    ];
    var controller = function ($scope,
                               getTrainingInfo,
                               $http,
                               $modal,
                               $routeParams,
                               getSubscribersService,
                               $route,
                               unsubscribeService,
                               openModalService,
                               subscribeService,
                               absentOutputService) {

        $scope.isCollapsed = {
            dates: true,
            subscribers: false
        };

        $scope.show = {
            subscribers: 'Hide',
            dates: 'Show'
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
            openModalService($scope.feedback, $scope.training.id);
        };

        $scope.subscribe = function () {
            subscribeService($scope.training.id, $scope.feedback).then(function (response) {
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    $scope.training.isSubscribe = true;
                    absentOutputService.prepare($scope.subscribers, $scope.training);
                }, function (error) {
                    console.log(error);
                });

            }, function (error) {
                console.log(error);
            });
        };

        $scope.unsubscribe = function () {
            unsubscribeService($scope.training.id).then(function (response) {
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    $scope.training.isSubscribe = false;
                    absentOutputService.prepare($scope.subscribers, $scope.training);
                }, function (error) {
                    console.log(error);
                });
            }, function (error) {
                console.error(error);
            });
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
                console.log(error);
            });
        },function(error){
            console.error(error);
        });

    };

    controller.$inject = services;

    angular.module('trainingPageModule').controller('trainingPageController', controller);

})();

