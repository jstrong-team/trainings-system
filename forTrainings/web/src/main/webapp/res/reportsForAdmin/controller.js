(function () {

    var services = [
        '$scope',
        '$http'
    ];

    var controller = function ($scope, $http) {

        $http.get('/rest/trainings/users').then(
            function(data){
                $scope.employeeList = data.data;
            },
            function(data, status){
                console.log(status);
            });

        $scope.getEmployeeInfo = function () {
            $http.get('/rest/storagetraining/getReport').then(
                function(data){
                    $scope.employeeInfo = data.data;
                },
                function(data, status){
                    console.log(status);
                });
        };

        $scope.printService = function (printElement) {

            var printContents = document.getElementById(printElement).innerHTML;
            var originalContents = document.body.innerHTML;

            document.body.innerHTML = printContents;

            window.print();

            document.body.innerHTML = originalContents;
        };


    };

    controller.$inject = services;

    console.log(controller);

    angular.module('reportsModule').controller('reportsController', controller);

})();


