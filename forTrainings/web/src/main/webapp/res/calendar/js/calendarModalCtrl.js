angular.module('calendarModule').controller('calendarModalCtrl', ['$scope', '$modalInstance', 'trainingsStr', 'trainingRedirectService', function ($scope, $modalInstance, trainingsStr, trainingRedirectService) {

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

    $scope.redirectToTrainingPage = function (id) {
        $modalInstance.close();
        trainingRedirectService(id);
    };
}]);