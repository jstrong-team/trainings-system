angular.module('trainingPageTrainerModule').controller('trainingPageTrainerController',['$scope','$location','getTrainingInfo','getSubscribersService','getFeedbacksService','editTrainingService', function($scope,$location,getTrainingInfo,getSubscribersService,getFeedbacksService,editTrainingService) {

    $scope.isCollapsed = false;

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

}]);


