angular.module('createModule').factory('createService', ['$http', function ($http) {
    var service = {
        serv: function (createInfo) {
            return $http.post('/rest/storagetraining', createInfo);
        }
    };
    return service;
}]);
