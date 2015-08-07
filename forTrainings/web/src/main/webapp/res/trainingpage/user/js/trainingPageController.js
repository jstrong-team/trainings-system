(function () {
    var services = [
        '$scope',
        'getTrainingInfo',
        '$http',
        '$modal',
        '$routeParams',
        'getSubscribersService',
        '$route',
        'openModalService',
        'subscribeService',
        'absentService',
        '$location'
    ];
    var controller = function ($scope,
                               getTrainingInfo,
                               $http,
                               $modal,
                               $routeParams,
                               getSubscribersService,
                               $route,
                               openModalService,
                               subscribeService,
                               absentService,
                               $location) {

        $scope.isCollapsed = {
            dates: true,
            subscribers: false
        };

        $scope.show = {
            subscribers: 'TRAINING_PAGE_HIDE',
            dates: 'TRAINING_PAGE_SHOW'
        };


        $scope.changeCollapse = {
            dates: function () {
                $scope.isCollapsed.dates = !$scope.isCollapsed.dates;
                if ($scope.isCollapsed.dates) {
                    $scope.show.dates ='TRAINING_PAGE_SHOW';
                } else {
                    $scope.show.dates ='TRAINING_PAGE_HIDE';
                }
            },
            subscribers: function () {
                $scope.isCollapsed.subscribers = !$scope.isCollapsed.subscribers;
                if ($scope.isCollapsed.subscribers) {
                    $scope.show.subscribers = 'TRAINING_PAGE_SHOW';
                } else {
                    $scope.show.subscribers = 'TRAINING_PAGE_HIDE';
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
            subscribeService.subscribe($scope.training.id, $scope.feedback).then(function () {
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    $scope.training.isSubscribe = true;
                    absentService.prepare($scope.subscribers, $scope.training);
                }, function (error) {
                    if(error.status===401){
                        $location.url('/ui/');
                    }
                    console.log(error);
                });

            }, function (error) {
                if(error.status===401){
                    $location.url('/ui/');
                }
                console.log(error);
            });
        };

        $scope.unsubscribe = function () {
            subscribeService.unsubscribe($scope.training.id).then(function () {
                getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.subscribers = data.data;
                    $scope.training.isSubscribe = false;
                    absentService.prepare($scope.subscribers, $scope.training);
                }, function (error) {
                    console.log(error);
                });
            }, function (error) {
                if(error.status===401){
                    $location.url('/ui/');
                }
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
                absentService.prepare($scope.subscribers, $scope.training);
            }, function (error) {
                if(error.status===401){
                    $location.url('/ui/');
                }
                console.log(error);
            });
        },function(error){
            if(error.status===401){
                $location.url('/ui/');
            }
            console.error(error);
        });

    };

    controller.$inject = services;

    angular.module('trainingPageModule').controller('trainingPageController', controller);

})();

