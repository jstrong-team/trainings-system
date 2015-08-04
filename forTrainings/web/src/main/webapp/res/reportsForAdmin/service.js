angular.module('reportsModule').factory('reportInfoFormat', function() {
    var doInfoFormat = function(data) {
        for (var i = 0; i < data.length; ++i) {
            data[i].date = moment(data[i].date).format('YYYY-MM-DD HH:mm');
            if (data[i].absent === true) {
                data[i].absent = 'REPORTS_TABLE_ATTENDANCE_VALUE_TRUE';
            } else {
                data[i].absent = 'REPORTS_TABLE_ATTENDANCE_VALUE_FALSE';
            }
        }
        return data;
    };
    return doInfoFormat;
});