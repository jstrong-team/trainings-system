angular.module('trainingPageTrainerModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/trainingPage/trainer/:trainingId', {
        templateUrl: 'res/trainingpage/trainer/training.html',
        controller: 'trainingPageTrainerController',
        resolve: {
            getTrainingInfo: ['$http', '$q','$routeParams','$location','$route', 'getRole','getTrainingData','storageService',function ($http, $q,$routeParams,$location,$route,getRole,getTrainingData,storageService) {
                var def = $q.defer();
                var id=$route.current.params.trainingId;
                storageService.clear();
                getRole(id).then(function (data, status, headers, config){
                    if (data.data.role === 'trainer') {
                        $location.url('/ui/trainingPage/trainer/' + id);
                        getTrainingData(id).then(function (data, status, headers, config) {
                            console.log(data);
                            def.resolve(data);
                        }, function (error) {
                            console.error(error);
                        });

                    } else if (data.data.role === 'user') {
                        $location.url('/ui/trainingPage/user/' + id);
                    }else if (data.data.role === 'admin') {
                        $location.url('/ui/trainingPage/admin/' + id);
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