angular.module('trainingPageModule').factory('absentService', ['$http','storageService',function ($http,storageService) {
    var services={};

    services.prepare = function (subscribers, training) {
        var temp;
        for (var i = 0; i < subscribers.length; i++) {
            temp = subscribers[i].participants;
            subscribers[i].participants = new Array(training.meets.length);
            var index = 0;
            for (var j = 0; (j < training.meets.length) && (index < temp.length); j++) {
                for (var k = 0; k < temp.length; k++) {
                    if (training.meets[j].id == temp[k].meetId) {
                        subscribers[i].participants[j] = temp[k];
                        index++;
                    }
                }
            }
        }
    };

    services.sendAttendance=function (id) {
        console.log(id);
        console.log(storageService.get());
        return $http.post('rest/storagetraining/updateAttendance?id=' + id,storageService.get());
    };

    return services;
}]);