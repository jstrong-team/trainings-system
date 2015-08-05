(function () {

    var services = [
        '$scope',
        '$http',
        '$filter',
        'reportInfoFormat',
        'ngTableParams'
    ];

    var controller = function ($scope, $http, reportInfoFormat, ngTableParams) {

        $http.get('/rest/trainings/users_trainings').then(
            function(data){
                $scope.employeeList = data.data.users;
                $scope.trainingsList = data.data.trainings;
            },
            function(data, status){
                console.log(status);
            });

        //$scope.employeeItem = '';
        //$scope.trainingItem = '';
        //$scope.dateTimeFrom = '';
        //
        //$scope.submitForm = function () {
        //
        //};

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

        var u1 = [info, positiveFeedback, negativeFeedback, training];
        var u2 = [info, positiveFeedback, negativeFeedback, training,];
        var u3 = [info, positiveFeedback, negativeFeedback];

        var EXAMPLE = [u1, u2, u3];

        console.log(EXAMPLE);


        $scope.tableParams = new ngTableParams({
            page: 1,
            count: 30
        }, {
            groupBy: 'role',
            total: data.length,
            getData: function($defer, params) {
                var orderedData = params.sorting() ?
                    $filter('orderBy')(data, $scope.tableParams.orderBy()) :
                    data;

                $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
            }
        });


        $scope.getEmployeeReport = function () {
            var obj = JSON.parse($scope.item);
            var id = obj.id;
            var name = obj.name;

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


