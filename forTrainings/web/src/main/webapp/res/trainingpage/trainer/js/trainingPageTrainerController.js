(function(){
    var services=[
        '$scope',
        '$location',
        'getTrainingInfo',
        'getSubscribersService',
        'getFeedbacksService'
    ];
    var controller=function($scope,
                            $location,
                            getTrainingInfo,
                            getSubscribersService,
                            getFeedbacksService) {

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


        $scope.editTraining=function (){
            $location.url('/ui/trainingPage/edit/'+$scope.training.id);
        };

        getTrainingInfo().then(function(data, status, headers, config) {
            $scope.training=data.data;
            $scope.training.time=[];
            $scope.training.dateTime=[];
            $scope.training.year=[];
            for(var j=0;j<$scope.training.dates.length;j++) {
                $scope.training.time.push(moment($scope.training.dates[j]).format('HH:mm'));
                $scope.training.dateTime.push(moment($scope.training.dates[j]).format('DD MMMM'));
                $scope.training.year.push(moment($scope.training.dates[j]).format('YYYY'));
            }
            getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                $scope.subscribers=data.data;
            }, function (error) {
                console.error(error);
            });
            getFeedbacksService($scope.training.id).then(function (data, status, headers, config) {
                $scope.feedbacks=data.data;
            }, function (error) {
                console.error(error);
            });
        });
    };
    controller.$injet=services;
    angular.module('trainingPageTrainerModule').controller('trainingPageTrainerController',controller);
})();




