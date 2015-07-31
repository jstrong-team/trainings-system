angular.module('loginModule').factory('loginService', ['$http', function($http) {
    var service = {serv : function(credationals) {
        return $http.post('/rest/login', credationals);
    }};
    return service;
}]);