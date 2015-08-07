(function () {

    var services = [
        '$rootScope',
        '$scope',
        '$http',
        '$location'
    ];

    var controller = function ($rootScope, $scope, $http, $location) {

        var badgeCount = 0;
        var ITEMS_PER_PAGE = 10;
        $scope.itemsPerPage = ITEMS_PER_PAGE;
        $scope.currentPage = 1;
        $scope.maxSize = 5;

        $scope.$watch('currentPage', function(newPage) {
            $http.get('/rest/news/notice?count=' + ITEMS_PER_PAGE + '&page=' + newPage).then(
                function(data){

                    console.log(data);

                    $scope.showPagination = null;
                    $scope.noNewsInHistory = null;
                    $scope.noNewsInHotNews = null;

                    $scope.actualCurrentListItems = data.data.actualNotices;
                    $scope.totalItems = data.data.historyCount;
                    $scope.historyCurrentListItems = data.data.historyNotices;

                    badgeCount = $scope.actualCurrentListItems.length;

                    if (badgeCount === 0 ) {
                        $scope.noNewsInHotNews = true;
                    }

                    if ($scope.totalItems > 0) {
                        $scope.showPagination = true;
                    } else {
                        $scope.noNewsInHistory = true;
                    }
                },
                function(error){
                    console.error(error);
                });
        });

        $scope.removeActualItem = function (id) {
            $http.post('/rest/news/complete', {id: id}).then(
                function(data, status){
                    $rootScope.$broadcast('removeNewsItem');
                    --badgeCount;

                    if (badgeCount === 0) {
                        $scope.noNewsInHotNews = true;
                    }

                },
                function(error){
                    console.error(error);
                });
        };

        $scope.redirectToTrainingPage = function (id, transactionId) {

            if (transactionId === null) {
                $location.url('/ui/trainingPage/approveCreate/' + id);
            } else {
                $location.url('/ui/trainingPage/approve/' + transactionId);
            }
        };

    };

    controller.$inject = services;
    angular.module('adminNewsModule').controller('newsController', controller);

})();


