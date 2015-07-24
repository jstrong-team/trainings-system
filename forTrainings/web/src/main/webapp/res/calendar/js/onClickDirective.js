angular.module('calendarModule').directive('onClickDirective', function () {
    return function (scope, element) {
        element.on('click', function (event) {
            var target = event.target;

            while (target !== element) {

                if (target.classList[0] === 'dayItem') {
                    var className = target.classList.toString();
                    scope.openModal(className);
                    event.stopPropagation();
                    break;
                }

                if (target.tagName !== 'P') {
                    event.stopPropagation();
                    break;
                }

                target = target.parentNode;
            }
        });
    };
});

