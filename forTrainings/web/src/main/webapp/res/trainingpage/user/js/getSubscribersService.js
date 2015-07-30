//angular.module('trainingPageModule').factory('getSubscribersService', ['$http','$q', function($http,$q) {
//    var getSubscribers = function(id) {
//        var def = $q.defer();
//        $http.get('rest/storagetraining/getSubscribers?id='+id).then(function(data, status, headers, config){
//            def.resolve(data);
//        },function(reject){
//            console.error(reject);
//        });
//            return def.promise;
//    };
//    return getSubscribers;
//}]);

angular.module('trainingPageModule').factory('getSubscribersService', ['$http', function($http) {
    var getSubscribers = function(id) {
        return $http.get('rest/storagetraining/getSubscribers?id='+id);

    };
    return getSubscribers;
}]);