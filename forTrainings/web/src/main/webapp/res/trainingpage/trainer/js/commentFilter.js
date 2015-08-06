angular.module('trainingPageTrainerModule').filter('yesNoFilter', function () {
    return function (input) {
        input = input || '';
        if (input == true) {
            return 'USER_FEEDBACK_YES';
        } else {
            return 'USER_FEEDBACK_NO';
        }
    };
});