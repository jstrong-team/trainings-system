angular.module('calendarModule').controller('calendarController', ['$scope', 'threeMonthList', '$modal', function ($scope, threeMonthList, $modal) {
    $scope.days = getThreeMonthDays();
    $scope.months = getThreeMoths();
    $scope.showNavbarHat = true;
    $scope.bla = '----------------------------------';
    //$scope.isNotLoginPage();
    $scope.$on('ngRepeatFinished', function () {
        markCurrentDay();
    });

    $scope.openModal = function (data) {
        console.log($scope.bla);
        $modal.open({
            animation: true,
            templateUrl: '/res/calendar/modal.html',
            controller: 'calendarModalCtrl',
            size: 'md',
            resolve: {
                className: function () {
                    return data;
                }
            }
        });
    };

    threeMonthList.getThreeMonthList().then(function (data) {
        //$scope.threeMonthData = data;
        $scope.showNavbarHat = false;
        colorDayItems(data);
    });
}]);