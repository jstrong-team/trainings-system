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
            max_participants: null, date: [], place: null, internal: true, externalTrainerName: null,
            externalTrainerMail: null, externalTrainerPhone: null
        };

        $scope.days = [
            {name: 'CREATE_TRAINING_DATA_DAYS_SUN', day: 0},
            {name: 'CREATE_TRAINING_DATA_DAYS_MON', day: 1},
            {name: 'CREATE_TRAINING_DATA_DAYS_TUE', day: 2},
            {name: 'CREATE_TRAINING_DATA_DAYS_WED', day: 3},
            {name: 'CREATE_TRAINING_DATA_DAYS_THUR', day: 4},
            {name: 'CREATE_TRAINING_DATA_DAYS_FR', day: 5},
            {name: 'CREATE_TRAINING_DATA_DAYS_SAT', day: 6}
        ];

        $scope.isCollapsedET = true;
        $scope.addRemoveTrainerButton = 'CREATE_TRAINING_ADD_EXTERNAL_BUTTON';

        $scope.isCollapsedExternalTrainer = function () {
            $scope.isCollapsedET = !$scope.isCollapsedET;
            $scope.addRemoveTrainerButton = $scope.isCollapsedET ? 'CREATE_TRAINING_ADD_EXTERNAL_BUTTON' : 'CREATE_TRAINING_REMOVE_EXTERNAL_BUTTON';
        };

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
                if ($scope.createInfo.externalTrainerName === null) {
                    $location.url('/ui/creation_response');
                } else {
                    $location.url('/ui/creation_response_external');
                }
            }, function (error) {
                console.error(error);
                $scope.error = 'Error';
            });
        };

    };

    controller.$inject = services;

    angular.module('createModule').controller('createController', controller);

})();


