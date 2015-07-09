var myMod=angular.module("app",['ngRoute','trainings','loginModule']);
// myMod.run(['$rootScope',function(oot){
// 	oot.hello="asdfasd";
// }]);
myMod.controller('appController',['$rootScope',function($scope){
    //$scope.hello="zxczxc";

}])



var trainings=angular.module('trainings',[]);

trainings.controller('trainingsController',['$scope',function($scope){
    //$scope.hello='asdas11';
}])

trainings.controller('newTrainingsController',['$scope',function($scope){
    //$scope.hello='new';
}])

trainings.config(function($routeProvider) {
            $routeProvider
                .when('/trainings', {
                    templateUrl: 'employee.html',
                    controller: 'newTrainingsController',
                    resolve: {}
                })
});