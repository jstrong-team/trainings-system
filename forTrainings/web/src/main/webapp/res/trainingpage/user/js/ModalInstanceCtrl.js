angular.module('trainingPageModule').controller('ModalInstanceCtrl', ['$scope', '$modalInstance', 'feedbacks','$http','$location',function($scope, $modalInstance, feedbacks,$http,$location){

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
                if(error.status===401){
                    $location.url('/ui/');
                }
                $modalInstance.dismiss(error);
            });
        }


    };

    $scope.cancel = function () {
        $modalInstance.dismiss();
    };

}]);