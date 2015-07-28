angular.module('trainingPageModule').factory('getTrainingData', ['$http', function($http) {
    var getrole = function(id) {
        return $http.get('rest/storagetraining/getTraining?id='+id);
    };
    return getrole;
}]);