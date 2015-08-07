angular.module('trainingPageTrainerModule').factory('editTrainingService', ['$location', function($location) {
    var edit = function(training) {
        console.log(training);
    };
    return edit;
}]);