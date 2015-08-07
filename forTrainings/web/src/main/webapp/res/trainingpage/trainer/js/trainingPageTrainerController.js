(function () {
    var services = [
        '$scope',
        '$location',
        'getTrainingInfo',
        'getSubscribersService',
        'getFeedbacksService',
        '$modal',
        'absentService'
    ];
    var controller = function ($scope,
                               $location,
                               getTrainingInfo,
                               getSubscribersService,
                               getFeedbacksService,
                               $modal,
                               absentService) {

        $scope.isCollapsed = {
            dates: true,
            subscribers: false
        };

        $scope.show = {
            subscribers: 'TRAINING_PAGE_HIDE',
            dates: 'TRAINING_PAGE_SHOW'
        };

        $scope.acceptAttendanceChanges=function(){
            absentService.sendAttendance($scope.training.id);
        };

        $scope.changeCollapse = {
            dates: function () {
                $scope.isCollapsed.dates = !$scope.isCollapsed.dates;
                if ($scope.isCollapsed.dates) {
                    $scope.show.dates ='TRAINING_PAGE_SHOW';
                } else {
                    $scope.show.dates ='TRAINING_PAGE_HIDE';
                }
            },
            subscribers: function () {
                $scope.isCollapsed.subscribers = !$scope.isCollapsed.subscribers;
                if ($scope.isCollapsed.subscribers) {
                    $scope.show.subscribers = 'TRAINING_PAGE_SHOW';
                } else {
                    $scope.show.subscribers = 'TRAINING_PAGE_HIDE';
                }
            }
        };

        $scope.trainerFeedback = {
            employeeId:null,
            presence:null,
            attitude:null,
            communication:null,
            question:null,
            interest:null,
            result:null,
            level:null,
            rating:null,
            other:null
        };


        $scope.openModal = function () {
            var modalInstance = $modal.open({
                animation: true,
                templateUrl: '/res/trainingpage/trainer/userRevieModal.html',
                controller: 'userRevieModalController',
                resolve: {
                    feedbacks: function () {
                        return {
                            feedback: $scope.trainerFeedback,
                            trainingId: $scope.training.id,
                            subscribers:$scope.subscribers
                        };
                    }
                }
            });
            modalInstance.result.then(function (response) {
                console.log(response);
            }, function (error) {
                if(error.status===401){
                    $location.url('/ui/');
                }
                console.error(error);
            });

        };

        $scope.editTraining = function () {
            $location.url('/ui/trainingPage/edit/' + $scope.training.id);
        };

        getTrainingInfo().then(function (data, status, headers, config) {
            $scope.training = data.data;
            $scope.training.time = [];
            $scope.training.dateTime = [];
            $scope.training.year = [];
            for (var j = 0; j < $scope.training.meets.length; j++) {
                $scope.training.time.push(moment($scope.training.meets[j].date).format('HH:mm'));
                $scope.training.dateTime.push(moment($scope.training.meets[j].date).format('DD MMMM'));
                $scope.training.year.push(moment($scope.training.meets[j].date).format('YYYY'));
            }
            getSubscribersService($scope.training.id).then(function (data, status, headers, config) {
                $scope.subscribers = data.data;
                absentService.prepare($scope.subscribers, $scope.training);
            }, function (error) {
                if(error.status===401){
                    $location.url('/ui/');
                }
                console.error(error);
            });
            getFeedbacksService($scope.training.id).then(function (data, status, headers, config) {
                $scope.feedbacks = data.data;
            }, function (error) {
                if(error.status===401){
                    $location.url('/ui/');
                }
                console.error(error);
            });
        });

    };
    controller.$injet = services;
    angular.module('trainingPageTrainerModule').controller('trainingPageTrainerController', controller);
})();




