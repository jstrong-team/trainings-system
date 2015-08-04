angular.module('trainingPageModule').factory('storageService', ['$http', function ($http) {
    var array=[];

    var service={};

    service.set=function(click){
        array.push(click);
    };
    service.get=function(){
        return {participant:array};
    };
    service.delete=function(click){
        for(var i=array.length-1;i>=0;i--){
            if((array[i].subscribeId===click.subscribeId)&&(array[i].meetId===click.meetId)){
                array.splice(i,1);
            }
        }
    };
    service.clear=function(){
        array=[];
    };
    return service;
}]);