angular.module('trainingPageModule').controller('trainingPageController', ['$scope', 'getTrainingInfo', '$http', '$modal', '$routeParams','getSubscribersService','$route','unsubscribeService', function ($scope, getTrainingInfo, $http, $modal, $routeParams,getSubscribersService,$route,unsubscribeService) {

    $scope.isCollapsed = false;

    $scope.feedback = {
        understand: null,
        interested: null,
        continueWithThisTrainer: null,
        smthNew: null,
        recommend: null,
        rate: null,
        other: null
    };

    $scope.openModal = function () {

        var modalInstance = $modal.open({
            animation: true,
            templateUrl: '/res/trainingpage/user/feedbackModal.html',
            controller: 'ModalInstanceCtrl',
            size: 'lg',
            resolve: {
                feedbacks: function () {
                    return {
                        feedback: $scope.feedback,
                        trainingId: $scope.training.id
                    };
                }
            }
        });

        modalInstance.result.then(function (response) {
            console.log(response);
        }, function (error) {
            console.log(error);
        });
    };
    //TODO:  move http post in service
    $scope.subscribe = function () {
        console.log('/ui/trainingPage/user/'+$scope.training.id);
        $route.reload();
        $http.post('/rest/storagetraining/addsubscriber?id='+ $scope.training.id, $scope.feedback).then(function (response) {
            //console.log(response);
        }, function (error) {
            console.log(error);
        });
    };

    $scope.unsubscribe=function(){
        unsubscribeService($scope.training.id).then(function(response){
            console.log(response);
            $route.reload();
        },function(error){
            console.error(error);
        });
    };

    getTrainingInfo().then(function (data, status, headers, config) {
        console.log(data.data);
        $scope.training=data.data;
        $scope.training.time=[];
        $scope.training.dateTime=[];
        $scope.training.year=[];
        console.log($scope.training);
        for(var j=0;j<$scope.training.dates.length;j++) {
            $scope.training.time.push(moment($scope.training.dates[j]).format('HH:mm'));
            $scope.training.dateTime.push(moment($scope.training.dates[j]).format('DD MMMM'));
            $scope.training.year.push(moment($scope.training.dates[j]).format('YYYY'));
        }
        getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
            $scope.subscribers=data.data;
        }, function (error) {
            console.log(error);
        });
        //getSubscribers
    });
}]);
