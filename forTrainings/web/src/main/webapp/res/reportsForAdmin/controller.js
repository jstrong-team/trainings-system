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

        $scope.employeeItem = '';
        $scope.trainingItem = '';
        $scope.dateTimeFrom = '';
        $scope.dateTimeTo = '';
        //$scope.submitForm = function () {
        //
        //};

        $scope.submitForm = function () {

            var userId = JSON.parse($scope.employeeItem).id;
            var trainingId = JSON.parse($scope.trainingItem).id;


            console.log(userId + ' ' + trainingId + ' ' + $scope.dateTimeFrom + ' ' + $scope.dateTimeTo);

            //var elem = document.getElementById('employeeInput');
            //elem.style.paddingTop = '0px';

            $http.get('/rest/storagetraining/getReport?userId=' + userId + '&trainingsId=' + trainingId +
            '&from=' + fromDateTime + '&to=' + toDateTime).then(
                function(data){
                    $scope.employeeInfo = reportInfoFormat(data.data);

                    if ($scope.employeeInfo.length !== 0) {
                        $scope.selectedEmployee = name;
                        $scope.noReportFound = null;
                    } else {
                        $scope.selectedEmployee = null;
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


