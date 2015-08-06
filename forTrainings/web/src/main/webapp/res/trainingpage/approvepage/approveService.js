angular.module('approvePageModule').factory('approveService', ['$http','$location', function($http,$location) {
    var service={};
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
            console.log(error);
        });
    };
    return service;
}]);