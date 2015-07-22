angular.module('trainingPageModule').controller('ModalInstanceCtrl', ['$scope', '$modalInstance', 'items','$http',function($scope, $modalInstance, feedback,$http){

    $scope.feedback = feedback;

    $scope.submit=function(){
        console.log($scope.feedback);
        $http.post('/rest/azdfsdfsdf', $scope.feedback).then(function(response){
            $modalInstance.close(response);
        }, function(error){
            $modalInstance.dismiss(error);
        });
    };

}]);