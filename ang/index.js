var myMod=angular.module("app",['ngRoute','trainings']);
// myMod.run(['$rootScope',function(oot){
// 	oot.hello="asdfasd";
// }]);
myMod.controller('appController',['$rootScope',function($scope){
	$scope.hello="zxczxc";

}])

var trainings=angular.module('trainings',[]);

trainings.controller('trainingsController',['$scope',function($scope){
	$scope.hello='asdas11';
}])

trainings.controller('newTrainingsController',['$scope',function($scope){
	$scope.hello='new';
}])

trainings.config(function($routeProvider) {
  $routeProvider
   .when('/', {
    templateUrl : 'http://localhost:8080/index.jsp',
    controller: 'trainingsController',
    // resolve: {
    //   // I will cause a 1 second delay
    //   delay: function($q, $timeout) {
    //     var delay = $q.defer();
    //     $timeout(delay.resolve, 1000);
    //     return delay.promise;
    //   }
    // }
  })
      .when('/trainings', {
    template: '{{hello}}',
    controller: 'newTrainingsController'
  })
});