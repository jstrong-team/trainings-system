(function () {

    var services = [
        '$rootScope',
        '$scope',
        '$http'
    ];

    var controller = function ($rootScope, $scope, $http) {


        var ITEMS_PER_PAGE = 10;
        $scope.itemsPerPage = ITEMS_PER_PAGE;


        //$scope.actualCurrentListItems = null;
        //
        //$scope.historyCurrentListItems = null;
        //$scope.bigTotalItems = null;

        $scope.currentPage = 1;
        $scope.maxSize = 5;

        $scope.$watch('currentPage', function(newPage){
            $http.get('/rest/news/notice?count=' + ITEMS_PER_PAGE + '&page=' + newPage).then(
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
            $http.post('/rest/news/complete', {id: id}).then(
                function(data, status){
                    $rootScope.$broadcast('removeNewsItem');
                },
                function(data, status){
                    console.log(status);
                });
        };
    };

    controller.$inject = services;
    angular.module('adminNewsModule').controller('newsController', controller);

})();


