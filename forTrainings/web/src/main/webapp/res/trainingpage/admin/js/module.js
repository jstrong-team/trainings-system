angular.module('trainingPageAdminModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/trainingPage/admin/:trainingId', {
        templateUrl: 'res/trainingpage/admin/training.html',
        controller: 'trainingPageAdminController',
        resolve: {
            getTrainingInfo: ['$http', '$q','$routeParams','$location','$route', 'getRole','getTrainingData',function ($http, $q,$routeParams,$location,$route,getRole,getTrainingData) {
                var def = $q.defer();
                var id=$route.current.params.trainingId;
                getRole(id).then(function (data, status, headers, config){
                    if (data.data.role === 'admin') {
                        getTrainingData(id).then(function (data, status, headers, config) {
                            def.resolve(data);
                        }, function (error) {
                            console.error(error);
                        });
                    } else if (data.data.role === 'user') {
                        $location.url('/ui/trainingPage/user/' + id);
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