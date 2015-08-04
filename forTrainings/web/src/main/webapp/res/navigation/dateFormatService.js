angular.module('navigationModule').factory('dateFormatService', [function () {
    var result = function (data) {

        var months = ['CALENDAR_MONTH_CASE_JANUARY', 'CALENDAR_MONTH_CASE_FEBRUARY', 'CALENDAR_MONTH_CASE_MARCH',
            'CALENDAR_MONTH_CASE_APRIL', 'CALENDAR_MONTH_CASE_MAY', 'CALENDAR_MONTH_CASE_JUNE', 'CALENDAR_MONTH_CASE_JULY',
            'CALENDAR_MONTH_CASE_AUGUST', 'CALENDAR_MONTH_CASE_SEPTEMBER', 'CALENDAR_MONTH_CASE_OCTOBER',
            'CALENDAR_MONTH_CASE_NOVEMBER', 'CALENDAR_MONTH_CASE_DECEMBER'];

        for (var i = 0; i < data.length; ++i) {
            data[i].time = [];
            data[i].dateNum = [];
            data[i].month = [];
            data[i].year = [];
            for (var j = 0; j < data[i].dates.length; j++) {
                data[i].time.push(moment(data[i].dates[j]).format('HH:mm'));
                data[i].dateNum.push(moment(data[i].dates[j]).format('DD'));
                data[i].month.push(months[moment(data[i].dates[j]).month()]);
                data[i].year.push(moment(data[i].dates[j]).format('YYYY'));
            }
        }
    };
    return result;
}]);