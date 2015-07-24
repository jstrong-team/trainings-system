angular.module('calendarModule').directive('onClickDirective', function () {
    return function (scope, element) {
        element.on('click', function (event) {
            var target = event.target;
            while (target !== element) {
                if (target.tagName === 'DIV') {
                    var className = target.classList.toString();
                    //alert(className);
                    scope.openModal(className);
                    colorDayItems();
                }
                target = target.parentNode;
            }
        });
    };
});

