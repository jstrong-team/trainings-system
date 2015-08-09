angular.module('calendarModule').controller('calendarModalCtrl', ['$scope', '$modalInstance', 'trainingsStr', 'trainingRedirectService', function ($scope, $modalInstance, trainingsStr, trainingRedirectService) {

    $scope.trainings = trainingsStr.dayTrainings;


    $scope.modalSubmit = function () {
    };

    $scope.redirectToTrainingPage = function (id) {
        $modalInstance.close();
        trainingRedirectService(id);
    };
}]);