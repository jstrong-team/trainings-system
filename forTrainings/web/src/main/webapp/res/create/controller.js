(function(){
    var services = [
        '$scope',
        'createService',
        '$location'
    ];
    var controller =  function($scope, createService, $location) {
        $scope.createInfo = {name: null, annotation: null, description : null, target : null, paid : true,
            max_participants : null, date : null, place : null, internal : true};
        $scope.error = null;

        $scope.submitForm = function(){
            console.log($scope.createInfo);
            createService.serv($scope.createInfo).then(function(response){
                console.log(response);
                $location.url('/ui/training_was_created');

            }, function(error){
                console.error(error);
                $scope.error="Wrong login or password";
            });
        }

    };

    controller.$inject = services;

    angular.module('createModule').controller('createController', controller);

})();


