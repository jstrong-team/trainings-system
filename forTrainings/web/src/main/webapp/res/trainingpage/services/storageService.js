angular.module('trainingPageModule').factory('storageService', ['$http', function ($http) {
    var array=[];

    var service={};

    service.set=function(click){
        array.push(click);
    };
    service.get=function(){
        return angular.copy(array);
    };
    service.delete=function(click){
        for(var i=array.length-1;i>=0;i--){
            if((array[i].id===click.id)&&(array[i].date===click.date)){
                array.splice(i,1);
            }
        }
    };
    service.clear=function(){
        array=[];
    };
    return service;
}]);