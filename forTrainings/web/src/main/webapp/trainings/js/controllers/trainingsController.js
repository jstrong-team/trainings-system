angular.module('trainingsModule').controller('trainingsController',['$scope','$location','threeMonthList', function($scope, $location, threeMonthList) {
    $scope.logout=function(){
        $location.url('/');
    }
    $scope.goToTrainings=function(){
        $location.url('/trainings');
    }

    threeMonthList.getThreeMonthList().then(function(data) {
        $scope.threeMonthData = data;
    })

}]);