angular.module('trainingPageModule').factory('subscribeService', ['$http', function($http) {
    var subscribe = function(id,feedback) {
        return $http.post('/rest/storagetraining/addsubscriber?id='+ id, feedback);
    };
    return subscribe;
}]);