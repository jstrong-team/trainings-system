(function () {

    var services = [
        '$scope',
        '$http',
        '$filter',
        'reportInfoFormat'
    ];

    var controller = function ($scope, $http, reportInfoFormat) {

        $http.get('/rest/trainings/users_trainings').then(
            function(data){
                $scope.employeeList = data.data.users;
                $scope.trainingsList = data.data.trainings;
            },
            function(data, status){
                console.log(status);
            });

        var positiveFeedback = [
            {
                date: '2015-08-17',
                text: 'blabla'
            }
        ];

        var negativeFeedback = [
            {
                date: '2015-08-17',
                text: 'blabla'
            },

            {
                date: '2015-08-29',
                text: 'blablacar'
            }
        ];

        var info = [
            {
                date: '2015-08-14',
                absent: 'true',
                reson: 'ill'
            },

            {
                date: '2015-08-20',
                absent: 'true',
                reson: 'drive'
            }
        ];

        var u1 = [info, positiveFeedback, negativeFeedback];
        var u2 = [info, positiveFeedback, negativeFeedback];
        var u3 = [info, positiveFeedback, negativeFeedback];

        var training = [u1, u2, u3];

        $scope.trainings = [training];

        $scope.noReportFound = null;
        $scope.initialState = null;

        $scope.employeeItem = '';
        $scope.trainingItem = '';
        $scope.dateTimeFrom = '';
        $scope.dateTimeTo = '';

        $scope.submitForm = function () {

            $scope.errorDateValidation = '';

            if ($scope.dateTimeFrom !== '') {
                if (!moment($scope.dateTimeFrom, 'YYYY-MM-DD', true).isValid()) {
                    $scope.errorDateValidation = 'DATE_VALIDATION_ERROR';
                    $scope.dateTimeFrom = '';
                    $scope.dateTimeTo = '';
                    return;
                }
            }

            if ($scope.dateTimeTo !== '') {
                if (!moment($scope.dateTimeTo, 'YYYY-MM-DD', true).isValid()) {
                    $scope.errorDateValidation = 'DATE_VALIDATION_ERROR';
                    $scope.dateTimeFrom = '';
                    $scope.dateTimeTo = '';
                    return;
                }
            }

            if ($scope.dateTimeFrom !== '' && $scope.dateTimeTo !== '') {
                if (Date.parse($scope.dateTimeFrom) > Date.parse($scope.dateTimeTo)) {
                    $scope.errorDateValidation = 'DATE_VALIDATION_FIRST_LAST';
                    $scope.dateTimeFrom = '';
                    $scope.dateTimeTo = '';
                    return;
                }
            }

            var userId = $scope.employeeItem;
            var trainingId = $scope.trainingItem;

            if ($scope.employeeItem !== '') {
                userId = JSON.parse(userId).id
            }

            if ($scope.trainingItem !== '') {
                trainingId = JSON.parse(trainingId).id
            }

            $http.get('/rest/storagetraining/getReport?userId=' + userId + '&trainingId=' + trainingId +
            '&dateFrom=' + $scope.dateTimeFrom + '&dateTo=' + $scope.dateTimeTo).then(
                function(data){

                    $scope.reportInfo = data.data;

                    if ($scope.reportInfo.trainings.length !== 0) {
                        $scope.initialState = true;
                        $scope.noReportFound = null;
                    } else {
                        $scope.initialState = null;
                        $scope.noReportFound = true;
                    }

                },
                function(data, status){
                    console.log(status);
                });
        };



        $scope.printService = function (printElement) {
            localStorage.setItem('printHtml',document.getElementById(printElement).innerHTML);
            window.open('/ui/admin/reports/print');
        };

    };

    controller.$inject = services;

    console.log(controller);

    angular.module('reportsModule').controller('reportsController', controller);

})();


