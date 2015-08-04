angular.module('calendarModule').controller('calendarModalCtrl', ['$scope', '$modalInstance', 'trainingsStr', 'trainingRedirectService', function ($scope, $modalInstance, trainingsStr, trainingRedirectService) {

    $scope.date = trainingsStr.date;
    $scope.trainings = trainingsStr.threeMonthTrainings;
        $scope.modalSubmit = function () {
    };

    $scope.redirectToTrainingPage = function (id) {
        $modalInstance.close();
        trainingRedirectService(id);
    };
}]);