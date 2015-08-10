angular.module('reportsModule').factory('reportInfoFormat', function() {
    var doInfoFormat = function(data) {
        for (var i = 0; i < data.length; ++i) {
            for (var j = 0; j < data[i].users.length; ++j) {
                for (var k = 0; k < data[i].users[j].meets.length; ++k) {
                    data[i].users[j].meets[k].date = moment(data[i].users[j].meets[k].date).format('YYYY-MM-DD HH:mm');
                    if (data[i].users[j].meets[k].absent === true) {
                        data[i].users[j].meets[k].absent = 'REPORTS_TABLE_ATTENDANCE_VALUE_TRUE';
                    } else {
                        data[i].users[j].meets[k].absent = 'REPORTS_TABLE_ATTENDANCE_VALUE_FALSE';
                    }
                }
            }
        }
        return data;
    };
    return doInfoFormat;
});