angular.module('trainingPageModule').factory('subscribeService', ['$http', function($http) {
    var service={};
    service.subscribe = function(id,feedback) {
        return $http.post('/rest/storagetraining/addsubscriber?id='+ id, feedback);
    };
    service.unsubscribe = function (id) {
        return $http.delete('rest/storagetraining/removeSubscriber?id=' + id);
    };
    return service;
}]);