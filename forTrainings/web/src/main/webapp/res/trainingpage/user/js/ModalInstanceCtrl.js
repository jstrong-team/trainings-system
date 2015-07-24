angular.module('trainingPageModule').controller('ModalInstanceCtrl', ['$scope', '$modalInstance', 'feedbacks','$http',function($scope, $modalInstance, feedbacks,$http){

    $scope.feedback = feedbacks;

    $scope.submit=function(){
        console.log($scope.feedback);
        $http.post('/rest/azdfsdfsdf', $scope.feedback).then(function(response){
            $modalInstance.close(response);
        }, function(error){
            $modalInstance.dismiss(error);
        });
    };

}]);