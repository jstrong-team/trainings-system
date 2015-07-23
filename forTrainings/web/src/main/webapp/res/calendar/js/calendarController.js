angular.module('calendarModule').controller('calendarController', ['$scope','threeMonthList', function($scope,threeMonthList) {
    $scope.days = getThreeMonthDays();
    $scope.months = getThreeMoths ();
    $scope.showNavbarHat=true;
    //$scope.isNotLoginPage();
    $scope.$on('ngRepeatFinished', function() {
        markCurrentDay();
    });
    threeMonthList.getThreeMonthList().then(function(data) {
        //$scope.threeMonthData = data;
        $scope.showNavbarHat=false;
        colorDayItems (data);
    })
}]);