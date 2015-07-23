angular.module('trainingPageModule').controller('trainingPageController',['$scope','getTrainingInfo','$http','$modal', function($scope,getTrainingInfo,$http,$modal) {

    $scope.training={
        name: 'JAVA SUPER DUPER TRAINING',
        annotation: '$apply() is used to execute an expression in angular from outside of the angular framework. ' +
        '(For example from browser DOM events, setTimeout, XHR or third party libraries). Because we are calling ' +
        'into the angular framework we need to perform proper scope life cycle of exception handling, executing watches.',
        description : '$apply() is used to execute an expression in angular from ',
        target : 'kids, bamby,white panda,black panda, anton grigoriev',
        paid : true,
        max_participants :10,
        date : ['2015-06-04 12:00:00'],
        place : '243',
        internal : true};

    $scope.paticipants=[{name:'fedia',lastname:'petrov'}];

    $scope.feedback={
        understand:null,
        interested:null,
        continueWithThisTrainer:null,
        smthNew:null,
        recommend:null,
        rate:null,
        other:null
    };

    $scope.openModal = function () {

        var modalInstance = $modal.open({
            animation: true,
            templateUrl: 'myModalContent.html',
            controller: 'ModalInstanceCtrl',
            size: 'lg',
            resolve: {
                items: function () {
                    return $scope.feedback;
                }
            }
        });
        modalInstance.result.then(function (response) {
            console.log(response);
        }, function (error) {
            console.log(error);
        });
    };




    getTrainingInfo().then(function(data, status, headers, config) {
        //console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa33");
        //console.log(data.data[0]);
        //$scope.training=data.data[0];
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
