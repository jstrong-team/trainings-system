angular.module('trainingPageModule').factory('unsubscribeService', ['$http', function ($http) {
    var unsubscribe = function (id) {
        return $http.delete('rest/storagetraining/removeSubscriber?id=' + id);
    };
    return unsubscribe;
}]);