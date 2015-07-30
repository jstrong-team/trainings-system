angular.module('trainingPageModule').factory('subscribeService', ['$http', function($http) {
    var unsubscribe = function(id,feedback) {
        return $http.post('/rest/storagetraining/addsubscriber?id='+ id, feedback);
    };
    return unsubscribe;
}]);