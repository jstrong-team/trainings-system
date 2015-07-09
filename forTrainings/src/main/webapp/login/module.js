angular.module('loginModule',[]).config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'login/login.html',
            controller: 'loginController'
            // resolve: {
            //   // I will cause a 1 second delay
            //   delay: function($q, $timeout) {
            //     var delay = $q.defer();
            //     $timeout(delay.resolve, 1000);
            //     return delay.promise;
            //   }
            // }
        })
});