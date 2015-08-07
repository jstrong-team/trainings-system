angular.module('calendarModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/trainings', {
        templateUrl: 'res/calendar/calendar.html',
        controller: 'calendarController',
        resolve: {
            calendarList: ['$http', '$q','$location', function($http, $q, $location){
                var def = $q.defer();
                $http.get('rest/trainings').success(function(data, status){
                    def.resolve(data);
                })
                    .error(function(data, status){
                        if(status===401){
                            $location.url('/ui/');
                        }
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