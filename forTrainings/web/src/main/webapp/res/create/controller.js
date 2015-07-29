(function () {
    var services = [
        '$scope',
        'createService',
        '$location',
        'validationService',
        'multipleDatesService'
    ];
    var controller = function ($scope, createService, $location, validationService, multipleDatesService) {
        $scope.createInfo = {
            name: null, annotation: null, description: null, target: null, paid: true,
            max_participants: null, date: [], place: null, internal: true
        };

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
        $scope.isTrainingPeriodic = '';
        $scope.errorDateValidation = '';
        $scope.firstDate = '';
        $scope.lastDate = '';

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
            if ($scope.isTrainingPeriodic === '') {
                $scope.errorDateValidation = validationService.oneTime($scope.firstDate);

            } else {
                $scope.errorDateValidation = validationService.periodic($scope.firstDate, $scope.lastDate);
            }
            if ($scope.errorDateValidation !== '') {
                $scope.firstDate = '';
                $scope.lastDate = '';
                return;
            }

            if ($scope.isTrainingPeriodic === '') {
                $scope.createInfo.date.push($scope.firstDate);

            } else {
                $scope.createInfo.date = multipleDatesService.multiple($scope.firstDate, $scope.lastDate, $scope.selectedDays);
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


