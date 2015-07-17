angular.module('calendarModule').controller('navigationController',['$scope','$location','doSearchService', 'threeMonthList', function($scope, $location, doSearchService, threeMonthList) {

    $scope.searchExpression='';

    $scope.searchResponse=null;

    $scope.navigation ={url: '/res/navigation/navigation.html'};

    $scope.doSearch=function(){
        doSearchService($scope.searchExpression).then(function (data, status, headers, config) {
            $scope.searchResponse=data.data;
            //console.log(data.data);
        }, function (error) {
            console.log(error);
        });
    };

    $scope.createLog=function(){
        console.log($scope.searchExpression);
        console.log($scope.searchResponse);
    };

    $scope.logout=function(){
        localStorage.clear();
        $location.url('/ui');
    };
    $scope.goToTrainings=function(){
        $location.url('/ui/trainings');
    };

    threeMonthList.getThreeMonthList().then(function(data) {
        //$scope.threeMonthData = data;
        colorDayItems (data);
    })
}]);