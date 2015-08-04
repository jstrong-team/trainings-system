angular.module('trainingEditModule').factory('editService', ['$http', function($http) {
    var edit =function(id, editInfo) {
        console.log(editInfo);
        editInfo.date=new Array(editInfo.meets.length);
        for(var i=0;i<editInfo.meets.length;i++){
            editInfo.date[i]=editInfo.meets[i].date;
        }
        $http.put('/rest/storagetraining/editTraining?id='+id, editInfo).catch(function(error){
            console.error(error);
        });
    };
    return edit;
}]);
