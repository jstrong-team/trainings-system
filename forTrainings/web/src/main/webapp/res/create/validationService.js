angular.module('createModule').factory('validationService', function () {

    return {

        oneTime: function (first) {

            var DATE_VALIDATION_ERROR = 'DATE_VALIDATION_ERROR';
            var DATE_VALIDATION_LATER_THAN_CURRENT = 'DATE_VALIDATION_LATER_THAN_CURRENT';

            if (!moment(first, 'YYYY-MM-DD HH:mm', true).isValid()) {
                return DATE_VALIDATION_ERROR;
            }

            if (Date.parse(first) < Date.parse (new Date())) {
                return DATE_VALIDATION_LATER_THAN_CURRENT;
            }

            return '';

        },

        periodic: function (first, last) {

            var DATE_VALIDATION_ERROR = 'DATE_VALIDATION_ERROR';
            var DATE_VALIDATION_FIRST_LAST = 'DATE_VALIDATION_FIRST_LAST';
            var DATE_VALIDATION_LATER_THAN_CURRENT = 'DATE_VALIDATION_LATER_THAN_CURRENT';

            if (Date.parse(first) > Date.parse(last)) {
                return DATE_VALIDATION_FIRST_LAST;
            }

            if (!moment(first, 'YYYY-MM-DD HH:mm', true).isValid() || !moment(last, 'YYYY-MM-DD HH:mm').isValid()) {
                return DATE_VALIDATION_ERROR;
            }

            if (Date.parse(first) < Date.parse (new Date())) {
                return DATE_VALIDATION_LATER_THAN_CURRENT;
            }

            if (Date.parse(last) < Date.parse (new Date())) {
                return DATE_VALIDATION_ERROR;
            }

            return '';
        }
    };
});
