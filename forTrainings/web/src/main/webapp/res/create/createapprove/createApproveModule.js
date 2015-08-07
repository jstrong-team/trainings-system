angular.module('createApproveModule', []).config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/ui/trainingPage/approveCreate/:trainingId', {
        templateUrl: 'res/create/createapprove/createApprovePage.html',
        controller: 'createApproveController',
        resolve: {
            getApproveData: ['$http', '$q', '$routeParams', '$location', '$route', 'getRole', 'getTrainingData', function ($http, $q, $routeParams, $location, $route, getRole, getTrainingData) {
                var def = $q.defer();
                var id = $route.current.params.trainingId;
                getRole(id).then(function (data, status, headers, config) {
                    if (data.data.role === 'admin') {
                        $http.get('rest/storagetraining//getNotApprovedTraining?id='+id).then(function (data, status, headers, config) {
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