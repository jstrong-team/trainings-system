angular.module('navigationModule').factory('dateFormatService', [function() {
    var result = function(data) {
        for (var i = 0; i < data.length; ++i) {
            data[i].time=[];
            data[i].dateTime=[];
            data[i].year=[];
            for(var j=0;j<data[i].dates.length;j++) {
                data[i].time.push(moment(data[i].dates[j]).format('HH:mm'));
                data[i].dateTime.push(moment(data[i].dates[j]).format('DD MMMM'));
                data[i].year.push(moment(data[i].dates[j]).format('YYYY'));
            }
        }
    };
    return result;
}]);