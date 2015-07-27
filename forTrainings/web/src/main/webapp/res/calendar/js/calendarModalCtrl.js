angular.module('calendarModule').controller('calendarModalCtrl', ['$scope', '$modalInstance', 'trainingsStr', '$location', function ($scope, $modalInstance, trainingsStr, $location) {

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

    $scope.redirectToTrainingPage = function () {
        $modalInstance.close();
        $location.url('/ui/trainingPage/user');
    };
}]);