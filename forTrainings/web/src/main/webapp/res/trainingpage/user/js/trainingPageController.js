(function () {
    var services = [
        '$scope',
        'getTrainingInfo',
        '$http', '$modal',
        '$routeParams',
        'getSubscribersService',
        '$route',
        'unsubscribeService',
        'openModalService',
        'subscribeService'
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
                               subscribeService) {

        $scope.isCollapsed = {
            dates: true,
            subscribers: true
        };

        $scope.show = {
            subscribers: 'Show',
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

        //TODO:  move http post in service
        $scope.subscribe = function () {
            console.log('/ui/trainingPage/user/' + $scope.training.id);
            subscribeService($scope.training.id, $scope.feedback).then(function (response) {

                //TODO:edit
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    $scope.training.isSubscribe = true;
                    //$scope.$apply();
                }, function (error) {
                    console.log(error);
                });

            }, function (error) {
                console.log(error);
            });
        };

        $scope.unsubscribe = function () {
            unsubscribeService($scope.training.id).then(function (response) {
                console.log(response);

                //TODO: edit
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    $scope.training.isSubscribe = false;
                }, function (error) {
                    console.log(error);
                });

            }, function (error) {
                console.error(error);
            });
        };

        getTrainingInfo().then(function (data, status, headers, config) {
            console.log(data.data);
            $scope.training = data.data;
            $scope.training.time = [];
            $scope.training.dateTime = [];
            $scope.training.year = [];
            console.log($scope.training);
            for (var j = 0; j < $scope.training.dates.length; j++) {
                $scope.training.time.push(moment($scope.training.dates[j]).format('HH:mm'));
                $scope.training.dateTime.push(moment($scope.training.dates[j]).format('DD MMMM'));
                $scope.training.year.push(moment($scope.training.dates[j]).format('YYYY'));
            }
            getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                $scope.subscribers = data.data;
            }, function (error) {
                console.log(error);
            });
        });

    };

    controller.$inject = services;

    angular.module('trainingPageModule').controller('trainingPageController', controller);

})();

