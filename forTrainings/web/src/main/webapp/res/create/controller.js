(function(){
    var services = [
        '$scope',
        'createService',
        '$location'
    ];
    var controller =  function($scope, createService, $location) {
        $scope.createInfo = {name: null, annotation: null, description : null, target : null, paid : true,
            max_participants : null, date : [], place : null, internal : true};

        $scope.isTrainingPeriodic = '';

        $scope.error = null;

        $scope.submitForm = function(){

            if ($scope.isTrainingPeriodic !== '') {
                if (Date.parse($scope.firstDate) > Date.parse($scope.lastDate)) {
                    $scope.firstDate = '';
                    $scope.lastDate = '';
                    return;
                }
                $scope.createInfo.date.push($scope.firstDate);
                $scope.createInfo.date.push($scope.lastDate);
            } else {
                $scope.createInfo.date.push($scope.firstDate);
            }

            console.log($scope.createInfo);
            createService.serv($scope.createInfo).then(function(response){
                console.log(response);
                $location.url('/ui/creation_response');
            }, function(error){
                console.error(error);
                $scope.error="Error";
            });
        }

    };

    controller.$inject = services;

    angular.module('createModule').controller('createController', controller);

})();


