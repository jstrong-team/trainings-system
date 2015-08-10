angular.module('trainingEditModule').factory('editService', ['$http','$location', function($http,$location) {
    var edit =function(id, editInfo) {
        editInfo.date=new Array(editInfo.meets.length);
        for(var i=0;i<editInfo.meets.length;i++){
            editInfo.date[i]=editInfo.meets[i].date;
        }
        $http.put('/rest/storagetraining/editTraining?id='+id, editInfo).catch(function(error){
            console.error(error);
        }).then(function(){
            $location.url('/ui/creation_response');
        },function(error){
            console.error(error);
        });
    };
    return edit;
}]);
