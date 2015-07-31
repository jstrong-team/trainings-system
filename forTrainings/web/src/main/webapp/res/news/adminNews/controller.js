(function () {

    var services = [
        '$scope',
        '$http'
    ];

    var controller = function ($scope, $http) {


        var CURRENT_ITEMS_COUNT = 20;


        $scope.currentListItems = null;
        $scope.bigTotalItems = null;
        $scope.bigCurrentPage = 1;
        $scope.maxSize = 10;

        $http.get('/rest/news/notice?count=' + CURRENT_ITEMS_COUNT).then(
            function(data){
                $scope.bigTotalItems = data;
                console.log(data);
            },
            function(data, status){
                console.log(status);
            });

    };

    controller.$inject = services;
    angular.module('adminNewsModule').controller('newsController', controller);

})();


