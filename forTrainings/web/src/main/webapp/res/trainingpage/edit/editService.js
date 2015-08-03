angular.module('trainingEditModule').factory('editService', ['$http', function($http) {
    var edit =function(id, editInfo) {
        $http.put('/rest/storagetraining/editTraining?id='+id, editInfo).catch(function(error){
            console.error(error);
        });
    };
    return edit;
}]);
