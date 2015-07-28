angular.module('editModule').factory('editService', ['$http', function($http) {
    var service = {serv : function(id, editInfo) {
        console.log(editInfo);
        //return $http.post('/rest/storagetraining/editFeedback?id='+id, editInfo);
    }};
    return service;
}]);
