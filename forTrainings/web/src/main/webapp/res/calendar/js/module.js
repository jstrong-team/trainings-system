angular.module('calendarModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/trainings', {
            templateUrl: 'res/calendar/calendar.html',
            controller: 'calendarController',
            resolve: {
                threeMonthList: ['$http', '$q', function($http, $q){
                    var def = $q.defer();
                    $http.get('rest/trainings?param=2&id=' + localStorage.getItem('id')).success(function(data, status){
                        def.resolve(data);
                    })
                        .error(function(data, status){
                            console.log(status);
                            return data;
                        });
                    return {
                        getThreeMonthList: function() {
                            return def.promise;
                        }
                    }
                }]
            }
        });
});