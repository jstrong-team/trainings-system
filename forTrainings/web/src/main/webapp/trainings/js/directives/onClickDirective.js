angular.module('trainingsModule').directive('onClickDirective', function() {
    return function(scope, element) {
        element.on('click', function(event)
        {
            var target = event.target;
            while (target !== element) {
                if (target.tagName === 'DIV') {
                    var className = target.classList.toString();
                    alert(className);
                    colorDayItems();
                }
                target = target.parentNode;
            }
        });
    };
});

