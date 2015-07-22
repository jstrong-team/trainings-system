angular.module('trainingPageTrainerModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/trainingPage/trainer', {
        templateUrl: 'res/trainingpage/trainer/training.html',
        controller: 'trainingPageTrainerController',
        resolve: {
            getTrainingInfo: ['$http', '$q', function($http, $q){
                var def = $q.defer();
                $http.get('rest/trainings/searchTrainings?param=block1&search=oracle').then(function(data, status, headers, config){
                    console.log(data);
                    def.resolve(data);
                }, function(error){
                    console.error(error);
                });
                return  function() {
                    return def.promise;
                }
            }]
        }
    });
});