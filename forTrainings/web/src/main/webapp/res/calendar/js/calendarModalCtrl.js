angular.module('calendarModule').controller('calendarModalCtrl', ['$scope', '$modalInstance', 'className',function($scope, $modalInstance, className){

    $scope.className = className;
    $scope.bla='111111';
    $scope.modalSubmit=function(){
        console.log($scope.className);
        //$http.post('/rest/azdfsdfsdf', $scope.feedback).then(function(response){
        //    $modalInstance.close(response);
        //}, function(error){
        //    $modalInstance.dismiss(error);
        //});
    };

}]);