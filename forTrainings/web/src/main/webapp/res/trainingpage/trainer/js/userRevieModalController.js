angular.module('trainingPageTrainerModule').controller('userRevieModalController', ['$scope', '$modalInstance', 'feedbacks', '$http', function ($scope, $modalInstance, feedbacks, $http) {

    $scope.feedback = feedbacks.feedback;
    $scope.trainingId = feedbacks.trainingId;
    $scope.subscribers = feedbacks.subscribers;
    $scope.rateshow = false;
    $scope.submit = function () {
        if ($scope.feedback.rating === null) {
            $scope.rateshow = true;
        } else {
            //console.log($scope.subscribers);
            //console.log($scope.feedback);
            $http.post('/rest/storagetraining/addTrainerFeedback?trainingId='+$scope.trainingId, $scope.feedback).then(function(response){
                $modalInstance.close(response);
            }, function(error){
                $modalInstance.dismiss(error);
            });
        }
    };

    $scope.cancel = function () {
        $modalInstance.dismiss();
    };

}]);