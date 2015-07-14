angular.module('trainingsModule').directive('onClickDirective', function() {
    return function(scope, element) {
        element.on('click', function(event)
        {
            var target = event.target;
            while (target !== element) {
                if (target.tagName === 'DIV') {
                    alert(target.classList);
                    return;
                }
                target = target.parentNode;
            }
        });
    };
});

