angular.module('trainingEditModule').factory('editService', ['$http', function($http) {
    var edit =function(id, editInfo) {
        $http.post('/rest/storagetraining/editTraining?id='+id, editInfo).then(function(){
            //console.log(response);
        },function(error){
            console.error(error);
        });
    };
    return edit;
}]);
