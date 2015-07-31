angular.module('trainingPageModule').factory('storageService', ['$http', function ($http) {
    var array=[];
    var set=function(click){
        array.push(click);
    };
    var get=function(){
        return angular.copy(array);
    };
    var deleteRecord=function(click){
        for(var i=array.length-1;i>=0;i--){
            if((array[i].id===click.id)&&(array[i].date===click.date)){
                array.splice(i,1);
            }
        }
    };
    return {
        get:get,
        set:set,
        delete:deleteRecord
    };
}]);