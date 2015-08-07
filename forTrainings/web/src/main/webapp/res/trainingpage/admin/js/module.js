angular.module('trainingPageAdminModule', []).config(function ($routeProvider) {
    $routeProvider.when('/ui/trainingPage/admin/:trainingId', {
        templateUrl: 'res/trainingpage/admin/training.html',
        controller: 'trainingPageAdminController',
        resolve: {
            getTrainingInfo: ['$http', '$q', '$routeParams', '$location', '$route', 'getRole', 'getTrainingData', 'storageService',
                function ($http, $q, $routeParams, $location, $route, getRole, getTrainingData, storageService) {
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
                                $location.url('/ui/trainingPage/trainer/' + id);
                                break;
                            case 'admin':
                                getTrainingData(id).then(function (data, status, headers, config) {
                                    def.resolve(data);
                                }, function (error) {
                                    console.error(error);
                                });
                                break;
                            default:
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