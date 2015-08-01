angular.module('calendarModule').controller('calendarController', ['$scope', '$location', 'calendarList', '$modal','trainingRedirectService', function ($scope, $location, calendarList, $modal,trainingRedirectService) {
    $scope.days = getThreeMonthDays();
    $scope.months = getThreeMonths();

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

    $scope.$on('ngRepeatFinished', function () {
        markCurrentDay();
        calendarList.getCalendarInfo().then(function (data) {
            colorDayItems(data.actualTrainingsHistory);
            addTrainerIcon(data.actualTrainingsHistory);
            dateTimeFormat(data.actualTrainingsHistory);
            dateTimeFormat(data.pastTrainingsHistory);
            $scope.threeMonthTrainings = data.actualTrainingsHistory;
            $scope.description = dayDescription(data.actualTrainingsHistory);
            $scope.pastTrainingHistory = data.pastTrainingsHistory
        });

    });

    $scope.redirectToTrainingPage = function (id) {
        trainingRedirectService(id);
    };
}]);