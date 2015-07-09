angular.module('loginModule').factory('loginService', ['$http', function($http) {
    var service = {a: function(credit) {
        return $http.post('/forTrainings', credit);
    }};
    return service;
}]);