angular.module('trainingsModule').controller('controllerCalendar', ['$scope', function($scope) {
    $scope.days = getThreeMonthDays();
    $scope.months = getThreeMoths ();
    $scope.$on('ngRepeatFinished', function() {
        markCurrentDay();
    });
}]);