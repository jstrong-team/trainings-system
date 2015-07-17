angular.module('calendarModule').controller('calendarController', ['$scope','threeMonthList', function($scope,threeMonthList) {
    $scope.days = getThreeMonthDays();
    $scope.months = getThreeMoths ();
    $scope.$on('ngRepeatFinished', function() {
        markCurrentDay();
    });
    threeMonthList.getThreeMonthList().then(function(data) {
        //$scope.threeMonthData = data;
        colorDayItems (data);
    })
}]);