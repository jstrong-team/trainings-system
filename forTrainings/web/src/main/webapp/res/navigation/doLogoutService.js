angular.module('navigationModule').factory('doLogoutService', ['$http', function($http) {
    var doDeleteRequest = function(expression) {
        return $http.delete('/rest/trainings');
    };
    return doDeleteRequest;
}]);