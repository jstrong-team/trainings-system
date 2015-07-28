angular.module('trainingPageModule').factory('getSubscribersService', ['$http', function($http) {
    var getSubscribers = function(id) {
        return $http.get('rest/storagetraining/getSubscribers?id='+id);

    };
    return getSubscribers;
}]);