(function () {
    var services = [
        '$rootScope',
        '$scope',
        '$location',
        '$http',
        'doSearchService',
        'doLogoutService',
        'dateFormatService',
        'getRole'
    ];

    var controller = function ($rootScope, $scope, $location, $http, doSearchService, doLogoutService, dateFormatService, getRole) {

        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();

        };

        $http.get('rest/badgeCount').then(
            function(data){
                if (data.data.badgeCount !== 0) {
                    $scope.badgeCount = data.data.badgeCount;
                }
            },
            function(data, status){
                console.log(status);
            });

        $scope.isAdmin = '';

        (function () {
            $http.get('rest/storagetraining/isAdmin').then(
                function(data){
                    $scope.isAdmin = data.data.role;
                    console.log($scope.isAdmin);
                },
                function(data, status){
                    console.log(status);
                });
        })();

        $scope.searchExpression = '';

        $rootScope.inputSearchText = '';

        //$scope.location = $location;

        $scope.searchResponse = null;

        $scope.noResultsFound = false;

        //$scope.navigation = {url: '/res/navigation/navigation.html'};

        $scope.name = localStorage.getItem('name');

        $scope.doSearch = function () {
            $rootScope.inputSearchText = $scope.searchExpression;
            if ($scope.searchExpression === '') {
                $scope.noResultsFound = false;
            }
            doSearchService($scope.searchExpression).then(function (data, status, headers, config) {
                dateFormatService(data.data);
                $scope.searchResponse = data.data;
                if (data.data == '') {
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
            $location.url('/ui/trainings');
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };

        $scope.createTraining = function () {
            $location.url('/ui/create');
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };

        $scope.goToNews = function () {
            $location.url('/ui/news');
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };

        $scope.goToReports = function () {
            $location.url('/ui/admin/reports');
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };

        $scope.redirectToTrainingPage = function (id) {
            trainingRedirectService(id);
            $rootScope.inputSearchText = '';
            $scope.searchExpression = '';
        };
    };

    controller.$inject = services;

    angular.module('navigationModule').controller('navigationController', controller);

})();