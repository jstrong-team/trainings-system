angular.module('calendarModule').controller('calendarModalCtrl', ['$scope', '$modalInstance', 'trainingsStr', function ($scope, $modalInstance, trainingsStr) {

    $scope.date = trainingsStr.date;
    $scope.trainings = trainingsStr.threeMonthTrainings;
    $scope.modalSubmit = function () {
        console.log($scope.date);
        console.log($scope.trainings);
        //$http.post('/rest/azdfsdfsdf', $scope.feedback).then(function(response){
        //    $modalInstance.close(response);
        //}, function(error){
        //    $modalInstance.dismiss(error);
        //});
    };

}]);