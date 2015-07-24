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
            windowClass: 'modalMain',
            //backdropClass:'modalBackground',
            resolve: {
                trainingsStr: function () {
                    var dateRe = /[0-9]{4}-[0-9]{2}-[0-9]{2}/ig;
                    var date = dateRe.exec(data);
                    return {
                        date:date[0],
                        threeMonthTrainings:$scope.threeMonthTrainings
                    };
                }
            }
        });
    };

    threeMonthList.getThreeMonthList().then(function (data) {
        $scope.threeMonthTrainings = data;
        $scope.showNavbarHat = false;
        colorDayItems(data);
    });
}]);