angular.module('trainingPageModule').controller('ModalInstanceCtrl', ['$scope', '$modalInstance', 'feedbacks','$http',function($scope, $modalInstance, feedbacks,$http){

    $scope.feedback = feedbacks.feedback;
    $scope.trainingId=feedbacks.trainingId;

    $scope.submit=function(){
        $http.post('/rest/storagetraining/addemployeefeedback?id='+$scope.trainingId, $scope.feedback).then(function(response){
            $modalInstance.close(response);
        }, function(error){
            $modalInstance.dismiss(error);
        });
    };

}]);