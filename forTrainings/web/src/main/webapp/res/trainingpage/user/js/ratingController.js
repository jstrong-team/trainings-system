angular.module('trainingPageModule').controller('ratingController',['$scope', function($scope) {

    $scope.maxRating=5;
    $scope.isRatingReadonly = false;
    $scope.currentRating = 2;
    $scope.overStar = null;
    $scope.percent=null;
    $scope.hoveringOver = function(value) {
        $scope.overStar = value;
        $scope.percent = 100 * (value / $scope.max);
    };

}]);