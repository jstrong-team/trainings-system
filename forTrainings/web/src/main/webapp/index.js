var myMod=angular.module("app",['ngRoute','trainingsModule','loginModule']);
// myMod.run(['$rootScope',function(oot){
// 	oot.hello="asdfasd";
// }]);
myMod.controller('appController',['$rootScope',function($scope){
    //$scope.hello="zxczxc";
}]);



//var trainings=angular.module('trainings',[]);
//
//trainings.controller('trainingsController',['$scope',function($scope){
//    //$scope.hello='asdas11';
//}]);