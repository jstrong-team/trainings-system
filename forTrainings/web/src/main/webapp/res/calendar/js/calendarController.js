angular.module('calendarModule').controller('calendarController', ['$scope', function($scope) {
    $scope.days = getThreeMonthDays();
    $scope.months = getThreeMoths ();
    $scope.$on('ngRepeatFinished', function() {
        markCurrentDay();
    });
}]);