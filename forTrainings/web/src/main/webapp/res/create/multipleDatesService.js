/**
 * Created by Ittp on 29.07.2015.
 */
angular.module('createModule').factory('multipleDatesService', function () {

    return {

        multiple: function (first, last, selectedDays) {
            var datesArray = [];

            datesArray.push(first);
            for (var d = 0; d < selectedDays.length; ++d) {
                var i = 0;
                var nextDay = moment(first).day(moment(first).day() + 1);
                var iterationDay = nextDay;
                while (selectedDays[d] != iterationDay.day()) {
                    ++i;
                    iterationDay = moment(first).day(moment(first).day() + i + 1);
                }

                i = 0;
                while (Date.parse(moment(iterationDay).format('YYYY-MM-DD')) < Date.parse(moment(last).format('YYYY-MM-DD'))) {
                    var result = iterationDay.format('YYYY-MM-DD HH:mm');
                    datesArray.push(result);
                    iterationDay = iterationDay.day(iterationDay.day() + 7);
                }
            }
            datesArray.push(last);

            return datesArray;
        }
    };
});
