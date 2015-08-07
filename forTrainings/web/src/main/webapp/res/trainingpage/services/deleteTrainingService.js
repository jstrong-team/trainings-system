angular.module('trainingPageModule').factory('deleteTrainingService', ['$http','$location', function($http,$location) {
    var remove = function(id) {
        return $http.delete('rest/storagetraining/deleteTraining?trainingId='+id).then(function(){
            $location.url('ui/trainings');
        }, function(error){
            if(error.status===401){
                $location.url('/ui/');
            }
            console.log(error);
        });
    };
    return remove;
}]);