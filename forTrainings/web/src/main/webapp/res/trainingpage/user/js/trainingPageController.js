angular.module('trainingPageModule').controller('trainingPageController',['$scope','getTrainingInfo', function($scope,getTrainingInfo) {

    $scope.temp1='directive context';

    $scope.feedback={
        understand:null,
        interested:null,
        continueWithThisTrainer:null,
        smthNew:null,
        recommend:null,
        rate:null,
        other:null
    };

    $scope.submit=function(){
        console.log($scope.feedback)
    }

    getTrainingInfo().then(function(data, status, headers, config) {
        //console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa33");
        //console.log(data.data[0]);
        $scope.training=data.data[0];
        $scope.trainingDate=new Date(data.data[0].date);
    });


}]);









//$scope.format = 'dd-MMMM-yyyy';
//
//var tomorrow = new Date();
//tomorrow.setDate(tomorrow.getDate() + 1);
//var afterTomorrow = new Date();
//afterTomorrow=new Date('2015-06-04 12:00:00');
//$scope.events = [
//    {
//        date: tomorrow,
//        status: 'full'
//    },
//    {
//        date: afterTomorrow,
//        status: 'partially'
//    }
//];
//
//$scope.getDayClass = function(date, mode) {
//    if (mode === 'day') {
//        var dayToCheck = new Date(date).setHours(0,0,0,0);
//        for (var i=0;i<$scope.events.length;i++){
//            var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);
//            if (dayToCheck === currentDay) {
//                return $scope.events[i].status;
//            }
//        }
//    }
//    return '';
//};
