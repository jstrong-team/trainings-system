angular.module('createModule').factory('createService', ['$http', function($http) {
    var service = {serv : function(createInfo) {
        console.log(createInfo);
        return $http.post('/rest/newtraining', createInfo);
    }};
    return service;
}]);
