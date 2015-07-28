angular.module('createModule').factory('validationService', function () {

    return {

        oneTime: function (first) {

            var DATE_VALIDATION_ERROR = 'Date validation error!';

            if (!moment(first, 'YYYY-MM-DD HH:mm', true).isValid()) {
                return DATE_VALIDATION_ERROR;
            }

            if (Date.parse(first) < Date.parse (new Date())) {
                return DATE_VALIDATION_ERROR;
            }

            return '';

        },

        periodic: function (first, last) {

            var DATE_VALIDATION_ERROR = 'Date validation error!';

            if (Date.parse(first) > Date.parse(last)) {
                return 'First date should be earlier than the last date!';
            }

            if (!moment(first, 'YYYY-MM-DD HH:mm', true).isValid() || !moment(last, 'YYYY-MM-DD HH:mm').isValid()) {
                return DATE_VALIDATION_ERROR;
            }

            if (Date.parse(first) < Date.parse (new Date())) {
                return DATE_VALIDATION_ERROR;
            }

            if (Date.parse(last) < Date.parse (new Date())) {
                return DATE_VALIDATION_ERROR;
            }

            return '';
        }
    };
});
