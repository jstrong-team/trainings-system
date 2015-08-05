(function () {

    var services = [
        '$scope',
        '$http',
        'reportInfoFormat'
    ];

    var controller = function ($scope, $http, reportInfoFormat) {

        $http.get('/rest/trainings/users').then(
            function(data){
                $scope.employeeList = data.data;
            },
            function(data, status){
                console.log(status);
            });

        $scope.getEmployeeReport = function () {
            var obj = JSON.parse($scope.item);
            var id = obj.id;
            var name = obj.name;
            var elem = document.getElementById('employeeInput');
            elem.style.paddingTop = '0px';

            $http.get('/rest/storagetraining/getReport?id=' + id).then(
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


