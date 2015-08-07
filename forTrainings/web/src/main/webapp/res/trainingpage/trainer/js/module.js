angular.module('trainingPageTrainerModule', []).config(function ($routeProvider) {
    $routeProvider.when('/ui/trainingPage/trainer/:trainingId', {
        templateUrl: 'res/trainingpage/trainer/training.html',
        controller: 'trainingPageTrainerController',
        resolve: {
            getTrainingInfo: ['$q', '$routeParams', '$location', '$route', 'getRole', 'getTrainingData', 'storageService', function ( $q, $routeParams, $location, $route, getRole, getTrainingData, storageService) {
                var def = $q.defer();
                var id = $route.current.params.trainingId;
                storageService.clear();
                getRole(id).then(function (data, status, headers, config) {
                    var role = data.data.role;
                    switch (role) {
                        case 'user':
                            $location.url('/ui/trainingPage/user/' + id);
                            break;
                        case 'trainer':
                            getTrainingData(id).then(function (data, status, headers, config) {
                                def.resolve(data);
                            }, function (error) {
                                if(error.status===401){
                                    $location.url('/ui/');
                                }
                                console.error(error);
                            });
                            break;
                        case 'admin':
                            $location.url('/ui/trainingPage/admin/' + id);
                            break;
                        default:
                            $location.url('/ui/trainings');
                    }
                }, function (error) {
                    if(error.status===401){
                        $location.url('/ui/');
                    }
                    console.error(error);
                });
                return function () {
                    return def.promise;
                };
            }]
        }
    });
});