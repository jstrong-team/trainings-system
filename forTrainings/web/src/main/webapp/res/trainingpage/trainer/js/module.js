angular.module('trainingPageTrainerModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/trainingPage/trainer/:trainingId', {
        templateUrl: 'res/trainingpage/trainer/training.html',
        controller: 'trainingPageTrainerController',
        resolve: {
            getTrainingInfo: ['$http', '$q','$routeParams','$location','$route', function ($http, $q,$routeParams,$location,$route) {
                var def = $q.defer();
                //console.log($route.current.params.trainingId);
                $http.get('rest/storagetraining/role?id=' + $route.current.params.trainingId).then(function (data, status, headers, config){
                    if (data.data.role === 'trainer') {
                        $location.url('/ui/trainingPage/trainer/' + $route.current.params.trainingId);
                        $http.get('rest/storagetraining/getTraining?id='+$route.current.params.trainingId).then(function (data, status, headers, config) {
                            console.log(data);
                            def.resolve(data);
                        }, function (error) {
                            console.error(error);
                        });

                    } else if (data.data.role === 'user') {
                        $location.url('/ui/trainingPage/user/' + $route.current.params.trainingId);
                    } else {
                        $location.url('/ui/trainings');
                    }
                }, function (error) {
                    console.error(error);
                });
                return function () {
                    return def.promise;
                };
            }]
        }
    });
});