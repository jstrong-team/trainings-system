angular.module('calendarModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/trainings', {
            templateUrl: 'res/calendar/calendar.html',
            controller: 'calendarController',
            resolve: {
                calendarList: ['$http', '$q', function($http, $q){
                    var def = $q.defer();
                    $http.get('rest/trainings').success(function(data, status){
                        def.resolve(data);
                    })
                        .error(function(data, status){
                            console.log(status);
                            return data;
                        });
                    return {
                        getCalendarInfo: function() {
                            return def.promise;
                        }
                    };
                }]
            }
        });
});