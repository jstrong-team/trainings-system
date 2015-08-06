angular.module('approvePageModule').factory('getApproveDataService', ['$http', function($http) {
    var getrole = function(id) {
        return $http.get('rest/storagetraining/mergeTrainings?id='+id);
    };
    return getrole;
}]);