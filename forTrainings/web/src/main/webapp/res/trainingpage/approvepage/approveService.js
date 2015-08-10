angular.module('approvePageModule').factory('approveService', ['$rootScope','$http','$location', function($rootScope,$http,$location) {
    var service={};

    service.approveCreate = function(id) {
        console.log({
            trainingId:id,
            adminAnswer:'Approve'
        });
        $http.put('rest/storagetraining/approveNew',{
            trainingId:id,
            adminAnswer:'Approve'
        }).then(function(){
            $location.url('/ui/news');
        }, function(error){
            console.log(error);
        });
    };

    service.dismissCreate = function(id) {
        console.log({
            trainingId:id,
            adminAnswer:'Approve'
        });
        $http.put('rest/storagetraining/approveNew',{
            trainingId:id,
            adminAnswer:'Dismiss'
        }).then(function(){
            $location.url('/ui/news');
        }, function(error){
            console.log(error);
        });
    };

    service.approve = function(id) {
        console.log({
            transactionId:id,
            adminAnswer:'Approve'
        });
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
        console.log({
            transactionId:id,
            adminAnswer:'Approve'
        });
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