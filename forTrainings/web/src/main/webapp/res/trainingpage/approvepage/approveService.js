angular.module('approvePageModule').factory('approveService', ['$rootScope','$http','$location', function($rootScope,$http,$location) {
    var service={};

    service.approveCreate = function(id) {
        $http.put('rest/storagetraining/approveNew',{
            trainingId:id,
            adminAnswer:'Approve'
        }).then(function(){
            $location.url('/ui/news');
        }, function(error){
            console.error(error);
        });
    };

    service.dismissCreate = function(id) {
        $http.put('rest/storagetraining/approveNew',{
            trainingId:id,
            adminAnswer:'Dismiss'
        }).then(function(){
            $location.url('/ui/news');
        }, function(error){
            console.error(error);
        });
    };

    service.approve = function(id) {
        $http.put('rest/storagetraining/approve',{
            transactionId:id,
            adminAnswer:'Approve'
        }).then(function(){
            $location.url('/ui/news');
        }, function(error){
            console.error(error);
        });
    };

    service.dismiss = function(id) {
        $http.put('rest/storagetraining/approve',{
            transactionId:id,
            adminAnswer:'Dismiss'
        }).then(function(){
            //$rootScope.$broadcast('removeNewsItem');
            $location.url('/ui/news');
        }, function(error){
            console.error(error);
        });
    };
    return service;
}]);