angular.module('trainingPageModule').controller('ModalInstanceCtrl', ['$scope', '$modalInstance', 'feedbacks','$http',function($scope, $modalInstance, feedbacks,$http){

    $scope.feedback = feedbacks.feedback;
    $scope.trainingId=feedbacks.trainingId;
    $scope.rateshow = false;

    $scope.submit=function(){
        if($scope.feedback.rate===null){
            $scope.rateshow = true;
        } else {
            $http.post('/rest/storagetraining/addemployeefeedback?id='+$scope.trainingId, $scope.feedback).then(function(response){
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