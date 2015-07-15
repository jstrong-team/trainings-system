angular.module('trainingsModule').controller('trainingsController',['$scope','$location','threeMonthList','doSearchService', function($scope, $location, threeMonthList,doSearchService) {

    $scope.searchExpression='';

    $scope.searchResponse=null;

    $scope.doSearch=function(){
        doSearchService($scope.searchExpression).then(function (data, status, headers, config) {
            $scope.searchResponse=data.data;
            console.log(data.data);
        }, function (error) {
            console.log(error);
        });
        console.log($scope.searchExpression);
    };

    $scope.createLog=function(){
        console.log($scope.searchExpression);
        console.log($scope.trainings);

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