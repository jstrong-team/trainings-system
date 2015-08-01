(function () {
    var services = [
        '$rootScope',
        '$scope',
        '$location',
        '$http',
        'doSearchService',
        'doLogoutService',
        'dateFormatService',
        'trainingRedirectService',
        'getBadgeService'
    ];

    var controller = function ($rootScope, $scope, $location, $http, doSearchService, doLogoutService, dateFormatService, trainingRedirectService, getBadgeService) {

        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();

        };

        $scope.badgeCount = null;

        var recountBadge = function () {
            getBadgeService.badgeCount().then(
                function (data) {
                    $scope.badgeCount = data;
                },
                function (data, status) {
                    console.log(status);
                }
            );
        };

        recountBadge();

        $scope.$on('removeNewsItem', function() {
            if ($scope.badgeCount === 1) {
                $scope.badgeCount = null;
            } else {
                --$scope.badgeCount;
            }
        });

        $scope.isAdmin = '';

        (function () {
            $http.get('rest/storagetraining/isAdmin').then(
                function(data){
                    $scope.isAdmin = data.data.role;
                },
                function(data, status){
                    console.log(status);
                });
        })();

        $scope.searchExpression = '';

        $rootScope.inputSearchText = '';

        $scope.searchResponse = null;

        $scope.noResultsFound = false;

        $scope.name = localStorage.getItem('name');

        $scope.doSearch = function () {
            $rootScope.inputSearchText = $scope.searchExpression;
            if ($scope.searchExpression === '') {
                $scope.noResultsFound = false;
            }
            doSearchService($scope.searchExpression).then(function (data, status, headers, config) {
                dateFormatService(data.data);
                $scope.searchResponse = data.data;
                if (data.data.length === 0) {
                    $scope.noResultsFound = true;
                } else {
                    $scope.noResultsFound = false;
                }
            }, function (error) {
                console.log(error);
            });
        };

        $scope.logout = function () {
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
            localStorage.clear();
            $scope.isAdmin = '';
            doLogoutService().then(function (data) {
                console.log(data);
                $location.url('/ui');
            }, function (error) {
                console.log(error);
            });
        };

        $scope.goToTrainings = function () {
            recountBadge();
            $location.url('/ui/trainings');
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };

        $scope.createTraining = function () {
            recountBadge();
            $location.url('/ui/create');
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };

        $scope.goToNews = function () {
            recountBadge();
            $location.url('/ui/news');
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };

        $scope.goToReports = function () {
            recountBadge();
            $location.url('/ui/admin/reports');
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };

        $scope.redirectToTrainingPage = function (id) {
            recountBadge();
            trainingRedirectService(id);
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };
    };

    controller.$inject = services;

    angular.module('navigationModule').controller('navigationController', controller);

})();