angular.module('trainingPageTrainerModule').factory('getFeedbacksService', ['$http', function($http) {
    var getFeedbacks = function(id) {
        return $http.get('rest/storagetraining/feedbacks?id='+id);
    };
    return getFeedbacks;
}]);