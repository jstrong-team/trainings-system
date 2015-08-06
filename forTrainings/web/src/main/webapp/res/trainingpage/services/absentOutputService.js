angular.module('trainingPageModule').factory('absentOutputService', [function () {
    var services={};
    services.prepare = function (subscribers, training) {
        //console.log('sssssssssssssssssssssssssssssssssssssssssssssss');
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
    return services;
}]);