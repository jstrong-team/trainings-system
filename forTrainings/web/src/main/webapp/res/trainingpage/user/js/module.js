angular.module('trainingPageModule', []).config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/ui/trainingPage/user/:trainingId', {
        templateUrl: 'res/trainingpage/user/training.html',
        controller: 'trainingPageController',
        resolve: {
            getTrainingInfo: ['$http', '$q','$routeParams','$location','$route','getRole','getTrainingData', function ($http, $q,$routeParams,$location,$route,getRole,getTrainingData) {
                var def = $q.defer();
                var id=$route.current.params.trainingId;
                getRole(id).then(function (data, status, headers, config){

                    var role = data.data.role;
                    switch (role) {
                        case 'user':
                            getTrainingData(id).then(function (data, status, headers, config) {
                                def.resolve(data);
                            }, function (error) {
                                console.error(error);
                            });
                            break;
                        case 'trainer':
                            $location.url('/ui/trainingPage/trainer/' + id);
                            break;
                        case 'admin':
                            $location.url('/ui/trainingPage/admin/' + id);
                            break;
                        default:
                            $location.url('/ui/trainings');
                    }


                    if (data.data.role === 'user') {
                        getTrainingData(id).then(function (data, status, headers, config) {
                            def.resolve(data);
                        }, function (error) {
                            console.error(error);
                        });
                    } else if (data.data.role === 'trainer') {
                        $location.url('/ui/trainingPage/trainer/' + id);
                    } else if (data.data.role === 'admin') {
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
}]);