(function () {

    var services = [
        '$scope',
        '$http'
    ];

    var controller = function ($scope, $http) {

        $http.get('/rest/trainings/users').then(
            function(data){
                $scope.employeeList = data.data;
                console.log($scope.employeeList);
            },
            function(data, status){
                console.log(status);
            });

        $scope.getEmployeeReport = function () {
            var obj = JSON.parse($scope.item);
            var id = obj.id;
            var name = obj.name;
            $scope.selectedEmployee = name;
            var elem = document.getElementById('employeeInput');
            elem.style.paddingTop = '0px';

            $http.get('/rest/storagetraining/getReport?id=' + id).then(
                function(data){
                    $scope.employeeInfo = data.data;
                    console.log($scope.employeeInfo);
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


