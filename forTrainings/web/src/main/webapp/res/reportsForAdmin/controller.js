(function () {

    var services = [
        '$scope',
        '$http'
    ];

    var controller = function ($scope, $http) {

        //$scope.employeeList = null;

        $http.get('/rest/trainings/users').then(
            function(data){
                $scope.employeeList = data.data;
            },
            function(data, status){
                console.log(status);
            });


    };

    controller.$inject = services;

    console.log(controller);

    angular.module('reportsModule').controller('reportsController', controller);

})();


