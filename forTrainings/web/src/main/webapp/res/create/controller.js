(function () {
    var services = [
        '$scope',
        'createService',
        '$location'
    ];
    var controller = function ($scope, createService, $location) {
        $scope.createInfo = {
            name: null, annotation: null, description: null, target: null, paid: true,
            max_participants: null, date: [], place: null, internal: true
        };

        $scope.isTrainingPeriodic = '';

        $scope.error = null;

        $scope.days = [
            {name: 'Sun:', day: 0},
            {name: 'Mon:', day: 1},
            {name: 'Tue:', day: 2},
            {name: 'Wed:', day: 3},
            {name: 'Thur:', day: 4},
            {name: 'Fr:', day: 5},
            {name: 'Sat:', day: 6}
        ];

        $scope.selectedDays = [];

        $scope.toggleSelection = function toggleSelection(day) {
            var idx = $scope.selectedDays.indexOf(day.day);

            if (idx > -1) {
                $scope.selectedDays.splice(idx, 1);
            }

            else {
                $scope.selectedDays.push(day.day);
            }
        };

        $scope.submitForm = function () {
            if ($scope.isTrainingPeriodic !== '') {
                if (Date.parse($scope.firstDate) > Date.parse($scope.lastDate)) {
                    $scope.firstDate = '';
                    $scope.lastDate = '';
                    return;
                }
                $scope.createInfo.date.push($scope.firstDate);
                $scope.createInfo.date.push($scope.lastDate);

                for (var d = 0; d < $scope.selectedDays.length; ++d) {
                    var i = 0;
                    var nextDay = moment($scope.firstDate).day(moment($scope.firstDate).day() + 1);
                    var iterationDay = nextDay;
                    while ($scope.selectedDays[d] != iterationDay.day()) {
                        ++i;
                        iterationDay = moment($scope.firstDate).day(moment($scope.firstDate).day() + i + 1);
                    }

                    i = 0;
                    while (iterationDay.date() < moment($scope.lastDate).date() - 7) {
                        iterationDay = iterationDay.day(iterationDay.day() + i);
                        var result = iterationDay.format('YYYY-MM-DD HH:mm:ss');
                        $scope.createInfo.date.push(result);
                        i = 7;
                    }
                }

            } else {
                $scope.createInfo.date.push($scope.firstDate);
            }

            console.log($scope.createInfo);
            createService.serv($scope.createInfo).then(function (response) {
                console.log(response);
                $location.url('/ui/creation_response');
            }, function (error) {
                console.error(error);
                $scope.error = 'Error';
            });
        };

    };

    controller.$inject = services;

    angular.module('createModule').controller('createController', controller);

})();


