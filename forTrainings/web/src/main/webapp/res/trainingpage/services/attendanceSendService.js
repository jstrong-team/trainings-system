angular.module('trainingPageTrainerModule').factory('attendanceSendService', ['$http','storageService', function ($http,storageService) {
    var accept = function (id) {
        console.log(id);
        console.log(storageService.get());
        return $http.post('rest/storagetraining/updateAttendance?id=' + id,storageService.get());
    };
    return accept;
}]);