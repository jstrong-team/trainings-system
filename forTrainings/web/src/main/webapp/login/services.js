angular.module('loginModule').factory('loginService',['$http',function($http){
    var service={serv: function(credationals){
        return $http.post('/forTrainings',credationals);
    }};
    return service;
}])