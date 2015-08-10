(function () {

    var services = [
        '$scope',
        '$http',
        '$window',
        'reportInfoFormat'
    ];

    var controller = function ($scope, $http, $window, reportInfoFormat) {

        $http.get('/rest/trainings/users_trainings').then(
            function(data){
                $scope.employeeList = data.data.users;
                $scope.trainingsList = data.data.trainings;
            },
            function(error){
                console.error(error);
            });

        $scope.noReportFound = null;
        $scope.initialState = null;

        $scope.employeeItem = '';
        $scope.trainingItem = '';
        $scope.dateTimeFrom = '';
        $scope.dateTimeTo = '';

        var userId = null;
        var trainingId = null;


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

            userId = $scope.employeeItem;
            trainingId = $scope.trainingItem;

            if ($scope.employeeItem !== '') {
                userId = JSON.parse(userId).id
            }

            if ($scope.trainingItem !== '') {
                trainingId = JSON.parse(trainingId).id
            }

            $http.get('/rest/storagetraining/getReport?userId=' + userId + '&trainingId=' + trainingId +
            '&dateFrom=' + $scope.dateTimeFrom + '&dateTo=' + $scope.dateTimeTo).then(
                function(data){

                    reportInfoFormat(data.data.trainings);
                    $scope.reportInfo = data.data;

                    if ($scope.reportInfo.trainings.length !== 0) {
                        $scope.initialState = true;
                        $scope.noReportFound = null;
                    } else {
                        $scope.initialState = null;
                        $scope.noReportFound = true;
                    }

                },
                function(error){
                    console.error(error);
                });
        };



        $scope.printService = function (printElement) {
            localStorage.setItem('printHtml',document.getElementById(printElement).innerHTML);
            window.open('/ui/admin/reports/print');
        };

        $scope.download = function () {
            $window.open('http://localhost:8080/rest/storagetraining/getReportFile?userId='+ userId +'&trainingId='+ trainingId +'&dateFrom='+ $scope.dateTimeFrom +'&dateTo=' + $scope.dateTimeTo, '_blank');
        };

    };

    controller.$inject = services;

    angular.module('reportsModule').controller('reportsController', controller);

})();


