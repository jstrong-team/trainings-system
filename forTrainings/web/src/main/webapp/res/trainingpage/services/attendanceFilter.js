angular.module('trainingPageTrainerModule').filter('attendanceFilter', function () {
    return function (input) {
        input = input || '';
        if (input === true) {
            return 'No';
        } else {
            return '';
        }
    };
});