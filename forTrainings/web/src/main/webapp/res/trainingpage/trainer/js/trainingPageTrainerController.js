(function(){
    var services=[
        '$scope',
        '$location',
        'getTrainingInfo',
        'getSubscribersService',
        'getFeedbacksService',
        'attendanceSendService'
    ];
    var controller=function($scope,
                            $location,
                            getTrainingInfo,
                            getSubscribersService,
                            getFeedbacksService,
                            attendanceSendService) {

        $scope.isCollapsed = {
            dates: true,
            subscribers: false
        };

        $scope.show = {
            subscribers: 'Hide',
            dates: 'Show'
        };

        $scope.acceptAttendanceChanges=function(){
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


        $scope.editTraining=function (){
            $location.url('/ui/trainingPage/edit/'+$scope.training.id);
        };

        getTrainingInfo().then(function(data, status, headers, config) {
            $scope.training=data.data;
            $scope.training.time=[];
            $scope.training.dateTime=[];
            $scope.training.year=[];
            for(var j=0;j<$scope.training.meets.length;j++) {
                $scope.training.time.push(moment($scope.training.meets[j].date).format('HH:mm'));
                $scope.training.dateTime.push(moment($scope.training.meets[j].date).format('DD MMMM'));
                $scope.training.year.push(moment($scope.training.meets[j].date).format('YYYY'));
            }
            getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                $scope.subscribers=data.data;
                //console.log('subscribers');
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
                //console.log($scope.training);
                //debugger;
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




