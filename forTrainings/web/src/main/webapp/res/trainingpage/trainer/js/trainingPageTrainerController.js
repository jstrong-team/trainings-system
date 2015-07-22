angular.module('trainingPageTrainerModule').controller('trainingPageTrainerController',['$scope','getTrainingInfo', function($scope,getTrainingInfo) {

    $scope.currentRating='3';

    getTrainingInfo().then(function(data, status, headers, config) {
        $scope.training=data.data[0];
        $scope.trainingDate=new Date(data.data[0].date);
    });

    $scope.feedbacks=[{
        understand:false,
        interested:false,
        continueWithThisTrainer:true,
        smthNew:true,
        recommend:true,
        rate:4,
        other:'smth bav veeeeeeeeeeeeeeeeeeeeery'
    },
        {
            understand:true,
            interested:false,
            continueWithThisTrainer:true,
            smthNew:true,
            recommend:true,
            rate:4,
            other:'smth bav veeeeeeeeeeeeeeeeeeeeery'
        }];

    $scope.newFeedbacks=[{}];
}]);


