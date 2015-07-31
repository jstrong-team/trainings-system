(function () {

    var services = [
        '$scope',
        '$http'
    ];

    var controller = function ($scope, $http) {


        var CURRENT_ITEMS_COUNT = 10;


        //$scope.actualCurrentListItems = null;
        //
        //$scope.historyCurrentListItems = null;
        //$scope.bigTotalItems = null;

        $scope.currentPage = 1;
        $scope.maxSize = 10;

        //$http.get('/rest/news/notice?count=' + CURRENT_ITEMS_COUNT).then(
        //    function(data){
        //        $scope.actualCurrentListItems = data.data.actualNotices;
        //
        //        $scope.totalItems = data.data.historyCount;
        //        $scope.historyCurrentListItems = data.data.historyNotices;
        //    },
        //    function(data, status){
        //        console.log(status);
        //    });

        $scope.$watch('currentPage', function(newPage){
            $http.get('/rest/news/noticeHistory?count=' + CURRENT_ITEMS_COUNT + '&page=' + newPage).then(
                function(data){
                    $scope.actualCurrentListItems = data.data.actualNotices;

                    $scope.totalItems = data.data.historyCount;
                    $scope.historyCurrentListItems = data.data.historyNotices;
                },
                function(data, status){
                    console.log(status);
                });
        });

        $scope.removeActualItem = function (id) {
            console.log(id);
            $http.post('/rest/news/complete', {id: id}).then(
                function(data, status){
                    console.log(data);
                    console.log(status);
                },
                function(data, status){
                    console.log(status);
                });
        };
    };

    controller.$inject = services;
    angular.module('adminNewsModule').controller('newsController', controller);

})();


