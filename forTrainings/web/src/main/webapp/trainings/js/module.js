angular.module('trainingsModule',[]).config(function($routeProvider) {
    $routeProvider
        .when('/trainings', {
            templateUrl: 'trainings/employee.html',
            controller: 'trainingsController',
            // resolve: {
            //   trainings: getTrainingsService().then(function(response){
            //       console.log(response.data);
            //   }, function(error){
            //       console.error(error);
            //   })
            //}
        })
});