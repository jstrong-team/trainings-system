angular.module('calendarModule').controller('calendarController', ['$scope', 'threeMonthList', '$modal', function ($scope, threeMonthList, $modal) {
    $scope.days = getThreeMonthDays();
    $scope.months = getThreeMonths();
    $scope.$on('ngRepeatFinished', function () {
        markCurrentDay();
    });

    $scope.openModal = function (data) {
        $modal.open({
            animation: true,
            templateUrl: '/res/calendar/modal.html',
            controller: 'calendarModalCtrl',
            size: 'md',
            windowClass: 'modalMain',
            resolve: {
                trainingsStr: function () {
                    var dateRe = /[0-9]{4}-[0-9]{2}-[0-9]{2}/ig;
                    var date = dateRe.exec(data);
                    return {
                        date: date[0],
                        threeMonthTrainings: $scope.threeMonthTrainings
                    };
                }
            }
        });
    };

    threeMonthList.getThreeMonthList().then(function (data) {
        $scope.threeMonthTrainings = data;
        colorDayItems(data);
        $scope.description = dayDescription(data);
    });
}]);