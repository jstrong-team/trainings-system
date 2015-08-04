(function(){
    var services = [
        '$scope',
        '$q',
        '$location',
        'getTrainingInfo',
        'getSubscribersService',
        'getFeedbacksService',
        'editTrainingService',
        'openModalService',
        'unsubscribeService',
        '$route',
        'subscribeService',
        'attendanceSendService'
    ];
    var controller =function ($scope,
                              $q,
                              $location,
                              getTrainingInfo,
                              getSubscribersService,
                              getFeedbacksService,
                              editTrainingService,
                              openModalService,
                              unsubscribeService,
                              $route,
                              subscribeService,
                              attendanceSendService) {

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

        $scope.editTraining = function () {
            $location.url('/ui/trainingPage/edit/' + $scope.training.id);
        };

        $scope.subscribe = function () {
            //console.log('/ui/trainingPage/user/'+$scope.training.id);
            subscribeService($scope.training.id, $scope.feedback).then(function () {
                $route.reload();
            }, function (error) {
                console.log(error);
            });
        };

        $scope.acceptAttendanceChanges=function(){
            attendanceSendService($scope.training.id);
        };

        $scope.openModal=function(){
            openModalService($scope.feedback,$scope.training.id);
        };

        $scope.unsubscribe=function(){
            unsubscribeService($scope.training.id).then(function(){
                $route.reload();
            },function(error){
                console.error(error);
            });
        };


        var getSubFeed = function() {
            return function () {
                getSubscribersService($scope.training.id).then(function(data, status, headers, config){
                    $scope.subscribers = data.data;
                    //console.log($scope.subscribers);
                },function(reject){
                    console.error(reject);
                });

                getFeedbacksService($scope.training.id).then(function (data, status, headers, config) {
                    $scope.feedbacks = data.data;
                }, function (error) {
                    console.error(error);
                });

            };

        };

        getTrainingInfo().then(function (data, status, headers, config) {
            var dfd = $q.defer();
            $scope.training = data.data;
            $scope.training.time = [];
            $scope.training.dateTime = [];
            $scope.training.year = [];
            for (var j = 0; j < $scope.training.meets.length; j++) {
                $scope.training.time.push(moment($scope.training.meets[j].date).format('HH:mm'));
                $scope.training.dateTime.push(moment($scope.training.meets[j].date).format('DD MMMM'));
                $scope.training.year.push(moment($scope.training.meets[j].date).format('YYYY'));
            }
            dfd.resolve($scope.training.id);
            //dfd.reject('dosd');
            return dfd.promise;

        }).then(function(id){
            getSubscribersService(id).then(function(data, status, headers, config){
                $scope.subscribers = data.data;
                var temp;
                for(var i=0;i<$scope.subscribers.length;i++){
                    temp=$scope.subscribers[i].participants;
                    $scope.subscribers[i].participants=new Array($scope.training.meets.length);
                    var index=0;
                    for(var j=0;(j<$scope.training.meets.length)&&(index<temp.length);j++){
                        for(var k=0;k<temp.length;k++)
                        {
                            if($scope.training.meets[j].id==temp[k].meetId){
                                $scope.subscribers[i].participants[j]=temp[k];
                                index++;
                            }
                        }
                    }
                }
            },function(reject){
                console.error(reject);
            });
            getFeedbacksService(id).then(function (data, status, headers, config) {
                $scope.feedbacks = data.data;
                console.log($scope.feedbacks);
            }, function (error) {
                console.error(error);
            });
        });

    };

    controller.$inject = services;

    angular.module('trainingPageAdminModule').controller('trainingPageAdminController', controller);
})();



