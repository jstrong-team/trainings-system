angular.module('trainingEditModule', []).config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/ui/trainingPage/edit/:trainingId', {
        templateUrl: 'res/trainingpage/edit/edit.html',
        controller: 'editController',
        resolve: {
            getTrainingInfo: ['$http', '$q','$routeParams','$location','$route', 'getRole','getTrainingData',function ($http, $q,$routeParams,$location,$route,getRole,getTrainingData) {
                var def = $q.defer();
                var id=$route.current.params.trainingId;
                getRole(id).then(function (data, status, headers, config){
                    if (data.data.role === 'trainer'||data.data.role === 'admin') {
                        getTrainingData(id).then(function (data, status, headers, config) {
                            console.log(data);
                            def.resolve(data);
                        }, function (error) {
                            console.error(error);
                        });
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
}]);