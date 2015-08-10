angular.module('trainingPageModule').factory('openModalService', ['$http','$modal', function($http,$modal) {
    var open = function(feedbackForm,id) {
        var modalInstance = $modal.open({
            animation: true,
            templateUrl: '/res/trainingpage/user/feedbackModal.html',
            controller: 'ModalInstanceCtrl',
            resolve: {
                feedbacks: function () {
                    return {
                        feedback: feedbackForm,
                        trainingId: id
                    };
                }
            }
        });
        modalInstance.result.then(function () {
        }, function (error) {
            console.error(error);
        });
    };
    return open;
}]);