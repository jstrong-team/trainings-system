angular.module('trainingPageModule', []).config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/ui/trainingPage/:trainingId', {
        templateUrl: 'res/trainingpage/user/training.html',
        controller: 'trainingPageController',
        resolve: {
            getTrainingInfo: ['$http', '$q','$routeParams', function ($http, $q,$routeParams) {
                var def = $q.defer();
                console.log($routeParams.trainingId);
                $http.get('rest/trainings/searchTrainings?search=java').then(function (data, status, headers, config) {
                    def.resolve(data);
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