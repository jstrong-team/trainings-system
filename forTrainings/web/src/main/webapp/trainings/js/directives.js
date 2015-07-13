angular.module('trainingsModule').directive('onFinishRender',['$timeout', function($timeout) {
    return function(scope) {
        if (scope.$last === true){
            $timeout(function () {
                scope.$emit('ngRepeatFinished');
            });
        }
    };
}]);

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

