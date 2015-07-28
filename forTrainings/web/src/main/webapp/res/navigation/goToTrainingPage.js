angular.module('navigationModule').factory('goToTrainingPage', ['$http', function($http) {
    var redirect = function(id) {
        return $http.get('rest/storagetraining/role?id=' + id);
    };
    return redirect;
}]);