angular.module('navigationModule').controller('navigationController', ['$rootScope', '$scope', '$location', 'doSearchService', 'doLogoutService', 'dateFormatService', function ($rootScope, $scope, $location, doSearchService, doLogoutService, dateFormatService) {

    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();

    };

    $scope.searchExpression = '';

    $rootScope.inputSearchText = '';

    $scope.location = $location;

    $scope.searchResponse = null;

    $scope.noResultsFound = false;

    $scope.navigation = {url: '/res/navigation/navigation.html'};


    $scope.doSearch = function () {
        $rootScope.inputSearchText = $scope.searchExpression;
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

    $scope.redirectToTrainingPage = function (id) {
        $location.url('/ui/trainingPage/user/' + id);
    };
}]);