angular.module('trainingsModule',[]).config(function($routeProvider) {
    $routeProvider
        .when('/trainings', {
            templateUrl: 'res/trainings/employee.html',
            controller: 'trainingsController',
            resolve: {
                threeMonthList: ['$http', '$q', function($http, $q){
                    var def = $q.defer();
                    $http.get('forTrainings/trainings/trainingHistory?param=2&id=' + localStorage.getItem('id')).success(function(data, status){
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
        })
});