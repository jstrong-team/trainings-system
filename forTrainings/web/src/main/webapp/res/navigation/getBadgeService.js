angular.module('navigationModule').factory('getBadgeService', ['$http', function($http) {

    var service = {};

    service.badgeCount = function() {
        return $http.get('rest/news/badgeCount').then(
            function(data){
                if (data.data.badgeCount !== 0) {
                    return data.data.badgeCount;
                }
            });
    };
    return service;
}]);