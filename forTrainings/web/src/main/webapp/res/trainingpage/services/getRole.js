angular.module('trainingPageModule').factory('getRole', ['$http', function($http) {
    var getrole = function(id) {
        return $http.get('rest/storagetraining/role?id=' + id);
    };
    return getrole;
}]);